package org.example.effective.chapter3.item11.hashcode;


import com.google.common.base.Objects;


public class GoodCode {
    private String gid;
    private String interfaceId;

    public GoodCode(String gid, String interfaceId) {
        this.gid = gid;
        this.interfaceId = interfaceId;
    }

    // 자바 7 이상부터 추가된 함수.
    // Array.hashCode()를 사용해서 해시값 생성
    // 호출하는 경우 매번 배열이 생성되기 때문에 성능 저하 발생 가능성 있음
//    @Override
//    public int hashCode() {
//        return java.util.Objects.hash(gid, interfaceId);
//    }


    //guava 라이브러리를 사용한 hashcode 생성
//    @Override
//    public int hashCode() {
//        return com.google.common.base.Objects.hashCode(gid, interfaceId);
//    }


//    //intelij default
//    @Override
//    public int hashCode() {
//        int result = java.util.Objects.hashCode(gid);
//        result = 31 * result + java.util.Objects.hashCode(interfaceId);
//        return result;
//    }

    // 해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려
    private volatile int hashCode; // 자동으로 0으로 초기화

    @Override public int hashCode() {
        if (this.hashCode != 0) {
            return hashCode;
        }

        synchronized (this) {
            int result = hashCode;
            if (result == 0) {
                result = java.util.Objects.hashCode(gid);
                result = 31 * result + java.util.Objects.hashCode(interfaceId);
                this.hashCode = result;
            }
            return result;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GoodCode worstHash = (GoodCode) o;
        return Objects.equal(gid, worstHash.gid) && Objects.equal(interfaceId, worstHash.interfaceId);
    }
}
