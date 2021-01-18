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
              <span class="cart__product--title-counter">(${d.counter} sản phẩm)</span>
            </h2>
            <div class="products--list">
              <ul>
                <li>
                  <div class="product">
                    <div class="product-img">
                      <a href="/productName">
                        <img src="assets/images/CPU/AMDAthlon200GE3.2GHz24RadeonVega3Graphics/gearvn_cpu_amd.jpg"
                          alt="">
                      </a>
                    </div>
                    <div class="product-content">
                      <div class="product-content--description">
                        <p class="name">Tên sản phẩm: <a href="/productName">(16GB DDR4 2x8G 3200) RAM AORUS RGB Memory
                            CL16-18-18-38 (kèm Demo kit)</a></p>
                      </div>
                      <div class="product-content--detail">
                        <p class="category">Mục sản phẩm: <span>VGA</span></p>
                      </div>
                    </div>
                    <div class="product-price">
                      <p style="position: absolute; top: 10px; left: -50px">Tổng tiền: <span>1000000000</span></p>
                      <br>
                      <br>
                      <p style="width: 150px; position: absolute;top: 30px; left: -15px; text-align: center;">
                        <span class="item-quantity">
                          <input type="button" value="-" onclick="minus()">
                          <input type="text" name="" id="quantity" size="4" value="1">
                          <input type="button" value="+" onclick="plus()">
                        </span>
                      </p>
                    </div>
                  </div>
                </li>
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
                <span class="text">Tổng tiền hàng: </span>
                <span class="money">100000000000đ</span>
                <br>
                <span class="text">Tổng tiền phí vận chuyển:</span>
                <span class="money">10000000đ</span>
              </p>
              <p class="price-total">
                <span class="text">Tổng thanh toán: </span>
                <span class="money">10000000000000đ</span>
              </p>
              <p></p>
            </div>
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