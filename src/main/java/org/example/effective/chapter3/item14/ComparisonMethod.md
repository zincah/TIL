
# Comparable & Comparator
> Comparable: 객체 스스로 기본 정렬 기준을 정의하는 인터페이스.    
> Comparator: 객체 외부에서 다양한 정렬 기준을 정의할 수 있는 인터페이스.

## Comparable vs Comparator
| 항목     | `Comparable<T>`          | `Comparator<T>`                      |
| ------ | ------------------------ | ------------------------------------ |
| 비교 기준  | 클래스 내부에 1개               | 클래스 외부에서 여러 개 정의 가능                  |
| 유연성    | 낮음                       | 높음 (람다, 메서드 참조, 체이닝 가능)              |
| 코드 위치  | 정렬 대상 클래스 내부             | 외부 또는 람다                             |
| 사용 예   | `Collections.sort(list)` | `Collections.sort(list, comparator)` |
| 대표 메서드 | `compareTo()`            | `compare(o1, o2)` 또는 메서드 체이닝         |
| 확장성    | 클래스 수정 필요                | 클래스 수정 없이 다양한 기준 정의 가능               |

## 정렬 방법에 따른 장/단점
`Person.java, PersonCompareTest.java 참고`    
1. Comparable : Comparable 상속받은 Person 클래스에서 정의한 정렬조건으로 정렬
2. Comparator : 내부 익명 클래스 활용하여 정렬
3. Comparator : 람다 + 체이닝 활용하여 정렬

| 방법                           | 장점                                             | 단점                                       |
| ---------------------------- | ---------------------------------------------- | ---------------------------------------- |
| `Comparable` (`compareTo()`) | - 기본 정렬 지정 가능<br>- `Collections.sort()`만으로 정렬됨 | - 기준 변경 불가<br>- 클래스 수정 필요                |
| `Comparator` (익명 클래스)        | - 기준 다양화 가능<br>- 외부에서 제어 가능                    | - 코드가 장황해짐                               |
| `Comparator` (람다+체이닝)        | - 가독성 ↑↑<br>- 기준 복합 적용 쉬움<br>- 유지보수 용이         | - Java 8+ 필요<br>- 개념을 모르면 다소 복잡해 보일 수 있음 |

## 각 정렬방법으로 추천하는 상황
| 상황                                   | 추천 방식             | 이유                                                                                |
| ------------------------------------ | ----------------- | --------------------------------------------------------------------------------- |
| **기본 정렬 기준이 명확하고 고정적일 때**            | `Comparable`      | - 한 가지 정렬 방식만 쓸 거라면 `compareTo()`에 넣는 게 간단<br>- `Collections.sort()` 등에서 바로 사용 가능 |
| **정렬 기준이 여러 개일 수 있고, 유연성이 중요할 때**    | `Comparator`      | - 필요할 때마다 다른 기준을 줄 수 있음<br>- 유지보수, 테스트 용이                                         |
| **복합 조건 정렬, 정렬 로직이 길거나 가독성이 중요한 경우** | 체이닝된 `Comparator` | - 선언적이고 읽기 쉬움<br>- `Comparator.comparing().thenComparing()` 방식은 함수형 스타일에 적합       |

## 성능에 미치는 영향
- Comparable과 Comparator 모두 정렬 알고리즘 자체는 동일합니다. (TimSort 등, O(n log n) 성능)

  | 방식                | 성능 차이               | 설명                                                              |
  | ----------------- | ------------------- | --------------------------------------------------------------- |
  | `Comparable`      | 빠름 (매우 미세하게)        | - JVM 최적화가 잘 됨<br>- 메서드 호출 경로가 짧음 (직접 구현)                       |
  | 익명 `Comparator`   | 느릴 수 있음             | - 매번 새 인스턴스 생성<br>- 람다보다 느릴 수 있음                                |
  | 체이닝된 `Comparator` | 거의 `Comparable`과 비슷 | - 람다 표현식은 인라이닝 되어 빠름<br>- `Comparator.comparing()`은 성능 저하 거의 없음 |




