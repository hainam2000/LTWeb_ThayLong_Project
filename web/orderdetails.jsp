<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lí chi tiết đơn hàng</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body><div class="contain-main">
    <div class="row" style="margin: 200px 100px 100px 100px">

        <div class="col-md-3 slide-bar ">
            <div class="list-group " style="margin-inline: 30px; text-align: center";>
                <a href="user?id=${sessionScope.user.id}" class="list-group-item list-group-item-action ">Thông tin cá nhân</a>
                <a href="order?id=${sessionScope.user.id}" class="list-group-item list-group-item-action active" style="margin-top: 10px">Danh sách đơn hàng</a>
            </div>
        </div>

        <div class="col-md-9 card-body-container">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-12">

                            <%--                            <form action="load4Edit?uid=${userDetail.id}" method="post">--%>
                            <br><hr style="height: 10px;background-color: #a9b3c9">
                            <div style="margin-left: 5px;margin-bottom: 90px">
                                <div>
                                    <h3 style="float: left;">Danh sách chi tiết đơn hàng</h3>
                                </div>
                            </div>

                                <table class="table table-data2" id="data-list">
                                    <thead>

                                    <tr style="border: solid 3px">
                                        <th>Tên</th>
                                        <th>Giá</th>
                                        <th>Số lượng</th>
                                        <th>Tổng tiền</th>
                                    </tr>

                                    <c:forEach var="order" items="${orderDetails}">
                                        <tr>
                                            <td>${order.productName}</td>
                                            <td>${order.totalPrice / order.quantity}</td>
                                            <td>${order.quantity}</td>
                                            <td>${order.totalPrice}</td>
                                        </tr>
                                    </c:forEach>
                                    </thead>

                                </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
