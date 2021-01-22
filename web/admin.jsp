<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="assets/css/admin-page.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css ">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <div class="contain-main">
        <div class="menu-sidebar__content ">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li class="navbar__single">
                        <a href="admin-page.html">Quản lí người dùng</a>

                    </li>
                    <li class="navbar__single ">
                        <a href="#" >Quản lí sản phẩm</a>
                    </li>

                    <li class="navbar__single">
                        <a href="admin-page-order.html">Quản lí đơn hàng</a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="user__modify__content">
            <div class="modify-user">
                <div class="content">
                    <span><h5>Nhập thông tin khách hàng</h5></span>
                </div>
                <div class="modify-form">
                    <form id="form-modify-user" method="post" action="">

                        <div class="input_box">
                            <div class="text">
                                <label for="fullname">Tên khách hàng</label>
                            </div>
                            <div class="input__">
                                <input class="form__input" id="fullname" type="text" name="fullname">
                            </div>
                            <div class="err">
                                <span class="error__message" id="error__fullname"></span>
                            </div>
                        </div>

                        <div class="input_box">
                            <div class="text">
                                <label for="id">Mã khách hàng</label>
                            </div>
                            <div class="input__">
                                <input class="form__input" id="id" type="text" name="id">
                            </div>
                            <div class="err">
                                <span class="error__message" id="error__id"></span>
                            </div>
                        </div>

                        <div class="input_box">
                            <div class="text">
                                <label  for="email">Email</label>
                            </div>
                            <div class="input__">
                                <input class="form__input" id="email" type="email" name="email">
                            </div>
                            <div class="err">
                                <span class="error__message" id="error__email"></span>
                            </div>
                        </div>

                        <div class="input_box">
                            <div class="text">
                                <label for="phone">Số điện thoại</label>
                            </div>
                            <div class="input__">
                                <input class="form__input" id="phone" type="text" name="phone">
                            </div>
                            <div class="err">
                                <span class="error__message" id="error__phone"></span>
                            </div>
                        </div>

                        <div class="input_box">
                            <div class="text">
                                <label for="address">Địa chỉ</label>
                            </div>
                            <div class="input__">
                                <input class="form__input" id="address" type="text" name="address">
                            </div>
                            <div class="err">
                                <span class="error__message" id="error__address"></span>
                            </div>
                        </div>

                        <div class="modify__button">
                            <input type="submit" value="Cập nhật" onclick="addUser();return false">

                        </div>


                    </form>

                </div>

            </div>

            <table class="table table-data2" id="data-list">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã KH</th>
                    <th>Tên KH</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Địa chỉ</th>
                    <th>Tác vụ</th>
                </tr>
                </thead>
                <tbody id="result">

                </tbody>
            </table>
        </div>
    </div>


    <script type="text/javascript">
        var count = 0;
        var dataList = [];

        function addUser() {
            // var index = document.getElementById('index').value;
            var fullname = document.getElementById("fullname").value;
            var id = document.getElementById("id").value;
            var email = document.getElementById("email").value;
            var phone = document.getElementById("phone").value;
            var address = document.getElementById("address").value;
            var letter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            var checkname = false;
            var checkid = false;
            var checkphone = false;
            var checkaddress = false;
            var checkemail = false;

            /*<=============================Kiem tra du lieu=============================>*/

            //ktra name
            if (fullname == "") {
                document.getElementById("error__fullname").innerHTML = "Vui lòng nhập tên khách hàng";
            } else {
                document.getElementById("error__fullname").innerHTML = "";
                checkname = true;
            }

            // kiem tra ma KH
            if (id == "") {
                document.getElementById("error__id").innerHTML = " Vui lòng nhập mã khách hàng"
            } else {
                document.getElementById("error__id").innerHTML = "";
                checkid = true;

            }

            //ktra email
            if (email == "") {
                document.getElementById("error__email").innerHTML = "Vui lòng nhập email";

            } else if (!email.match(letter)) {
                document.getElementById("error__email").innerHTML = "Vui lòng nhập đúng định dạng email";


            } else {
                document.getElementById("error__email").innerHTML = "";
                checkemail = true;

            }

            //ktra phone
            if (phone == "") {
                document.getElementById("error__phone").innerHTML = "Vui lòng nhập số điện thoại";
            } else if (isNaN(phone)) {
                document.getElementById("error__phone").innerHTML = "Chỉ cho phép nhập số";
            } else {
                document.getElementById("error__phone").innerHTML = "";
                checkphone = true;

            }


            //ktra dia chi
            if (address == "") {
                document.getElementById("error__address").innerHTML = "Vui lòng nhập địa chỉ";
            } else {
                document.getElementById("error__address").innerHTML = "";
                checkaddress = true;

            }


            /*< ==================== them du lieu vao bang ====================>*/
            if (checkname == true && checkid == true && checkaddress == true && checkphone == true && checkemail == true) {
                var user = {
                    "fullname": fullname,
                    "id": id,
                    "email": email,
                    "phone": phone,
                    "address": address,

                }
                dataList.push(user);


                var dataListTag = document.getElementById("result");
                dataListTag.innerHTML +=
                    `<tr>
                            <td>${++count}</td>
                            <td>${fullname}</td>
                            <td>${id}</td>
                            <td>${email}</td>
                            <td>${phone}</td>
                            <td>${address}</td>
                            <td><button class="fa fa-edit" onclick="editUser(${count - 1})">Sửa</button>
                            <button class="fa fa-trash" onclick="deleteUser(${count - 1})">Xóa</button></td>
                        </tr>`
            }

            //  }

            function deleteUser(index) {
                // console.log(index)
                // dataList.splice(index, 1)
                // showUser();
            }

            function showUser() {
                document.getElementById('result').innerHTML = ''

                for (var i = 0; i < dataList.length; i++) {
                    document.getElementById('result').innerHTML += `<tr>
                            <td>${i + 1}</td>
                            <td>${dataList[i].fullname}</td>
                            <td>${dataList[i].id}</td>
                            <td>${dataList[i].email}</td>
                            <td>${dataList[i].phone}</td>
                            <td>${dataList[i].address}</td>
                            <td><button class="fa fa-edit" onclick="editUser(${i})">Sửa</button>
                            <button class="fa fa-trash" onclick="deleteUser(${i})">Xóa</button></td>
                        </tr>`
                }
            }

            function editUser(index) {
                // var user = dataList[index]
                // console.log(user)
                // document.getElementById('index').value = index
                // document.getElementById('fullname').value = user.fullname
                // document.getElementById('id-user').value = user.id
                // document.getElementById('email').value = user.email
                // document.getElementById('phone').value = user.phone
                // document.getElementById('address').value = user.address

            }
        }
    </script>
</body>
</html>