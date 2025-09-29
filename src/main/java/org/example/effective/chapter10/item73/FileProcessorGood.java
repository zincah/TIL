package org.example.effective.chapter10.item73;

import java.io.*;

public class FileProcessorGood {
    public String readFirstLine(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        } catch (IOException e) {
            // 구현 세부사항 캡슐화 → 고수준 의미 있는 예외로 변환
            throw new CruzlinkException("001", "설정 파일 읽기에 실패했습니다: " + filePath, e);
        }
    }
}
