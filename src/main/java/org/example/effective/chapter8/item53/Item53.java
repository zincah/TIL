package org.example.effective.chapter8.item53;

public class Item53 {
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    // 인수가 1개 이상이어야 하는 가변인수 메서드 - 잘못 구현 한 예
    // 인수를 0개를 받을 수 있기 때문에 런타임시에만 에러를 알 수 있음
    // 코드 또한 지저분함
    static int wrongMin(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("need at least one argument");
        }
        int min = args[0];
        for(int i =1; i < args.length; i++) {
            if(args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }
    // 인수가 1개 이상이어야 하는 가변인수 메서드 - 올바르게 구현 한 예
    static int goodMin(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for(int arg: remainingArgs) {
            if(arg < min) {
                min = arg;
            }
        }
        return min;
    }


    // 그러나 가변인수는 메서드가 호출 될 때마다 배열을 새로 할당하고 초기화함
    // 성능 이슈 발생 가능성 있음
    // 아래와 같은 방식으로 특수 상황에서 가변인수로 인한 성능 이슈 해결 가능
    public void foo(){}
    public void foo(int a1){}
    public void foo(int a1, int a2){}
    public void foo(int a1, int a2, int a3){}
    public void foo(int a1, int a2, int a3, int... rest){}


    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3));

    }
}
