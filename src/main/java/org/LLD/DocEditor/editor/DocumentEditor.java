package org.LLD.DocEditor.editor;

import org.LLD.DocEditor.model.*;
import org.LLD.DocEditor.persistence.Persistence;

public class DocumentEditor {
    private Document document;
    private Persistence persistence;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Persistence persistence) {
        this.document = document;
        this.persistence = persistence;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }
    public void addImage(String path) {
        document.addElement(new ImageElement(path));
    }
    public String renderDoc() {
        renderedDocument = document.render();
        if(renderedDocument.isEmpty()) {
            throw new RuntimeException("Document is Empty");
        }

        return renderedDocument;
    }
    public void addNewLine() {
        document.addElement(new NewLineElement());
    }
    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }
    public void saveDoc() {
        persistence.save(renderDoc());
    }
}
