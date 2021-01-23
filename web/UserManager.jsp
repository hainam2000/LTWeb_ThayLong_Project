<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="assets/css/userManager.css">
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
                        <a href="#" >Quản lí sản phẩm</a>
                    </li>

                    <li class="navbar__single">
                        <a href="#">Quản lí đơn hàng</a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="user__modify__content">
            <div class="modify-user">
                <div class="content">
                    <span><h5>Nhập thông tin khách hàng</h5></span>
                </div>
                <div class="modify-form">
                    <form id="form-modify-user" method="post" action="">

                        <div class="input_box">
                            <div class="text">
                                <label for="fullname">Tên khách hàng</label>
                            </div>
                            <div class="input__">
                                <input class="form__input" id="fullname" type="text" name="fullname">
                            </div>
                            <div class="err">
                                <span class="error__message" id="error__fullname"></span>
                            </div>
                        </div>

                        <div class="input_box">
                            <div class="text">
                                <label for="id">Mã khách hàng</label>
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
                                <label  for="email">Email</label>
                            </div>
                            <div class="input__">
                                <input class="form__input" id="email" type="email" name="email">
                            </div>
                            <div class="err">
                                <span class="error__message" id="error__email"></span>
                            </div>
                        </div>

                        <div class="input_box">
                            <div class="text">
                                <label for="phone">Số điện thoại</label>
                            </div>
                            <div class="input__">
                                <input class="form__input" id="phone" type="text" name="phone">
                            </div>
                            <div class="err">
                                <span class="error__message" id="error__phone"></span>
                            </div>
                        </div>


                        <div class="modify__button">
                            <input type="submit" value="Tìm">
                        </div>

                    </form>

                </div>

            </div>

            <table class="table table-data2" id="data-list">
                <thead>

                <tr>
                    <th>Mã KH</th>
                    <th>Tên KH</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Địa chỉ</th>
                    <th>Tài khoản</th>
                    <th>Tác vụ</th>
                </tr>

                <c:forEach var="u" items="${userList}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.fullName}</td>
                        <td>${u.email}</td>
                        <td>${u.phone}</td>
                        <td>${u.address}</td>
                        <td>${u.accountName}</td>
                        <td><a  href="LoadForEditUser_A?uid=${u.id}"><i class="fas fa-edit">Sửa</i></a>
                            <a href="deleteUser?uid=${u.id}"><i class="fas fa-trash">Xóa</i></a></td>
                    </tr>
                </c:forEach>
                </thead>
                <tbody id="result">

                </tbody>
            </table>
        </div>
    </div>

</body>
</html>