import java.io.*;
import java.util.*;

public class part1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dataInputStream = new DataInputStream(System.in);
        Console console = System.console();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Command Line Arguments");
            System.out.println("2. Scanner");
            System.out.println("3. BufferedReader");
            System.out.println("4. DataInputStream");
            System.out.println("5. Console");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    commandLineArguments(args);
                    break;
                case 2:
                    scannerInput(scanner);
                    break;
                case 3:
                    bufferedReaderInput(bufferedReader);
                    break;
                case 4:
                    dataInputStreamInput(dataInputStream);
                    break;
                case 5:
                    consoleInput(console);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private static void commandLineArguments(String[] args) {
        System.out.println("Command Line Arguments:");
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    private static void scannerInput(Scanner scanner) {
        System.out.print("Enter input using Scanner: ");
        String input = scanner.nextLine();
        System.out.println("Input entered: " + input);
    }

    private static void bufferedReaderInput(BufferedReader bufferedReader) {
        try {
            System.out.print("Enter input using BufferedReader: ");
            String input = bufferedReader.readLine();
            System.out.println("Input entered: " + input);
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }

    private static void dataInputStreamInput(DataInputStream dataInputStream) {
        try {
            System.out.print("Enter input using DataInputStream: ");
            String input = dataInputStream.readLine();
            System.out.println("Input entered: " + input);
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }

    private static void consoleInput(Console console) {
        if (console == null) {
            System.out.println("Console not available.");
            return;
        }
        System.out.print("Enter input using Console: ");
        String input = console.readLine();
        System.out.println("Input entered: " + input);
    }
}
