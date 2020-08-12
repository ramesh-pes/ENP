<!doctype html>
<html class="fixed">
<head>

<!-- Basic -->
<meta charset="UTF-8">

<title>Security ENP</title>
<meta name="keywords" content="HTML5 Admin Template" />
<meta name="description"
	content="JSOFT Admin - Responsive HTML5 Template">
<meta name="author" content="JSOFT.net">

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<!-- Web Fonts  -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light"
	rel="stylesheet" type="text/css">

<!-- Vendor CSS -->
<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="assets/vendor/font-awesome/css/font-awesome.css" />
<link rel="stylesheet"
	href="assets/vendor/magnific-popup/magnific-popup.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-datepicker/css/datepicker3.css" />

<!-- Specific Page Vendor CSS -->
<link rel="stylesheet"
	href="assets/vendor/jquery-ui/css/ui-lightness/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-multiselect/bootstrap-multiselect.css" />
<link rel="stylesheet" href="assets/vendor/morris/morris.css" />

<!-- Theme CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme.css" />

<!-- Skin CSS -->
<link rel="stylesheet" href="assets/stylesheets/skins/default.css" />

<!-- Theme Custom CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme-custom.css">

<!-- Head Libs -->
<script src="assets/vendor/modernizr/modernizr.js"></script>

