package org.example.effective.chapter4.item24;


/**
 * 공개된 정적 멤버 클래스
 * - 외부에서 접근해서 사용 가능
 * - API용 내부 클래스 등에 사용됨
 */
public class C_PublicStaticClass {
    public static class PublicStaticHelper {
        public static void help() {
            System.out.println("Public static helper");
        }
    }
}

class C_Test {
    public static void main(String[] args) {
        C_PublicStaticClass.PublicStaticHelper.help();
    }
}