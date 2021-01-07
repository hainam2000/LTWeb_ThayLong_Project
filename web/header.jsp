<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <!-- Bootstrap core CSS -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="assets/css/font-awesome.min.css">

  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="assets/css/header.css">
  <link rel="stylesheet" href="assets/css/fotorama.css">
  <script src="assets/js/bootstrap.js"></script>
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/bootstrap.bundle.js"></script>
  <script src="assets/js/fotorama.js"></script>
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
          <form class="search-form" action="search" method="get">
            <input type="text" placeholder="Input something..." name="search" style="border-radius: 5px;">
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
                    class="btn btn-outline-info btn-sm">Chi Tiết Giỏ Hàng</a>
                </div>

                <ul class="shopping-cart-item">
                  <c:forEach items="${cart}" var="item" begin="1" end="5">
                  <li>
                    <img style="max-width: 125px; max-height: 125px;"
                      src=${item.imgUrl}>
                    <span class="item-name">${item.name}</span>
                    <span class="item-quantity">Số lượng:
                      <input type="button" value="-" onclick="minus();">
                      <input type="text" name="" id="quantity" size="2" value="1">
                      <input type="button" value="+" onclick="plus();">
                    </span>
                    <span class="item-price">Tổng tiền:${item.salePrice}</span>
                    <button type="button" class="btn btn-outline-danger item-cancel">X</button>
                  </li>
                  </c:forEach>
                </ul>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
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