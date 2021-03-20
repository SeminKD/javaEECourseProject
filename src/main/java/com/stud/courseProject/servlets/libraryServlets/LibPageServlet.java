package com.stud.courseProject.servlets.libraryServlets;

import com.stud.courseProject.dataAccess.LibraryData;
import com.stud.courseProject.model.Library;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LibPageServlet", value = "/libraries")
public class LibPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Library> list = LibraryData.getLibraries();
        if (list != null) {
            request.setAttribute("libs", list);
            request.getRequestDispatcher("libs.jsp").forward(request, response);
        } else {
            String str = "Не удалось получить список библиотек";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
