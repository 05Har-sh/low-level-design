package org.LLD.DocEditor.persistence;

import java.io.FileWriter;
import java.io.IOException;

// FileStorage implementation of Persistence
public class FileStorage implements Persistence {
    @Override
    public void save(String data) {
        try{
            FileWriter outfile = new FileWriter("document.txt");
            outfile.write(data);
            outfile.close();
            System.out.println("document saved to file");
        }catch (IOException e){
            System.out.println("Error saving document to file: " + e.getMessage());
        }

    }
}
