<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>${title}</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- Bootstrap responsive -->
<link rel="stylesheet"
	href="/resources/css/bootstrap-responsive.min.css">
<!-- jQuery UI -->
<link rel="stylesheet"
	href="/resources/css/plugins/jquery-ui/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="/resources/css/plugins/jquery-ui/smoothness/jquery.ui.theme.css">
<!-- chosen -->
<link rel="stylesheet" href="/resources/css/plugins/chosen/chosen.css">
<!-- Datepicker -->
<link rel="stylesheet"
	href="/resources/css/plugins/datepicker/datepicker.css">
<!-- Plupload -->
<link rel="stylesheet"
	href="/resources/css/plugins/plupload/jquery.plupload.queue.css">
<!-- select2 -->
<link rel="stylesheet" href="/resources/css/plugins/select2/select2.css">
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
<!-- imagesLoaded -->
<script
	src="/resources/js/plugins/imagesLoaded/jquery.imagesloaded.min.js"></script>
<!-- jQuery UI -->
<script src="/resources/js/plugins/jquery-ui/jquery.ui.core.min.js"></script>
<script src="/resources/js/plugins/jquery-ui/jquery.ui.widget.min.js"></script>
<script src="/resources/js/plugins/jquery-ui/jquery.ui.mouse.min.js"></script>
<script src="/resources/js/plugins/jquery-ui/jquery.ui.resizable.min.js"></script>
<script src="/resources/js/plugins/jquery-ui/jquery.ui.sortable.min.js"></script>
<script src="/resources/js/plugins/jquery-ui/jquery.ui.spinner.js"></script>
<script src="/resources/js/plugins/jquery-ui/jquery.ui.slider.js"></script>
<!-- Bootstrap -->
<script src="/resources/js/bootstrap.min.js"></script>
<!-- Bootbox -->
<script src="/resources/js/plugins/bootbox/jquery.bootbox.js"></script>
<!-- Masked inputs -->
<script
	src="/resources/js/plugins/maskedinput/jquery.maskedinput.min.js"></script>
<!-- Datepicker -->
<script src="/resources/js/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Chosen -->
<script src="/resources/js/plugins/chosen/chosen.jquery.min.js"></script>
<!-- PLUpload -->
<script src="/resources/js/plugins/plupload/plupload.full.js"></script>
<script src="/resources/js/plugins/plupload/jquery.plupload.queue.js"></script>
<!-- Custom file upload -->
<script
	src="/resources/js/plugins/fileupload/bootstrap-fileupload.min.js"></script>
<script src="/resources/js/plugins/mockjax/jquery.mockjax.js"></script>
<!-- select2 -->
<script src="/resources/js/plugins/select2/select2.min.js"></script>
<!-- icheck -->
<script src="/resources/js/plugins/icheck/jquery.icheck.min.js"></script>
<!-- number format -->
<script src="/resources/js/plugins/format/jquery.number.min.js"></script>
<!-- complexify -->
<script
	src="/resources/js/plugins/complexify/jquery.complexify-banlist.min.js"></script>
