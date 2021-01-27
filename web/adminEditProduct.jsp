<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Chỉnh sửa thông tin sản phẩm</title>
    <link rel="stylesheet" href="assets/css/EditProduct.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css ">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">


</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="row">
    <div class="col-md-12">

        <div class="col-md-12">
            <br><h3 style="margin-left: 125px;">Nhập thông tin cảu sản phẩm</h3><hr>

            <form action="adminEditProduct" method="post" style="margin: 100px 100px 0px 100px;">

            <div class="form-group row">
                <label for="id" class="col-4 col-form-label">ID</label>
                <div class="col-8">
                    <input id="id" name="id" value="${productDetail.id}" class="form-control here" type="text" readonly>
                </div>
            </div>

            <div class="form-group row">
                <label for="name" class="col-4 col-form-label">Tên sản phẩm</label>
                <div class="col-8">
                    <input id="name" name="name" value="${productDetail.name}" class="form-control here" type="text" >
                </div>
            </div>

            <div class="form-group row">
                <label for="description" class="col-4 col-form-label">Mô tả</label>
                <div class="col-8">
                    <input id="description" name="description" value="${productDetail.description}" class="form-control here" type="text" >
                </div>
            </div>

            <div class="form-group row">
                <label for="details" class="col-4 col-form-label">Chi tiết sản phẩm</label>
                <div class="col-8">
                    <input id="details" name="details" value="${productDetail.details}" class="form-control here" type="text">
                </div>
            </div>

            <div class="form-group row">
                <label for="price" class="col-4 col-form-label">Giá gốc</label>
                <div class="col-8">
                    <input id="price" name="price" value="${productDetail.price}" class="form-control here" type="text">
                </div>
            </div>

            <div class="form-group row">
                <label for="isSale" class="col-4 col-form-label">Sale (1: giảm giá  | 0: không giảm)</label>
                <div class="col-8">
                    <input id="isSale" name="isSale" value="${productDetail.isSale}" class="form-control here"  type="text" >
                </div>
            </div>

            <div class="form-group row">
                <label for="salePrice" class="col-4 col-form-label">Giá khuyến mãi</label>
                <div class="col-8">
                    <input id="salePrice" name="salePrice" value="${productDetail.salePrice}" class="form-control here"  type="text" >
                </div>
            </div>

            <div class="form-group row">
                <label for="brandName" class="col-4 col-form-label">Tên hãng sản xuất</label>
                <div class="col-8">
                    <input id="brandName" name="brandName" value="${productDetail.brandName}" class="form-control here" type="text">
                </div>
            </div>

            <div class="form-group row">
                <label for="categoryName" class="col-4 col-form-label">Loại sản phẩm</label>
                <div class="col-8">
                    <input id="categoryName" name="categoryName" value="${productDetail.categoryName}" class="form-control here" type="text">
                </div>
            </div>

            <div class="form-group row">
                <label for="storage" class="col-4 col-form-label">Số lượng trong kho</label>
                <div class="col-8">
                    <input id="storage" name="storage" value="${productDetail.storage}" class="form-control here" type="text">
                </div>
            </div>
            <hr>
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <button name="submit" type="submit" class="btn btn-primary btn-submit">Cập nhật</button>
                </div>

            </div>
        </form>

<%--            add Image modal--%>
            <div class="modal" id="addImageModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="contain-main">
                            <div class="tabcontent" id="addImage" style="display: block">
                                <h3 class="form-title">Nhập thông tin hình ảnh</h3>
                                <div class="form-container">
                                    <%-- from here--%>

                                    <form class="reg-form" method="get" action="addImage">


                                        <div class="form-group">
                                            <label class="lb">Số lượng trong</label>
                                            <input class="form-control" type="text" placeholder="" name="new_pro_storage">
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
        <div class="product__details--images" style=" margin: 100px 100px 100px 100px">

            <div style="margin-left: 22px;margin-bottom: 50px">
                <div>
                    <h3>Hình ảnh của sản phẩm</h3>
                </div>
                <div style="float: left;text-align: center;">
                    <a href="#" data-toggle="modal" data-target="#addImageModal"><span>Thêm ảnh</span></a>
                </div>
            </div>
            <div style="margin-left: -20px ">
            <c:forEach items="${images}" var="img">
                <div style="float :left; padding-top: 50px;padding-left: 40px">
                    <div>
                        <img style="height: 200px;width: 200px;" src=${img.url} >
                    </div>
                    <div style="margin-top: 10px">
                        <a href="#">Sửa ảnh</a> | <a href="deleteImage?imgId=${img.id}&pid=${img.idProduct}">Xóa ảnh</a>
                    </div>
                </div>
            </c:forEach>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
