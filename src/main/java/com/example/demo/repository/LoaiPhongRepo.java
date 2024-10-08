package com.example.demo.repository;

import com.example.demo.entity.LoaiPhong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaiPhongRepo extends JpaRepository<LoaiPhong, Integer> {
}