<script src="/resources/js/plugins/complexify/jquery.complexify.min.js"></script>
<!-- Mockjax -->
<script src="/resources/js/plugins/mockjax/jquery.mockjax.js"></script>
<!-- Theme framework -->
<script src="/resources/js/eakroko.min.js"></script>
<!-- Theme scripts -->
<script src="/resources/js/application.min.js"></script>
<!-- Just for demonstration -->
<script src="/resources/js/demonstration.min.js"></script>
<!-- Favicon -->
<link rel="shortcut icon" href="/resources/img/favicon.ico" />
</head>
<body>
	<div id="navigation">
		<div class="container-fluid">
			<a href="#" id="brand">System</a> <a href="#" class="toggle-nav"
				rel="tooltip" data-placement="bottom" title="Toggle navigation"><i
				class="icon-reorder"></i></a>
			<ul class='main-nav'>
				<li class='active'><a href="/home/index"><span>Dashboard</span></a></li>
			</ul>
			<div class="user">
				<ul class="icon-nav">
					<li class='dropdown'><a href="#" class='dropdown-toggle'
						data-toggle="dropdown"><i class="icon-envelope"></i><span
							class="label label-lightred">4</span></a>
						<ul class="dropdown-menu pull-right message-ul">
							<li><a href="#"> <img
									src="/resources/img/demo/user-1.jpg" alt="">
									<div class="details">
										<div class="name">Jane Doe</div>
										<div class="message">Lorem ipsum Commodo quis nisi ...</div>
									</div>
							</a></li>
							<li><a href="#"> <img
									src="/resources/img/demo/user-2.jpg" alt="">
									<div class="details">
										<div class="name">John Doedoe</div>
										<div class="message">Ut ad laboris est anim ut ...</div>
									</div>
									<div class="count">
										<i class="icon-comment"></i> <span>3</span>
									</div>
							</a></li>
							<li><a href="#"> <img
									src="/resources/img/demo/user-3.jpg" alt="">
									<div class="details">
										<div class="name">Bob Doe</div>
										<div class="message">Excepteur Duis magna dolor!</div>
									</div>
							</a></li>
							<li><a href="components-messages.html" class='more-messages'>Go
									to Message center <i class="icon-arrow-right"></i>
							</a></li>
						</ul></li>
					<li class='dropdown colo'><a href="#" class='dropdown-toggle'
						data-toggle="dropdown"><i class="icon-tint"></i></a>
						<ul class="dropdown-menu pull-right theme-colors">
							<li class="subtitle">Predefined colors</li>
							<li><span class='red'></span> <span class='orange'></span> <span
								class='green'></span> <span class="brown"></span> <span
								class="blue"></span> <span class='lime'></span> <span
								class="teal"></span> <span class="purple"></span> <span
								class="pink"></span> <span class="magenta"></span> <span
								class="grey"></span> <span class="darkblue"></span> <span
								class="lightred"></span> <span class="lightgrey"></span> <span
								class="satblue"></span> <span class="satgreen"></span></li>
						</ul></li>
				</ul>
				<div class="dropdown">
					<a href="#" class='dropdown-toggle' data-toggle="dropdown">John
						Doe <img src="/resources/img/demo/user-avatar.jpg" alt="">
					</a>
					<ul class="dropdown-menu pull-right">
						<li><a href="more-userprofile.html">Edit profile</a></li>
						<li><a href="#">Account settings</a></li>
						<li><a href="more-login.html">Sign out</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid" id="content">
		<div id="left">
			<form action="search-results.html" method="GET" class='search-form'>
				<div class="search-pane">
					<input style="font-style: italic;" type="text" name="search"
						placeholder="Search here...">
					<button type="submit">
						<i class="icon-search"></i>
					</button>
				</div>
			</form>
			<div class="subnav">
				<div class="subnav-title">
					<a href="#" class='toggle-subnav'><i class="icon-angle-down"></i><span>Content</span></a>
				</div>
				<ul class="subnav-menu">
					<li class='dropdown'><a href="#" data-toggle="dropdown">Articles</a>
						<ul class="dropdown-menu">
							<li><a href="#">Action #1</a></li>
							<li><a href="#">Antoher Link</a></li>
							<li class='dropdown-submenu'><a href="#"
								data-toggle="dropdown" class='dropdown-toggle'>Go to level 3</a>
								<ul class="dropdown-menu">
									<li><a href="#">This is level 3</a></li>
									<li><a href="#">Unlimited levels</a></li>
									<li><a href="#">Easy to use</a></li>
								</ul></li>
						</ul></li>
					<li><a href="#">News</a></li>
					<li><a href="#">Pages</a></li>
					<li><a href="#">Comments</a></li>
				</ul>
			</div>
			<div class="subnav">
				<div class="subnav-title">
					<a href="#" class='toggle-subnav'><i class="icon-angle-down"></i><span>Plugins</span></a>
				</div>
				<ul class="subnav-menu">
					<li><a href="#">Cache manager</a></li>
					<li class='dropdown'><a href="#" data-toggle="dropdown">Import
							manager</a>
						<ul class="dropdown-menu">
							<li><a href="#">Action #1</a></li>
							<li><a href="#">Antoher Link</a></li>
							<li class='dropdown-submenu'><a href="#"
								data-toggle="dropdown" class='dropdown-toggle'>Go to level 3</a>
								<ul class="dropdown-menu">
									<li><a href="#">This is level 3</a></li>
									<li><a href="#">Unlimited levels</a></li>
									<li><a href="#">Easy to use</a></li>
								</ul></li>
						</ul></li>
					<li><a href="#">Contact form generator</a></li>
					<li><a href="#">SEO optimization</a></li>
				</ul>
			</div>
			<div class="subnav">
				<div class="subnav-title">
					<a href="#" class='toggle-subnav'><i class="icon-angle-down"></i><span>Settings</span></a>
				</div>
				<ul class="subnav-menu">
					<li><a href="#">Theme settings</a></li>
					<li class='dropdown'><a href="#" data-toggle="dropdown">Page
							settings</a>
						<ul class="dropdown-menu">
							<li><a href="#">Action #1</a></li>
							<li><a href="#">Antoher Link</a></li>
							<li class='dropdown-submenu'><a href="#"
								data-toggle="dropdown" class='dropdown-toggle'>Go to level 3</a>
								<ul class="dropdown-menu">
									<li><a href="#">This is level 3</a></li>
									<li><a href="#">Unlimited levels</a></li>
									<li><a href="#">Easy to use</a></li>
								</ul></li>
						</ul></li>
					<li><a href="#">Security settings</a></li>
				</ul>
			</div>
			<div class="subnav subnav-hidden">
				<div class="subnav-title">
					<a href="#" class='toggle-subnav'><i class="icon-angle-right"></i><span>Default
							hidden</span></a>
				</div>
				<ul class="subnav-menu">
					<li><a href="#">Menu</a></li>
					<li class='dropdown'><a href="#" data-toggle="dropdown">With
							submenu</a>
						<ul class="dropdown-menu">
							<li><a href="#">Action #1</a></li>
							<li><a href="#">Antoher Link</a></li>
							<li class='dropdown-submenu'><a href="#"
								data-toggle="dropdown" class='dropdown-toggle'>More stuff</a>
								<ul class="dropdown-menu">
									<li><a href="#">This is level 3</a></li>
									<li><a href="#">Easy to use</a></li>
								</ul></li>
						</ul></li>
					<li><a href="#">Security settings</a></li>
				</ul>
			</div>
		</div>
		<jsp:include page="../${view}" />
	</div>
	<div id="footer">
		<p>
			Aptech - Claim System <span class="font-grey-4">|</span> <a href="#">Contact</a>
			<span class="font-grey-4">|</span> <a href="#">Imprint</a>
		</p>
		<a href="#" class="gototop"><i class="icon-arrow-up"></i></a>
	</div>
</body>
</html>