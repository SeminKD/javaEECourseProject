package com.stud.courseProject.servlets.studentServlets;

import com.stud.courseProject.dataAccess.StudentData;
import com.stud.courseProject.model.DTO.StudBooksDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudBooksServlet", value = "/students-books")
public class StudBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<StudBooksDTO> list = StudentData.getStudentsBooks(Integer.parseInt(request.getParameter("id")));
        if (list != null) {
            request.setAttribute("books", list);
            request.getRequestDispatcher("students-books.jsp").forward(request, response);
        } else {
            String str = "Не удалось получить данные о книгах на руках студента";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
