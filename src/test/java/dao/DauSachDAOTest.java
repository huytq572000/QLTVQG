package dao;

import model.DauSach;
import model.NhaCungCap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
public class DauSachDAOTest {
    @Test
    void tim_dau_sach_theo_ten(){
        // tìm đầu sách theo tên khi nhập tên không có trong csdl
        DauSachDAO dao = new DauSachDAO();
        String key = "XXXXX";
        List<DauSach> list = dao.searchByName(key);
        assertNotNull(list);
        assertEquals(0,list.size());
    }
    @Test
    void getDauSachById(){
        // kiểm tra lấy thông tin đầu sách theo id
        DauSachDAO dao = new DauSachDAO();
        DauSach ds = dao.getDauSachById(1);
        String expected = "Ngành IT có gì";
        assertEquals(expected,ds.getTen());
    }
    @Test
    void insertDauSach() {
        //thêm mới một đầu sách
        DauSachDAO dao = new DauSachDAO();
        String ten = "Tuổi Trẻ";
        int nxb = 2020;
        String tacgia = "nguyen A";
        Float giabia = 1000f;
        int soluong = 5;
        String mota ="a";
        DauSach ds = new DauSach();
        ds.setTen(ten);
        ds.setNxb(nxb);
        ds.setTacgia(tacgia);
        ds.setGiabia(giabia);
        ds.setSoluong(soluong);
        ds.setMota(mota);
        try{
            DAO.con.setAutoCommit(false);
            boolean ok = dao.insertDauSach(ten, nxb, tacgia,giabia, soluong,mota);
            assertTrue(ok);
            //lấy thông tin đầu sách vừa thêm để kiểm tra
            DauSach result = dao.getDauSach();
            assertEquals(ds.getTen(), result.getTen());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
