<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1"
	name="viewport">
<title>Login</title>
<link href="./Images/pizza1.jpg" rel="icon">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
<link rel="stylesheet" type="text/css" href="./css/font-awesome.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.0/jquery.min.js"
	integrity="sha512-qp27nuUylUgwBZJHsmm3W7klwuM5gke4prTvPok3X5zi50y3Mo8cgpeXegWWrdfuXyF2UdLWK/WCb5Mv7CKHcA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="./js/popper.js"></script>
<script src="./js/bootstrap.min.js"></script>
<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.h-custom {
	height: calc(100% - 73px);
}

@media ( max-width : 450px) {
	.h-custom {
		height: 100%;
	}
}

.section-title {
	margin: 0%;
	font-size: 36px;
	font-weight: 700;
	font-family: "Playfair Display", serif;
	color: #cda45e;
}
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6">
				<img src="./Images/pizza1.jpg" class="img-fluid" alt="Sample image"
					style="width: 100%; height: auto;">
			</div>
			
			<div class="col-lg-6 align-self-center">
				<div class="row section-title justify-content-center">PIZZA-OVEN</div>
				<div class="row  justify-content-center">
					<img src="./Images/user.svg" class="img-fluid" alt="Sample image"style="width: 100px; height: auto;">
				</div>				
				<div class="row justify-content-center">
					<div class="col-lg-8">
						<div class=" row section-title">Receptionist Login</div>
						
						<!-- onclick="ValidateEmail(document.getElementById('email')) -->
						<form action="Home" method="post">
							<!-- Email input -->
							<div class="form-outline mb-4">
								<input type="email" name="email" id="email"
									class="form-control form-control-lg"
									placeholder="Enter a valid email address" />
							</div>
							<!-- Password input -->
							<div class="form-outline mb-4">
								<input type="password" name="password" id="password"
									class="form-control form-control-lg"
									placeholder="Enter password" />
							</div>
							<!-- <div class="d-flex justify-content-between align-items-center"> -->
							<!-- Checkbox -->
							<!-- <div class="form-check mb-0">
								<input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
								<label class="form-check-label" for="form2Example3"> Remember me </label>
							</div>
							<a href="#!" class="text-body">Forgot password?</a>
						</div> -->
							<div class="form-outline mb-4">
								<button class="form-control form-control-lg btn btn-dark"
									type="submit">Login</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	
	
	<script type="text/javascript">
	function ValidateEmail(email)
{
	
    var mailformat = "/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/";
    if(email.value.match(mailformat))
    {
        document.getElementById('password').focus();
        return true;
    }
    else
    {
        alert("You have entered an invalid email address!");
        document.getElementById('email').focus();
        return false;
    }
}
</script>
</body>

</html>