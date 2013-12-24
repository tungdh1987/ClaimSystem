<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>FLAT - Error page</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- Bootstrap responsive -->
<link rel="stylesheet" href="/resources/css/bootstrap-responsive.min.css">
<!-- Theme CSS -->
<link rel="stylesheet" href="/resources/css/style.css">
<!-- Color CSS -->
<link rel="stylesheet" href="/resources/css/themes.css">
<!-- jQuery -->
<script src="/resources/js/jquery.min.js"></script>
<!-- Nice Scroll -->
<script src="/resources/js/plugins/nicescroll/jquery.nicescroll.min.js"></script>
<!-- Bootstrap -->
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="/resources/img/favicon.ico" />
</head>
<body class='error'>
	<div class="wrapper">
		<div class="code">
			<span>404</span><i class="icon-warning-sign"></i>
		</div>
		<div class="desc">Oops! Sorry, that page could'nt be found.</div>
		<form action="https://www.google.com.vn/search" class='form-horizontal'>
			<div class="input-append">
				<input type="text" name="q" placeholder="Search a site..">
				<button type='submit' class='btn'>
					<i class="icon-search"></i>
				</button>
			</div>
		</form>
		<div class="buttons">
			<div class="pull-left">
				<a href="javascript:window.history.back();" class="btn"><i class="icon-arrow-left"></i>
					Back</a>
			</div>
		</div>
	</div>
</body>
</html>
