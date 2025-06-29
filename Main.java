import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<String> studentNames;
    private ArrayList<Double> studentGrades;
    private Scanner scanner;

    public Main() {
        studentNames = new ArrayList<>();
        studentGrades = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("=== Student Grade Tracker ===");
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    calculateAverage();
                    break;
                case 4:
                    findHighestScore();
                    break;
                case 5:
                    findLowestScore();
                    break;
                case 6:
                    generateSummaryReport();
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add a new student and grade");
        System.out.println("2. View all students and grades");
        System.out.println("3. Calculate average grade");
        System.out.println("4. Find highest score");
        System.out.println("5. Find lowest score");
        System.out.println("6. Generate summary report");
        System.out.println("7. Exit");
    }

    private void addStudent() {
        System.out.println("\nAdd New Student");
        String name = getStringInput("Enter student name: ");
        double grade = getDoubleInput("Enter student grade (0-100): ");
        
        // Validate grade
        while (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            grade = getDoubleInput("Enter student grade (0-100): ");
        }
        
        studentNames.add(name);
        studentGrades.add(grade);
        System.out.println("Student added successfully!");
    }

    private void viewAllStudents() {
        if (studentNames.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        
        System.out.println("\nList of Students and Grades:");
        System.out.println("----------------------------");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.printf("%-20s: %.2f%n", studentNames.get(i), studentGrades.get(i));
        }
    }

    private void calculateAverage() {
        if (studentGrades.isEmpty()) {
            System.out.println("No grades available to calculate average.");
            return;
        }
        
        double sum = 0;
        for (double grade : studentGrades) {
            sum += grade;
        }
        double average = sum / studentGrades.size();
        System.out.printf("\nAverage grade: %.2f%n", average);
    }

    private void findHighestScore() {
        if (studentGrades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        
        double highest = studentGrades.get(0);
        int index = 0;
        
        for (int i = 1; i < studentGrades.size(); i++) {
            if (studentGrades.get(i) > highest) {
                highest = studentGrades.get(i);
                index = i;
            }
        }
        
        System.out.printf("\nHighest score: %.2f by %s%n", highest, studentNames.get(index));
    }

    private void findLowestScore() {
        if (studentGrades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        
        double lowest = studentGrades.get(0);
        int index = 0;
        
        for (int i = 1; i < studentGrades.size(); i++) {
            if (studentGrades.get(i) < lowest) {
                lowest = studentGrades.get(i);
                index = i;
            }
        }
        
        System.out.printf("\nLowest score: %.2f by %s%n", lowest, studentNames.get(index));
    }

    private void generateSummaryReport() {
        if (studentGrades.isEmpty()) {
            System.out.println("No data available for report.");
            return;
        }
        
        System.out.println("\n=== Grade Summary Report ===");
        System.out.println("Number of students: " + studentNames.size());
        
        // Calculate average
        double sum = 0;
        for (double grade : studentGrades) {
            sum += grade;
        }
        double average = sum / studentGrades.size();
        System.out.printf("Average grade: %.2f%n", average);
        
        // Find highest and lowest
        double highest = studentGrades.get(0);
        double lowest = studentGrades.get(0);
        int highIndex = 0;
        int lowIndex = 0;
        
        for (int i = 1; i < studentGrades.size(); i++) {
            if (studentGrades.get(i) > highest) {
                highest = studentGrades.get(i);
                highIndex = i;
            }
            if (studentGrades.get(i) < lowest) {
                lowest = studentGrades.get(i);
                lowIndex = i;
            }
        }
        
        System.out.printf("Highest score: %.2f by %s%n", highest, studentNames.get(highIndex));
        System.out.printf("Lowest score: %.2f by %s%n", lowest, studentNames.get(lowIndex));
        
        // Display all students
        System.out.println("\nAll Students:");
        System.out.println("----------------------------");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.printf("%-20s: %.2f%n", studentNames.get(i), studentGrades.get(i));
        }
    }

    // Helper methods for input
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static void main(String[] args) {
        Main tracker = new Main();
        tracker.run();
    }
}