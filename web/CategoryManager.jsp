<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Loại sản phẩm</title>
    <link rel="stylesheet" href="assets/css/categoryManager.css">
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

        <div class="category__modify__content">
            <div class="modal" id="addCategoryModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="contain-main">
                            <div class="tabcontent" id="addCategory" style="display: block">
                                <h3 class="form-title">Nhập loại sản phẩm</h3>
                                <div class="form-container">
<%--                                   from here --%>

                                    <form class="reg-form" method="get" action="addCategory">

                                        <div class="form-group">
                                            <label class="lb">Tên loại</label>
                                            <input class="form-control" type="text" placeholder="tên loại sản phẩm cần thêm" name="new_category_name" required>
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
                    <h3 style="float: left;">Các loại sản phẩm trong cừa hàng</h3>
                </div>
                <div style="float: left;text-align: center;padding-left: 12px;">
                    <a href="#" data-toggle="modal" data-target="#addCategoryModal" ><span style="font-size: 17px">Thêm loại sản phẩm</span></a>
                </div>
            </div>

            <table class="table table-data2" id="data-list">
                <thead>

                <tr style="border: solid 3px">
                    <th>Mã loại sản phẩm</th>
                    <th>Loại sản phẩm</th>
                    <th>Tác vụ</th>
                </tr>

                <c:forEach var="c" items="${categoryList}">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.name}</td>

                        <td>
                            <a href="loadCategory4Edit?cid=${c.id}">Sửa</a> | <a href="deleteCategory?cid=${c.id}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </thead>

            </table>
        </div>
    </div>


</body>
</html>