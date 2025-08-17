package jdbc.service;

import jdbc.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService{

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    List<Student> studentList = new ArrayList<>();

    // inserting student into the database
    @Override
    public void insertStudent(Student student){
        String sql = "insert into student (id, name, marks) values(?,?,?)";
        try (Connection connection = ConnectionService.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,student.getStudentId());
            statement.setString(2,student.getName());
            statement.setInt(3,student.getMarks());

            int rows =statement.executeUpdate();
            if (rows>0)
                System.out.println("success");
             else
                System.out.println("fail");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void getAllStudent() {
        try (Connection connection = ConnectionService.getConnection()) {
            String sql = "Select * from student";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet row= statement.executeQuery();
            System.out.println("#############Student List###############");
            while (row.next()){
                System.out.println("\n------------------------------\nID : "+row.getInt("id")+"\nName: "+row.getString("name")+"\nMarks: "+row.getInt("marks")+"\n------------------------------\n");

            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean deleteStudent(int id) {
        try(Connection connection = ConnectionService.getConnection()) {
            String sql = "delete from student where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int rows = statement.executeUpdate();

            return rows>0;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateStudent(int id, String name, int marks) {
        try(Connection connection = ConnectionService.getConnection()){
            String sql = "update student set name = ?, marks=? where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2,marks);
            statement.setInt(3,id);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getDataOfAStudent(int id) {

        try(Connection connection = ConnectionService.getConnection()){
            String sql ="Select * from student where id ="+id;
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                int idd = resultSet.getInt("id");
                String name= resultSet.getString("name");
                int marks = resultSet.getInt("marks");
                System.out.println("\n------------------------------\nID: "+id+"\nName: "+name+"\nMarks: "+marks+"\n------------------------------\n");
                System.out.println("\n");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
