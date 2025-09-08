package org.example.effective.chapter9.item58;

import java.util.*;

/**
 * for-each 문을 사용할 수 없는 상황
 * 1. 파괴적인 필터링: 컬렉션을 순회하면서 remove를 호출하는 경우
 * 2. 변형: 리스트나 배열을 순회하면서 그 원소의 값을 변경하는 경우
 * 3. 병렬 반복: 여러 컬렉션을 병렬로 순회하는 경우
 */
public class Card {
    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        // NoSuchElementException 발생
        System.out.println("잘못된 예제");
        try {
            for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
                for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                    System.out.println("Suit[" + i.next() + "], Rank[" + j.next() + "]");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("### NoSuchElementException 발생!! \n");
        }

        System.out.println("for-each 사용");
        for ( Suit suit : suits) {
            for ( Rank rank : ranks) {
                System.out.println( "Suit[" + suit + "], Rank[" + rank + "]");
            }
        }
    }
}
