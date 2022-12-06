package model;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NhaCungCap implements Serializable {
    private int id;
    private String ten, diachi, email,mota, dienthoai;

}
