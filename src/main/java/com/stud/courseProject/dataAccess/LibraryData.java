package com.stud.courseProject.dataAccess;

import com.stud.courseProject.model.*;
import com.stud.courseProject.model.DTO.LibBooksDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibraryData {

    public static ArrayList<Library> getLibraries(){
        ArrayList<Library> list = new ArrayList<>();
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("select * from Library order by id_library");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Library lib = new Library(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                list.add(lib);
            }
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return null;
        }
        return list;
    }

    public static ArrayList<LibBooksDTO> getLibBooks(int id_lib){
        ArrayList<LibBooksDTO> list = new ArrayList<>();
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("select author ,name_book, publish_house, publish_date, quantity" +
                    " from book where id_library=?");
            ps.setInt(1,id_lib);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                LibBooksDTO lb = new LibBooksDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                );
                list.add(lb);
            }
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return null;
        }
        return list;
    }

}
