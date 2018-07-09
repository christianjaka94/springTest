<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Enter page</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
		<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
		<c:url var="showArtists" value="/artists" ></c:url>
		<c:url var="showStyles" value="/styles" ></c:url>
		<c:url var="showPeople" value="/people" ></c:url>
	    <script>
	    $( document ).ready(function() {
	    	$('#artistButton').on('click', function() {
				document.location.href = '${showArtists}'
			});
	    	$('#styleButton').on('click', function() {
				document.location.href = '${showStyles}'
			});
	    	$('#peopleButton').on('click', function() {
				document.location.href = '${showPeople}'
			});
	    });
	    </script>
    </head>
	<body>
		<!-- Header -->
		<header class="w3-container w3-theme w3-padding" id="myHeader">
		  <h1 class="w3-xxxlarge w3-animate-bottom w3-center">MUSIFY</h1>
		</header>
	
		<div class="w3-row-padding w3-center w3-margin-top">
			<button id="artistButton" class="w3-third w3-card w3-container">
				<h3>Artists</h3><br>
				<i class="fa fa-desktop w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
			</button>
			<button id="styleButton" class="w3-third w3-card w3-container">
	  			<h3>Styles</h3><br>
	  			<i class="fa fa-css3 w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
		  	</button>	
		  	<button id="peopleButton" class="w3-third w3-card w3-container">
	  			<h3>People</h3><br>
	  			<i class="fa fa-diamond w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
			</button>
		</div>
	</body>
</html>