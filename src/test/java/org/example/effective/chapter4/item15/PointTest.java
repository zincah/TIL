package org.example.effective.chapter4.item15;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter4.item15.SafePoint;
import org.example.effective.chapter4.item15.UnsafePoint;
import org.junit.jupiter.api.Test;

/**
 * public 가변 필드 및 public static final 배열
 */
@Slf4j
public class PointTest {

    @Test
    public void synchronizedFail() throws InterruptedException {

        for(int i=0; i<1000; i++){
            UnsafePoint point = new UnsafePoint();

            Thread th1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    point.x = 10;
                    Thread.yield(); // 강제로 발생하도록 교차 실행할 수 있게 Thread.yield() 실행
                    point.y = 20;
                }
            });

            Thread th2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    point.x = 50;
                    Thread.yield();
                    point.y = 10;
                }
            });

            th1.start();
            th2.start();
            th1.join();
            th2.join();

            // 상태 불일치 조건: x, y가 한 쌍이 아닌 경우
            if (!((point.x == 10 && point.y == 20) || (point.x == 50 && point.y == 10))) {
                log.debug("❌ 불일치 상태 발생: x = {}, y = {}", point.x, point.y);
            }
        }

    }


    @Test
    public void synchronizedSucc() throws InterruptedException {

        for(int i=0; i<1000; i++){
            SafePoint point = new SafePoint();

            Thread th1 = new Thread(() -> point.move(10, 20));
            Thread th2 = new Thread(() -> point.move(50, 10));

            th1.start();
            th2.start();
            th1.join();
            th2.join();

            int x = point.getX();
            int y = point.getY();

            boolean consistent = (x == 10 && y == 20) || (x == 50 && y == 10);
            if (!consistent) {
                log.debug("❌ 일관성 깨짐 (동기화 실패): x = {}, y = {}", x, y);
            }
        }
    }

}

