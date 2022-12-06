package dao;

import com.example.servlet.NhapSoLuongDonGiaServlet;
import model.LuotNhap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LuotNhapDAO extends DAO{
      public void saveLuotNhap(Integer idDauSach,Float dongia, Integer soluong,Float thanhtien){
            String sql = "INSERT INTO luotnhap(dongia, soluong,idDausach) " +
                    "VALUES (?,?,?);";
                  try {
                        PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                        ps.setInt(1, soluong);
                        ps.setFloat(2, dongia);
                        ps.setInt(3,idDauSach);
                     ps.executeUpdate();
                        ResultSet generatedKeys = ps.getGeneratedKeys();
                        generatedKeys.next();
                        DauSachDAO dauSachDAO = new DauSachDAO();

                        NhapSoLuongDonGiaServlet.list.add(new LuotNhap(generatedKeys.getInt(1),soluong,dongia,thanhtien,dauSachDAO.getDauSachById(idDauSach)));
                        System.out.println(NhapSoLuongDonGiaServlet.list);
                  } catch (Exception e) {
                        e.printStackTrace();
                  }
      }

}
