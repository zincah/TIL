package org.example.effective.chapter6.item41.reason2;

/**
 * 마커 인터페이스를 사용하면 적용 대상을 더 정밀하게 지정할 수 있다.
 *
 * - 마커 애너테이션을 사용하면 annotationProcess 메소드를 호출할 때 런타임때 확인할 수 있지만
 * - 마커 인터페이스를 사용하면 컴파일 시점 부터 확인할 수 있다.
 *
 * 즉, 메서드에 전달되는 객체가 특정 성질(타입)을 가졌는지 확인해야 나다면
 * 그것을 타입으로 명시할 수 있는 마커 인터페이스를 써야 안전하고 확장에 강하다는 의미
 */
public class MutableService {

    public String annotationProcess(Object obj){
        if(!obj.getClass().isAnnotationPresent(MutableAnno.class)){
            throw new IllegalArgumentException("Not a mutable container");
        }

        return "process ing...";
    }

    public String interfaceProcess(MutableInte container){
        return "process ing...";
    }

    public static void main(String[] args) {
        MutableService service = new MutableService();

        // 마커 애너테이션 예제
        service.annotationProcess(new MySet()); // 허용
        service.annotationProcess(new MyCollection()); // 허용
        service.annotationProcess("String 이지롱"); // 논리 오류지만 컴파일 오류로 안잡힘

        // 마커 인터페이스 예제
        MutableInte m1 = new MySets();
        MutableInte m2 = new MyCollections();
        String m3 = "string 이지롱";

        service.interfaceProcess(m1); // 허용
        service.interfaceProcess(m2); // 허용
//        service.interfaceProcess(m3); // 컴파일 오류
    }
}
