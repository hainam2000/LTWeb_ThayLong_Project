<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>LKMT - Linh Kiện Máy Tính</title>
    <link rel="stylesheet" href="assets/css/register-page.css">
</head>
<body>
    <div class="contain-main">
        <div class="tab">
            <button class="tablinks" onclick="changeTab(event, 'login')" id="defaultOpen">ĐĂNG NHẬP</button>
            <button class="tablinks" onclick="changeTab(event, 'register')" >ĐĂNG KÝ</button>
        </div>
        <div class="tabcontent" id="register">
            <h3 class="form-title">ĐĂNG KÝ</h3>
            <div class="form-container">
                <form class="reg-form" method="post" action="register">
                    <div class="form-group">
                        <label class="lb">Tài Khoản</label>
                        <input class="form-control" type="text" placeholder="Tài khoản (VD: aaa)"
                            name="username" required>
                        <div class="error"></div>
                    </div>
                    <div class="form-group">
                        <label class="lb">Mật khẩu</label>
                        <input class="form-control" type="password" placeholder="Mật khẩu (8-18 ký tự)"
                            name="password" required>
                        <div class="error"></div>
                    </div>
                    <div class="form-group">
                        <label class="lb">Nhập lại mật khẩu</label>
                        <input class="form-control" type="password"
                            placeholder="Vui lòng nhập đúng mật khẩu ở trên " name="confirm-password" required>
                        <div class="error"></div>
                    </div>
                    <br>
                    <h5 style="text-align: center">Thông tin cá nhân</h5>

                    <div class="form-group">
                        <label id="" class="lb">Họ & tên</label>
                        <input class="form-control" type="text" placeholder="Họ & Tên" name="fullname"
                            required>
                        <div class="error"></div>
                    </div>
                    <div class="form-group">
                        <label class="lb">Số điện thoại</label>
                        <input class="form-control" type="text" placeholder="Số điện thoại" name="phone"
                            required>
                        <div class="error"></div>
                    </div>
                    <div class="form-group">
                        <label class="lb">Email</label>
                        <input class="form-control" type="email" placeholder="Địa chỉ Email" name="username">
                        <div class="error"></div>
                    </div>
                    <div class="form-group">
                        <label class="lb">Địa chỉ</label>
                        <input class="form-control" type="text" placeholder="Địa chỉ " name="address">
                        <div class="error"></div>
                    </div>
                    <button class="btn-reg">Đăng ký</button>
                </form>
                <br>
            </div>
        </div>
        <div class="tabcontent" id="login">
            <h3 class="form-title">ĐĂNG NHẬP</h3>
            <div class="form-container">
                <form class="login-form" method="post" action="login">

                    <div class="form-group">
                        <label class="lb">Tài Khoản</label>
                        <input class="form-control" type="text" placeholder="Tài khoản" name="username">
                    </div>

                    <div class="form-group">
                        <label class="lb">Mật khẩu</label>
                        <input class="form-control" type="password" placeholder="Mật khẩu"
                            name="password">

                    </div>
                    <a class="forgot-pass" href="#">Quên mật khẩu?</a>
                    <button class="btn-login">Đăng nhập</button>

                </form>
                <br>
            </div>
        </div>
    </div>
    <script>
        function changeTab(evt, name) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }

            // Get all elements with class="tablinks" and remove the class "active"
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }

            // Show the current tab, and add an "active" class to the button that opened the tab
            document.getElementById(name).style.display = "block";
            evt.currentTarget.className += " active";
        }

        document.getElementById("defaultOpen").click();
    </script>
</body>

</html>