function login(){
	//清空提示信息
	$("#count_span").html("");
	$("#password_span").html("");
	//获取请求参数
	var check = true; //通过检测 
	var name = $("#count").val().trim();
	var password = $("#password").val().trim();
	console.log(name+":"+password);
	//检查参数格式
	if(name==""){
		$("#count_span").html("用户名为空").css("color","red");
		check = false;
	}
	if(password==""){
		$("#password_span").html("密码为空").css("color","red");
		check = false;
	}
	//发送Ajax请求
	if(check){
		$.ajax({
			url:"http://localhost:8080/cloud_note/user/login.do",
			type:"post",
			data:{"name":name,"password":password},
			dataType:"json",
			success:function(result){
				if(result.status==0){//登录成功
					//获取返回的用户ID，存入Cookie
					var userId = result.data;
					//调用cookie_util.js函数写入Cookie
					addCookie("userId",userId,2);
					location.href="edit.html";
				}else if(result.status==1){//账号错误
					$("#count_span").html(result.msg).css("color","red");
				}else if(result.status==2){//密码错误
					$("#password_span").html(result.msg).css("color","red");
				}
			},
			error:function(){
				alert("发生登录异常");
			}
		});
	}
}


function sign(){
	//清空提示信息
	$("#warning_1 span").html("");
	$("#warning_2 span").html("");
	$("#warning_3 span").html("");
	$(".warning").hide();
	//获取请求参数
	var name = $("#regist_username").val().trim();
	var nick = $("#nickname").val().trim();
	var password = $("#regist_password").val().trim();
	var final_password = $("#final_password").val().trim();
	//检查格式
	var check = true;
	if(name == ""){
		$("#warning_1 span").html("用户名不能为空");
		$("#warning_1").show();
		check = false;
	}
	if(password==""){
		$("#warning_2 span").html("请输入密码");
		$("#warning_2").show();
		check = false;
	}else if(password.length<6){
		$("#warning_2 span").html("密码过短(6位)");
		$("#warning_2").show();
		check = false;
	}
	if(final_password==""){
		$("#warning_3 span").html("请再次输入密码");
		$("#warning_3").show();
		check = false;
	}else if(final_password != password){
		$("#warning_3 span").html("密码输入不一致");
		$("#warning_3").show();
		check = false;
	}
	//发送Ajax请求
	if(check){
		$.ajax({
			url:"http://localhost:8080/cloud_note/user/regist.do",
			type:"post",
			data:{"name":name,"nick":nick,"password":password},
			dataType:"json",
			success:function(result){
				if(result.status==0){//成功
					//提示成功
					alert(result.msg);
					//切换到登录界面
					$("#back").click();
				}else if(result.status==1){
					//提示用户名已占用
					$("#warning_1 span").html(result.msg);
					$("#warning_1").show();
				}
				
			},
			error:function(){
				alert("注册发生异常");
			}
		});
	}
}