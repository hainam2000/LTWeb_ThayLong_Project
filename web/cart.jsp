<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta http-equiv="x-ua-compatible" content="ie=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="assets/css/cart.css">
                <link rel="stylesheet" href="assets/css/font-awesome.min.css">
                <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
                <script src="/assets/js/cart.js"></script>
                <title>Cart</title>
            </head>

            <body>
                <jsp:include page="header.jsp"></jsp:include>
                <div class="page-content">
                    <div class="cart__product">
                        <h2 class="cart__product--title">
                            GIỎ HÀNG
                            <span class="cart__product--title-counter">(${cart == null ? 0 : cart.getTotalQuantity()}
                                sản phẩm)</span>
                        </h2>
                        <div class="products--list">
                            <ul>
                                <c:forEach items="${cart.getProducts()}" var="p">
                                    <li>
                                        <div class="product">
                                            <div class="product-img">
                                                <a href="/LTWeb_war_exploded/product?pid=${p.id}">
                                                    <img src="${p.imgUrl}" alt="">
                                                </a>
                                            </div>
                                            <div class="product-content">
                                                <div class="product-content--description">
                                                    <p class="name">Tên sản phẩm: <a
                                                            href="/LTWeb_war_exploded/product?pid=${p.id}">${p.name}</a>
                                                    </p>
                                                </div>
                                                <div class="product-content--detail">
                                                    <p class="category">Mục sản phẩm: <span>${p.categoryName}</span></p>
                                                </div>
                                            </div>
                                            <div class="product-price">
                                                <p style="position: absolute; top: 10px; left: -50px">Tổng tiền:
                                                    <span>${p.price * p.quantity}</span>
                                                </p>
                                                <br>
                                                <br>
                                                <p style="width: 150px;text-align: center;">
                                                    <span class="product-quantity">
                                                        <span style="position: absolute; left:-50px;">Số lượng: </span>
                                                        <form class="product-quantity--update" action="cart/update?pid=${p.id}" method="post">
                                                        <a href="cart/add?pid=${p.id}"
                                                           class="btn btn-outline-secondary">+</a>
                                                        <input type="text" id="quantity" name="quantity" value="${p.quantity}">
                                                         <a href="cart/remove?pid=${p.id}" class="btn btn-outline-secondary">-</a>
                                                             <button value="update" type="submit"
                                                                     class="btn btn-outline-secondary">Update</button>
                                                        </form>
                                                    </span>
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="cart__price">
                        <c:if test="${sessionScope.user != null}">
                            <div class="address">
                                <p class="heading">
                                    <span>Thông tin nhận hàng</span>
                                    <a href="/account">Thay đổi</a>
                                </p>
                                <p class="title">
                                    <b class="name">${user.fullName}</b>
                                    <b class="phone"> ${user.phone}</b>
                                </p>
                                <p class="user-address">
                                    ${user.address}
                                </p>
                            </div>
                            <div class="coupon">

                            </div>
                        </c:if>
                        <div class="total-price">
                            <p class="prices-item">
                                <span class="text">Tạm tính: </span>
                                <span class="money">${cart.getTotalPrice()}đ</span>
                            </p>

                        </div>
                        <c:if test="${sessionScope.user == null}">
                            <a href="/cart" data-toggle="modal" data-target="#myModal" class="btn btn-success">
                                <span> Thanh Toán </span>
                            </a>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                            <a href="checkout?userID=${sessionScope.user.id}" class="btn btn-success">
                                <span> Thanh Toán </span>
                            </a>
                        </c:if>
                    </div>
                </div>
                <script>
                    var count = 1;
                    var countElement = document.getElementById("quantity");

                    function plus() {
                        count++;
                        countElement.value = count;
                    }

                    function minus() {
                        if (count > 1) {
                            count--;
                            countElement.value = count;
                        }
                    }

                </script>
            </body>

            </html>