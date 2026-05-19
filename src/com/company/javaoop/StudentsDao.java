package com.company.javaoop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentsDao {
    public void addStudent(Student student) {
        String sql = "INSERT INTO students(name , grade )Values(? , ?)";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setDouble(2, student.getGrade());
                ps.executeUpdate();
                System.out.println("Insert : " +  student.getName());
            } catch(SQLException e){
                System.out.println("Error order ");
                e.printStackTrace();
            }
    }
    public void printAll(){
        String sql = "select * from students";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getNString("name");
                double grade = rs.getDouble("grade");
                System.out.println(" id| " + id + " " + "| name | " + name + " " + "|grade| "+grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(int id , String newName ,double newGrade ) {
        String sql = "update students set name = ? , grade = ? where id = ? ";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newName);
            ps.setDouble(2, newGrade);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Student Update ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(int id ){
        String sql = "delete from students where id = ? ";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , id );
            ps.executeUpdate();
            System.out.println(" delete done ");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }





