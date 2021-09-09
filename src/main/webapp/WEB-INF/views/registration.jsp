<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<style>
.card {
	margin: 0 auto; /* Added */
	float: none; /* Added */
	margin-bottom: 10px; /* Added */
}

#message {
	display: none;
	background: #f1f1f1;
	color: #000;
	position: relative;
	padding: 20px;
	margin-top: 10px;
}

#message p {
	padding: 10px 35px;
	font-size: 18px;
}

/* Add a green text color and a checkmark when the requirements are right */
.valid {
	color: green;
}

.valid:before {
	position: relative;
	left: -35px;
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
	color: red;
}

.invalid:before {
	position: relative;
	left: -35px;
}
</style>
<title>Registration</title>
</head>
<body>
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Conference Registration</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
				</div>
			</div>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="card " style="border-radius: 10px; width: 50rem;">
		<div class="card-header text-center">
			<h5 class="card-title">Create Account</h5>
		</div>
		<form:form action="insertuser" method="post"
			enctype="multipart/form-data"
			style="border-radius: 10px; margin-left: 10px; margin-right: 10px;">
			<br>
			<div class="mb-3">
				<label for="exampleInputusername" class="form-label">User
					Name</label> <input type="text" class="form-control"
					id="exampleInputusername" aria-describedby="emailHelp" name="name"
					required="required">
			</div>

			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" name="email"
					required="required">
			</div>
			<div class="mb-3">
				<label for="inputPassword5" class="form-label">Password</label> <input
					type="password" id="psw" class="form-control"
					aria-describedby="passwordHelpBlock"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="password"
					required="required">
				<div id="passwordHelpBlock" class="form-text">Your password
					must be at least 8 or more characters long, contain letters and
					numbers, and must not contain spaces.</div>
				<div id="message">
					<p class="fs-5">Password must contain the following:</p>
					<p class="form-label" id="letter" class="invalid">A <b>lowercase</b>
						letter
					</p><p class="form-label" id="capital" class="invalid">A <b>capital
							(uppercase)</b> letter
					</p> <p class="form-label" id="number" class="invalid">A <b>number</b></p>
					<p class="form-label" id="length" class="invalid">Minimum
						<b>8 characters</b>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label for="exampleInputusermobile" class="form-label">Mobile
						Number</label> <input type="tel" class="form-control"
						id="exampleInputusermobile" aria-describedby="emailHelp"
						name="mobile" pattern="^\d{10}$" required="required">
				</div>
				<div class="col-md-6">
					<label for="exampleInputuserdob" class="form-label">DOB</label> <input
						type="date" class="form-control" id="exampleInputuserdob"
						aria-describedby="emailHelp" name="dob" max="${tdate}"
						required="required">
				</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputuserimg" class="form-label">Photo</label> <input
					type="file" class="form-control" id="exampleInputuserimg"
					aria-describedby="emailHelp" name="image"
					accept="image/png, image/jpeg,image/jpg" required="required">
			</div>
			<div class="col-md-12 text-center">
				<button type="submit" class="btn btn-primary">Register</button>
				<a class="nav-link" href="login">Login</a>
			</div>
			<br>
		</form:form>

		<script>
			var myInput = document.getElementById("psw");
			var letter = document.getElementById("letter");
			var capital = document.getElementById("capital");
			var number = document.getElementById("number");
			var length = document.getElementById("length");

			// When the user clicks on the password field, show the message box
			myInput.onfocus = function() {
				document.getElementById("message").style.display = "block";
			}

			// When the user clicks outside of the password field, hide the message box
			myInput.onblur = function() {
				document.getElementById("message").style.display = "none";
			}

			// When the user starts to type something inside the password field
			myInput.onkeyup = function() {
				// Validate lowercase letters
				var lowerCaseLetters = /[a-z]/g;
				if (myInput.value.match(lowerCaseLetters)) {
					letter.classList.remove("invalid");
					letter.classList.add("valid");
				} else {
					letter.classList.remove("valid");
					letter.classList.add("invalid");
				}

				// Validate capital letters
				var upperCaseLetters = /[A-Z]/g;
				if (myInput.value.match(upperCaseLetters)) {
					capital.classList.remove("invalid");
					capital.classList.add("valid");
				} else {
					capital.classList.remove("valid");
					capital.classList.add("invalid");
				}

				// Validate numbers
				var numbers = /[0-9]/g;
				if (myInput.value.match(numbers)) {
					number.classList.remove("invalid");
					number.classList.add("valid");
				} else {
					number.classList.remove("valid");
					number.classList.add("invalid");
				}

				// Validate length
				if (myInput.value.length >= 8) {
					length.classList.remove("invalid");
					length.classList.add("valid");
				} else {
					length.classList.remove("valid");
					length.classList.add("invalid");
				}
			}
		</script>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->
</body>
</html>


<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="user/insertuser" method="post" enctype="multipart/form-data" >
User Name:<input type="text" name="name" required="required"/><br><br>
Email Id:<input type="email" name="email"  required="required"/><br><br>
Password :<input type="text" name="password"  required="required"/><br><br>
Mobile:<input type="tel" name="mobile" pattern="^\d{10}$" required="required"/><br><br>
DOB:<input type="date" name="dob" max="${tdate} " required="required"/><br><br>
Photo: <input type="file" name="image"  required="required" accept="image/png, image/jpeg,image/jpg"/>
<input type="submit" value="Register"/>
</form:form>
</body>
</html>
-->