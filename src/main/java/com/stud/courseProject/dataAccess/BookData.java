package com.stud.courseProject.dataAccess;

import com.stud.courseProject.model.DTO.BookDTO;
import com.stud.courseProject.model.DTO.EditBookDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookData {

    public static ArrayList<BookDTO> getBooks(){
        ArrayList<BookDTO> list = new ArrayList<>();
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("select b.id_book, b.name_book,b.author,\n" +
                    "b.publish_house, b.publish_date, b.quantity, l.address from Book as b, Library as l\n" +
                    "where b.id_library=l.id_library order by b.id_book");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                BookDTO book = new BookDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getString(7)
                );
                list.add(book);
            }
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return null;
        }
        return list;
    }

    public static int deleteBook(int id){
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("delete from Discharge where id_book=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            ps = connection.prepareStatement("delete from Book where id_book=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return 0;
        }
        return 1;
    }

    public static EditBookDTO showEditingBook(int id){
        EditBookDTO book = new EditBookDTO();
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("select id_book, name_book,author,\n" +
                    "publish_house, publish_date, quantity from Book \n" +
                    "where id_book=?");
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                        book.setId_book(resultSet.getInt(1));
                        book.setName_book(resultSet.getString(2));
                        book.setAuthor(resultSet.getString(3));
                        book.setPublish_house(resultSet.getString(4));
                        book.setPublish_date(resultSet.getString(5));
                        book.setQuantity(resultSet.getInt(6));
            }
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return null;
        }
        return book;
    }

    public static int updateBook(int id, String name, String author, String publish_house, String publish_date,
                                  int quantity, int id_library){
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("update Book set name_book=?, author=?, publish_house=?," +
                    "publish_date=?, quantity=?, id_library=? where id_book=?");
            ps.setString(1,name);
            ps.setString(2,author);
            ps.setString(3,publish_house);
            ps.setString(4,publish_date);
            ps.setInt(5,quantity);
            ps.setInt(6, id_library);
            ps.setInt(7,id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return 0;
        }
        return 1;
    }

    public static int addBook(String name, String author, String publish_house, String publish_date,
                               int quantity, int id_library){
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("insert into Book values(nextval('id_book_seq')," +
                    "?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,author);
            ps.setString(3,publish_house);
            ps.setString(4,publish_date);
            ps.setInt(5,quantity);
            ps.setInt(6,id_library);
            ps.executeUpdate();
        }
        catch (SQLException e){
            DataAccess.writeError(e);
            return 0;
        }
        return 1;
    }
}
