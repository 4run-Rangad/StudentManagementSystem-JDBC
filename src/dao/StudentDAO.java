package dao;

import model.Student;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public void getAllStudents(){
        String sql = "SELECT * FROM students";
        try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                System.out.println(rs.getInt("ID") + " "+ rs.getString("name") + " " +
                        rs.getString("email") + " " + rs.getString("course") + " " +
                        rs.getInt("marks"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMarks(int id, int newMarks) {
        String sql = "UPDATE students SET marks = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, newMarks);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Student Updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id){
        String sql = "DELETE FROM students WHERE id = ?";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student Deleted!");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
