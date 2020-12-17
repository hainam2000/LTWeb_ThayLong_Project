<html lang="en">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>CPU</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="assets/css/shop-homepage.css" rel="stylesheet">
  <style>
    <%@include file="assets/css/header.css"%>
    <%@include file="assets/vendor/bootstrap/css/bootstrap.min.css"%>
    <%@include file="assets/css/shop-homepage.css"%>
    <%@include file="assets/css/font-awesome.min.css"%>
  </style>
</head>
<body >

  <!-- Navigation -->
  <jsp:include page="header.html"></jsp:include>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">LKMT Store</h1>
        <div class="list-group">
          <a href="#" class="list-group-item">Asus</a>
          <a href="#" class="list-group-item">Geforce</a>
          <a href="#" class="list-group-item">AMD</a>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
<%--          <div class="carousel-inner" role="listbox">--%>
<%--            <div class="carousel-item active">--%>
<%--              <img class="d-block img-fluid" src="http://localhost:8080/LTWeb_war_exploded/assets/images/CPU/AMDRyzen95900X64MB3.7GHzBoost4.8GHz1224/gearvn-amd-ryzen-9-5900x-64mb-3-7ghz-boost-4-8ghz-12-nhan-24-luong_37c9b8b6804944f7ada5d5630bd57537.png" alt="First slide">--%>
<%--            </div>--%>
<%--            <div class="carousel-item">--%>
<%--              <img class="d-block img-fluid" src="http://localhost:8080/LTWeb_war_exploded/assets/images/CPU/AMDRyzen33300X16MB3.8GHz48/amd-ryzen-3-3100_40c54ff2c14f4561ba2ccc226107a9fd.png" alt="Second slide">--%>
<%--            </div>--%>
<%--            <div class="carousel-item">--%>
<%--              <img class="d-block img-fluid" src="http://localhost:8080/LTWeb_war_exploded/assets/images/CPU/AMDRyzen32200G3.5GHzVGARadeonVega86MB44/gearvn_amd_ryzen_3_2200g_3.jpg" alt="Third slide">--%>
<%--            </div>--%>
<%--          </div>--%>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">
<c:forEach items="${dataCPU}" var="d">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src=${d.imgUrl} alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">${d.name}</a>
                </h4>
                <h5>${d.price}</h5>
                <p class="card-text">${d.description}</p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
</c:forEach>
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <jsp:include page="footer.html"></jsp:include>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
