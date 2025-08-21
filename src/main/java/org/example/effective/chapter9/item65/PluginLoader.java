package org.example.effective.chapter9.item65;

import org.example.effective.chapter9.item65.good.Renderer;

/**
 * 타협안 : 리플렉션은 생성까지만, 그 후엔 인터페이스로 사용
 * - 리플렉션은 인스턴스 생성까지만 이후 로직은 타입 안정성 확보
 */
public class PluginLoader {

    public static Renderer loadRenderer(String className){
        try{
            // 리플렉션으로 클래스 로딩 및 인스턴스 생성
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // 인터페이스로 형변환해서 반환 (타입 안정성 확보)
            if(!(instance instanceof Renderer)){
                throw new IllegalArgumentException("클래스가 Renderer를 구현한 클래스가 아닙니다.");
            }

            return (Renderer) instance;
        }catch (Exception e){
            throw new RuntimeException("로딩 실패 " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String className = "org.example.effective.chapter9.item65.good.HtmlRenderer";

        // 사용 시에는 반드시 타입 안전한 인터페이스(또는 추상 클래스)로 참조
        Renderer renderer = loadRenderer(className);
        String output = renderer.render("Hello Reflection");
        System.out.println(output);
    }
}
