package com.stud.courseProject.servlets.dischargeServlets;

import com.stud.courseProject.dataAccess.*;
import com.stud.courseProject.model.DTO.BookDTO;
import com.stud.courseProject.model.DTO.LibrarianDTO;
import com.stud.courseProject.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DischargeAddServlet", value = "/add-discharge")
public class DischargeAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<BookDTO> books = DischargeData.getBooksForDischarges();
        ArrayList<Student> students = StudentData.getStudents();
        ArrayList<LibrarianDTO> librarians = LibrarianData.getLibrarians();
        if (books != null && students != null && librarians != null) {
            request.setAttribute("books", books);
            request.setAttribute("students", students);
            request.setAttribute("librs", librarians);
            request.getRequestDispatcher("add-discharge.jsp").forward(request, response);
        } else {
            String str = "Не удалось получить данные, необходимые для добавления выписки";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        int id_book = Integer.parseInt(request.getParameter("id_book"));
        int id_student = Integer.parseInt(request.getParameter("id_student"));
        int id_librarian = Integer.parseInt(request.getParameter("id_librarian"));
        String period = request.getParameter("period");
        int i = DischargeData.addDischarge(id_student, id_book, id_librarian, period);
        if (i == 1)
            response.sendRedirect("/discharges");
        else {
            String str = "Не удалось добавить выписку";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
