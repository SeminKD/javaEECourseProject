package com.stud.courseProject.servlets.bookServlets;

import com.stud.courseProject.dataAccess.BookData;
import com.stud.courseProject.dataAccess.LibraryData;
import com.stud.courseProject.model.DTO.EditBookDTO;
import com.stud.courseProject.model.Library;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EditBookServlet", value = "/edit-book")
public class EditBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EditBookDTO book = BookData.showEditingBook(id);
        ArrayList<Library> libs = LibraryData.getLibraries();
        if (book != null && libs!=null) {
            request.setAttribute("book", book);
            request.setAttribute("libraries", libs);
            request.getRequestDispatcher("edit-book.jsp").forward(request, response);
        } else {
            String str = "Не удалось получить данные, необходимые для редактирования книги";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String publish_house = request.getParameter("publish_house");
        String publish_date = request.getParameter("publish_date");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int id_library = Integer.parseInt(request.getParameter("id_library"));
        int i = BookData.updateBook(id, name, author, publish_house, publish_date, quantity, id_library);
        if (i == 1)
            response.sendRedirect("/books");
        else {
            String str = "Не удалось изменить книгу";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
