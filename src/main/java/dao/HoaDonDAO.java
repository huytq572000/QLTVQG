package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class HoaDonDAO extends DAO{
    public int insertHoaDon(int idNCC
    ){
        String sql = "insert into hoadon(ngayin,idNCC) values(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2,idNCC);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            generatedKeys.next();
            return generatedKeys.getInt(1);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return 0;
    }
    public void insertHoaDon_LuotNhap(int idHoaDon,int idLuotNhap){
        String sql1 = "insert into hoadon_luotnhap(idhoadon,idLuotnhap) values(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setInt(1,idHoaDon);
            ps.setInt(2,idLuotNhap);
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
