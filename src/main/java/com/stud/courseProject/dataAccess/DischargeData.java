package com.stud.courseProject.dataAccess;

import com.stud.courseProject.model.DTO.BookDTO;
import com.stud.courseProject.model.DTO.DischargeBookDTO;
import com.stud.courseProject.model.DTO.DischargeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DischargeData {

    public static ArrayList<DischargeDTO> getDischarges() {
        ArrayList<DischargeDTO> list = new ArrayList<>();
        try (Connection connection = DataAccess.getNewConnection()) {
            PreparedStatement ps = connection.prepareStatement("select d.id_discharge, s.id_student, s.name_student, s.stud_group, b.id_book,b.name_book, b.author, b.publish_house, b.publish_date,\n" +
                    "\t\tl.name_librarian, d.issue_date, d.return_period\n" +
                    "from student as s, book as b, librarian as l, discharge as d\n" +
                    "where s.id_student=d.id_student and l.id_librarian=d.id_librarian and d.id_book=b.id_book order by d.id_discharge");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String info_student = resultSet.getInt(2) + ", " + resultSet.getString(3)
                        + ", " + resultSet.getString(4);
                DischargeBookDTO info_book = new DischargeBookDTO(resultSet.getInt(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8), resultSet.getString(9));
                DischargeDTO dis = new DischargeDTO(id, info_student, info_book, resultSet.getString(10),
                        resultSet.getString(11), resultSet.getString(12));
                list.add(dis);
            }
        } catch (SQLException e) {
            DataAccess.writeError(e);
            return null;
        }
        return list;
    }

    public static int deleteDischarge(int id, int id_book) {
        try (Connection connection = DataAccess.getNewConnection()) {
            PreparedStatement ps = connection.prepareStatement("delete from Discharge where id_discharge=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps = connection.prepareStatement("update Book set quantity=quantity+1 where id_book=?");
            ps.setInt(1, id_book);
            ps.executeUpdate();
        } catch (SQLException e) {
            DataAccess.writeError(e);
            return 0;
        }
        return 1;
    }

    public static int editDischarge(int id, String period) {
        try (Connection connection = DataAccess.getNewConnection()) {
            PreparedStatement ps = connection.prepareStatement("update discharge set return_period=? where id_discharge=?");
            ps.setString(1, period);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            DataAccess.writeError(e);
            return 0;
        }
        return 1;
    }

    public static int addDischarge(int id_student, int id_book, int id_librarian,
                                   String return_period) {
        try (Connection connection = DataAccess.getNewConnection()) {
            PreparedStatement ps = connection.prepareStatement("insert into discharge values(nextval('id_discharge_seq'),?,?,?,?,?)");
            ps.setInt(1, id_book);
            ps.setInt(2, id_student);
            ps.setInt(3, id_librarian);
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            ps.setString(4, date);
            ps.setString(5, return_period);
            ps.executeUpdate();
            ps = connection.prepareStatement("update Book set quantity=quantity-1 where id_book=?");
            ps.setInt(1, id_book);
            ps.executeUpdate();
        } catch (SQLException e) {
            DataAccess.writeError(e);
            return 0;
        }
        return 1;
    }

    public static ArrayList<BookDTO> getBooksForDischarges(){
        ArrayList<BookDTO> list = new ArrayList<>();
        try(Connection connection = DataAccess. getNewConnection()){
            PreparedStatement ps = connection.prepareStatement("select b.id_book, b.name_book,b.author,\n" +
                    "b.publish_house, b.publish_date, b.quantity, l.address from Book as b, Library as l\n" +
                    "where b.id_library=l.id_library and quantity>0 order by b.id_book");
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
}
