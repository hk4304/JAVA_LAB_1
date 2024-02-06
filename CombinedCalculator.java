import java.util.Arrays;
import java.util.Scanner;

public class CombinedCalculator {
    public static void main(String[] args) {
        CombinedCalculator calculator = new CombinedCalculator();
        Scanner scn = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Array Operation");
            System.out.println("6. Exit");

            int choice = scn.nextInt();

            switch (choice) {
                case 1:
                    calculator.performBinaryOperation('+');
                    break;

                case 2:
                    calculator.performBinaryOperation('-');
                    break;

                case 3:
                    calculator.performBinaryOperation('*');
                    break;

                case 4:
                    calculator.performBinaryOperation('/');
                    break;

                case 5:
                    calculator.performArrayOperation();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        scn.close();
    }

    private void performBinaryOperation(char operator) {
        double[] numbers = inputNumbers();
        double firstNumber = numbers[0];
        double secondNumber = numbers[1];

        switch (operator) {
            case '+':
                System.out.println("The Addition of " + firstNumber + " and " + secondNumber + " is " + addition(firstNumber, secondNumber));
                break;

            case '-':
                System.out.println("The Subtraction of " + firstNumber + " and " + secondNumber + " is " + subtraction(firstNumber, secondNumber));
                break;

            case '*':
                System.out.println("The Multiplication of " + firstNumber + " and " + secondNumber + " is " + multiplication(firstNumber, secondNumber));
                break;

            case '/':
                System.out.println("The Division of " + firstNumber + " and " + secondNumber + " is " + division(firstNumber, secondNumber));
                break;

            default:
                System.out.println("Invalid operation");
                break;
        }
    }

    private void performArrayOperation() {
        double[] arr = getArrayInput();

        System.out.println("Choose an array operation:");
        System.out.println("1. Variance");
        System.out.println("2. Standard Deviation");
        System.out.println("3. Average");

        Scanner scn = new Scanner(System.in);
        int arrayOperationChoice = scn.nextInt();

        switch (arrayOperationChoice) {
            case 1:
                System.out.println("Variance: " + varianceOfArray(arr));
                break;

            case 2:
                System.out.println("Standard Deviation: " + standardDeviationOfArray(arr));
                break;

            case 3:
                System.out.println("Average: " + calculateMean(arr));
                break;

            default:
                System.out.println("Invalid array operation");
                break;
        }
    }

    private double[] inputNumbers() {
        double numbers[] = new double[2];
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter First Number:");
        double firstNumber = scan.nextDouble();
        numbers[0] = firstNumber;

        System.out.println("Enter Second Number :");
        double secondNumber = scan.nextDouble();
        numbers[1] = secondNumber;

        return numbers;
    }

    private double[] getArrayInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        double[] array = new double[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextDouble();
        }

        return array;
    }

    private double addition(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    private double subtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    private double multiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    private double division(double firstNumber, double secondNumber) {
        if (secondNumber != 0) {
            return firstNumber / secondNumber;
        } else {
            System.out.println("Error: Cannot divide by zero");
            return Double.NaN;
        }
    }

    private double sumOfArray(double[] array) {
        return Arrays.stream(array).sum();
    }

    private double varianceOfArray(double[] array) {
        double mean = calculateMean(array);
        double sumSquaredDifferences = 0;

        for (double num : array) {
            sumSquaredDifferences += Math.pow(num - mean, 2);
        }

        return sumSquaredDifferences / array.length;
    }

    private double standardDeviationOfArray(double[] array) {
        return Math.sqrt(varianceOfArray(array));
    }

    private double calculateMean(double[] array) {
        return Arrays.stream(array).sum() / array.length;
    }
}
