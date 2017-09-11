//照片预览
function previewFile() {
	var preview = document.querySelector('#preview');
	var file = document.querySelector('input[type=file]').files[0];
	var reader = new FileReader();
	reader.onloadend = function() {
		preview.src = reader.result;
	}
	if(file) {
		reader.readAsDataURL(file);
	} else {
		preview.src = "";
	}
}
//提示框：暂未开启此功能
function display_alert()
  {
  alert("暂未开启此功能");
  }
//修改密码
$(document).ready(function(){
	$("#upload").click(function(){
		if($("#newPassword").val().length<6){
			alert("新密码长度应大于6位");
		}else{
		$.ajax({//调用jquery的ajax方法 
			type:"POST",//设置ajax方法提交数据的形式 
			url:" ",//把数据提交到后台
			beforeSend: function() {
				console.log('before send')
			},
			data:{
				oldPassword: $("#oldPassword").val(),
				newPassword: $("#newPassword").val(),//数据
			},
			success:function(result){//提交成功后的回调，result参数是后台的输出内容
			if(result=="true"){
				alert("修改成功");
			}
			else if(result="false"){
				alert("原密码错误，请重试");
			}
			
			},
			error:function(){
				alert("提交失败，请稍后重试");
			}
		});	
		}
		
	});
});

//退出登录
$(document).ready(function(){
    $("#log-out").click(function(){
            $.ajax({//调用jquery的ajax方法
                type:"GET",//设置ajax方法提交数据的形式
                url:"/p_logout",//把数据提交到后台
                beforeSend: function() {
                    console.log('before send')
                },
                success:function(){//退出成功，提示并跳转到登录页面
                    alert("退出成功");
                    location.href="login.html";
                },
                error:function(){//退出失败
                    alert("退出失败，请稍后重试");
                }
            });
        }
    );
});