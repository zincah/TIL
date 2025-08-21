package org.example.effective.chapter9.item65.good;

public class MarkdownRenderer implements Renderer{
    @Override
    public String render(String input) {
        return "**" + input + "**";
    }
}
