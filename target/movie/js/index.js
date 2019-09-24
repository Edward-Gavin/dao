  $(document).ready(function(){
        $("#s").addClass("hide");
        $("#c").addClass("hide");

        $('.log-btn').click(function(){
            var pwd = $("#Password").val();
            if(pwd.length < 1){
            $('.log-status').addClass('wrong-entry');
            } 
        });
        $('.sign-btn').click(function(){
            var spwd = $("#sPassword").val();
            var srepwd = $("#srePassword").val();
            if(spwd.length < 1){
                $('.sign-status1').addClass('wrong-entry');
            } 
            if(srepwd.length < 1){
                $('.sign-status2').addClass('wrong-entry');
            }
            if(spwd != srepwd){
                $('.sign-status1').addClass('wrong-entry');
                $('.sign-status2').addClass('wrong-entry');
            }
        });
        $('.change-btn').click(function(){
            var cpwd = $("#cPassword").val();
            var crepwd = $("#crePassword").val();
            if(cpwd.length < 1){
                $('.change-status1').addClass('wrong-entry');
            } 
            if(crepwd.length < 1){
                $('.change-status2').addClass('wrong-entry');
            }
            if(cpwd != crepwd){
                $('.change-status1').addClass('wrong-entry');
                $('.change-status2').addClass('wrong-entry');
            }
        });


        $('.form-control').keypress(function(){
            removeAll();
        });
        
        $(".signup-link").click(function(){
            $("#l").addClass("hide");
            $("#s").removeClass("hide");
        });
        $(".change-link").click(function(){
            $("#l").addClass("hide");
            $("#c").removeClass("hide");
        });
        
        $(".fa-arrow-left").click(function(){
            $("#l").removeClass("hide");
            $("#s").addClass("hide");
            $("#c").addClass("hide");
            removeAll();
        });

        function removeAll(){
            $('.log-status').removeClass('wrong-entry');
            $('.sign-status1').removeClass('wrong-entry');
            $('.sign-status2').removeClass('wrong-entry');
            $('.change-status1').removeClass('wrong-entry');
            $('.change-status2').removeClass('wrong-entry');
        }
    });