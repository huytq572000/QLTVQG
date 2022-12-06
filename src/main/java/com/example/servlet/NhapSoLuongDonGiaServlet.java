package com.example.servlet;

import dao.DauSachDAO;
import dao.LuotNhapDAO;
import model.DauSach;
import model.LuotNhap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SoLuongDonGia", value = "/so-luong-don-gia")
public class NhapSoLuongDonGiaServlet extends HttpServlet {
    public static List<LuotNhap> list = new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showEditForm(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            insertLuotNhap(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String url = "";
        url = "/nhapdongiasoluong.jsp";
        DauSachDAO dao = new DauSachDAO();
        int id = Integer.parseInt(request.getParameter("idEdit"));
        DauSach ds = dao.getDauSachById(id);
        request.setAttribute("dausach",ds);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }
    private void insertLuotNhap(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Float dongia = Float.parseFloat(request.getParameter("dongia"));
        Integer soluong = Integer.parseInt(request.getParameter("soluong"));
        Integer idDauSach = Integer.parseInt(request.getParameter("idDauSach"));
        Float thanhtien = soluong*dongia;
        LuotNhapDAO dao = new LuotNhapDAO();
        dao.saveLuotNhap(idDauSach,dongia, soluong,thanhtien);
        response.sendRedirect("hoa-don-nhap?idEdit="+HoaDonNhapServlet.idNCC);
    }
}
