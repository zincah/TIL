package org.example.effective.chapter11.item78;

/**
 * item78 : 공유된 가변 데이터는 동기화해 사용해라
 *
 * 스레드가 여러 개일 때, 가변 상태를 공유하면 아래와 같은 문제 발생
 * 1. 가시성 문제 : 한 스레드가 값을 변경했을 때, 다른 스레드가 이를 바로 보지 못할 수 있음 (cpu core, 캐시, 메모리 재정렬 때문에)
 * 2. 원자성 문제 : count++ 같은 복합 연산은 원자적이지 않음, 여러 스레드가 동시에 실행하면 값이 꼬임
 * 3. 재정렬 문제 : 컴파일러/jit/cpu 가 명령을 재배치하면 여러 스레드 간 순서가 어긋날 수 있음
 *
 * -> 동기화(synchronized/volatile/atomic)
 */
public class SynchronizedExample {
    public static void main(String[] args) throws InterruptedException {

        BadStopThread badStopThread = new BadStopThread();
//        badStopThread.testRun();

        StopThreadOne stopThreadOne = new StopThreadOne();
//        stopThreadOne.testRun();

        StopThreadTwo stopThreadTwo = new StopThreadTwo();
        stopThreadTwo.testRun();
    }

}

// 동기화 없는 flag 종료
class BadStopThread{

    private static boolean stopRequested = false;

    public void testRun() throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            while(!stopRequested){ // true임을 못 읽을 수 있음
                System.out.println("thread...");
            }
        });

        backgroundThread.start();
        Thread.sleep(1000);
        System.out.println("after 1sec..");
        stopRequested = true;
    }

}

// 해경방법 1 : synchronized 동기화
class StopThreadOne{
    private static boolean stopRequested;

    private static synchronized void requestStop(){
        stopRequested = true;
    }

    private static synchronized boolean stopRequested(){
        return stopRequested;
    }

    public void testRun() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(!stopRequested()){
                System.out.println("thread...");
            }
        });

        thread.start();
        Thread.sleep(1000);
        System.out.println("after 1 sec..");
        requestStop();
    }
}

// 해결방법 2 : volatile 사용
// 서로 다른 스레드가 항상 최신값을 읽게 해줌 (가시성 보장)
// 하지만 복합 연산이 있을 경우 연산 자체를 atomic 하게 만들지는 않음 (원자성 보장 x)
class StopThreadTwo{
    private static volatile boolean stopRequested = false;

    public void testRun() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(!stopRequested){
                System.out.println("thread...");
            }
        });

        thread.start();
        Thread.sleep(1000);
        System.out.println("after 1 sec..");
        stopRequested = true;
    }
}
