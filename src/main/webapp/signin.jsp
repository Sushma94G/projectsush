<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html lang="zxx">

<head>
<title>Assignment-management</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="My School Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
        addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
<!-- //Meta tag Keywords -->

<!-- Custom-Files -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Bootstrap-CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Style-CSS -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<!-- Font-Awesome-Icons-CSS -->
<!-- //Custom-Files -->

<!-- Web-Fonts -->
<link
	href="//fonts.googleapis.com/css?family=Lora:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext,vietnamese"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800&amp;subset=latin-ext"
	rel="stylesheet">
<!-- //Web-Fonts -->
</head>

<body>
	<!-- header -->
	<header>
		<div class="container">
			<div
				class="header d-lg-flex justify-content-between align-items-center py-2 px-sm-2 px-1">
				<!-- logo -->
				<div id="logo">
					<h1>
						<a href="index.html">Signin</a>
					</h1>
				</div>
				<!-- //logo -->
				<!-- nav -->
				<div class="nav_w3ls ml-lg-5">
					<nav>
						<label for="drop" class="toggle">Menu</label> <input
							type="checkbox" id="drop" />
						<ul class="menu">
							<li><a href="home.jsp">Home</a></li>
							<li><a href="signup.jsp">Signup</a></li>
							<li>
								<!-- First Tier Drop Down --> <input type="checkbox" id="drop-2" />

							</li>
							<li><a href="signin.jsp">Signin</a></li>
							<li><a href="register.html">upload</a></li>
						</ul>
					</nav>
				</div>
				<!-- //nav -->
			</div>
		</div>
	</header>
	<!-- //header -->


	<div class="main-w3pvt mian-content-wthree text-center" id="home">
		<div class="container">
			<div class="style-banner mx-auto">
				<h3 class="text-wh font-weight-bold">
					Welcome to <span>X-workz</span> <br>Best for Education
				</h3>
				<p class="mt-3 text-li" id="join">Join the My Intitute now</p>
				<!-- form -->
				<div class="home-form-w3ls mt-5">
					<form action="signin.ams" method="post">
						<h2>${msg }</h2>
						<div class="row justify-content-center">
							<div class="col-lg-6">
								 <div class="form-group">
                        <label class="col-form-label">Email</label>
                        <input type="text" class="form-control" placeholder="email" name="emailId" required="">
                          </div>
								<div class="form-group">
									<label class="col-form-label">Password</label> 
									<input type="password" class="form-control" placeholder="*****"
										name="password" required="">
								</div>
							</div>
						</div>
						<button type="submit" class="btn_apt btn">Signin</button>
						<button type="submit" class="btn_apt btn">Cancel</button>
					</form>
				</div>
				<!-- //form -->
			</div>
		</div>
	</div>
	<!-- //banner -->


	<div class="fixed-footer">
		<div class="container">Copyright &copy; 2019 Your Institute</div>
	</div>










</body>

</html>