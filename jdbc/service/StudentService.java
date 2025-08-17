package jdbc.service;

import jdbc.model.Student;

import java.util.List;

public interface StudentService {
    void getAllStudent();
    void insertStudent(Student student);
    boolean deleteStudent(int id);
    void updateStudent(int id, String name, int marks);
    void getDataOfAStudent(int id);

}
