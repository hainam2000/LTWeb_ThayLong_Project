<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý chi tiết đơn hàng</title>
    <link rel="stylesheet" href="assets/css/orderManager.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="contain-main">
    <div class="menu-sidebar__content ">
        <nav class="navbar-sidebar">
            <ul class="list-unstyled navbar__list">
                <li class="navbar__single">
                    <a href="loadUser">Quản lí người dùng</a>

                </li>
                <li class="navbar__single ">
                    <a href="loadProduct" >Quản lí sản phẩm</a>
                </li>

                <li class="navbar__single">
                    <a href="loadOrder">Quản lí đơn hàng</a>
                </li>

                <li class="navbar__single">
                    <a href="loadCategory">Danh mục sản phẩm</a>
                </li>

                <li class="navbar__single">
                    <a href="loadBrand">Hãng sản xuất</a>
                </li>

                <li class="navbar__single">
                    <a href="loadShipping">Shipping</a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="order__modify__content">
        <div class="modify-order">
            <div class="content">
                <span><h3>Nhập thông tin đơn hàng</h3></span>
            </div>
            <div class="modify-form">
                <form id="form-modify-order" method="post" action="">

                    <div class="input_box">
                        <div class="text">
                            <label for="id">Mã đơn hàng</label>
                        </div>
                        <div class="input__">
                            <input class="form__input" id="id" type="text" name="id">
                        </div>
                        <div class="err">
                            <span class="error__message" id="error__id"></span>
                        </div>
                    </div>

                    <div class="input_box">
                        <div class="text">
                            <label for="uid">Mã khách hàng</label>
                        </div>
                        <div class="input__">
                            <input class="form__input" id="uid" type="text" name="uid">
                        </div>
                        <div class="err">
                            <span class="error__message" id="error__uid"></span>
                        </div>
                    </div>


                    <div class="modify__button">
                        <input type="submit" value="Tìm">
                    </div>

                </form>

            </div>

        </div>

        <br><hr style="height: 10px;background-color: #a9b3c9">
        <div style="margin-left: 5px;margin-bottom: 90px">
            <div>
                <h3 style="float: left;">Chi tiết đơn hàng</h3>
                <h4 style="float: left;">Tổng đơn hàng ${totalPrice}</h4>
            </div>
        </div>

        <table class="table table-data2" id="data-list">
            <thead>

            <tr style="border: solid 3px">
                <th>Tên</th>
                <th>Giá</th>
                <th>Số lượng</th>
                <th>Tổng tiền</th>
            </tr>

            <c:forEach var="order" items="${orderDetails}">
                <tr>
                    <td>${order.productName}</td>
                    <td>${order.totalPrice / order.quantity}</td>
                    <td>${order.quantity}</td>
                    <td>${order.totalPrice}</td>
                </tr>
            </c:forEach>
            </thead>

        </table>
    </div>
</div>


</body>
</html>