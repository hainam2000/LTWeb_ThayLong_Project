<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="assets/css/font-awesome.min.css">

  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="assets/css/header.css">
  <script src="assets/js/bootstrap.js"></script>
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/bootstrap.bundle.js"></script>
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
            <button value="search" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
          </form>
        </div>
        <div class="header__user">
          <ul>
            <li>
              <a href="/LTWeb_war_exploded/account">
                <i class="fa fa-user" aria-hidden="true"></i><span> Tài
                  khoản </span>
              </a>
              <ul class="header__user--account">
                <li >
                  <a role="button" href="/LTWeb_war_exploded/login" style=" color: #32494d" class="btn btn-outline-info">Đăng nhập</a>
                </li>
                <li>
                  <a role="button" href="/LTWeb_war_exploded/register" style=" color: #32494d" class="btn btn-outline-info">Đăng
                    ký</a>
                </li>
                <li>
                  <a role="button" href="/LTWeb_war_exploded/account" style=" color: #32494d" class="btn btn-outline-info">Tài
                    khoản</a>
                </li>
              </ul>
            </li>
            <li>
              <a href="/LTWeb_war_exploded/cart">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i><span> Giỏ hàng </span>
              </a>

              <div class="header__user--cart">
                <div class="shopping-cart-header">
                  <i style="position: relative; right: 30%;" class="fa fa-shopping-cart cart-icon fa-lg"></i>
                  <span style="position: relative;right: 30%;" class="badge fa-sm">200</span>
                  <a role="button" href="/LTWeb_war_exploded/cart" style="float: right; color: #32494d"
                    class="btn btn-outline-info btn-sm">View Cart</a>
                </div>

                <ul class="shopping-cart-item">
                  <li>
                    <img style="max-width: 125px; max-height: 125px;"
                      src="http://localhost:8080/LTWeb_war_exploded/assets/images/product/1/1.jpg">
                    <span class="item-name">item name ne nha may asdasdasdasdsadasdasdba </span>
                    <span class="item-quantity">Số lượng:
                      <input type="button" value="-" onclick="minus();">
                      <input type="text" name="" id="quantity" size="2" value="1">
                      <input type="button" value="+" onclick="plus();">
                    </span>
                    <span class="item-price">Tổng tiền:</span>
                    <button type="button" class="btn btn-outline-danger item-cancel">X</button>
                  </li>
                </ul>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>

  <div class="advertisement">
    <div class="submenu">
      <ul>
        <c:forEach items="${clist}" var="c">
        <li>
          <a href="category?cid=${c.id}">${c.name}</a>
        </li>
        </c:forEach>
      </ul>
    </div>
    
    <div id="demo" class="carousel slide" data-ride="carousel" style="width: 500px;">

      <!-- Indicators -->
      <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
        <li data-target="#demo" data-slide-to="4"></li>
        <li data-target="#demo" data-slide-to="5"></li>
      </ul>

      <!-- The slideshow -->
      <div class="carousel-inner">
        <div class="carousel-inner_img carousel-item active">
          <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid1.jpg" alt="">
        </div>
        <div class="carousel-inner_img carousel-item">
          <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid2.jpg" alt="">
        </div>
        <div class="carousel-inner_img carousel-item">
          <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid3.jpg" alt="">
        </div>
        <div class="carousel-inner_img carousel-item">
          <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid4.jpg" alt="">
        </div>
        <div class="carousel-inner_img carousel-item">
          <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid5.jpg" alt="">
        </div>
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
          <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
          <span class="carousel-control-next-icon"></span>
        </a>
      </div>

      <!-- Left and right controls -->
      <!-- <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
      </a>
      <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
      </a> -->
      <div class="carousel-right">
        <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid6.jpg" alt="">
        <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid7.jpg" alt="">
      </div>
    </div>
  </div>
</header>
  <script>
    var count = 1;
    var countElement = document.getElementById("quantity");
    function plus(){
      count++;
      countElement.value = count;
    }
    function minus(){
      if(count > 1){
        count--;
        countElement.value = count;
      }
    }
  </script>
</body>

</html>