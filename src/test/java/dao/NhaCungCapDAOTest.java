package dao;



import model.NhaCungCap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NhaCungCapDAOTest {
    @Test
    void tim_ncc_theo_ten() {
        // tìm kiếm nhà cung cấp theo tên khi nhập tên không có trong csdl
        NhaCungCapDAO dao = new NhaCungCapDAO();
        String keyword = "xxxx";
        List<NhaCungCap> list = dao.searchByName(keyword);
        assertNotNull(list);
        assertEquals(0, list.size());
    }

    @Test
    void getNCCById() {
        // kiểm tra lấy thông tin nhà cung cấp theo id
        NhaCungCapDAO dao = new NhaCungCapDAO();
        NhaCungCap ncc = dao.getNCCById(1);
        String expected = "kim đồng";
        assertEquals(expected, ncc.getTen());
    }

    @Test
    void insertNCC() {
        //thêm mới một nhà cung cấp
        NhaCungCapDAO dao = new NhaCungCapDAO();
        String ten = "Tuổi Trẻ";
        String diachi = "hà nội";
        String sdt = "03265897";
        String email = "a@gmail.com";
        String mota = "a";
        NhaCungCap ncc = new NhaCungCap();
        ncc.setTen(ten);
        ncc.setDiachi(diachi);
        ncc.setDienthoai(sdt);
        ncc.setEmail(email);
        ncc.setMota(mota);
        try{
            DAO.con.setAutoCommit(false);
            boolean ok = dao.insertNCC(ten, diachi,sdt, email,mota);
            assertTrue(ok);
            // lấy thông tin nhà cung cấp vừa thêm để kiểm tra
            NhaCungCap result = dao.getNhaCungCap();
            assertEquals(ncc.getTen(), result.getTen());
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
