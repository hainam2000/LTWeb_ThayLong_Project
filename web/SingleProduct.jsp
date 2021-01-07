<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <html lang="en">

      <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>LKMT - Linh Kiện Máy Tính</title>

        <!-- Custom styles for this template -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/css/shop-item.css">
        <!-- jQuery 1.8 or later, 33 KB -->
        <script src="assets/js/bootstrap.js"></script>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.bundle.js"></script>
      </head>

      <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="page-content">
          <div class="product">
            <div class="product__showcase">
              <div class="product__showcase--fotorama">
                <div class="fotorama" data-autoplay="3000" data-nav="thumbs">
                  <c:forEach items="${images}" var="img">
                    <img src=${img.url}>
                  </c:forEach>
                </div>
              </div>
              <div class="product__showcase--details">
                <h4 class="details--name">${product.name}</h4>
                <ul>
                  <li>
                    <span>Thể loại: </span> ${product.categoryName}
                  </li>
                  <li>
                    <span>Nhà sản xuất: </span> ${product.brandName}
                  </li>
                  <li>
                    <span>Tình trạng: </span> new - 100%
                  </li>
                  <li>
                    <span>Bảo hành: </span> 36 tháng
                  </li>
                </ul>
                <p class="details--price">
                  Giá cũ: <span>${product.price}đ</span>
                </p>
                <p class="details--priceSale">
                  Giá KM: <span>${product.salePrice}đ</span>
                </p>
                <button type="button" class="btn btn-danger btn-lg">Đặt hàng</button>
              </div>
              <div class="product__details">
                <h2>Thông tin sản phẩm</h2>
                <div class="product__details--information">
                  <p>${product.details}</p>
                </div>
                <div class="product__details--images">
                  <h3>Hình ảnh sản phẩm</h3>
                  <c:forEach items="${images}" var="img">
                    <img src=${img.url}>
                  </c:forEach>
                </div>
              </div>
            </div>
          </div>
          <div class="relate">
            <h3>Các sản phẩm khác</h3>
            <ul>
              <c:forEach items="${itemsList}" var="item">
                <li>
                  <div class="relate__product">
                    <a href="product?pid=${item.id}">
                      <img src="${item.imgUrl}">
                      <p class="name">
                        ${item.name}
                      </p>
                      <p class="price">
                        Giá: <span>${item.price}đ</span>
                      </p>
                      <p class="saleprice">
                        Giá KM: <span>${item.salePrice}đ</span>
                      </p>
                    </a>
                  </div>
                </li>
              </c:forEach>
            </ul>
          </div>
        </div>
      </body>

      </html>