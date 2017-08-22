// 登录
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var reg_rewrite = new RegExp("(^|/)" + name + "/([^/]*)(/|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    var q = window.location.pathname.substr(1).match(reg_rewrite);
    if(r != null){
        return unescape(r[2]);
    }else if(q != null){
        return unescape(q[2]);
    }else{
        return null;
    }
}
document.cookie="marker="+getQueryString("marker");



// 注册
 function signupclicl() {
            $.ajax({
                url:"/signup/request",
                type:"POST",
                data:"userName="+$("#username").val()+"&password="+$("#password").val()/*{
                    "userName":$("#username").val(),
                    "password":$("#password").val()
                }*/,
                error:function (xhr, status, error) {
                    alert("注册失败");
                },
                success:function(data,status){
                    if(data.success==true){
                        alert("注册成功");
                    }
                    else{
                        alert("注册失败");
                    }
                },
                timeout:50000
            })
        }
        function checkname() {
            $.ajax({
                url:"/signup/check/"+$("#username").val(),
                type:"GET",
                success:function (data,status) {
                    if(data.nameUsed==true){
                        $("#checkname").text("");
                    }
                    else{
                        $("#checkname").text("用户名已被使用");
                    }
                }
            })
        }





function doReset(){  
  document.getElementById("login-2").value="";
}  /*清除输入框内容*/
  

  $(".button-collapse").sideNav({
});



 function remove(node){
        node.parentNode.removeChild(node);
 }



function del(){
    var part = document.getElementsByClassName("part");
    var trash = document.getElementsByClassName("trash");
    for(var i = 0;i<trash.length;i++){
        (function(i) {                  //var的作用域问题
            trash[i].onclick =  function () {
                var trashNum = i;
                var msg = "确定删除？";
                if (confirm(msg)==true){
                    remove(part[trashNum]);
                    return del();
                }
                else{
                    return false;
                }
            }
        })(i)
    }
}
del();


 