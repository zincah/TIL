package my.wonseok.chapter02.item11.hashcode;


import com.google.common.base.Objects;

/**
 * study
 * hashcode란?
 * - 객체의 메모리 주소를 기반으로한 정수값 생성
 * - 객체의 동일성 비교를 위한 첫 단계로 활용
 * - 서로 다른 해시값에 대해서는 다른 해시값을 반환하는 것이 좋음
 *
 * 규약
 * - 일관성: 같은 객체에 대해 같은 값 반환
 * - 동등성: equals()가 true면 같은 값 반환
 */
public class WorstCode {
    private String gid;
    private String interfaceId;

    public WorstCode(String gid, String interfaceId) {
        this.gid = gid;
        this.interfaceId = interfaceId;
    }

    //최악의 hashcode
    @Override
    public int hashCode() {
        return 25;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WorstCode worstHash = (WorstCode) o;
        return Objects.equal(gid, worstHash.gid) && Objects.equal(interfaceId, worstHash.interfaceId);
    }
}
