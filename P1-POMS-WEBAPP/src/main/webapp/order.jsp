<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order</title>
<link href="./Images/pizza1.jpg" rel="icon">
<link href="./assets/img/apple-touch-icon.png" rel="apple-touch-icon">
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="./assets/vendor/animate.css/animate.min.css"
	rel="stylesheet">
<link href="./assets/vendor/aos/aos.css" rel="stylesheet">
<link href="./assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="./assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="./assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="./assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="./assets/css/style.css" rel="stylesheet">

<style>

.myButton{
	font-weight: 600;
    font-size: 13px;
    letter-spacing: 0.5px;
    text-transform: uppercase;
    display: inline-block;
    padding: 12px 30px;
    border-radius: 50px;
    transition: 0.3s;
    background-color:transparent;
    line-height: 1;
    color: white;
    margin-top:15px;
    margin-left:10px;
    border: 2px solid #cda45e; 
}
.my-btn:hover{
     	background-color:#cda45e;
    }
.my-btn{
	background-color:transparent;
	font-size:20px;
	border:none;
	border-radius:20px;
	color:white;
	margin-left:10px;
}
.nav-value{
	font-size:20px;
	font-weight:10px;
}
.myButton:hover{
     	background-color:#cda45e;
    }
 .bgcolor:active{
 	background-color:transparent;
 }
 .bgcolor{
 	background-color:transparent;
 	border-radius:20px;
 	color:white;
 	border: 2px solid #cda45e
 }
</style>
</head>

<body>
<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-dark fixed-top py-3">
			<div class="container-fluid">
				<a class="navbar-brand " href="home.jsp" style ="font-size:25px;">Pizza Oven</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><form method = "post" action ="HomeServlet" ><button class = "my-btn" >Home</button></form></li>
						<li class="nav-item"><form method = "post" action ="Orders" ><button class = "my-btn" >Orders</button></form></li>
						<li class="nav-item"><form method = "post" action ="CancelledList" ><button class = "my-btn">CancelOrder</button></form></li>
						<li class="nav-item"><form method = "post" action ="Login" ><button class = "my-btn">Logout</button></form></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<section id="book-a-table" class="book-a-table mt-5">
		<div class="container" data-aos="fade-up">

			<div class="section-title">
				
				<p>Book Order</p>
			</div>
			<form action="order" method="post" role="form" data-aos="fade-up"
				data-aos-delay="100">
				<div class="row">
					<div class="col-lg-4 form-group mt-4">
						<input type="text" name="name" class="form-control bgcolor" id="name"
							placeholder="Your Name">
					</div>
					<div class="col-lg-4 form-group mt-4">
						<input type="email" class="form-control bgcolor" name="email" id="email"
							placeholder="Your Email">
					</div>
					<div class="col-lg-4 form-group mt-4">
						<input type="text" class="form-control bgcolor" name="phone" id="phone"
							placeholder="Your Phone">
					</div>
					<div class="col-lg-4 form-group mt-4">
						<input type="text" name="address" class="form-control bgcolor"
							id="address" placeholder="Delivery Address">
					</div>
					<div class="col-lg-4 form-group mt-4 ">
						<select class="form-select form-control bgcolor" name="status"
							aria-label="Default select example" style="font-weight: inherit;
    background-color: transparent;
    color: grey;
    border: 2px solid #cda45e;">
							<option selected>select</option>
							<option value="confirmed">confirmed</option>
						</select>
					</div>
					<div class="col-lg-4 mt-4">
						<div class="dropdown ">
							<button
								class="btn  dropdown-toggle dropdown-toggle-split form-group bgcolor"
								type="button" id="dropdownMenu2" data-bs-toggle="dropdown"
								aria-expanded="false"
								style="width: 100%;
    font-weight: inherit;
    background-color: transparent;
    color: grey;
    border: 2px solid #cda45e;">
								Choose Item</button>
							<div class="dropdown-menu" name = "drop-down" style = "max-height:300px;overflow-y:auto;">
								<div class="form-check">
									<div class="dropdown-item">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox1" value="samosa 120" name = "1"/>samosa 120<span>&#8377</span>
									</div>
									<div class="dropdown-item">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox3" value="Pizza 100" name = "1"/>Pizza 100<span>&#8377</span>
									</div>
									<div class="dropdown-item">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox3" value="Beverage 120" name = "1"/>Beverage 120<span>&#8377</span>
									</div>
									<div class="dropdown-item">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox3" value="Cookies 60" name = "1"/>Cookies 60<span>&#8377</span>

									</div>
									<div class="dropdown-item">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox3" value="Tea 80" name = "1"/>Tea 80<span>&#8377</span>
									</div>
									<div class="dropdown-item"style ="margin-bottom:auto">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox3" value="Coffee 50" name = "1" />Coffee 50<span>&#8377</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group mt-4">
					<textarea class="form-control bgcolor" name="message" rows="5"
						placeholder="Message"></textarea>
					<div class="validate"></div>
				</div>

				<div class="text-center">
					<button
						class="myButton" type="submit">
								Book Order</button>
				</div>
			</form>
		</div>
	</section>
	<!-- End Book OrderSection -->
	<!-- Vendor JS Files -->
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>
</body>

</html>