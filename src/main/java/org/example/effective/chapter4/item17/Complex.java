package org.example.effective.chapter4.item17;

/**
 * 1. 변경자 메서드를 제공하지 않는다.
 * 2. 클래스를 확장할 수 없도록 한다. (ex. final로 선언)
 * 3. 모든 필드를 final로 선언한다.
 * 4. 모든 필드를 private로 선언한다.
 * 5. 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.
 */
public final class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart()        { return re; }
    public double imaginaryPart()   { return im; }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                        re * c.im + im * c.re);
    }

    public Complex divededBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override public  boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        return Double.compare(c.re, re) == 0
            && Double.compare(c.im, im) == 0;
    }

    @Override public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
