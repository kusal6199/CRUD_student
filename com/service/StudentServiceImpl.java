package com.service;

import com.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentServices{

    static List<Student> studentList = new ArrayList<>();
    @Override
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student Added Successful and size of list------> "+studentList.size());
    }

    @Override
    public boolean deleteStudent(int id) {
        for (int i = 0 ; i< studentList.size(); i++){
            if (studentList.get(i).getRollNo()==id) {
                studentList.remove(i);
                return true;
            }
        }
        return  false;
    }

    @Override
    public List<Student> getAllStudent() {

        return studentList;
    }

    @Override
    public void updateStudent(int id) {

       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter name: ");
       String newName = scanner.next();

        System.out.println("Enter marks: ");
        int newMarks=scanner.nextInt();

        for (int i =0; i < studentList.size();i++){
            if (studentList.get(i).getRollNo()== id) {
               Student student = studentList.get(i);
                System.out.println("before update: "+ student);
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("After update: "+student);
                break;

            }
        }

    }
}
