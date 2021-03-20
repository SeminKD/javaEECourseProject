package com.stud.courseProject.servlets.dischargeServlets;

import com.stud.courseProject.dataAccess.DischargeData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DischargeEditServlet", value = "/edit-discharge")
public class DischargeEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String period = request.getParameter("period");
        request.setAttribute("period", period);
        request.setAttribute("id", id);
        request.getRequestDispatcher("edit-discharge.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        int id = Integer.parseInt(request.getParameter("id"));
        String date = request.getParameter("date");
        int i = DischargeData.editDischarge(id, date);
        if (i == 1)
            response.sendRedirect("/discharges");
        else {
            String str = "Не удалось изменить выписку";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
