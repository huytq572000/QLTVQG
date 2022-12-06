<%--
  Created by IntelliJ IDEA.
  User: T-Q-H
  Date: 12/1/2022
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nhập sách</title>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- fontawesome  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

    <!-- style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css">

</head>

<body>

<div id="page" class="d-flex">
    <nav id="sidebar" class="nav flex-column">
        <li class="nav-item logo">
            <div><i class="fa-brands fa-product-hunt fa-lg"></i>${sessionScope.account.name}</div>
        </li>
        <li class="sidebar-item nav-item active" value="0">
            <div class="nav-link d-flex">
                <div class="icon-item">
                    <i class="fa-solid fa-box-archive fa-lg"></i>
                </div>
                <div>
                    Nhập sách
                </div>
            </div>
        </li>
        <li class="sidebar-item nav-item" value="1">
            <div class="nav-link d-flex">
                <div class="icon-item">
                    <i class="fas fa-file"></i></i>
                </div>
                <div>
                    Quản lý đầu sách
                </div>
            </div>
        </li>
        <li class="sidebar-item nav-item" value="1">
            <div class="nav-link d-flex">
                <div class="icon-item">
                    <i class='fas fa-book-medical'></i>
                </div>
                <div>
                    Mượn sách
                </div>
            </div>
        </li>
        <li class="sidebar-item nav-item" value="1">
            <div class="nav-link d-flex">
                <div class="icon-item">
                    <i class='fas fa-book'></i>
                </div>
                <div>
                    Trả sách
                </div>
            </div>
        </li>
        <li class="sidebar-item nav-item" value="1">
            <div class="nav-link d-flex">
                <div class="icon-item">
                    <i class='far fa-address-card'></i>
                </div>
                <div>
                    Quản lý thẻ bạn đọc
                </div>
            </div>
        </li>
    </nav>
    <div class="flex-grow-1">
        <menu class="d-flex justify-content-end">
            <div id="logout-btn" class="d-flex align-items-center">
                <a href="/QLTVQG/"><i class="fa-solid fa-arrow-right-from-bracket fa-lg"></i></a>
                Đăng xuất
            </div>
        </menu>
        <!--  phần nhét code -->
        <main>
            <div class="header-main">
                <h4 style="font-weight: bold">Tìm kiếm đầu sách</h4>
            </div>
            <div class="background-main">
                <div class="toolbar d-flex justify-content-between">
                    <form action="search-dau-sach" method="post">
                        <div id="search" class="input-group mb-3">
                            <input name="txt" type="text" class="form-control shadow-none"
                                   placeholder="Tìm theo tên đầu sách">
                            <button type="submit" class="input-group-text" title="Tìm kiếm"><i
                                    class="fa-solid fa-magnifying-glass"></i></button>
                        </div>
                    </form>
                    <div>
                        <a class="btn btn-primary btn-save" href="them-dau-sach" role="button"><i
                                class="fa-solid fa-plus"></i></a>
                    </div>
                </div>
                <div id="product-data">
                    <table class="table table-borderless">
                        <thead class="sticky-top">
                        <tr>
                            <th scope="col">Tên đầu sách</th>
                            <th scope="col">Tác giả</th>
                            <th scope="col">Năm xuất bản</th>
                            <th scope="col">Giá bìa</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Mô tả</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${data1}" var="k">
                            <tr>
                                <td style="vertical-align: middle;"><a
                                        href="so-luong-don-gia?idEdit=${k.getId()}">${k.getTen()}</a></td>
                                <td style="vertical-align: middle;">${k.getTacgia()}</td>
                                <td style="vertical-align: middle;">${k.getNxb()}</td>
                                <td style="vertical-align: middle;">${k.getGiabia()}</td>
                                <td style="vertical-align: middle;">${k.getSoluong()}</td>
                                <td style="vertical-align: middle;">${k.getMota()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>
</div>


<!-- bootstrap -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>

</html>

