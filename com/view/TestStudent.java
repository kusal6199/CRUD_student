package com.view;

import com.model.Student;
import com.service.StudentServiceImpl;
import com.service.StudentServices;

import java.util.List;
import java.util.Scanner;

public class TestStudent {

    static StudentServices service = new StudentServiceImpl();
    public static void main(String[] args) {
        insertStudent();
        deleteStudent();
        updateStudent();
        getAllStudent();
    }



    static void insertStudent(){

        Scanner sc= new Scanner(System.in);

        char key;
        do{
            Student student = new Student();
            System.out.println("enter id: ");
            student.setRollNo(sc.nextInt());

            System.out.println("enter name: ");
            student.setName(sc.next());

            System.out.println("enter marks: ");
            student.setMarks(sc.nextInt());

//            StudentServices service = new StudentServiceImpl();

            service.addStudent(student);

            System.out.println("do you want to continue[y/n]: ");
            key = sc.next().charAt(0);
        }while (key=='y');

    }

    static void deleteStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id to delete student: ");
        int id = scanner.nextInt();

//        StudentServices services = new StudentServiceImpl();
        if(service.deleteStudent(id))
            System.out.println("Student with id: "+ id+" is deleted");

        else
            System.out.println("user not found");
    }

    static void updateStudent(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("enter the id to update student: ");
        int id=scanner.nextInt();

//        StudentServices services = new StudentServiceImpl();
        service.updateStudent(id);

    }

    static void getAllStudent(){
//        StudentServices services = new StudentServiceImpl();
        List<Student> list = service.getAllStudent();
        for (Student student: list){
            System.out.println(student);
        }
    }

}
