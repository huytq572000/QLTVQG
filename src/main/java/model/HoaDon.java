package model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon implements Serializable {
    private int id;
    private LocalDate time;
    private NhaCungCap ncc;
    private List<LuotNhap> dsLuotNhap;

}
