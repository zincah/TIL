package org.example.effective.chapter9.item65.good;

// 팩토리 패턴으로 구현체 관리
public class RendererFactory {
    public static Renderer getRenderer(String type){
        switch (type){
            case "html" : return new HtmlRenderer();
            case "markdown" : return new MarkdownRenderer();
            default: throw new IllegalArgumentException("지원하지 않는 타입");
        }
    }
}
