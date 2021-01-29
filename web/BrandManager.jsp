<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hãng sản xuất</title>
    <link rel="stylesheet" href="assets/css/brandManager.css">
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

        <div class="brand__modify__content">

            <div class="modal" id="addBrandModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="contain-main">
                            <div class="tabcontent" id="addBrand" style="display: block">
                                <h3 class="form-title">Nhập thông tin nhà sản xuất mới</h3>
                                <div class="form-container">
<%--                                   from here --%>

                                    <form class="reg-form" method="get" action="addBrand">

                                        <div class="form-group">
                                            <label class="lb">Loại sản phẩm</label>
                                            <input class="form-control" type="text" placeholder="Tên hãng sản xuất" name="new_brand_name"
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
                    <h3 style="float: left;">Các hãng sản xuất</h3>
                </div>
                <div style="float: left;text-align: center;padding-left: 12px;">
                    <a href="#" data-toggle="modal" data-target="#addBrandModal"><span>Thêm nhà sản xuất</span></a>
                </div>
            </div>

            <table class="table table-data2" id="data-list">
                <thead>

                <tr style="border: solid 3px">
                    <th>Mã Hãng sản xuất</th>
                    <th>Tên hãng sản xuất</th>
                    <th>Tác vụ</th>
                </tr>

                <c:forEach var="b" items="${brandList}">
                    <tr>
                        <td>${b.id}</td>
                        <td>${b.name}</td>

                        <td>
                            <a href="loadBrand4Edit?bid=${b.id}">Sửa</a> | <a href="deleteBrand?bid=${b.id}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </thead>

            </table>
        </div>
    </div>


</body>
</html>