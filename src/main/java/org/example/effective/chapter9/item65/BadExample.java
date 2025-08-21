package org.example.effective.chapter9.item65;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 아이템 65 : 리플렉션보다는 인터페이스를 사용하라
 *
 * 리플렉션이란? : 자바에서 클래스, 메서드, 필드 등을 런타임에 동적으로 조작할 수 있는 기능
 * 특징
 * 1) 런타임에 클래스 이름으로 객체 생성 가능
 * 2) 메서드 호출, 필드 접근 등도 동적으로 수행 가능
 * 3) 프레임워크, 플러그인 시스템 등에서 사용됨
 *
 * # 되도록 사용하지 말아야하는 이유
 * - 타입 안전성 없음 (잘못된 형변환도 컴파일 타입에서 인지 못함)
 * - 성능 저하
 * - IDE 지원 불가 (자동완성, 리펙토링, 추적 등 기능 동작하지 않음)
 * - 예외 다양
 * - 유지보수 어려움
 */
public class BadExample {

    // 리플렉션을 과하게 사용하는 경우
    public static void main(String[] args) {

        try{
            // 클래스명이 잘못되면 컴파일이 아닌 런타임에서 터짐
            String className = "org.example.effective.chapter9.item65.good.HtmlRenderer";
            Class<?> clazz = Class.forName(className);
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // 메서드 이름 오타 --> 컴파일러 체크 못함
            Method renderMethod = clazz.getMethod("render", String.class);
            String result = (String) renderMethod.invoke(obj, "hello");

            System.out.println(result);

        }catch (ClassNotFoundException | NoSuchMethodException ce){
            ce.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}

