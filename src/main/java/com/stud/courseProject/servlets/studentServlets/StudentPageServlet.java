package com.stud.courseProject.servlets.studentServlets;

import com.stud.courseProject.dataAccess.StudentData;
import com.stud.courseProject.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentPageServlet", value = "/students")
public class StudentPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> list = StudentData.getStudents();
        if (list != null) {
            request.setAttribute("students", list);
            request.getRequestDispatcher("students-page.jsp").forward(request, response);
        } else {
            String str = "Не удалось получить список стдуентов";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
