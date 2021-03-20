package com.stud.courseProject.servlets.bookServlets;

import com.stud.courseProject.dataAccess.BookData;
import com.stud.courseProject.model.DTO.BookDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BookPageServlet", value = "/books")
public class BookPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<BookDTO> list = BookData.getBooks();
        if (list != null) {
            request.setAttribute("books", list);
            request.getRequestDispatcher("books-page.jsp").forward(request, response);
        } else {
            String str = "Не удалось получить список книг";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int i = BookData.deleteBook(id);
        if (i == 1) doGet(request, response);
        else {
            String str = "Не удалось удалить книгу";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
