<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin cá nhân</title>
    <link rel="stylesheet" href="assets/css/EditUser.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css ">
      
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="row">
    <div class="col-md-12">

        <br><h3 style="margin-left: 125px;">Nhập thông tin cá nhân</h3><hr>

        <form action="editUser" method="post" style="margin: 100px 100px 0px 100px;">

            <div class="form-group row">
                <label for="id" class="col-4 col-form-label">ID</label>
                <div class="col-8">
                    <input id="id" name="id" value="${userDetail.id}" class="form-control here" type="text" readonly>
                </div>
            </div>

            <div class="form-group row">
                <label for="fullname" class="col-4 col-form-label">Họ tên</label>
                <div class="col-8">
                    <input id="fullname" name="fullname" value="${userDetail.fullName}" class="form-control here" type="text" >
                </div>
            </div>

            <div class="form-group row">
                <label for="phone" class="col-4 col-form-label">Số điện thoại</label>
                <div class="col-8">
                    <input id="phone" name="phone" value="${userDetail.phone}" class="form-control here" type="text">
                </div>
            </div>

            <div class="form-group row">
                <label for="address" class="col-4 col-form-label">Địa chỉ</label>
                <div class="col-8">
                    <input id="address" name="address" value="${userDetail.address}" class="form-control here" type="text">
                </div>
            </div>

            <div class="form-group row">
                <label for="email" class="col-4 col-form-label">Email</label>
                <div class="col-8">
                    <input id="email" name="email" value="${userDetail.email}" class="form-control here"  type="Email" readonly>
                </div>
            </div>

            <div class="form-group row">
                <label for="username" class="col-4 col-form-label">Tài khoản</label>
                <div class="col-8">
                    <input id="username" name="username" value="${userDetail.accountName}" class="form-control here" type="text" readonly>
                </div>
            </div>


            <div class="form-group row">
                <label for="newpass" class="col-4 col-form-label">Thay đổi mật khẩu </label>
                <div class="col-8">
                    <input id="newpass" name="newpass" value="${userDetail.password}" class="form-control here" type="password">
                </div>
            </div>
            <hr>
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <button name="submit" type="submit" class="btn btn-primary btn-submit">Cập nhật</button>
                </div>

            </div>
        </form>
    </div>
</div>
</body>
</html>
