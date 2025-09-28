package org.example.effective.chapter10.item70;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {

    // IOException은 검사 예외입니다. 호출자는 반드시 처리해야 합니다.
    public void processFile(String path) throws IOException {
        File file = new File(path);

        // 파일이 존재하지 않거나, 권한이 없을 수 있습니다.
        // 이는 프로그램의 논리적 오류가 아닌, '외부 환경' 문제입니다.
        try (FileReader reader = new FileReader(file)) {
            // 파일 내용 처리 로직...
        }
        // 메서드 선언부에 'throws IOException'을 넣거나 여기서 catch 해야 합니다.
    }

    public static void main(String[] args) {
        CheckedExceptionExample example = new CheckedExceptionExample();

        try {
            example.processFile("non_existent_file.txt");
        } catch (IOException e) {
            // 호출자가 예외를 잡아서 '복구' 조치를 취할 수 있습니다.
            System.err.println("파일 처리 실패: " + e.getMessage());
            // 복구 예시: 사용자에게 파일 경로를 다시 입력받거나, 기본 설정으로 대체.
            // System.out.println("기본 설정 파일을 로드합니다...");
        }

        // catch 강제됨
        //example.processFile("non_existent_file.txt");

    }
}