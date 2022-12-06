package com.example.servlet;



import dao.NhaCungCapDAO;

import model.NhaCungCap;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="SearchServlet", urlPatterns ="/search")
public class SearchNCCServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String txtSearch = request.getParameter("txt");
        NhaCungCapDAO dao = new NhaCungCapDAO();
        List<NhaCungCap> list = dao.searchByName(txtSearch);
        request.setAttribute("data",list);
        request.getRequestDispatcher("trangchu.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("trangchu.jsp").forward(req,resp);
    }
}