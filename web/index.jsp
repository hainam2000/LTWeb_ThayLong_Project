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
          <script src="assets/js/bootstrap.js"></script>
          <script src="assets/js/jquery.min.js"></script>
          <script src="assets/js/bootstrap.bundle.js"></script>

        </head>

        <body>

          <!-- Navigation -->
          <jsp:include page="header.jsp"></jsp:include>
          <jsp:include page="advertisement.jsp"></jsp:include>
          <!-- Page Content -->
          <div class="page-content" style="margin-top: 5% !important;">
            <div class="container">

              <div class="row">
                <c:forEach items="${productsList}" var="p">
                  <div class="product">
                    <div class="product__header">
                      <a href="/LTWeb_war_exploded/product?pid=${p.id}">
                        <img class="card-img-top" src=${p.imgUrl} alt="">
                      </a>
                    </div>
                    <div class="product__details">
                      <h5 class="product__details--name">
                        <a href="/LTWeb_war_exploded/product?pid=${p.id}">${p.name}</a>
                      </h5>
                      <h6 class="product__details--price">${p.price}đ | ${p.salePrice}đ</h6>
                      <h6 class="product__details--onStock">Còn lại: ${p.storage}</h6>
                    </div>
                    <div class="product__footer">
<%--                      &userID=${sessionScope.user.id}--%>
                      <form action="cart/add?pid=${p.id}" method="post">
                      <button class="btn btn-outline-info" style="color: #32494d">Thêm vào <i class="fa fa-shopping-cart" aria-hidden="true"></i></button>
                      </form>
                    </div>
                  </div>
                </c:forEach>
              </div>
              <!-- /.row -->

            </div>
          </div>

            <ul class="pagination justify-content-center">
              <li class="page-item">
                <a class="page-link" href="#" tabindex="-1">Previous</a>
              </li>
              <c:forEach begin="1" end="${pageLimit}" var="i">
              <li class="page-item"><a class="page-link" href="Index?index=${i}">${i}</a></li>
              </c:forEach>
              <li class="page-item">
                <a class="page-link" href="#">Next</a>
              </li>
            </ul>

          <!-- /.col-lg-9 -->

          <!-- Footer -->
          <jsp:include page="footer.jsp"></jsp:include>

          <!-- Bootstrap core JavaScript -->
          <script src="vendor/jquery/jquery.min.js"></script>
          <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        </body>

        </html>