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
								<li class="nav"><a href="index.jsp"> <i
										class="fa fa-home" aria-hidden="true"></i> <span>Home</span>
								</a></li>
								<li class="nav"><a href="registration.jsp"> <i
										class="fa fa-hand-o-right" aria-hidden="true"></i> <span>Registration Phase</span>
								</a></li>
								<li class="nav-active"><a href="verification.jsp"> <i
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
					<h2>Verification</h2>


				</header>

				<div class="row">
					<div class="col-md-12 col-lg-12 col-xl-12">
						<section class="panel">
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-12">
										<h4>Verification Phase</h4>
										<hr />
										
										<%
											String msg = request.getParameter("msg");
											if (msg != null)
											{
											   %>
											   		<div style='padding:20px; margin:20px; border: solid lightgray 1px;'>
												   		<h5>Message from the Server:</h5>
												   		<hr/>
												   		<h4><%=msg %></h4>
											   		</div>				
											   		<br/><br/>							   	
											   <%
											}
										%>
										
										<form action='verification' method=post class='col-md-6'>
											<label>Enter your Email ID</label>
											<input type=text name='email' class='form-control' required="required" placeholder='Email ID'/>
											<br/>
											<label>Enter your passcode</label>
											<input type=password name='passcode' class='form-control' required="required" placeholder='Passcode'/>
											<br/>
											<input type=submit value='Verify' class='btn btn-primary' />
										</form>
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