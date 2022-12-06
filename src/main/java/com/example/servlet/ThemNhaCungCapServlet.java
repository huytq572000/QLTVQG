package com.example.servlet;

import dao.NhaCungCapDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/them-nha-cung-cap")
public class ThemNhaCungCapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        resp.sendRedirect("themNCC.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("tenncc");
        String diachi = req.getParameter("diachi");
        String sdt = req.getParameter("sdt");
        String email = req.getParameter("email");
        String mota = req.getParameter("mota");
        NhaCungCapDAO dao = new NhaCungCapDAO();
        dao.insertNCC(name, diachi,sdt,email,mota);
        resp.sendRedirect("search");
    }
}
