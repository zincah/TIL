package my.wonseok.chapter02.item19;

public class Super {
    public Super(){
        //생성자에서 재정의 가능한 함수 호출
        overrideMe();
    }

    public void overrideMe(){
        System.out.println("Super.overrideMe()");
    }
}
