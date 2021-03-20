package com.stud.courseProject.servlets.studentServlets;

import com.stud.courseProject.dataAccess.StudentData;
import com.stud.courseProject.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentDeleteServlet", value = "/delete-student")
public class StudentDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> list = StudentData.getStudents();
        if (list != null) {
            request.setAttribute("students", list);
            request.getRequestDispatcher("delete-student.jsp").forward(request, response);
        } else {
            String str = "Не удалось получить данные, необходимые для удаления студента";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int i = StudentData.deleteStudent(id);
        if (i == 1)
            response.sendRedirect("/students");
        else {
            String str = "Не удалось удалить студента";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
