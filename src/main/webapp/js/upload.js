//select-省份与城市关联
var city = [[ "广州" ,"深圳"],["潍坊" ,"淄博", "威海", "烟台", "菏泽" ,"日照" ,"德州" ],
["无锡" ,"常州", "扬州", "徐州", "苏州" ,"连云港" ]];  
function changeSelect(){  
    var provinceSel = document.getElementById("province_1");
    var citySel = document.getElementById("city_1");
      
    clearSelect(citySel);   //清空列表框中原有数据  
      
    var index = provinceSel.selectedIndex;  
    for(var i=0;i<city[index].length;i++){  
        citySel.options[i] = new Option(city[index][i]);  
    }     
}  
function clearSelect(select) {//清空列表框中的信息  
    while(select.length > 0){  
        select.options[0] = null;   //将列表框中的第一项删除  
    }  
}  
//更改城市提交地址
function changeAction(){
	var provinceSel = document.getElementById("province");
    var citySel = document.getElementById("city"); 
    var formAction = document.getElementById('form_city');
    formAction.action = "/upload/uploadPhoto/spots"+"/"+provinceSel.value+"/"+citySel.value;
}

//更改学校提交地址
function changeAction_School(){
	var provinceSel = document.getElementById("province_school");  
	var formAction = document.getElementById('form_school');
    formAction.action = "/upload/uploadPhoto/college"+"/"+provinceSel.value;
}
//照片预览
function previewFile_1() {
 var preview = document.querySelector('#preview_1');
 var file  = document.querySelector('#uploadFile_1').files[0];
 var reader = new FileReader();
 reader.onloadend = function () {
  preview.src = reader.result;
 }
 if (file) {
  reader.readAsDataURL(file);
 } else {
  preview.src="img/preview-picture.png";
 }
}
function previewFile_2() {
 var preview = document.querySelector('#preview_2');
 var file  = document.querySelector('#uploadFile_2').files[0];
 var reader = new FileReader();
 reader.onloadend = function () {
  preview.src = reader.result;
 }
 if (file) {
  reader.readAsDataURL(file);
 } else {
  preview.src="img/preview-picture.png";
 }
}
//提交检测
$(document).ready(function(){
    $("#upload_city").click(function(){
        if($("#photoName_city").val().length==0){
            alert("照片名不能为空");
        }else if($("#albumName_city").val().length==0){
            alert("景点名不能为空");
        }else if($("#uploadFile_1").val().length==0){
            alert("未上传照片");
        }else if($("#photoDesc_city").val().length==0){
            alert("未添加描述");
        } else{
        	var formData = new FormData($("#form_city")[0]);
            $.ajax({//调用jquery的ajax方法
                type:"POST",//设置ajax方法提交数据的形式
                url:"/upload/uploadPhoto/spots/"+$("#province_1").val()+"/"+$("#city_1").val(),//把数据提交到后台
                beforeSend: function() {
                    console.log('before send')
                },
                data:formData,//提交数据
                async:false,
                processData:false,
                cache:false,
                contentType:false,
                success:function(){//提交成功
                        alert("提交成功");
                },
                error:function(){
                    alert("提交失败，请稍后重试");
                }
            });
        }

    });
});