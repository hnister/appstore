<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>开发者注册</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath }/statics/css/nprogress.css"
	rel="stylesheet">
<!-- Animate.css -->
<link href="https://colorlib.com/polygon/gentelella/css/animate.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath }/statics/css/custom.min.css"
	rel="stylesheet">
<script type="text/javascript">
	function query() {
		var devCode = $("#devCode").val();
		$.ajax({
			type : "GET",
			dataType : "json",
			contentType : "application/json",//上传内容格式为json结构
			data : {
				devCode : devCode
			}, //上传的参数
			//async : false,
			url : "findDevByCode", //请求的url
			success : function(data) { //请求成功的回调函数
				if (data.msg == "OK") {
					$("#msg").text("可用");
					$("#send").attr("disabled", false);
				} else {
					$("#msg").text("该用户存在")
					$("#send").attr("disabled", true);
				}
			},
			error : function(e) { //请求失败的回调函数
				console.log(e);
			}
		})
	}
	function ack() {
		var pas1 = $("#password").val();
		var pas2 = $("#repassword").val();
		if (pas1 != pas2) {
			$("#msg2").text("密码输入不一致");
			$("#send").attr("disabled", true);
		}else{
			$("#msg2").text("");
			$("#send").attr("disabled", false);
		}
	}
</script>
</head>

<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
			id="signin"></a>

		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					<form class="form-horizontal form-label-left" action="devinfoadd"
						method="post" enctype="multipart/form-data">
						<h1>开发者注册</h1>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="name">登录名<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="devCode" class="form-control col-md-7 col-xs-12"
									data-validate-length-range="20" data-validate-words="1"
									name="devCode" required="required" placeholder="请输入用户名"
									type="text" onchange="javascript:query();">
							</div>
							<label id="msg"></label>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="name">用户名 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="APKName" class="form-control col-md-7 col-xs-12"
									data-validate-length-range="20" data-validate-words="1"
									name="devName" required="required" placeholder="请输入用户名"
									type="text">
							</div>
						</div>

						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="name">密码<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="password" class="form-control col-md-7 col-xs-12"
									name="devPassword" data-validate-length-range="20"
									data-validate-words="1" required="required" placeholder="请输入密码"
									type="password">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="name">确认密码 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="repassword" class="form-control col-md-7 col-xs-12"
									data-validate-length-range="20" data-validate-words="1"
									name="interfaceLanguage" required="required"
									placeholder="请输入密码" type="password"
									onchange="javascript:ack();">
									<label id="msg2"></label>
							</div>
						</div>
						<div class="ln_solid"></div>
						<div class="form-group">
							<div class="col-md-6 col-md-offset-3">
								<button id="send" type="submit" class="btn btn-success">提交</button>
								<button type="button" class="btn btn-primary" id="back" onclick="javascript:window.location.href='${pageContext.request.contextPath }'">返回</button>
								<br /> <br />
							</div>
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
</body>
</html>