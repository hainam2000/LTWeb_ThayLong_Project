function checkValue(){
    var name    = document.getElementById("username").value;
        pass    = document.getElementById("password").value;
        form    = document.getElementsByName("form").value;
        re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        s1= re.test(String(name).toLowerCase());
        if(name=="" || pass ==""){
            alert("vui long nhap day du thong tin");
            return false;
        }
        else if(s1==false){
            alert("Sai dinh dang email");
            return false;
        }
        else if(pass.length < 8){
            alert("Nhap sai mat khau,mat khau phai dai hon 8 ky tu");
            return false;
        }
        else if(pass.length >20){
            alert("Nhap sai mat khau,mat khau phai nho hon 20 ky tu");
            return false;
        }

        else{
            alert("Dang nhap thanh cong!!!!");
            return true;
        }





}