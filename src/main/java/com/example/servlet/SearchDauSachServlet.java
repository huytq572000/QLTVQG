package com.example.servlet;

import dao.DauSachDAO;
import model.DauSach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchDauSach", value= "/search-dau-sach")
public class SearchDauSachServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String txtSearch = request.getParameter("txt");
        DauSachDAO dao = new DauSachDAO();
        List<DauSach> list = dao.searchByName(txtSearch);
        request.setAttribute("data1",list);
        request.getRequestDispatcher("dausach.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("dausach.jsp").forward(req,resp);
    }
}
