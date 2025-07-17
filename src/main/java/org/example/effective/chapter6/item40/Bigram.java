package org.example.effective.chapter6.item40;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 아이템 40 : 메서드를 재정의할때는 항상 @Override를 붙여라
 * - 컴파일러가 재정의가 맞는지 확인해주고, 오타나 실수를 잡을 수 있음
 * - @override를 붙이면 정확히 상위 클래스나 인터페이스 메서드를 재정의하고 있는지 컴파일 타임에 체크해줌
 * - 따라서 재정의일 경우 @override붙이는 습관이 좋음
 *
 * + 추상클래스의 추상 메서드 구현할때는 @override 붙이지 않아도 컴파일러가 인식
 * + 인터페이스 메서드를 구현할때 default 메서드가 아니면 컴파일러가 인식
 *      --> 하지만 오타, 시그니쳐 오류, 오버라이딩 실수 방지 등등을 위해 @override붙이는 습관이 좋음
 */

public class Bigram{

    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    // 1. Override 애너테이션이 없을 경우 --> 컴파일 에러 확인 x
    public boolean equals(Bigram b){
        return b.first == first && b.second == second;
    }

    // 2-1. Override 애너테이션이 있을 경우 --> 컴파일 에러 확인 o
//    @Override
//    public boolean equals(Bigram b){
//        return b.first == first && b.second == second;
//    }

    // 2-2. 메서드 제대로 재정의
//    @Override
//    public boolean equals(Object obj) {
//        if(!(obj instanceof Bigram)){
//            return false;
//        }
//        Bigram b = (Bigram) obj;
//        return b.first == first && b.second == second;
//    }

    public int hashCode(){
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for(int i =0; i<10; i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                s.add(new Bigram(ch, ch));
            }
        }

        System.out.println(s.size());
    }

}
