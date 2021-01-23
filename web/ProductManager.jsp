<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý sản phẩm</title>
    <link rel="stylesheet" href="assets/css/productManager.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css ">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">


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

    <div class="product__modify__content">
        <div class="modify-product">
            <div class="content">
                <span><h5>Nhập thông tin sản phẩm</h5></span>
            </div>
            <div class="modify-form">
                <form id="form-modify-product" method="post" action="">

                    <div class="input_box">
                        <div class="text">
                            <label for="pid">Mã Sản phẩm</label>
                        </div>
                        <div class="input__">
                            <input class="form__input" id="pid" type="text" name="pid">
                        </div>
                        <div class="err">
                            <span class="error__message" id="error__id__product"></span>
                        </div>
                    </div>

                    <div class="input_box">
                        <div class="text">
                            <label for="cid">Mã loại sản phẩm</label>
                        </div>
                        <div class="input__">
                            <input class="form__input" id="cid" type="text" name="cid">
                        </div>
                        <div class="err">
                            <span class="error__message" id="error__id__category"></span>
                        </div>
                    </div>

                    <div class="input_box">
                        <div class="text">
                            <label for="bid">Mã hãng sản xuất</label>
                        </div>
                        <div class="input__">
                            <input class="form__input" id="bid" type="text" name="bid">
                        </div>
                        <div class="err">
                            <span class="error__message" id="error__id__brand"></span>
                        </div>
                    </div>



                    <div class="modify__button">
                        <input  class="mod__btn" type="submit" value="Tìm" onclick="">

                    </div>


                </form>

            </div>

        </div>


        <div class="row">
            <c:forEach items="${productsList}" var="p">
                <div class="product">
                    <div class="product__header">
                        <a href="product?pid=${p.id}">
                            <img class="card-img-top" src=${p.imgUrl} alt="">
                        </a>
                    </div>
                    <div class="product__details">
                        <h5 class="product__details--name">
                            <a href="product?pid=${p.id}">${p.name}</a>
                        </h5>
                        <h6 class="product__details--price">${p.price}đ | ${p.salePrice}đ</h6>
                        <h6 class="product__details--onStock">Còn lại: ${p.storage}</h6>
                    </div>
                    <div class="product__footer">
                        <a  href="LoadForEditProduct_A?pid=${p.id}"><i class="fas fa-edit">Sửa</i></a>
                        <a href=deleteProduct?pid=${p.id}"><i class="fas fa-trash">Xóa</i></a>

                    </div>
                </div>
            </c:forEach>

            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                </li>
                <c:forEach begin="1" end="${pageLimit}" var="i">
                    <li class="page-item"><a class="page-link" href="loadProduct?index=${i}">${i}</a></li>
                </c:forEach>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </div>

    </div>

</div>

</body>
</html>