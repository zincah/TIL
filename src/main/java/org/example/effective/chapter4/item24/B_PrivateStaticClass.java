package org.example.effective.chapter4.item24;

/**
 * private 정적 멤버 클래스
 * - 외부 클래스 내부에서만 사용
 * - 클래스 내부 유틸 클래스(헬퍼클래스) 또는 빌더 패턴에서 자주 쓰임
 */

public class B_PrivateStaticClass {
    private static class PrivateStaticHelper {
        static void help() {
            System.out.println("Private static helper");
        }
    }

    public static void main(String[] args) {
        PrivateStaticHelper.help();
    }
}

class B_Test {
    public static void main(String[] args) {
        //외부에서 접근 불가
        B_PrivateStaticClass.PrivateStaticHelper.help();
    }
}
