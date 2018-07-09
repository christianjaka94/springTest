<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Artist page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
	<c:url var="showArtists" value="/artists" ></c:url>
	<c:url var="showStyles" value="/styles" ></c:url>
	<c:url var="showPeople" value="/people" ></c:url>
	<c:url var="returnHome" value="/artist/return" ></c:url>	
	<style>
	.datatable{
	margin-left: 30em;
	}
	
	</style> 
	<script>
	    $( document ).ready(function() {
	    	$('#returnButton').on('click', function() {
				document.location.href = '${returnHome}'
			});
	    });
	    </script>   
  </head>
<body>
<!-- Header -->
<header class="w3-container w3-theme w3-padding" id="myHeader">
  <h1 class="w3-xxxlarge w3-animate-bottom w3-center">MUSIFY</h1>
<button id="returnButton">
<h4>Home</h4>
</button>
</header>
<h1>
	Add an Artist
</h1>

<c:url var="addAction" value="/artist/add" ></c:url>

<form:form action="${addAction}" commandName="artist">
<table>
	<c:if test="${!empty artist.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="year">
				<spring:message text="Year"/>
			</form:label>
		</td>
		<td>
			<form:input path="year" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty artist.name}">
				<input type="submit"
					value="<spring:message text="Edit Artist"/>" />
			</c:if>
			<c:if test="${empty artist.name}">
				<input type="submit"
					value="<spring:message text="Add Artist"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<div class="w3-center">
		<div class="w3-container">
			<h3 class="w3-theme">Artist List</h3>
		</div>
		<c:if test="${!empty listArtists}">
			<table class="datatable w3-border-top">
				<tr>
					<th width="80">Artist ID</th>
					<th width="120">Artist Name</th>
					<th width="120">Artist Year</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listArtists}" var="artist">
					<tr>
						<td>${artist.id}</td>
						<td>${artist.name}</td>
						<td>${artist.year}</td>
						<td><a href="<c:url value='/artist/edit/${artist.id}' />" >Edit</a></td>
						<td><a href="<c:url value='/artist/remove/${artist.id}' />" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
</div>
</body>
</html>
