# 아이템 68 요약: 일반적으로 통용되는 **자바 명명 규칙** 정리

이 문서는 *이펙티브 자바* 아이템 68의 취지를 실무 기준으로 재구성한 체크리스트와 예제를 담았습니다.  
목표: **다른 개발자가 즉시 이해·예상할 수 있는 이름**을 사용해 API 품질과 유지보수성을 높이기.

---

## 1) 패키지 이름
- 모두 **소문자**, 조직 도메인을 역순으로: `com.example.app.core`
- **언더스코어/대문자/혼합 표기 금지**: `com.example.XMLHttp` (X) → `com.example.xml.http` (가능한 쪼개기)
- **동사 금지**, **복수형 지양**, **간결**하게

```text
✔ org.example.effective.chapter9.item68
✘ org.example.Effective.Item_68
```

---

## 2) 클래스/인터페이스/열거형/애노테이션 이름
- **UpperCamelCase**, 주로 **명사/명사구**
- 인터페이스는 능력/역할을 드러내는 명사/형용사: `Comparator`, `Readable`
- 열거형은 **집합의 이름**: `DayOfWeek`, 상수는 **대문자 스네이크**

```java
public final class HttpRequest { ... }
public interface Cache { ... }
public enum UserRole { ADMIN, MEMBER, GUEST }
public @interface Beta { }
```

안티패턴:
```text
✘ DataProcessorClass, ManagerImpl, UtilClass (의미 불분명/과도한 접미사)
```

---

## 3) 메서드 이름
부작용 있음이라고 표현한 것은 객체의 내부 상태를 바꾸거나, 외부 리소스에 영향을 주는 메소드라는 것을 뜻함

- **lowerCamelCase**, **동사/동사구** 중심
- 관례적 쌍(Pairs) 유지: `add/remove`, `put/get`, `start/stop`, `open/close`, `read/write`, `lock/unlock`
- **불린(boolean) 반환**: `isXxx`, `hasXxx`, `canXxx`
- **조회(순수 함수)**: `getXxx()` (부작용 없음)
- **명령(부작용 있음)**: `setXxx(value)`, `updateXxx()`, `sendXxx()` 등
- **변환/표현**: `toXxx()`, `asXxx()`
- **팩터리(정적)**: `of(...)`, `from(...)`, `valueOf(...)`, `getInstance()`, `newInstance()`
- **생성 빌더**: `builder()` / 빌더의 속성은 명사형(`withXxx`, `x(...)`) 일관
- **컬렉션 크기**: `size()` / 배열은 `length` 필드

예시:
```java
public boolean isActive() { ... }
public int size() { ... }
public User of(String id) { ... }           // static factory
public String toJson() { ... }              // 변환
public void sendMessage(Message msg) { ... }// 부작용
public Optional<User> findById(String id) { ... } // 조회 + Optional
```

안티패턴:
```text
✘ doProcess(), handleData()   // 의미가 불명확
✘ getXxx()가 내부 상태를 바꿈    // 조회자(getter)에 부작용 금지
```

---

## 4) 필드/지역변수/상수 이름
- **필드/지역변수**: lowerCamelCase, 도메인 친화적
- **상수(`static final`)**: 대문자 스네이크 `MAX_SIZE`, `DEFAULT_TIMEOUT_MS`
- 컬렉션은 **복수형** 사용: `users`, `orderItems`
- 단위 표기는 접미사로: `timeoutMs`, `sizeBytes`

```java
private int retryCount;
private List<String> userIds;
public static final int MAX_RETRY = 3;
public static final Duration DEFAULT_TTL = Duration.ofMinutes(5);
```

---

## 5) 제네릭 타입 매개변수
- 관례적 단문자 대문자 사용
  - `T`(Type), `E`(Element), `K`/`V`(Key/Value), `R`(Result), `X`(Exception), `U`/`S`(2nd/3rd Type)

```java
public interface Mapper<T, R> {
    R map(T value);
}
public interface BiConsumer<K, V> {
    void accept(K key, V value);
}
```

---

## 6) 약어와 두문자어(Acronym)
- **첫 글자만 대문자**(일반적 클래스/메서드 컨벤션에 맞춤)
  - `HttpClient`, `XmlParser`, `UrlCodec`
- 모두 대문자 나열은 지양: `HTTPClient`, `XML_PARSER` (X)

```java
class HttpUrlBuilder { 
    void setUrl(String baseUrl) { ... } 
}
```

---

