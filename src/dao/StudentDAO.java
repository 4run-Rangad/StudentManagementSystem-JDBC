package dao;

import model.Student;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {
    public void addStudent(Student s){
        String sql ="INSERT INTO students(name,email,course,marks) VALUES(?,?,?,?)";

        try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,s.getName());
            ps.setString(2,s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4,s.getMarks());
            ps.executeUpdate();
            System.out.println("Student Added Successfully!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
