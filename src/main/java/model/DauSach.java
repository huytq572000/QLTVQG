package model;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DauSach implements Serializable {
    private int id;
    private String ten, tacgia;
    private int nxb;
    private float giabia;
    private int soluong;
    private String mota;

}