## 7) 예외/테스트/도메인 특화
### 7.1 예외 클래스
- `XxxException`으로 끝나야 함. 메시지는 조치에 도움을 주도록 구체적으로.
```java
public class InsufficientBalanceException extends RuntimeException { ... }
```

### 7.2 테스트 메서드 이름(JUnit)
- **행위-조건-기대** 패턴 권장: `shouldX_whenY_givenZ`
```java
@Test
void shouldReturnEmpty_whenUserNotFound_givenInvalidId() { ... }
```

### 7.3 도메인 이름 선택 팁
- 도메인 용어를 그대로(해당 프로젝트/비즈니스에서 쓰는 전문 용어를 그대로 반영): `Ledger(원장)`, `Remittance(송금)`, `Settlement(정산)`
- 모호한 범용 단어 금지: `Manager`, `Processor`, `Handler`
```
예시) PaymentProcessor -> PaymentAuthorizationService 
```


---

## 8) 오버로딩/가시성/부작용 일관성
- 오버로딩된 메서드는 **의미/단위/순서** 일관성을 유지 : 파라미터의 의미와 순서가 일관되게 사용해야한다.
- 공개 API에서 **부작용 유무**가 이름만으로 예측 가능해야 함 : 단순 조회성인지 데이터가 변경되는 로직이 존재하는지 예측 가능해야한다.
- 불변 객체는 `withXxx(...)`로 새 인스턴스 반환 패턴 선호

```java
public Price withTaxRate(BigDecimal taxRate) { ... } // 새 인스턴스 반환
```

---

## 9) 실전 예제: 잘 지은 이름 vs 잘못 지은 이름

### ✅ 좋은 예
```java
// 주문 관련 서비스 - 도메인 이름이 바로 드러남 (OrderService)
public final class OrderService {
    // 의존성은 명확하게 타입으로 표현됨 (역할이 보임: 저장소와 결제 게이트웨이)
    private final OrderRepository repository;
    private final PaymentGateway paymentGateway;

    // 의존성은 생성자 주입 → 테스트/확장 용이, 불변 필드(final)로 안정성 확보
    public OrderService(OrderRepository repository, PaymentGateway paymentGateway) {
        this.repository = repository;
        this.paymentGateway = paymentGateway;
    }

    // "placeOrder" → 주문 생성이라는 도메인 행위가 이름만으로 분명히 드러남
    // 부작용 있음 (DB 저장 + 결제 요청) → 명령 메서드라 이름에 동사 사용
    public OrderId placeOrder(CreateOrderCommand command) {
        validate(command);                             // 입력 검증
        Order order = Order.from(command);             // 정적 팩터리 (의도가 드러남)
        repository.save(order);                        // 저장
        paymentGateway.requestPayment(order.paymentInfo()); // 외부 결제 시스템 호출
        return order.id();                             // 생성된 주문 ID 반환
    }

    // "findById" → 조회 성격, Optional로 "없을 수도 있음"을 타입으로 드러냄
    // 부작용 없음 → 호출자가 안심하고 사용 가능
    public Optional<Order> findById(OrderId id) {
        return repository.findById(id);
    }

    // "cancel" → 명령 성격, 상태 변경 + 저장 → 이름만으로 부작용 예측 가능
    public void cancel(OrderId id) {
        repository.findById(id).ifPresent(order -> {
            order.cancel();   // 도메인 객체의 상태 변경
            repository.save(order);
        });
    }

    // 내부 검증 로직 - private 메서드로 외부에 노출되지 않음
    private void validate(CreateOrderCommand command) { /* ... */ }
}
```

### ❌ 나쁜 예
```java
// 클래스 이름이 "ManagerClass" → 무슨 역할인지 알 수 없음
public class ManagerClass {
    // Object 타입 → 도메인 의미 불명확, IDE/컴파일러 도움 없음
    private Object dao;
    private Object util;

    // "doWork" → 무엇을 하는지 전혀 알 수 없음 (행위 불분명)
    public void doWork(Object obj) { /* ?? */ }

    // "handleData" → 구체적으로 어떤 데이터를 어떻게 처리하는지 불명확
    public void handleData(Object data) { /* ?? */ }

    // "getData" → 이름은 조회(get)이지만 실제로는 부작용이 있을지도 모름
    // → 이름과 동작 불일치 (안티패턴)
    public Object getData(String s) { /* 부작용 있을지도? */ return null; }

    // "setStuff" → 무엇을 세팅하는지 전혀 알 수 없음
    public void setStuff(int x) { /* 무엇을? */ }
}
```