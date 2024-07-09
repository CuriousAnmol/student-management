import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> students;
    private int nextId;

    public StudentManagement() {
        students = new ArrayList<>();
        nextId = 1;
    }

    public void addStudent(String name, int age, String major) {
        Student student = new Student(nextId++, name, age, major);
        students.add(student);
        System.out.println("Student added: " + student);
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void updateStudent(int id, String name, int age, String major) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setMajor(major);
                System.out.println("Student updated: " + student);
                return;
            }
        }
        System.out.println("Student not found with ID: " + id);
    }

    public void deleteStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student removed: " + student);
                return;
            }
        }
        System.out.println("Student not found with ID: " + id);
    }

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter major: ");
                    String major = scanner.nextLine();
                    management.addStudent(name, age, major);
                    break;
                case 2:
                    management.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter student ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new major: ");
                    String newMajor = scanner.nextLine();
                    management.updateStudent(idToUpdate, newName, newAge, newMajor);
                    break;
                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    management.deleteStudent(idToDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
