package org.example.effective.chapter11.item78;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile vs AtomicInteger 예제
 *
 * - volatile 은 "가시성"만 보장하고, ++ 같은 복합 연산의 원자성은 보장하지 못한다.
 * - AtomicInteger 는 CAS(Compare-And-Swap)를 이용해서 ++ 같은 복합 연산도 원자적으로 보장한다.
 */
public class AtomicExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== volatile 카운터 테스트 ===");
        VolatileCounterExample volatileExample = new VolatileCounterExample();
        volatileExample.testRun();

        System.out.println();
        System.out.println("=== AtomicInteger 카운터 테스트 ===");
        AtomicCounterExample atomicExample = new AtomicCounterExample();
        atomicExample.testRun();
    }
}

/**
 * ❌ volatile 을 사용한 카운터 예제
 * - count++ 는 "읽기 → 더하기 → 쓰기" 3단계 연산이라 원자적이지 않다.
 * - 여러 스레드가 동시에 count++ 를 하면 중간에 값이 덮어씌워져서 결과가 줄어든다.
 */
class VolatileCounterExample {

    // 가시성은 보장되지만, ++ 연산이 원자적이지 않기 때문에 안전하지 않다.
    private static volatile int count = 0;

    private static final int THREAD_COUNT = 10;
    private static final int INCREMENT_PER_THREAD = 100_000;

    public void testRun() throws InterruptedException {
        count = 0; // 초기화

        Thread[] threads = new Thread[THREAD_COUNT];

        // 10개의 스레드가 각각 100,000번씩 count++ 수행
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENT_PER_THREAD; j++) {
                    count++; // 🚨 원자적이지 않은 연산
                }
            });
        }

        long start = System.currentTimeMillis();

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();

        int expected = THREAD_COUNT * INCREMENT_PER_THREAD;
        System.out.println("volatile count 최종값 = " + count);
        System.out.println("기대값(expected)       = " + expected);
        System.out.println("동일하지 않다면 → 원자성 깨짐 (volatile로는 부족)");
        System.out.println("실행 시간(ms)          = " + (end - start));
    }
}

/**
 * ✅ AtomicInteger 를 사용한 카운터 예제
 * - incrementAndGet() 이 내부적으로 CAS 를 사용하여 원자적으로 동작한다.
 * - 여러 스레드가 동시에 호출해도 최종 결과가 항상 기대값과 일치한다.
 */
class AtomicCounterExample {

    private static final AtomicInteger count = new AtomicInteger(0);

    private static final int THREAD_COUNT = 10;
    private static final int INCREMENT_PER_THREAD = 100_000;

    public void testRun() throws InterruptedException {
        count.set(0); // 초기화

        Thread[] threads = new Thread[THREAD_COUNT];

        // 10개의 스레드가 각각 100,000번씩 incrementAndGet() 수행
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENT_PER_THREAD; j++) {
                    count.incrementAndGet(); // ✅ 원자적 연산
                }
            });
        }

        long start = System.currentTimeMillis();

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();

        int expected = THREAD_COUNT * INCREMENT_PER_THREAD;
        System.out.println("AtomicInteger count 최종값 = " + count.get());
        System.out.println("기대값(expected)            = " + expected);
        System.out.println("항상 동일해야 함 → 원자성 보장");
        System.out.println("실행 시간(ms)               = " + (end - start));
    }
}
