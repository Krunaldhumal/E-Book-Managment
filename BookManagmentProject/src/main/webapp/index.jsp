<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Management System</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: #0B0B45">
		<a class="navbar-brand" style="color: aliceblue;" href="index.jsp"><i
			class="fa-solid fa-house"></i> BMS</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					style="color: aliceblue;" href="showbookdata"><i
						class="fa-solid fa-book"></i> Books <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					style="color: aliceblue;" href="addservlet"><i
						class="fa-solid fa-book-open"></i> Add Book</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<div class="container mt-5">
		<h1>Book Management System</h1>
		<form action="addservlet" method="post">
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="author">Author:</label> <input type="text"
					class="form-control" id="author" name="author">
			</div>
			<button type="submit" class="btn btn-primary ml-3">Add Book</button>
			<a href="/BookManagmentProject/showbookdata">
				<button type="button" class="btn btn-primary">View Book</button>
			</a>
		</form>

	</div>
	<div class="navbar navbar-expand-lg navbar-light fixed-bottom"
		style="background-color: #0B0B45; justify-content: center;">
		<h5 style="color: aliceblue;">Our Privacy Policy Generator can
			help you generate a customized Privacy Policy in around three
			minutes, for free.</h5>
	</div>

</body>
</html>