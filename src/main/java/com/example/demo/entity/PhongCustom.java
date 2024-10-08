package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhongCustom {
    @Id
    private Integer id;

    private String tenLoaiPhong;
    private String ghiChu;
    private Integer soLuongPhong;
    private String tenPhong;
    private Integer trangThai;
}
