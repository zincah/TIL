package org.example.effective.chapter5.item27;
import java.util.ArrayList;
import java.util.List;

/**
 * unchecked 경고 -> 무시하지말고 원인 찾아 제거
 * 제거 불가능한경우 -> @SuppressWarnings("unchecked")를 최소 범위
 * 전체 메서드에 절대로 억제 붙히면 안됨. 항상 최소범위로 억제 설정
 */
public class WarningExample {

    public static void main(String[] args) {
        // (1) 로 타입 사용 - 컴파일 시 unchecked 경고 발생
        List rawList = new ArrayList();
        rawList.add("hello");
        String s1 = (String) rawList.get(0);
        System.out.println("Raw list value: " + s1);

        // (2) 제네릭 타입 사용 - 경고 없음
        List<String> safeList = new ArrayList<>();
        safeList.add("world");
        String s2 = safeList.get(0);
        System.out.println("Generic list value: " + s2);

        // (3) 비검사 경고 억제 - 최소 범위에 @SuppressWarnings 사용
        List<String> suppressedList = createUnsafeList();
        String s3 = suppressedList.get(0);
        System.out.println("Suppressed list value: " + s3);
    }

    // 비검사 경고를 피할 수 없는 경우 최소 범위에서 억제
    @SuppressWarnings("unchecked")
    private static List<String> createUnsafeList() {
        return (List<String>) new ArrayList();
    }
}

