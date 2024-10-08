<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@include file="_form.jsp"%>
<table class="table" border="1">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên phòng</th>
        <th scope="col">Số lượng phòng</th>
        <th scope="col">Ghi chú</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">Tên loại phòng</th>
        <th scope="col">Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="p">
        <tr>
            <td>${ p.id }</td>
            <td>${ p.ten_phong }</td>
            <td>${ p.so_luong_phong }</td>
            <td>${ p.ghi_chu }</td>
            <td>${ p.trang_thai }</td>
            <td>${ p.loaiPhong.ten_loai_phong}</td>
            <td>
                <a href="/dich-vu/detail/${p.id}">Detail</a>
                <a href="/dich-vu/delete/${p.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
