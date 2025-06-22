package org.example.effective.chapter6.item36;

//과거에 사용하던 열거
public class OldText {
    public static final int STYLE_BOLD = 1 << 0; //0001
    public static final int STYLE_ITALIC = 1 << 1; //0010
    public static final int STYLE_UNDERLINE = 1 << 2; //0100
    public static final int STYLE_STRIKETHROUGH = 1 << 3; //1000

    public void applyStyle(int style) {
        //...
    }

    public static void main(String[] args) {
        OldText text = new OldText();
        text.applyStyle(STYLE_BOLD | STYLE_ITALIC);

    }
}
