package com.service;

import com.model.Student;

import java.util.List;

public interface StudentServices {
    void addStudent(Student student);
    boolean deleteStudent(int id);
    List<Student> getAllStudent();
    void updateStudent(int id);
}
