<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký</title>
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/register-page.css">
</head>
<body>
    <div class="container">
    <h3 class="form-title">ĐĂNG KÝ</h3>
    <div class="form-container">
        <form class="reg-form">

            <div class="form-group">
                <label for="username" class="lb">Tài Khoản</label>
                <input id="username" class="form-control" type="text" placeholder="Tài khoản (VD: aaa)" name="username"required >
                <div class = "error"></div>
            </div>
            <div class="form-group">
                <label for="password" class="lb">Mật khẩu</label>
                <input id="password" class="form-control" type="password" placeholder="Mật khẩu (8-18 ký tự)" name="password"required>
                <div class = "error"></div>
            </div>
            <div class="form-group">
                <label for="confirm-pass" class="lb">Nhập lại mật khẩu</label>
                <input id="confirm-pass" class="form-control" type="password" placeholder="Vui lòng nhập đúng mật khẩu ở trên " name="confirm-password"required>
                <div class = "error"></div>
            </div>
            <br>
            <h5 style="text-align: center">Thông tin cá nhân</h5>

            <div class="form-group">
                <label for="fullname" id="" class="lb">Họ & tên</label>
                <input id="fullname" class="form-control" type="text" placeholder="Họ & Tên" name="fullname" required>
                <div class = "error"></div>
            </div>
            <div class="form-group">
                <label for="phone" class="lb">Số điện thoại</label>
                <input id="phone" class="form-control" type="text" placeholder="Số điện thoại" name="phone" required>
                <div class = "error"></div>
            </div>
            <div class="form-group">
                <label for="email" class="lb">Email</label>
                <input id="email" class="form-control" type="email" placeholder="Địa chỉ Email" name="username" >
                <div class = "error"></div>
            </div>
            <div class="form-group">
                <label for="address" class="lb">Địa chỉ</label>
                <input id="address" class="form-control" type="text" placeholder="Địa chỉ " name="address">
                <div class = "error"></div>
            </div>


            <button class="btn-reg">Đăng ký</button>
            <br>
            <span class="login-title">Đã có tài khoản ? <a class="login" href="login-page.html">đăng nhập</a></span>

        </form>
        <br>
    </div>
</div>
</body>
</html>