package org.LLD.DocEditor;

import org.LLD.DocEditor.editor.DocumentEditor;
import org.LLD.DocEditor.model.Document;
import org.LLD.DocEditor.persistence.FileStorage;
import org.LLD.DocEditor.persistence.Persistence;

import java.util.Scanner;

public class DocumentEditorClient {

    public static void main(String[] args) {

        Document document = new Document();
        Persistence persistence = new FileStorage();
        DocumentEditor editor = new DocumentEditor(document, persistence);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = readChoice(scanner);

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter text: ");
                    editor.addText(scanner.nextLine());
                }

                case 2 -> {
                    System.out.print("Enter image path: ");
                    editor.addImage(scanner.nextLine());
                }

                case 3 -> editor.addNewLine();

                case 4 -> editor.addTabSpace();

                case 5 -> {
                    System.out.println("\n----- Document -----");
                    System.out.println(editor.renderDoc());
                    System.out.println("--------------------");
                }

                case 6 -> editor.saveDoc();

                case 7 -> {
                    running = false;
                    System.out.println("Exiting Document Editor...");
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {

        System.out.println();
        System.out.println("================================");
        System.out.println("         DOCUMENT EDITOR         ");
        System.out.println("================================");
        System.out.println("1. Add Text");
        System.out.println("2. Add Image");
        System.out.println("3. Add New Line");
        System.out.println("4. Add Tab Space");
        System.out.println("5. View Document");
        System.out.println("6. Save Document");
        System.out.println("7. Exit");
        System.out.println("================================");
        System.out.print("Enter your choice: ");
    }

    private static int readChoice(Scanner scanner) {

        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int choice = scanner.nextInt();

        // Consume the newline left behind by nextInt()
        scanner.nextLine();

        return choice;
    }
}