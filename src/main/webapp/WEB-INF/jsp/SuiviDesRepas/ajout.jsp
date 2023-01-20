<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Application de suivi des repas">
	<meta name="author" content="benocode">
	
	<title>Ajouter un repas</title>
	
	<!-- Bootstrap core CSS -->
	<link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<!-- <link href="css/4-col-portfolio.css" rel="stylesheet">  -->
	<link rel="icon" href="../../images/benocode_logo.ico">
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="../../index.html">Mes Applications</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="../../index.html">Accueil
							<span class="sr-only">(current)</span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<header class="container">
		<hr>
		<div class="row">
			<h1 class="mx-auto my-5">Ajout</h1>
		</div>
	</header>
	
	<main class="container">
		<form method="post" action="AjoutRepas">
			<div class="row d-flex justify-content-center">
				<div>
					<label for="date">date :</label>
					<input type="date" name="date" autofocus><br>
					<label for="heure">heure : </label>
					<input type="time" name="heure"><br>
					<label for="repas">repas : </label>
					<textarea name="" cols="30" rows="3"></textarea><br>
				</div>
			</div>
			<div class="d-flex justify-content-center">
				<button type="submit" class="mx-5 btn btn-secondary">
					Valider
				</button>
				<a href="accueil.html" class="mx-5 btn btn-secondary">
					Annuler
				</a>
			</div>
		</form>
	</main>
	<footer class="py-5 bg-dark fixed-bottom">
		<div class="container">
			<div class="">
				<p class="m-0 text-center text-white">Copyright &copy; benocode
				2023</p>
			</div>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="../../vendor/jquery/jquery.min.js"></script>
	<script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>