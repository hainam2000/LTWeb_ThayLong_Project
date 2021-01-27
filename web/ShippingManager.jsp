<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Phương thức giao hàng</title>
    <link rel="stylesheet" href="assets/css/shippingManager.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css ">
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
                        <a href="#">Quản lí đơn hàng</a>
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

        <div class="shipping__modify__content">
            <div class="modal" id="addShippingModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="contain-main">
                            <div class="tabcontent" id="addShipping" style="display: block">
                                <h3 class="form-title">Cách thức giao hàng mới</h3>
                                <div class="form-container">
<%--                                   from here --%>

                                    <form class="reg-form" method="get" action="addShipping">

                                        <div class="form-group">
                                            <label class="lb">Phương thức giao hàng</label>
                                            <input class="form-control" type="text" placeholder="tên phương thức" name="new_shipping_name"
                                                   required>
                                            <div class="error"></div>
                                        </div>

                                        <div class="form-group">
                                            <label class="lb">Tính chất</label>
                                            <input class="form-control" type="text" placeholder="fast,safe" name="new_shipping_type"
                                                   required>
                                            <div class="error"></div>
                                        </div>

                                        <div class="form-group">
                                            <label class="lb">Giá phải trả</label>
                                            <input class="form-control" type="text" placeholder="giá tiền" name="new_shipping_price"
                                                   required>
                                            <div class="error"></div>
                                        </div>


                                        <button class="btn-reg" type="submit" style="margin-left: 190px">Thêm</button>
                                    </form>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div style="margin-left: 5px;margin-bottom: 90px">
                <div>
                    <h3 style="float: left;">Các phương thức giao hàng</h3>
                </div>
                <div style="float: left;text-align: center;padding-top: 25px;padding-left: 12px;">
                    <a href="#" data-toggle="modal" data-target="#addShippingModal"><span>Thêm phương thức giao hàng</span></a>
                </div>
            </div>

            <table class="table table-data2" id="data-list">
                <thead>

                <tr style="border: solid 3px">
                    <th>Mã phương thức</th>
                    <th>Tên phương thức</th>
                    <th>Tính chất</th>
                    <th>Giá</th>
                    <th>Tác vụ</th>

                </tr>

                <c:forEach var="s" items="${shippingList}">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.type}</td>
                        <td>${s.price}</td>

                        <td>
                            <a href="loadShipping4Edit?sid=${s.id}">Sửa</a> | <a href="deleteShipping?sid=${s.id}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </thead>

            </table>
        </div>
    </div>


</body>
</html>