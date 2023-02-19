<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<title>Order Details</title>
<meta content="" name="description" />
<meta content="" name="keywords" />

<!-- Favicons -->
<link href="./Images/pizza1.jpg" rel="icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet" />

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet" />
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet" />

<!-- Table -->
<link rel="Stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<style>

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

</style>
</head>

<body>
	<!-- ======= Header ======= -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container-fluid">
				<a class="navbar-brand" href="home.jsp" style ="font-size:25px;">Pizza Oven</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>	
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><form method = "post" action ="HomeServlet" ><button class = "my-btn">Home</button></form></li>
						<li class="nav-item"><form method = "post" action ="BookOrderServlet" ><button class = "my-btn">BookOrder</button></form></li>
						<li class="nav-item"><form method = "post" action ="CancelledList" ><button class = "my-btn">CancelOrder</button></form></li>
						<li class="nav-item"><form method = "post" action ="Login" ><button class = "my-btn">Logout</button></form></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main id="main">
		<div class="container  px-2"
			style="margin-bottom: 5%; margin-top: 5%;">
			<div class="table-responsive">
				<div>
							<jsp:include page="OrderTable.jsp" />
				</div>
			</div>
		</div>
	</main>
	<!-- End #main -->
	<!-- Cancel Order -->
		<div class="modal fade" id="DeleteModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Cancel Order
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="mx-1 mx-md-4" action="delete" method="post">
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="cancelId" name="cancelId" value=""
									class="form-control"/>
							</div>
						</div>
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="reason" name="reason" value=""
									class="form-control" placeholder="Enter the cancellation reason"/>
							</div>
						</div>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Cancel-Order</button>
						</form>
						</div>
				</div>
		</div>
	</div>
	<!-- Cancel order -->
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Edit Order
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="mx-1 mx-md-4" action="update" method="post">
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="id" name="id" value=""
									class="form-control" />
							</div>
						</div>
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="name" name="name" class="form-control"
									placeholder="Enter Name" />
							</div>
						</div>
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="email" name="email" class="form-control"
									placeholder="Enter Email" />
							</div>
						</div>
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="address" name="address"
									class="form-control" placeholder="Enter Delivery Address" />
							</div>
						</div>
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="contact" name="contact"
									class="form-control" placeholder="Enter Phone Number" />
							</div>
						</div>
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-book fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<div class="dropdown">
									<button
										class=" dropdown-toggle dropdown-toggle-split form-control"
										type="button" id="dropdownMenu2" data-bs-toggle="dropdown"
										aria-expanded="false" style="width: 100%;">Choose
										Item</button>
									<div class="dropdown-menu" name="drop-down"
										style="max-height: 300px; overflow-y: auto;">
										<div class="form-check">
											<div class="dropdown-item">
												<input class="form-check-input" type="checkbox" checked
													id="inlineCheckbox1" value="samosa 120" name="2" />samosa
												120<span>&#8377</span>
											</div>
											<div class="dropdown-item">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox3" value="Pizza 100" name="2" />Pizza
												100<span>&#8377</span>
											</div>
											<div class="dropdown-item">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox3" value="Beverage 120" name="2" />Beverage
												120<span>&#8377</span>
											</div>
											<div class="dropdown-item">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox3" value="Cookies 60" name="2" />Cookies
												60<span>&#8377</span>

											</div>
											<div class="dropdown-item">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox3" value="Tea 80" name="2" />Tea 80<span>&#8377</span>
											</div>
											<div class="dropdown-item" style="margin-bottom: auto">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox3" value="Coffee 50" name="2" />Coffee
												50<span>&#8377</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Update</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- ======= Footer ======= -->
	<footer id="footer">
		<div class="footer-top">
			<div class="container">
				<div class="row" style="justify-content: space-around">
					<div class="col-lg-3 col-md-6 footer-contact">
						<h3>Receptionist</h3>
						<p>
							Deepak Katiyare <br /> New York, NY 535022<br /> United States
							<br /> <br /> <strong>Phone:</strong> +1 5589 55488 55<br /> <strong>Email:</strong>
							info@example.com<br />
						</p>
					</div>

					<div class="col-lg-2 col-md-6 footer-links">
						<h4>Useful Links</h4>
						<ul>
							<li><i class="bx bx-chevron-right"></i> <a href="home.jsp">Home</a>
							</li>
						</ul>
					</div>

					<div class="col-lg-3 col-md-6 footer-links">
						<h4>Operations</h4>
						<ul>
							<li><i class="bx bx-chevron-right"></i> <a
								href="orderslist.jsp">Show Order Details</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="order.jsp">Book-Order</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!-- <div class="container d-md-flex py-4">
			<div class="me-md-auto text-center text-md-start">
				<div class="copyright">
					&copy; Copyright <strong><span>CodeTech</span></strong>. All Rights
					Reserved
				</div>
				<div class="credits">
					Designed by <a>Krunal Zodape</a>
				</div>
			</div>
			<div class="social-links text-center text-md-right pt-3 pt-md-0">
				<a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> <a
					href="#" class="facebook"><i class="bx bxl-facebook"></i></a> <a
					href="#" class="instagram"><i class="bx bxl-instagram"></i></a> <a
					href="#" class="google-plus"><i class="bx bxl-skype"></i></a> <a
					href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
			</div>
		</div> -->
	</footer>
	<!-- End Footer -->

	<div id="preloader"></div>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>
	<script type="text/javascript">
		$(function() {
			// ON SELECTING ROW
			$(".edit").click(function() {
				//FINDING ELEMENTS OF ROWS AND STORING THEM IN VARIABLES
				var id = $(this).parents("tr").find(".id").text();
				var name = $(this).parents("tr").find(".name").text();
				var email = $(this).parents("tr").find(".email").text();
				var address = $(this).parents("tr").find(".address").text();
				var contact = $(this).parents("tr").find(".contact").text();
				document.getElementById("name").value = name;
				document.getElementById("id").value = id;
				document.getElementById("email").value = email;
				document.getElementById("contact").value = contact;
				document.getElementById("address").value = address;
			});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			// ON SELECTING ROW
			$(".delete").click(function() {
				//FINDING ELEMENTS OF ROWS AND STORING THEM IN VARIABLES
				var id = $(this).parents("tr").find(".id").text();
				document.getElementById("cancelId").value = id;
			});
		});
	</script>
	<script type="text/javascript">
        const tabs = document.querySelectorAll('[data-tab-value]')
        const tabInfos = document.querySelectorAll('[data-tab-info]')
  
        tabs.forEach(tab => {
            tab.addEventListener('click', () => {
                const target = document
                    .querySelector(tab.dataset.tabValue);
  
                tabInfos.forEach(tabInfo => {
                    tabInfo.classList.remove('active')
                })
                target.classList.add('active');
            })
        })
    </script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>
	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script> -->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<script>
		$(document)
				.ready(
						function() {
							$("#MyTable")
									.DataTable(
											{
												initComplete : function() {
													this
															.api()
															.columns()
															.every(
																	function() {
																		var column = this;
																		var select = $(
																				'<select><option value=""></option></select>')
																				.appendTo(
																						$(
																								column
																										.footer())
																								.empty())
																				.on(
																						"change",
																						function() {
																							var val = $.fn.dataTable.util
																									.escapeRegex($(
																											this)
																											.val());
																							//to select and search from grid
																							column
																									.search(
																											val ? "^"
																													+ val
																													+ "$"
																													: "",
																											true,
																											false)
																									.draw();
																						});

																		column
																				.data()
																				.unique()
																				.sort()
																				.each(
																						function(
																								d,
																								j) {
																							select
																									.append('<option value="' + d + '">'
																											+ d
																											+ "</option>");
																						});
																	});
												},
											});
						});
	</script>
	  <script lang="javascript">
    const reloadUsingLocationHash = () => {
      window.location.hash = "reload";
    }
    window.onload = reloadUsingLocationHash();
  </script>
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
</body>

</html>