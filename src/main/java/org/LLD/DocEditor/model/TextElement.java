package org.LLD.DocEditor.model;

public class TextElement implements DocumentElement {
    private String text;
    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}
