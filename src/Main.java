import dao.StudentDAO;
import model.Student;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();


        while(true){
            System.out.println("\n--- Student Management System---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("Choose option: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Course: ");
                    String course = sc.next();
                    System.out.print("Marks: ");
                    int marks = sc.nextInt();

                    Student s = new Student(name, email, course, marks);
                    dao.addStudent(s);
                    break;

                case 2:
                    dao.getAllStudents();
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    int id = sc.nextInt();
                    System.out.print("New Marks: ");
                    int newMarks = sc.nextInt();
                    dao.updateMarks(id, newMarks);
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int delId = sc.nextInt();
                    dao.deleteStudent(delId);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}
