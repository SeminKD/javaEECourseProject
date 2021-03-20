package com.stud.courseProject.servlets.dischargeServlets;

import com.stud.courseProject.dataAccess.DischargeData;
import com.stud.courseProject.model.DTO.DischargeDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DischargesPageServlet", value = "/discharges")
public class DischargesPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DischargeDTO> list = DischargeData.getDischarges();
        if (list != null) {
            request.setAttribute("dises", list);
            request.getRequestDispatcher("discharge-page.jsp").forward(request, response);
        }
        else {
            String str = "Не удалось получить список выписок";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_book = Integer.parseInt(request.getParameter("id_book"));
        int i = DischargeData.deleteDischarge(id, id_book);
        if (i == 1)
            doGet(request, response);
        else {
            String str = "Не удалось удалить выписку";
            request.setAttribute("error", str);
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
