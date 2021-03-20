package com.stud.courseProject.servlets.librarianServlets;

import com.stud.courseProject.dataAccess.LibrarianData;
import com.stud.courseProject.model.DTO.LibrarianDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LibrarianPageServlet", value = "/librarians")
public class LibrarianPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<LibrarianDTO> list = LibrarianData.getLibrarians();
        if (list != null) {
            request.setAttribute("librarians", list);
            request.getRequestDispatcher("librarians-page.jsp").forward(request, response);
        } else {
            String str = "Не удалось получить список библиотекарей";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }

}
