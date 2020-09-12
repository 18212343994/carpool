
jQuery(document).ready(function() {

    /*
        Background slideshow
    */
    $.backstretch([
      "assets/img/backgrounds/1.jpg"
    , "assets/img/backgrounds/2.jpg"
    , "assets/img/backgrounds/3.jpg"
    ], {duration: 3000, fade: 750});

    /*
        Tooltips
    */
    $('.links a.home').tooltip();
    $('.links a.blog').tooltip();

    /*
        Form validation
    */
    $('.register form').submit(function(){
        $(this).find("label[for='username']").html('用户名');
        $(this).find("label[for='password']").html('密码');
        $(this).find("label[for='repassword']").html('确认密码');
        $(this).find("label[for='email']").html('电子邮件');
        $(this).find("label[for='mobile']").html('手机号');
        ////
        var mobile = $(this).find('input#mobile').val();
        var repassword = $(this).find('input#repassword').val();
        var username = $(this).find('input#username').val();
        var email = $(this).find('input#email').val();
        var password = $(this).find('input#password').val();
        
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - 请输入用户名.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - 请输入密码.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
        if(repassword == '') {
            $(this).find("label[for='repassword']").append("<span style='display:none' class='red'> - 请输入确认密码.</span>");
            $(this).find("label[for='repassword'] span").fadeIn('medium');
            return false;
        }
        if(email == '') {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - 请输入电子邮件.</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        if(mobile == '') {
            $(this).find("label[for='mobile']").append("<span style='display:none' class='red'> - 请输入确认密码.</span>");
            $(this).find("label[for='mobile'] span").fadeIn('medium');
            return false;
        }
        
    });

});


