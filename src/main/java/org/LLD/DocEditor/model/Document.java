package org.LLD.DocEditor.model;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<DocumentElement> elements = new ArrayList<>();

    public void addElement(DocumentElement e) {
        elements.add(e);
    }
    public String render() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Rendering document with " + elements.size() + " elements.");
        for(DocumentElement doc : elements) {
            sb.append(doc.render());
        }
        return sb.toString();
    }
}
