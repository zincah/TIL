package org.example.effective.chapter9.item65.good;

/**
 * 좋은 예 : 리플렉션을 사용하지 않고 인터페이스와 팩토리 활용
 *
 * -> 리플렉션은 최후의 수단이다. 가능하면 쓰지 말고, 꼭 써야 한다면 생성까지만 쓰고 인터페이스로 감싸라.
 */
public class CallRenderer {

    // 클라이언트 예시
    public static void main(String[] args) {
        Renderer renderer = RendererFactory.getRenderer("html");
        System.out.println(renderer.render("Hello!"));
    }
}
