package com.example.demo.repository;

import com.example.demo.entity.Phong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongRepository extends JpaRepository<Phong,Integer> {
//    public Page<Phong> findByTenLike(String keyword, PageRequest p);
}
