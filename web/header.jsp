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
  <link rel="stylesheet" href="assets/css/bootstrap.css">
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
            <a class="navbar-brand" href="/LTWeb_war_exploded/Index"><img src="assets/images/data/logo_divine_pure_white.png"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
          </div>
          <div class="header-container--logo--text">
            <a href="/LTWeb_war_exploded/Index" style="text-align: center;">LKMT Store</a>
          </div>
        </div>
        <div class="header-container--search">
          <form class="search-form" action="search" method="get">
            <input type="text" placeholder="Asus, ram, vga,..." name="search" style="border-radius: 5px;">
            <button value="search" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
          </form>
        </div>
        <div class="header__user">
          <ul>
            <li>
              <c:if test="${sessionScope.user == null}">
                <a href="#" data-toggle="modal" data-target="#myModal">
                  <i class="fa fa-user" aria-hidden="true"></i><span> Đăng nhập </span>
                </a>
              </c:if>
              <c:if test="${sessionScope.user != null}">
                <a href="#" data-toggle="modal" data-target="#myModal">
                  <i class="fa fa-user" aria-hidden="true"></i><span> Tài khoản </span>
                </a>
                <ul class="header__user--account" style="font-size: 15px !important;">
                  <c:if test="${sessionScope.user.role == 1}">
                    <li >
                      <a role="button" href="user?id=${sessionScope.user.id}" style=" color: #32494d" class="btn btn-outline-info btn-sm">Tài khoản</a>
                    </li>
                    <li>
                      <a role="button" href="loadUser" style=" color: #32494d" class="btn btn-outline-info btn-sm">Quản lý khách hàng</a>
                    </li>
                    <li>
                      <a role="button" href="loadOrder" style=" color: #32494d" class="btn btn-outline-info btn-sm">Quản lý đơn hàng</a>
                    </li>
                    <li>
                      <a role="button" href="loadProduct" style=" color: #32494d" class="btn btn-outline-info btn-sm">Quản lý sản phẩm</a>
                    </li>
                    <li>
                      <a role="button" href="loadUser" style=" color: #32494d" class="btn btn-outline-info btn-sm">Quản lý</a>
                    </li>
                    <li>
                      <a role="button" href="logout" style=" color: #32494d" class="btn btn-outline-info btn-sm">Đăng xuất</a>
                    </li>
                  </c:if>
                  <c:if test="${sessionScope.user.role == 2}">
                    <li >
                      <a role="button" href="order?id=${sessionScope.user.id}" style=" color: #32494d" class="btn btn-outline-info btn-sm">Kiểm tra đơn hàng</a>
                    </li>
                    <li>
                      <a role="button" href="user?id=${sessionScope.user.id}" style=" color: #32494d" class="btn btn-outline-info btn-sm">Tài khoản</a>
                    </li>
                    <li>
                      <a role="button" href="#" style=" color: #32494d" class="btn btn-outline-info btn-sm">Câu hỏi thường gặp</a>
                    </li>
                    <li>
                      <a role="button" href="logout" style=" color: #32494d" class="btn btn-outline-info btn-sm">Đăng xuất</a>
                    </li>
                  </c:if>
                </ul>
              </c:if>
            </li>
            <li>
              <a href="/LTWeb_war_exploded/cart">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i><span> Giỏ hàng </span>
              </a>

              <div class="header__user--cart" style="font-size: 15px !important;">
                <div class="shopping-cart-header">
                  <i style="position: relative; right: 70%;" class="fa fa-shopping-cart cart-icon fa-lg"></i>
                  <span style="position: relative;right: 69%;" class="badge fa-sm">${cart == null ? 0 : cart.getTotalQuantity()}</span>
                  <a role="button" href="/LTWeb_war_exploded/cart" style="float: right; color: #32494d"
                     class="btn btn-outline-info btn-sm">Chi Tiết Giỏ Hàng</a>
                </div>

                <ul class="shopping-cart-item">
                  <c:forEach items="${cart.getProducts()}" var="p" begin="0" end="2">
                    <li>
                      <img style="max-width: 125px; max-height: 125px;"
                           src=${p.imgUrl}>
                      <span class="item-name">${p.name}</span>
                      <div class="item-quantity">
                        <span style="float: left;">Số lượng: </span>
                        <form class="product-quantity--update" action="cart/update?pid=${p.id}" method="post">
                        <a href="cart/addon?pid=${p.id}"
                           class="btn btn-secondary">+</a>
                        <input type="text" id="quantity" name="quantity" value="${p.quantity}">
                         <a href="cart/removeon?pid=${p.id}" class="btn btn-secondary">-</a>
                        </form>
                      </div>
                      <span class="item-price">Tổng tiền:${p.price}</span>
                      <a style="color: red; float:right;" href="cart/delete?pid=${p.id}" class="btn btn-outline-danger item-cancel">X</a>
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
<c:if test="${sessionScope.user == null}">
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="contain-main">
          <div class="tab">
            <button class="tablinks" onclick="changeTab(event, 'login')" id="defaultOpen">ĐĂNG NHẬP</button>
            <button class="tablinks" onclick="changeTab(event, 'register')">ĐĂNG KÝ</button>
            <button class="tablinks" onclick="changeTab(event, 'forgot')">QUÊN MẬT KHẨU</button>
          </div>
          <div class="alert alert-danger " style="${mess == null ? "display: none;" : "display: block;"}">
              ${mess}
          </div>
          <div class="tabcontent" id="register">
            <h3 class="form-title">ĐĂNG KÝ</h3>
            <!--<div class="alert alert-danger " style="${mess == null ? "display: none;" : "display: block;"}">
            ${mess}
          </div> -->
            <div class="form-container">
              <form class="reg-form" method="post" action="register">
                <div class="form-group">
                  <label class="lb">Tài Khoản</label>
                  <input class="form-control" type="text" placeholder="Tài khoản (VD: aaa)" name="username" required>
                  <div class="error"></div>
                </div>
                <div class="form-group">
                  <label class="lb">Mật khẩu</label>
                  <input class="form-control" type="password" placeholder="Mật khẩu (8-18 ký tự)" name="password"
                         required>
                  <div class="error"></div>
                </div>
                <div class="form-group">
                  <label class="lb">Nhập lại mật khẩu</label>
                  <input class="form-control" type="password" placeholder="Vui lòng nhập đúng mật khẩu ở trên "
                         name="confirmPassword" required>
                  <div class="error"></div>
                </div>
                <div class="form-group">
                  <label class="lb">Email</label>
                  <input class="form-control" type="email" placeholder="Địa chỉ Email" name="mail">
                  <div class="error"></div>
                </div>
                <button class="btn-reg btn btn-info">Đăng ký</button>
              </form>
              <br>
            </div>
          </div>
          <div class="tabcontent" id="login">
            <h3 class="form-title">ĐĂNG NHẬP</h3>
            <div class="form-container">
              <form class="login-form" method="post" action="login">
                <div class="form-group">
                  <label class="lb">Tài Khoản</label>
                  <input class="form-control" type="text" placeholder="Tài khoản" name="username">
                </div>

                <div class="form-group">
                  <label class="lb">Mật khẩu</label>
                  <input class="form-control" type="password" placeholder="Mật khẩu" name="password">

                </div>
                <a class="forgot-pass" onclick="changeTab(event, 'forgot')">Quên mật khẩu?</a>
                <button class="btn-login btn btn-success">Đăng nhập</button>
              </form>
              <br>
            </div>
          </div>
          <div class="tabcontent" id="forgot">
            <h3 class="form-title">QUÊN MẬT KHẨU</h3>
            <div class="form-container">
              <form class="login-form" method="post" action="forgotPassword">
                <div class="form-group">
                  <label class="lb">Tài Khoản</label>
                  <input class="form-control" type="text" placeholder="Tài khoản" name="username">
                </div>
                <div class="form-group">
                  <label class="lb">Email</label>
                  <input class="form-control" type="email" placeholder="Địa chỉ Email" name="mail">
                </div>
                <button class="btn-forgot btn btn-warning">Xác nhận</button>
              </form>
              <br>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</c:if>
<script>
  var xhttp = new XMLHttpRequest();
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
  function changeTab(evt, name) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(name).style.display = "block";
    evt.currentTarget.className += " active";
  }
  document.getElementById("defaultOpen").click();
</script>
</body>

</html>