package org.LLD.DocEditor.model;

public class NewLineElement implements DocumentElement {

    @Override
    public String render() {
        return "\n";
    }
}
