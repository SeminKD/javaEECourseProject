package com.stud.courseProject.servlets.studentServlets;

import com.stud.courseProject.dataAccess.StudentData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentAddServlet", value = "/add-student")
public class StudentAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add-student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String name = request.getParameter("name");
        String group = request.getParameter("group");
        int i = StudentData.addStudent(name, group);
        if (i == 1)
            response.sendRedirect("/students");
        else {
            String str = "Не удалось добавить студента";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
