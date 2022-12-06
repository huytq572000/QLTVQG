package model;

import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LuotNhap implements Serializable {
    private int id;
    private int soluong;
    private float dongia;
    private float thanhtien;
    private DauSach dauSach;
//    privatemy

//    public LuotNhap(int id, int soluong, float dongia) {
//        this.id = id;
//        this.soluong = soluong;
//        this.dongia = dongia;
//    }
//
//    public LuotNhap(int id, int soluong, float dongia, float thanhtien) {
//        this.id = id;
//        this.soluong = soluong;
//        this.dongia = dongia;
//        this.thanhtien = thanhtien;
//    }

}
