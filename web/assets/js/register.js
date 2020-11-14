$(document).ready(function() {
    $('body').on('click','#register', function() {
    var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
    var mobile = $('#phone-number').val();
    if(mobile !==''){
        if (vnf_regex.test(mobile) == false) 
        {
            alert('Số điện thoại của bạn không đúng định dạng!');
        }
    }else{
        alert('Bạn chưa điền số điện thoại!');
    }
    });
});