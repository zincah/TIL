package org.example.effective.chapter9.item65.good;

public class HtmlRenderer implements Renderer{
    @Override
    public String render(String input) {
        return "<p>" + input + "</p>";
    }
}
