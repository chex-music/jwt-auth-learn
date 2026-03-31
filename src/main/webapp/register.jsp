<!DOCTYPE html>
<html>
<head>
<title>Register</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="bg-light">

	<div class="container mt-5">

		<div class="row justify-content-center">

			<div class="col-md-4">

				<h3 class="text-center mb-4">Register</h3>

				<form action="RegisterServlet" method="post"
					onsubmit="return validatePassword()">

					<!-- Username -->
					<div class="mb-3">
						<label class="form-label">Username</label> <input type="text"
							name="username" class="form-control" required>
					</div>

					<!-- Password -->
					<div class="mb-3">
						<label class="form-label">Password</label> <input type="password"
							name="password" class="form-control" id="pass" required>
					</div>

					<!-- Confirm Password -->
					<div class="mb-3">
						<label class="form-label">Confirm Password</label> <input
							type="password" name="confirmPassword" id="confirmPass"
							class="form-control" required>
					</div>

					<!-- Button -->
					<div class="d-grid">
						<button type="submit" class="btn btn-success">Register</button>
					</div>

					<!-- Login link -->
					<p class="text-center mt-3">
						Already have an account? <a href="login.jsp">Login</a>
					</p>

				</form>

			</div>

		</div>

	</div>
	<script>
		console.log(typeof confirmPass);
	</script>
	<script type="text/javascript">
		function validatePassword() {
			let pass = document.getElementById("pass").value;
			let confirmPassword = document.getElementById("confirmPass").value;

			if (pass !== confirmPassword) {
				alert("Passwords do not match");
				return false;
			}
			return true;
		}
	</script>
</body>

</html>