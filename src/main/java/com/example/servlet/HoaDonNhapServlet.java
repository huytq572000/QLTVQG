package com.example.servlet;

import dao.HoaDonDAO;
import dao.NhaCungCapDAO;
import model.LuotNhap;
import model.NhaCungCap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HoaDonNhap", value = "/hoa-don-nhap")
public class HoaDonNhapServlet extends HttpServlet {
    public static int idNCC ;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      showEditForm(request,response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String url = "";
        url = "/hoadonnhap.jsp";
        NhaCungCapDAO dao = new NhaCungCapDAO();
        if(idNCC != Integer.parseInt(request.getParameter("idEdit"))){
            NhapSoLuongDonGiaServlet.list.removeAll(NhapSoLuongDonGiaServlet.list);
        }
         idNCC = Integer.parseInt(request.getParameter("idEdit"));
        NhaCungCap ncc = dao.getNCCById(idNCC);
        request.setAttribute("nhacungcap",ncc);
        if(NhapSoLuongDonGiaServlet.list.size() != 0){
            request.setAttribute("data", NhapSoLuongDonGiaServlet.list);
        }
        float tongtien = 0;
        for(LuotNhap l: NhapSoLuongDonGiaServlet.list){
            tongtien += l.getThanhtien();
        }
        request.setAttribute("tongtien",tongtien);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoaDonDAO dao = new HoaDonDAO();
        int idHoadon = dao.insertHoaDon(HoaDonNhapServlet.idNCC);
        for (LuotNhap l : NhapSoLuongDonGiaServlet.list){
            dao.insertHoaDon_LuotNhap(idHoadon,l.getId());
        }
    }
}
