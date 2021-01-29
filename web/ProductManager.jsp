<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý sản phẩm</title>
    <link rel="stylesheet" href="assets/css/productManager.css">


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

    <div class="product__modify__content">
        <div class="modify-product">
            <div class="content">
                <span><h3>Nhập thông tin sản phẩm</h3></span>
            </div>
            <div class="modify-form">
                <form id="form-modify-product" method="post" action="productSearch">

                    <div class="input_box">
                        <div class="input__">
                            <input class="form__input" id="pid" type="text" name="searchText" placeholder="Asus, ram, vga,...">
                        </div>
                        <div class="err">
                            <span class="error__message" id="error__id__product"></span>
                        </div>
                    </div>



                    <div class="modify__button">
                        <input  class="mod__btn" type="submit" value="Tìm" onclick="">

                    </div>


                </form>

            </div>

        </div>
        <div class="modal" id="addProductModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="contain-main">
                        <div class="tabcontent" id="addProduct" style="display: block">
                            <h3 class="form-title">Nhập thông tin sản phẩm</h3>
                            <div class="form-container">
<%--                                    from here--%>

                                <form class="reg-form" method="get" action="addProduct">

                                    <div class="form-group">
                                        <label class="lb">Tên sản phẩm</label>
                                        <input class="form-control" type="text" placeholder="" name="new_pro_name">
                                        <div class="error"></div>
                                    </div>
                                    <div class="form-group">
                                        <label class="lb">Mô tả</label>
                                        <input class="form-control" type="text" placeholder="" name="new_pro_description">
                                        <div class="error"></div>
                                    </div>
                                    <div class="form-group">
                                        <label class="lb">Chi tiết sản phẩm</label>
                                        <input class="form-control" type="text" placeholder="" name="new_pro_detail">
                                        <div class="error"></div>
                                    </div>
                                    <div class="form-group">
                                        <label class="lb">Giá sản phẩm</label>
                                        <input class="form-control" type="text" placeholder="" name="new_pro_price">
                                        <div class="error"></div>
                                    </div>
                                    <div class="form-group">
                                        <label class="lb">Giảm giá</label>
                                        <input class="form-control" type="text" placeholder="1 nếu là sản phẩm giảm giá | 0 nếu sản phẩm không giảm giá" name="new_pro_isSale">
                                        <div class="error"></div>
                                    </div>
                                    <div class="form-group">
                                        <label class="lb">Giá khuyến mãi</label>
                                        <input class="form-control" type="text" placeholder="" name="new_pro_salePrice">
                                        <div class="error"></div>
                                    </div>
                                    <div class="form-group">
                                        <label class="lb">Tên hãng sản xuất</label>
                                        <input class="form-control" type="text" placeholder="ASUS,MSI,...." name="new_pro_brandName">
                                        <div class="error"></div>
                                    </div>
                                    <div class="form-group">
                                        <label class="lb">Loại sản phẩm</label>
                                        <input class="form-control" type="text" placeholder="Mainboard,Ram,....." name="new_pro_categoryName">
                                        <div class="error"></div>
                                    </div>
                                    <div class="form-group">
                                        <label class="lb">Số lượng trong</label>
                                        <input class="form-control" type="text" placeholder="" name="new_pro_storage">
                                        <div class="error"></div>
                                    </div>


                                    <button class="btn-reg" type="submit" style="margin-left: 190px">Thêm sản phẩm</button>
                                </form>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br><hr style="height: 10px;background-color: #a9b3c9">
        <div style="margin-left: 10px;margin-bottom: 90px">
            <div>
                <h3 style="float: left;">Danh sách sản phẩm</h3>
            </div>
            <div style="float: left;text-align: center;padding-left: 12px;">
                <a href="#" data-toggle="modal" data-target="#addProductModal"><span>Thêm sản phẩm</span></a>
            </div>
        </div>

        <div class="row">
            <c:forEach items="${productsList}" var="p">
                <div class="product" style="margin: 25px 25px">
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
                            <a  href="loadPro4Edit?pid=${p.id}"> Sửa </a> |
                            <a href="deleteProduct?pid=${p.id}"> Xóa </a>

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