package org.example.effective.chapter3.item10;

import java.util.Objects;

/**
 * 대칭성(symmetry): A=B 이면 B=A이다.
 */
public class CaseInsensitiveString {
    private final String s;

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        System.out.println(cis.equals(s));  // true
        System.out.println(s.equals(cis));  // false
    }

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // 대칭성 위배!
    @Override
    public boolean equals(Object o) {
        String c = ((CaseInsensitiveString) o).s;
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        if (o instanceof String) // 한 방향으로만 작용한다!
            return s.equalsIgnoreCase((String) o);
        return false;
    }
}
