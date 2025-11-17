package org.example.effective.chapter10.item77;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * itme77 : 예외를 무시하지 말라
 * 예외를 catch 하고 아무것도 하지 않는 것은 위험하다.
 * 예외를 무시해야하는 경우는 주석이라도 남겨야함
 */
public class IgnoreExceptionExamples {

    public static void main(String[] args) {

        // 1 --------------------------------------
        // close() 예외 무시
        // 자원 해제 과정으로써 주요 로직은 끝났기에 close() 실패한다고 더이상 할 수 있는 일이 없음
        InputStream is = IgnoreExceptionExamples.class.getClassLoader().getResourceAsStream("test.txt");

        if(is == null) {
            System.out.println("파일을 찾을 수 없습니다.");
            throw new RuntimeException("파일을 찾을 수 없습니다.");
        }

        try{
            byte[] buffer = new byte[1024];
            int len = is.read(buffer);
            System.out.println(new String(buffer,0, len));
        }catch (IOException e){
            // 파일 읽기는 실패 해야함
            System.out.println("파일 읽기 실패");
            throw new RuntimeException("파일 읽기 실패", e);
        }finally {
            if(is != null){
                try{
                    is.close();
                }catch (IOException ignored){
                    // 파일 닫기 실패 예외 무시 처리
                }
            }
        }

        // 2 --------------------------------------
        // ExecutorService에서 예외가 발생했을 때 일부로 무시해도 되는 경우
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<?> future = executor.submit(() -> {
            throw new RuntimeException("작업 중 에러");
        });

        try{
            future.get(); // execution exception 발생
        }catch (InterruptedException e){
            Thread.currentThread().interrupt(); // 인터럽트는 반드시 다시 설정
        }catch (ExecutionException ignored){
            System.out.println("ignored excetion " + ignored.getMessage());
            // 작업 실패는 무시해도 되는 상황
        }

        executor.shutdown();
    }
}
