package jdbc.view;


import jdbc.model.Student;
import jdbc.service.StudentService;
import jdbc.service.StudentServiceImpl;

import java.util.Scanner;

public class TestStudent {
    public static void main(String[] args) throws Exception{

       while (true){
           System.out.println("\n===== Student Management System =====");
           System.out.println("1. Add Student");
           System.out.println("2. Update Student");
           System.out.println("3. Delete Student");
           System.out.println("4. View All Students");
           System.out.println("5. Get particular Student");
           System.out.println("6. Exit");
           System.out.print("Enter choice: ");
           int choice = scanner.nextInt();

           switch (choice){
               case 1->addStudent();
               case 2->updateStudent();
               case 3-> deleteStudent();
               case 4->getAllStudent();
               case 5-> getDataOfAStudent();
               case 6-> {
                   System.out.println("Existing....");
                   System.exit(0);
               }
               default -> System.out.println("Invalid Input: Try Again: ");
           }

       }

    }

    static char key;
    static StudentService service = new StudentServiceImpl();
    static Scanner scanner= new Scanner(System.in);


    static void addStudent() throws Exception {
        do {
            Student student = new Student();

            System.out.print("Enter student ID: ");
            student.setStudentId(scanner.nextInt());


            System.out.print("Enter student Name: ");
            student.setName(scanner.next());

            System.out.print("Enter student Marks: ");
            student.setMarks(scanner.nextInt());

            service.insertStudent(student);
            System.out.println("✅ Student added successfully!\n");

            System.out.print("Do you want to add more [y/n]: ");
            key = scanner.next().charAt(0);

        } while (key == 'y');
    }


    static void getAllStudent(){
        service.getAllStudent();
    }

    static void updateStudent() {
        do {
            System.out.print("Enter ID to update: ");
            int id = scanner.nextInt(); // always nextLine + parseInt

            System.out.print("Enter the name: ");
            String name = scanner.next(); // supports spaces

            System.out.print("Enter the marks: ");
            int marks =scanner.nextInt(); // always nextLine + parseInt

            service.updateStudent(id, name, marks);
            System.out.println("✅ Student updated successfully!");

            System.out.print("Do you want to continue [y/n]: ");
             key = scanner.next().charAt(0);
        } while (key == 'y');
    }


    static void deleteStudent(){
        do {
            System.out.println("Enter ID to delete student: ");
            int id = scanner.nextInt();
            service.deleteStudent(id);

            System.out.println("do you want to delete more: ");
            key=scanner.next().charAt(0);

        }while (key=='y');
    }

    static void getDataOfAStudent(){
        do{
            System.out.println("enter id to get: ");
           int id = scanner.nextInt();

            service.getDataOfAStudent(id);
        }while (key=='y');
    }
}
