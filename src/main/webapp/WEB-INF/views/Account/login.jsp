<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>Claim System - Login</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- Bootstrap responsive -->
<link rel="stylesheet"
	href="/resources/css/bootstrap-responsive.min.css">
<!-- icheck -->
<link rel="stylesheet" href="/resources/css/plugins/icheck/all.css">
<!-- Theme CSS -->
<link rel="stylesheet" href="/resources/css/style.css">
<!-- Color CSS -->
<link rel="stylesheet" href="/resources/css/themes.css">
<!-- jQuery -->
<script src="/resources/js/jquery.min.js"></script>
<!-- Nice Scroll -->
<script src="/resources/js/plugins/nicescroll/jquery.nicescroll.min.js"></script>
<!-- Validation -->
<script src="/resources/js/plugins/validation/jquery.validate.min.js"></script>
<script src="/resources/js/plugins/validation/additional-methods.min.js"></script>
<!-- icheck -->
<script src="/resources/js/plugins/icheck/jquery.icheck.min.js"></script>
<!-- Bootstrap -->
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/eakroko.min.js"></script>
<!-- Favicon -->
<link rel="shortcut icon" href="/resources/img/favicon.ico" />
</head>
<body class='login'>
	<div class="wrapper">
		<h1>
			<a href="#"><img src="/resources/img/logo-big.png" alt=""
				class='retina-ready' width="59" height="49">Claim System</a>
		</h1>
		<div class="login-body">
			<h2>SIGN IN</h2>
			<form action="/account/login" class='form-validate' id="test"
				method="POST">
				<c:if test='${error != null}'>
					<div class="control-group">
						<span
							style="text-align: center; font-size: 14px !important; color: rgb(185, 74, 72);"
							class="help-block error">${error}</span>
					</div>
				</c:if>
				<div class="control-group">
					<div class="email controls">
						<input type="text" name="email" placeholder="Email address"
							class='input-block-level' data-rule-required="true"
							data-rule-email="true" />
					</div>
				</div>
				<div class="control-group">
					<div class="pw controls">
						<input type="password" name="password" placeholder="Password"
							class='input-block-level' data-rule-required="true">
					</div>
				</div>
				<div class="submit">
					<input type="submit" value="Sign me in" class='btn btn-primary'>
				</div>
			</form>
			<div class="forget">
				<a href="#"><span>Forgot password?</span></a>
			</div>
		</div>
	</div>
</body>
</html>
