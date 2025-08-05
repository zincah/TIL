# ☕ JavaDoc 작성 가이드

본 문서는 공개 API 요소(Class, Interface, Method 등)에 대해 Javadoc을 작성할 때 따라야 할 작성 규칙 및 형식을 설명합니다.  
Effective Java 아이템 56을 기반으로 작성되었으며, 팀 내 코드 품질 및 문서화 통일성을 높이는 데 목적이 있습니다.

---

## 📌 기본 원칙

| 항목 | 규칙 |
|------|------|
| 작성 대상 | 모든 **공개 API 요소** (public/protected 클래스, 인터페이스, 생성자, 메서드, 필드 등) |
| 목적 | 외부 사용자(또는 미래의 나)를 위한 **계약 문서** 역할 |
| 문체 | **세 번째 인칭**, **명사절/서술형 문장**, **Java 코드 포함 시 `{@code ...}` 사용** |

---

## ✍️ 주석 작성 규칙 요약

### ✅ 클래스 / 인터페이스 주석

- **첫 문장은 요약 설명으로 작성 (한 줄 설명 + 마침표)**
- 이 타입이 **무엇을 대표하고**, **무엇을 제공하는지** 설명
- 이후에 추가 설명을 문단으로 붙일 수 있음 (`<p>` 태그 사용 권장)

```java
/**
 * {@code Calculator}는 정수 기반의 간단한 수학 계산 기능을 제공합니다.
 *
 * <p>이 클래스는 add, divide 등의 기능을 제공합니다.
 */
```

### ✅ 생성자 주석

- 클래스의 목적과 함께 **객체 생성 시의 의미**를 설명
- 보통 "객체를 생성합니다.” 또는 "생성자입니다." 형태로 시작

```java
/**
 * {@code StandardCalculator}의 기본 생성자입니다.
 * 특별한 초기화는 없습니다.
 */
public StandardCalculator() { ... }
```

### ✅ 메서드 주석

**1. 첫 문장**
   - 무엇을 하는지 요약 (ex. 두 수를 더해 반환합니다)
   - 동사형 서술문으로 작성 (명령문❌)

**2. 태그 작성**   

| 태그               | 설명                               |
| ---------------- | -------------------------------- |
| `@param`         | 매개변수 설명 (`@param name 설명`)       |
| `@return`        | 반환값 설명                           |
| `@throws`        | 발생 가능한 예외 및 조건                   |
| `@implSpec`      | default 메서드 또는 구현 명세 (Java 8+)   |
| `@since`         | API가 도입된 버전                      |
| `@deprecated`    | 더 이상 사용하면 안 되는 API 설명            |
| `@inheritDoc`    | 상위 클래스/인터페이스 주석을 그대로 상속받음        |
| `{@code ...}`    | 코드 조각 표현 (e.g. {@code a + b})    |
| `{@literal ...}` | 특수문자 표현 (e.g. {@literal <html>}) |

---
## 🧪 문서 확인 방법
```
# javadoc -d doc [.java파일 경로]
# implSpec 사용하기 위해서는 -tag "implSpec:a:Implementation Requirements:" 포함해서 실행

javadoc -d doc -tag "implSpec:a:Implementation Requirements:" *.java
```