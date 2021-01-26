<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta http-equiv="x-ua-compatible" content="ie=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="assets/css/checkout.css">
                <link rel="stylesheet" href="assets/css/font-awesome.min.css">
                <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
                <script src="/assets/js/cart.js"></script>
                <title>LKMT - Thông tin thanh toán</title>
            </head>

            <body>
                <jsp:include page="header.jsp"></jsp:include>
                <div class="page-content" style="">
                    <div class="cart__product">
                        <h3 class="cart__product--title">
                            GIỎ HÀNG
                            <span class="cart__product--title-counter">(${cart == null ? 0 : cart.getTotalQuantity()}
                                sản phẩm)</span>
                        </h3>
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
                                                <p style="width: 150px; position: absolute;top: 30px; left: -15px; text-align: center;">
                                                    <span class="product-quantity">
                                                        Số lượng: ${p.quantity}
                                                    </span>
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <h3 class="cart__product--title" style="margin-top: 10px;">
                            Phương thức vận chuyển
                        </h3>
                        <div class="shipping-method">
                            <form id="shipping" method="get" action="/LTWeb_war_exploded/checkout">
                                <input type="radio" name="shipping" id="saving" onclick="getShipping()" value="saving">
                                <label for="saving">Giao hang tiet kiem</label> <br>
                                <input type="radio" name="shipping" id="fast" onclick="getShipping()" value="fast">
                                <label for="fast">Giao hang nhanh</label><br>
                                <input type="radio" name="shipping" id="safety" onclick="getShipping()" value="safety">
                                <label for="safety">Giao hang an toan</label>
                            </form>
                        </div>
                        <h3 class="cart__product--title" style="margin-top: 10px;">
                            Phương thức thanh toán
                        </h3>

                        <p class="payment" style="margin-top: 10px;">
                            <c:if test="${sessionScope.user != null && !sessionScope.user.address.equals('')}">
                                <a href="payment?userID=${sessionScope.user.id}" class="btn btn-danger" style="width: fit-content">
                                    Xác nhận thanh toán
                                </a>
                            </c:if>
                            <c:if test="${sessionScope.user == null}">
                                <div class="alert alert-warning">
                                    Xin vui lòng <a href="#" data-toggle="modal" data-target="#myModal" class="alert-link">đăng nhập</a>.
                                </div>
                            </c:if>
                            <c:if test="${sessionScope.user.address.equals('') && sessionScope.user != null}">
                                <div class="alert alert-warning">
                                    Xin vui lòng <a href="#" class="alert-link">cập nhật địa chỉ</a>.
                                </div>
                            </c:if>
                            (Xin vui lòng kiểm tra lại đơn hàng trước khi Thanh Toán)
                        </p>
                    </div>
                    <div class="cart__price">
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
                        <div class="total-price">
                            <p class="prices-item">
                                <span class="text">Tổng tiền hàng: </span>
                                <span class="money">${cart.getTotalPrice()}đ</span>
                                <br>
                                <span class="text" style="margin-top: 3px;">Phí vận chuyển:</span>
                                <span class="money">${cart.getShippingPrice()}đ</span>
                            </p>
                            <p class="price-total">
                                <span class="text">Tổng thanh toán: </span>
                                <span class="money">${cart.getShippingPrice() + cart.getTotalPrice()}đ</span>
                            </p>
                        </div>
                    </div>
                </div>
                <script>
                    function submitPayment() {
                        document.getElementById("payment").submit();
                    }
                        // document.getElementById("shipping").submit();
                        // $(document).ready( function (){
                        //     var radioVal;
                        //     $("input[type='radio']").click( function () {
                        //         radioVal = $("[name=shipping]:checked").val();
                        //         alert(radioVal)
                        //         $.post("checkout.jsp", {"shippingType" : radioVal});
                        //     })
                        //     // $('#payment').blur(function () {
                        //     //
                        //     // })
                        // })
                    //
                    // $(document).ready(function() {
                    //     $('[name=shipping]:checked').blur(function() {
                    //
                    //     });
                    // });

                    function getShipping() {
                            var radioVal;
                                radioVal = $('input[name="shipping"]:checked').val();
                                console.log(radioVal);
                                // $.post("checkout.jsp", {"shippingType" : radioVal});
                                $.ajax({
                                type : 'POST',
                                url : 'checkout',
                                data : {
                                    shipping : radioVal
                                },
                                success : function() {
                                        location.reload();
                                }
                            })
                    }
                </script>
            </body>

            </html>