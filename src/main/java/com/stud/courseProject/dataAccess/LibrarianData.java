package com.stud.courseProject.dataAccess;

import com.stud.courseProject.model.DTO.LibrarianDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibrarianData {

    public static ArrayList<LibrarianDTO> getLibrarians(){
        ArrayList<LibrarianDTO> list = new ArrayList<>();
        try(Connection connection=DataAccess.getNewConnection()) {
            PreparedStatement ps = connection.prepareStatement("select l.id_librarian," +
                    "l.name_librarian,lib.address from librarian as l, library as lib " +
                    "where l.id_library=lib.id_library");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                LibrarianDTO librarian = new LibrarianDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                list.add(librarian);
            }
        } catch (SQLException e) {
            DataAccess.writeError(e);
            return null;
        }
        return list;
    }
}
