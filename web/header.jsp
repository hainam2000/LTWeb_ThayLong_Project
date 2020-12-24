<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<!DOCTYPE html>--%>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/css/shop-homepage.css" rel="stylesheet">
  <link rel="stylesheet" href="assets/css/header.css">
  <link rel="stylesheet" href="assets/css/font-awesome.min.css">
</head>

<body>
<header>
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <div class="header__container--logo">
          <div class="header__container--logo--img left">
            <a class="navbar-brand" href="#"><img src="assets/images/data/logo_divine_pure_white.png"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
          </div>
          <div class="header-container--logo--text">
            <a href="#" style="text-align: center;">LKMT Store</a>
          </div>
        </div>
        <div class="header-container--search">
          <form class="search-form">
            <input type="text" placeholder="Input product name..." name="search" style="border-radius: 5px;">
            <button value="search" type="submit"><i
                    class="fa fa-search" aria-hidden="true"></i></button>
          </form>
        </div>
        <div class="header__user">
          <ul>
            <li>
              <a href="/login">
                <i class="fa fa-user" aria-hidden="true"></i><span> Đăng nhập </span>
              </a>
              <ul class="header__user--account">
                <li>
                  <a role="button" href="/login" style=" color: #32494d" class="btn btn-outline-info btn-sm">Đăng nhập</a>
                </li>
                <li>
                  <a role="button" href="/register" style=" color: #32494d" class="btn btn-outline-info btn-sm">Đăng ký</a>
                </li>
                <li>
                  <a role="button" href="/account" style=" color: #32494d" class="btn btn-outline-info btn-sm">Tài khoản</a>
                </li>
              </ul>
            </li>
            <li>
              <a href="/cart">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i><span> Giỏ hàng </span>
              </a>
              
              <div class="header__user--cart">
                <div class="shopping-cart-header">
                  <i style="position: relative; right: 30%;" class="fa fa-shopping-cart cart-icon fa-lg"></i>
                  <span style="position: relative;right: 30%;" class="badge fa-sm">200</span>
                  <a role="button" href="/cart" style="float: right; color: #32494d" class="btn btn-outline-info btn-sm">View Cart</a>
                </div>

                <ul class="shopping-cart-item">
                  <li>
                    <img style="max-width: 125px; max-height: 125px;" src="assets/images/CPU/AMDAthlon200GE3.2GHz24RadeonVega3Graphics/gearvn_cpu_amd.jpg">
                    <span class="item-name">item name ne nha may asdasdasdasdsadasdasdba </span>
                    <span class="item-quantity">Số lượng:</span>
                    <span class="item-price">Tổng tiền:</span>
                    <button type="button" class="btn btn-outline-danger item-cancel">X</button>
                  </li>
                </ul>
              </div>
            </li>
          </ul>
        </div>
      </div>
  </div>
  </nav>
  </div>
</header>
</body>

</html>