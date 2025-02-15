<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aeroport</title>
</head>
<body>
<h2>Liste Aeroports</h2>
	<ul>
		<c:forEach items="${aeroports}" var="aeroport">
			<li>${aeroport.nom}</li>
			<a href="aeroportUpdate?id=${aeroport.id}">Modifier</a>
		</c:forEach>
	</ul>
	<br>
		<form action="ajouterAeroport" method="post">
		    <label>Nom</label><input type="text" name="NOM_AEROPORT"><br>
		    <input type="submit" value="Envoyer">
	    </form>
	<br>
</body>
</html>