</head>
<body>
	<section class="body">

		<!-- start: header -->
		<header class="header">
			<div class="logo-container">
				<a href="../" class="logo">
					<h4>Encrypted Negative Password (ENP)</h4>
				</a>

			</div>

		</header>
		<!-- end: header -->

		<div class="inner-wrapper">
			<!-- start: sidebar -->
			<aside id="sidebar-left" class="sidebar-left">



				<div class="nano">
					<div class="nano-content">
						<nav id="menu" class="nav-main" role="navigation">
							<ul class="nav nav-main">
								<li class="nav-active"><a href="index.jsp"> <i
										class="fa fa-home" aria-hidden="true"></i> <span>Home</span>
								</a></li>
								<li class="nav"><a href="registration.jsp"> <i
										class="fa fa-hand-o-right" aria-hidden="true"></i> <span>Registration Phase</span>
								</a></li>
								<li class="nav"><a href="verification.jsp"> <i
										class="fa fa-hand-o-left" aria-hidden="true"></i> <span>Verification Phase</span>
								</a></li>
								<li class="nav"><a href="asaservice.jsp"> <i
										class="fa fa-cloud" aria-hidden="true"></i> <span>ENP-AS-A-SERVICE</span>
								</a></li>
								<li class="nav"><a href="usage.jsp"> <i
										class="fa fa-list" aria-hidden="true"></i> <span>Usage Statistics</span>
								</a></li>

							</ul>
						</nav>


						<hr class="separator" />


					</div>

				</div>

			</aside>
			<!-- end: sidebar -->

			<section role="main" class="content-body">
				<header class="page-header">
					<h2>Home</h2>


				</header>

				<div class="row">
					<div class="col-md-12 col-lg-12 col-xl-12">
						<section class="panel">
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-12">
										<h4>Design and Implementation of Authentication scheme by
											Encrypted Negative Password</h4>
										<hr />
										<h5>Abstract</h5>
										<p>Secure password storage is a vital aspect in systems
											based on password authentication, which is still the most
											widely used authentication technique, despite its some
											security flaws. In this project, we propose a password
											authentication framework that is designed for secure password
											storage and could be easily integrated into existing
											authentication systems. In our framework, first, the received
											plain password from a client is hashed through a
											cryptographic hash function (e.g., SHA-256). Then, the hashed
											password is converted into a negative password. Finally, the
											negative password is encrypted into an Encrypted Negative
											Password (abbreviated as ENP) using a symmetric-key algorithm
											(e.g., AES), and multi-iteration encryption could be employed
											to further improve security. The cryptographic hash function
											and symmetric encryption make it difficult to crack passwords
											from ENPs. Moreover, there are lots of corresponding ENPs for
											a given plain password, which makes precomputation attacks
											(e.g., lookup table attack and rainbow table attack)
											infeasible. The algorithm complexity analyses and comparisons
											show that the ENP could resist lookup table attack and
											provide stronger password protection under dictionary attack.
											It is worth mentioning that the ENP does not introduce extra
											elements (e.g., salt); besides this, the ENP could still
											resist precomputation attacks. Most importantly, the ENP is
											the first password protection scheme that combines the
											cryptographic hash function, the negative password and the
											symmetric-key algorithm, without the need for additional
											information except the plain password</p>

										<hr />
										<h5>Existing Systems</h5>
										<p>Owing to the development of the Internet, a vast number
											of online services have emerged, in which password
											authentication is the most widely used authentication
											technique, for it is available at a low cost and easy to
											deploy. Hence, password security always attracts great
											interest from academia and industry. Despite great research
											achievements on password security, passwords are still
											cracked since users’ careless behaviors. For instance, many
											users often select weak passwords; they tend to reuse same
											passwords in different systems; they usually set their
											passwords using familiar vocabulary for its convenience to
											remember. In addition, system problems may cause password
											compromises. It is very difficult to obtain passwords from
											high security systems. On the one hand, stealing
											authentication data tables (containing usernames and
											passwords) in high security systems is difficult. On the
											other hand, when carrying out an online guessing attack,
											there is usually a limit to the number of login attempts.
											However, passwords may be leaked from weak systems.
											Vulnerabilities are constantly being discovered, and not all
											systems could be timely patched to resist attacks, which
											gives adversaries an opportunity to illegally access weak
											systems. In fact, some old systems are more vulnerable due to
											their lack of maintenance. Finally, since passwords are often
											reused, adversaries may log into high security systems
											through cracked passwords from systems of low security</p>
										<hr />
										<h5>Proposed Solution</h5>
										<p>In this project, a password protection scheme called
											Encrypted Negative Password (abbreviated as ENP) is proposed,
											which is based on the Negative Database (abbreviated as NDB),
											cryptographic hash function and symmetric encryption, and a
											password authentication framework based on the ENP is
											presented. The NDB is a new security technique that is
											inspired by biological immune systems and has a wide range of
											applications. In the ENP, the secret key is the hash value of
											the password of each user, so it is almost always different
											and does not need to be specially generated and stored.
											Consequently, the ENP enables symmetric encryption to be used
											for password protection</p>
										<hr/>
										<h5>Advantages</h5>
										<ul>
											<li>Stronger security algorithm which provides resistance to various kind of attacks including dictionary attacks and look-up table attack</li>
											<li>No extra burden on programmers for configuring more parameters</li>
											<li>Simple and convenient to use</li>
										</ul>
									</div>

								</div>
							</div>
						</section>
					</div>
				</div>




			</section>
		</div>


	</section>

	<!-- Vendor -->
	<script src="assets/vendor/jquery/jquery.js"></script>
	<script
		src="assets/vendor/jquery-browser-mobile/jquery.browser.mobile.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
	<script src="assets/vendor/nanoscroller/nanoscroller.js"></script>
	<script
		src="assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script src="assets/vendor/magnific-popup/magnific-popup.js"></script>
	<script src="assets/vendor/jquery-placeholder/jquery.placeholder.js"></script>

	<!-- Specific Page Vendor -->
	<script src="assets/vendor/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
	<script
		src="assets/vendor/jquery-ui-touch-punch/jquery.ui.touch-punch.js"></script>
	<script src="assets/vendor/jquery-appear/jquery.appear.js"></script>
	<script
		src="assets/vendor/bootstrap-multiselect/bootstrap-multiselect.js"></script>
	<script src="assets/vendor/jquery-easypiechart/jquery.easypiechart.js"></script>
	<script src="assets/vendor/flot/jquery.flot.js"></script>
	<script src="assets/vendor/flot-tooltip/jquery.flot.tooltip.js"></script>
	<script src="assets/vendor/flot/jquery.flot.pie.js"></script>
	<script src="assets/vendor/flot/jquery.flot.categories.js"></script>
	<script src="assets/vendor/flot/jquery.flot.resize.js"></script>
	<script src="assets/vendor/jquery-sparkline/jquery.sparkline.js"></script>
	<script src="assets/vendor/raphael/raphael.js"></script>
	<script src="assets/vendor/morris/morris.js"></script>
	<script src="assets/vendor/gauge/gauge.js"></script>
	<script src="assets/vendor/snap-svg/snap.svg.js"></script>
	<script src="assets/vendor/liquid-meter/liquid.meter.js"></script>
	<script src="assets/vendor/jqvmap/jquery.vmap.js"></script>
	<script src="assets/vendor/jqvmap/data/jquery.vmap.sampledata.js"></script>
	<script src="assets/vendor/jqvmap/maps/jquery.vmap.world.js"></script>
	<script
		src="assets/vendor/jqvmap/maps/continents/jquery.vmap.africa.js"></script>
	<script src="assets/vendor/jqvmap/maps/continents/jquery.vmap.asia.js"></script>
	<script
		src="assets/vendor/jqvmap/maps/continents/jquery.vmap.australia.js"></script>
	<script
		src="assets/vendor/jqvmap/maps/continents/jquery.vmap.europe.js"></script>
	<script
		src="assets/vendor/jqvmap/maps/continents/jquery.vmap.north-america.js"></script>
	<script
		src="assets/vendor/jqvmap/maps/continents/jquery.vmap.south-america.js"></script>

	<!-- Theme Base, Components and Settings -->
	<script src="assets/javascripts/theme.js"></script>

	<!-- Theme Custom -->
	<script src="assets/javascripts/theme.custom.js"></script>

	<!-- Theme Initialization Files -->
	<script src="assets/javascripts/theme.init.js"></script>


	<!-- Examples -->
	<script src="assets/javascripts/dashboard/examples.dashboard.js"></script>
</body>
</html>