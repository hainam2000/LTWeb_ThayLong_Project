<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin nhà sản xuất</title>
    <link rel="stylesheet" href="assets/css/EditUser.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css ">
      
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="row">
    <div class="col-md-12">

        <div class="col-md-12">

            <br><h3 style="margin-left: 125px;">Nhập thông tin nhà sản xuất</h3><hr>

            <form action="adminEditBrand" method="post" style="margin: 100px 100px 0px 100px;">

            <div class="form-group row">
                <label for="id" class="col-4 col-form-label">ID</label>
                <div class="col-8">
                    <input id="id" name="id" value="${brandDetail.id}" class="form-control here" type="text" readonly>
                </div>
            </div>

            <div class="form-group row">
                <label for="name" class="col-4 col-form-label">Tên nhà sản xuất</label>
                <div class="col-8">
                    <input id="name" name="name" value="${brandDetail.name}" class="form-control here" type="text" >
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
