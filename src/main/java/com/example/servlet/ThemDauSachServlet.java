package com.example.servlet;

import dao.DauSachDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/them-dau-sach")
public class ThemDauSachServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        resp.sendRedirect("themdausach.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("ten");
        int nxb = Integer.parseInt(req.getParameter("nxb"));
        String tacgia = req.getParameter("tacgia");
        Float giaban = Float.parseFloat(req.getParameter("giaban"));
        int soluong = Integer.parseInt(req.getParameter("soluong"));
        String mota = req.getParameter("mota");
        DauSachDAO dao = new DauSachDAO();
        dao.insertDauSach(name, nxb, tacgia, giaban, soluong, mota);
        resp.sendRedirect("search-dau-sach");
    }
}
