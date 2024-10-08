package com.example.demo.controller;

import com.example.demo.entity.LoaiPhong;
import com.example.demo.entity.Phong;
import com.example.demo.repository.LoaiPhongRepo;
import com.example.demo.repository.PhongRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("dich-vu")
public class PhongController {
    @Autowired
    private PhongRepository phongRepo;
    @Autowired
    private LoaiPhongRepo loaiPhongRepo;

    @ModelAttribute("dsLoaiPhong")
    public List<LoaiPhong> getDsLoaiPhong() {
        return loaiPhongRepo.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(
            @RequestParam(name = "page", defaultValue = "0") int PageNo,
            @RequestParam(name = "limit", defaultValue = "5") int PageSize,
            Model model) {
        PageRequest p = PageRequest.of(PageNo, PageSize);
        model.addAttribute("phong", new Phong());
        Page<Phong> ds = this.phongRepo.findAll(p);
        model.addAttribute("data", ds.getContent());
        return "phong_view/hien_thi";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("phong") Phong p, BindingResult rs) {
        if (rs.hasErrors()) {
            return "phong_view/hien_thi";
        }
        phongRepo.save(p);
        return "redirect:dich-vu/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.phongRepo.deleteById(id);
        return "redirect:/dich-vu/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        Phong phong = phongRepo.findById(id).orElse(null);
        model.addAttribute("phong", phong);
        model.addAttribute("data", phongRepo.findAll());
        return "phong_view/hien_thi";
    }
}
