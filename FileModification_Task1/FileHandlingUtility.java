import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // Method 1: Write to file (overwrite if exists)
    public static void writeFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("\n Successfully written to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method 2: Read from file
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("\n File Content of " + filename + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  → " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method 3: Append content to existing file
    public static void appendToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.newLine();
            writer.write(content);
            System.out.println("\n Successfully appended content to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }

    // Display welcome header
    public static void showWelcome() {
        System.out.println("-----------------------------------------------------");
        System.out.println("         JAVA FILE HANDLING UTILITY");
        System.out.println("-----------------------------------------------------");
        //System.out.println("  Internship: CODTECH\t\tTask: 1");
        //System.out.println("-----------------------------------------------------");
    }

    // Main method - User Interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        showWelcome();

        System.out.print("\nEnter filename (e.g., myfile.txt): ");
        String filename = scanner.nextLine();

        System.out.println("\nChoose an operation:");
        System.out.println(" 1. Write to file");
        System.out.println(" 2. Read from file");
        System.out.println(" 3. Append to file");
        System.out.print("\nEnter your choice (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume the leftover newline

        switch (choice) {
            case 1:
                System.out.print("\nEnter content to WRITE: ");
                String writeContent = scanner.nextLine();
                writeFile(filename, writeContent);
                break;
            case 2:
                readFile(filename);
                break;
            case 3:
                System.out.print("\n Enter content to APPEND: ");
                String appendContent = scanner.nextLine();
                appendToFile(filename, appendContent);
                break;
            default:
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
        }

        System.out.println("\n-----------------------------------------------------");
        System.out.println("Task Completed  \nDate: " + java.time.LocalDate.now());
        System.out.println("-----------------------------------------------------");

        scanner.close();
    }
}
