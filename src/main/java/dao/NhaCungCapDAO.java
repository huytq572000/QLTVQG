package dao;


import model.NhaCungCap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO extends DAO{
    public List<NhaCungCap> searchByName(String txtSearch) {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "select * from nhacungcap as ncc WHERE ncc.ten like concat('%',?,'%')";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + txtSearch + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setId(rs.getInt("id"));
                ncc.setTen(rs.getString("ten"));
                ncc.setDiachi(rs.getString("diachi"));
                ncc.setDienthoai(rs.getString("sdt"));
                ncc.setEmail(rs.getString("email"));
                ncc.setMota(rs.getString("mota"));
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public NhaCungCap getNCCById(int id){
        NhaCungCap result = new NhaCungCap();
        String sql = "SELECT * FROM nhacungcap as m WHERE m.id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result.setId(Integer.parseInt(id + ""));
                result.setTen(rs.getString("ten"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public boolean insertNCC(String ten, String diachi, String email, String mota, String dienthoai){
        boolean check = true;
        String sql = "insert into nhacungcap(ten, diachi,sdt,email,mota) value(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setString(2,diachi);
            ps.setString(3, dienthoai);
            ps.setString(4,email);
            ps.setString(5, mota);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }
    public NhaCungCap getNhaCungCap(){
        NhaCungCap ncc = new NhaCungCap();
        String sql = "SELECT *\n" +
                "FROM nhacungcap\n" +
                "WHERE id = (SELECT MAX(id) FROM nhacungcap);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ncc.setId(rs.getInt("id"));
                ncc.setTen(rs.getString("ten"));
                ncc.setDiachi(rs.getString("diachi"));
                ncc.setDienthoai(rs.getString("sdt"));
                ncc.setEmail(rs.getString("email"));
                ncc.setMota(rs.getString("mota"));
            }
        } catch (SQLException e) {
        }
        return ncc;
    }
}
