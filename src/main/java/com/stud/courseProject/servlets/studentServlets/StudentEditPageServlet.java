package com.stud.courseProject.servlets.studentServlets;

import com.stud.courseProject.dataAccess.StudentData;
import com.stud.courseProject.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentEditPageServlet", value = "/edit-student")
public class StudentEditPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> list = StudentData.getStudents();
        if (list != null) {
            request.setAttribute("students", list);
            request.getRequestDispatcher("edit-student.jsp").forward(request, response);
        } else {
            String str = "Не удалось получить данные, необходимые для редактирования студента";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String group = request.getParameter("group");
        int i = StudentData.editStudent(name, group, id);
        if (i == 1)
            response.sendRedirect("/students");
        else {
            String str = "Не удалось получить изменить студента";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
