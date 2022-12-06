<%--
  Created by IntelliJ IDEA.
  User: T-Q-H
  Date: 12/5/2022
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <li class="sidebar-item nav-item active">
            <div class="nav-link d-flex">
                <div class="icon-item">
                    <i class="fa-solid fa-box-archive fa-lg"></i>
                </div>
                <div>
                    Nhập sách
                </div>
            </div>
        </li>
        <li class="sidebar-item nav-item">
            <div class="nav-link d-flex">
                <div class="icon-item">
                    <i class="fas fa-file"></i></i>
                </div>
                <div>
                    Quản lý đầu sách
                </div>
            </div>
        </li>
        <li class="sidebar-item nav-item">
            <div class="nav-link d-flex">
                <div class="icon-item">
                    <i class='fas fa-book-medical'></i>
                </div>
                <div>
                    Mượn sách
                </div>
            </div>
        </li>
        <li class="sidebar-item nav-item">
            <div class="nav-link d-flex">
                <div class="icon-item">
                    <i class='fas fa-book'></i>
                </div>
                <div>
                    Trả sách
                </div>
            </div>
        </li>
        <li class="sidebar-item nav-item">
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
                <a href="/QLTVQG/"> <i class="fa-solid fa-arrow-right-from-bracket fa-lg"></i></a>
                Đăng xuất
            </div>
        </menu>
        <!--  phần nhét code -->
        <form id="formThem" action="them-nha-cung-cap" method="POST" >
            <div class="app__add-product">
                <div class="content__header">
                    <div class="content__name defaultCursor">
                        <a href="/QLTVQG/search">
                            <i class="fa-solid fa-arrow-left-long me-2 fa-lg" style="cursor: pointer"></i>
                        </a>
                        Thêm nhà cung cấp
                    </div>

                    <div id="successNotify"></div>
                    <button type="submit" class="btn-accept btn-accept-button btn-save">Xác nhận</button>
                </div>
                <div class="content__attributes">
                    <div class="content__attributes-items">
                        <div class="item-name defaultCursor">Thông tin chung</div>
                        <div class="item-content container">
                            <div class="item-content__main-row row">
                                <div class="col-9 general-info">
                                    <div class="container">
                                        <div class="row general-info__basic">
                                            <div class="row">
                                                <div class="atb col-6">
                                                    <span class="atb-name defaultCursor">Tên nhà cung cấp<span style="color: red"> *</span></span>
                                                    <input type="text" name="tenncc" class="atb-input input-group form-control shadow-none form-control shadow-none" placeholder="Nhập tên nhà cung cấp"  autofocus >
                                                </div>
                                                <div class="atb col-6">
                                                    <span class="atb-name defaultCursor">Địa chỉ<span style="color: red"> *</span></span>
                                                    <input type="text" name="diachi" class="atb-input input-group form-control shadow-none" placeholder="Nhập địa chỉ" >
                                                </div>
                                                <div class="atb col-6">
                                                    <span class="atb-name defaultCursor">Số điện thoại<span style="color: red"> *</span></span>
                                                    <input type="text" name="sdt" class="atb-input input-group form-control shadow-none" placeholder="Nhập số điện thoại" >
                                                </div>
                                                <div class="atb col-6">
                                                    <span class="atb-name defaultCursor">Email<span style="color: red"> *</span></span>
                                                    <input type="text" name="email" class="atb-input input-group form-control shadow-none" placeholder="Nhập email" >
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="general-info__description" style="position: relative;">
                                        <span class="atb-name defaultCursor">Mô tả</span>
                                        <textarea  maxlength="255" class="info-des form-control shadow-none" name="mota" rows="4" cols="50" placeholder="Nhập Mô tả"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>


<!-- bootstrap -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>

</html>

