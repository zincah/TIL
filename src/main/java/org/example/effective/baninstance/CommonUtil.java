package org.example.effective.baninstance;

public class CommonUtil {

    /** private 생성자를 활용해서 클래스가 인스턴스 화 되는 것을 막는다. **/
    private CommonUtil(){
        throw new AssertionError();
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static int minus(int a, int b){
        return a-b;
    }
}
