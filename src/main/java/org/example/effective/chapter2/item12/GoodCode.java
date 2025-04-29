package my.wonseok.chapter02.item12;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * toString 구현 방법
 * 1. 롬복 (가장 추천, 소스 간결화)
 * 2. IDE 자동 생성 기능 사용
 * 3. apache-commons-lang 라이브러리 사용 (ToStringBuilder). JSON 스타일을 포함한 다양한 스타일 제공
 * 4. google guava 사용
 */

@ToString //lombok 사용
public class GoodCode {

    public static void main(String[] args) {
        GoodCode goodCode = new GoodCode("gid", "interfaceId");
        System.out.println(goodCode);
        System.out.println(goodCode.toStringApache());
        System.out.println(goodCode.toStringGuava());
    }

    private String gid;
    private String interfaceId;

    public GoodCode(String gid, String interfaceId) {
        this.gid = gid;
        this.interfaceId = interfaceId;
    }


    public String toStringApache() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("gid", gid)
                .append("interfaceId", interfaceId)
                .toString();
    }

    public String toStringGuava() {
        return MoreObjects.toStringHelper(this)
                .add("gid", gid)
                .add("interfaceId", interfaceId)
                .toString();

    }

}
