package org.example.effective.chapter3.item13;

// PhoneNumber에 toString 메서드 추가 (75쪽)
public final class RestrictCloneTest {
    private final short areaCode, prefix, lineNum;

    public RestrictCloneTest(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix   = rangeCheck(prefix,   999, "프리픽스");
        this.lineNum  = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    /**
     * 이 전화번호의 문자열 표현을 반환한다.
     * 이 문자열은 "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다.
     * XXX는 지역 코드, YYY는 프리픽스, ZZZZ는 가입자 번호다.
     * 각각의 대문자는 10진수 숫자 하나를 나타낸다.
     *
     * 전화번호의 각 부분의 값이 너무 작아서 자릿수를 채울 수 없다면,
     * 앞에서부터 0으로 채워나간다. 예컨대 가입자 번호가 123이라면
     * 전화번호의 마지막 네 문자는 "0123"이 된다.
     */
    @Override public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    public static RestrictCloneTest of(String phoneNumberString) {
        String[] split = phoneNumberString.split("-");
        RestrictCloneTest phoneNumber = new RestrictCloneTest(
                Short.parseShort(split[0]),
                Short.parseShort(split[1]),
                Short.parseShort(split[2]));
        return phoneNumber;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RestrictCloneTest))
            return false;
        RestrictCloneTest pn = (RestrictCloneTest)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }

    @Override public RestrictCloneTest clone() {
        try {
            return (RestrictCloneTest) super.clone();
        } catch ( CloneNotSupportedException e ) {
            throw new AssertionError(); //클론 절대 금지
        }
    }

    public static void main(String[] args) {
        System.out.println("클론 금지");
        RestrictCloneTest jenny = new RestrictCloneTest(707, 867, 5309);
        jenny.clone();
    }
}
