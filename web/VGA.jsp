<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>LKMT - Linh Kiện Máy Tính</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="assets/css/fontawesome.min.css">

  <!-- Custom styles for this template -->
  <link href="assets/css/shop-homepage.css" rel="stylesheet">
  <link rel="stylesheet" href="assets/css/header.css">
  <script src="assets/js/bootstrap.js"></script>
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/bootstrap.bundle.js"></script>

</head>

<body>

<!-- Navigation -->
<jsp:include page="header.jsp"></jsp:include>

<!-- Page Content -->
<div class="page-content">
  <div class="container">

    <div class="row">
      <c:forEach items="${list}" var="p">
        <div class="product">
          <div class="product__header">
            <a href="#">
              <img class="card-img-top" src=${p.imgUrl} alt="">
            </a>
          </div>
          <div class="product__details">
            <h5 class="product__details--name">
              <a href="#">${p.name}</a>
            </h5>
            <h6 class="product__details--price">${p.price}đ | ${p.salePrice}đ</h6>
            <h6 class="product__deatails--onStock">Còn lại: ${p.storage}</h6>
          </div>
          <div class="product__footer">
            <button type="button" class="btn btn-outline-info">Add to <i class="fa fa-shopping-cart"
                                                                         aria-hidden="true"></i></button>
          </div>
        </div>
      </c:forEach>
    </div>
    <!-- /.row -->

  </div>
</div>
<!-- /.col-lg-9 -->

<!-- Footer -->
<jsp:include page="footer.html"></jsp:include>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>