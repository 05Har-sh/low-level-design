package org.LLD.DocEditor.persistence;

// Placeholder DBStorage implementation
public class DbStorage implements Persistence {
    @Override
    public void save(String data) {
        // Save to DB
        System.out.println("Saved to database " + data);
    }
}
