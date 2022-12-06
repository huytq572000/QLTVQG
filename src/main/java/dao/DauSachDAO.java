package dao;

import model.DauSach;
import model.NhaCungCap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DauSachDAO extends DAO{
    public List<DauSach> searchByName(String txtSearch) {
        List<DauSach> list = new ArrayList<>();
        String sql = "select * from dausach as ds WHERE ds.ten like concat('%',?,'%')";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + txtSearch + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DauSach ds = new DauSach();
                ds.setId(rs.getInt("id"));
                ds.setTen(rs.getString("ten"));
                ds.setTacgia(rs.getString("tacgia"));
                ds.setNxb(rs.getInt("namxuatban"));
                ds.setGiabia(rs.getFloat("giabia"));
                ds.setSoluong(rs.getInt("soluong"));
                ds.setMota(rs.getString("mota"));
                list.add(ds);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public DauSach getDauSachById(int id){
        DauSach result = new DauSach();
        String sql = "SELECT * FROM dausach as ds WHERE ds.id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result.setId(Integer.parseInt(id + ""));
                result.setTen(rs.getString("ten"));
                result.setTacgia(rs.getString("tacgia"));
                result.setNxb(rs.getInt("namxuatban"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public boolean insertDauSach(String ten,int nxb, String tacgia, Float giabia, int soluong, String mota){
        boolean check = true;
        String sql = "insert into dausach(ten, namxuatban,tacgia,giabia,soluong,mota) value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setInt(2,nxb);
            ps.setString(3, tacgia);
            ps.setFloat(4,giabia);
            ps.setInt(5, soluong);
            ps.setString(6, mota);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }
    public DauSach getDauSach(){
        DauSach ds = new DauSach();
        String sql = "SELECT *\n" +
                "FROM dausach\n" +
                "WHERE id = (SELECT MAX(id) FROM dausach);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ds.setId(rs.getInt("id"));
                ds.setTen(rs.getString("ten"));
                ds.setNxb(rs.getInt("namxuatban"));
                ds.setTacgia(rs.getString("tacgia"));
                ds.setGiabia(rs.getFloat("giabia"));
                ds.setSoluong(rs.getInt("soluong"));
                ds.setMota(rs.getString("mota"));
            }
        } catch (SQLException e) {
        }
        return ds;
    }
}
