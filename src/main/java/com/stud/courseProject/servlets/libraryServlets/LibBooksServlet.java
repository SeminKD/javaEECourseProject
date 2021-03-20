package com.stud.courseProject.servlets.libraryServlets;

import com.stud.courseProject.dataAccess.LibraryData;
import com.stud.courseProject.model.DTO.LibBooksDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LibBooksServlet", value = "/lib-books")
public class LibBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<LibBooksDTO> list = LibraryData.getLibBooks(Integer.parseInt(request.getParameter("id")));
        if(list!=null) {
            request.setAttribute("books", list);
            request.getRequestDispatcher("lib-books.jsp").forward(request, response);
        }
        else {
            String str = "Не удалось получить данные о книгах в библиотеке";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }

}
