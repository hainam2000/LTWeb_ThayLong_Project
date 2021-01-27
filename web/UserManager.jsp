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
                        <a href="loadProduct" >Quản lí sản phẩm</a>
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
            <div class="modal" id="addUserModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="contain-main">
                            <div class="tabcontent" id="addUser" style="display: block">
                                <h3 class="form-title">Nhập thông tin tài khoản</h3>
                                <div class="form-container">
<%--                                   from here --%>

                                    <form class="reg-form" method="get" action="addUser">

                                        <div class="form-group">
                                                <label class="lb">Họ tên</label>
                                                <input class="form-control" type="text" placeholder="Họ và Tên" name="new_user_fullname">
                                                <div class="error"></div>
                                        </div>

                                        <div class="form-group">
                                            <label class="lb">Email</label>
                                            <input class="form-control" type="email" placeholder="VD: aaa@gmail.com" name="new_user_email">
                                            <div class="error"></div>
                                        </div>

                                        <div class="form-group">
                                            <label class="lb">SDT</label>
                                            <input class="form-control" type="text" placeholder="Số điện thoại" name="new_user_phone">
                                            <div class="error"></div>
                                        </div>

                                        <div class="form-group">
                                            <label class="lb">Địa chỉ</label>
                                            <input class="form-control" type="text" placeholder="Địa chỉ" name="new_user_address">
                                            <div class="error"></div>
                                        </div>

                                        <div class="form-group">
                                            <label class="lb">Chức năng (1: Admin | 2: Người dùng)</label>
                                            <input class="form-control" type="text" placeholder="1 or 2" name="new_user_role">
                                            <div class="error"></div>
                                        </div>


                                        <div class="form-group">
                                            <label class="lb">Tài Khoản</label>
                                            <input class="form-control" type="text" placeholder="Tài khoản (VD: aaa)" name="new_username" required>
                                            <div class="error"></div>
                                        </div>

                                        <div class="form-group">
                                            <label class="lb">Mật khẩu</label>
                                            <input class="form-control" type="password" placeholder="Mật khẩu (8-18 ký tự)" name="new_user_password"
                                                   required>
                                            <div class="error"></div>
                                        </div>


                                        <button class="btn-reg" type="submit" style="margin-left: 190px">Thêm tài khoản</button>
                                    </form>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br><hr>
            <div style="margin-left: 5px;margin-bottom: 90px">
                <div>
                    <h3 style="float: left;">Danh sách tài khoản</h3>
                </div>
                <div style="float: left;text-align: center;padding-top: 25px;padding-left: 12px;">
                    <a href="#" data-toggle="modal" data-target="#addUserModal"><span>Thêm tài khoản</span></a>
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
                        <td>
                            <a href="loadUser4Edit?uid=${u.id}">Sửa</a> | <a href="deleteUser?uid=${u.id}">Xóa</a>
                        </td>
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