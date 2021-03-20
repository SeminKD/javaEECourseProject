package com.stud.courseProject.dataAccess;

import com.stud.courseProject.model.Student;
import com.stud.courseProject.model.DTO.StudBooksDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentData {

    public static ArrayList<Student> getStudents(){
        ArrayList<Student> list = new ArrayList<>();
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("select * from Student order by id_student");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Student student = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                list.add(student);
            }
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return null;
        }
        return list;
    }

    public static ArrayList<StudBooksDTO> getStudentsBooks(int id_student){
        ArrayList<StudBooksDTO> list = new ArrayList<>();
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("select b.author ,b.name_book,b.publish_house, publish_date, d.issue_date, d.return_period" +
                    " from book as b, discharge as d where d.id_book=b.id_book and " +
                    "d.id_student=?");
            ps.setInt(1,id_student);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                StudBooksDTO sb = new StudBooksDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                list.add(sb);
            }
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return null;
        }
        return list;
    }

    public static int addStudent(String name, String group){
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("insert into Student values(nextval('id_student_seq'), " +
                    "?, ?)");
            ps.setString(1,name);
            ps.setString(2,group);
            ps.executeUpdate();
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return 0;
        }
        return 1;
    }

    public static int deleteStudent(int id){
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("delete from Discharge where id_student=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            ps = connection.prepareStatement("delete from Student where id_student=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return 0;
        }
        return 1;
    }
    public static int editStudent(String name, String group, int id){
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("update Student set name_student=?," +
                    "stud_group=? where id_student=?");
            ps.setString(1,name);
            ps.setString(2,group);
            ps.setInt(3,id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return 0;
        }
        return 1;
    }
}
