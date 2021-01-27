<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Thông tin cá nhân</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/user.css" rel="stylesheet">
    <!------ Include the above in your HEAD tag ---------->
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="contain-main">
	<div class="row">

		<div class="col-md-3 slide-bar ">
		     <div class="list-group " >
                <a href="#" class="list-group-item list-group-item-action active">Thông tin cá nhân</a>
                <a href="#" class="list-group-item list-group-item-action active">Danh sách đơn hàng</a> 
            </div> 
		</div>

		<div class="col-md-9 card-body-container">
		    <div class="card">
		        <div class="card-body">
		            <div class="row">
		                <div class="col-md-12">
		                    <h4>Thông tin cá nhân</h4>
		                    <hr>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-md-12">

<%--                            <form action="load4Edit?uid=${userDetail.id}" method="post">--%>
                                <form action="load4Edit" method="post">

                                <div class="form-group row">
                                    <label for="id" class="col-4 col-form-label">ID</label>
                                    <div class="col-8">
                                        <input id="id" name="id" value="${userDetail.id}" class="form-control here" type="text" readonly>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="username" class="col-4 col-form-label">Tài khoản</label> 
                                    <div class="col-8">
                                        <input id="username" name="username" value="${userDetail.accountName}" class="form-control here" type="text" readonly>
                                    </div>
                                  </div>                   

                              <div class="form-group row">
                                <label for="fullname" class="col-4 col-form-label">Họ tên</label> 
                                <div class="col-8">
                                  <input id="fullname" name="fullname" value="${userDetail.fullName}" class="form-control here" type="text" readonly>
                                </div>
                              </div>                     
                              
                              <div class="form-group row">
                                <label for="phone" class="col-4 col-form-label">Số điện thoại</label> 
                                <div class="col-8">
                                  <input id="phone" name="phone" value="${userDetail.phone}" class="form-control here" type="text"readonly>
                                </div>
                              </div>    

                              <div class="form-group row">
                                <label for="address" class="col-4 col-form-label">Địa chỉ</label> 
                                <div class="col-8">
                                  <input id="address" name="address" value="${userDetail.address}" class="form-control here" type="text"readonly>
                                </div>
                              </div>

                              <div class="form-group row">
                                <label for="email" class="col-4 col-form-label">Email</label> 
                                <div class="col-8">
                                  <input id="email" name="email" value="${userDetail.email}" class="form-control here"  type="Email" readonly>
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
		            
		        </div>
		    </div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>