<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification d'Aeroports</title>
</head>
<body>
<p>Nom de l'aeroport : ${aeroport.nom}</p>
	<form action="aeroportUpdate?id=${aeroport.id}" method="post">
		<label>Nom</label><input type="text" name="NOM_AEROPORT"><br>
		<input type="submit" value="Envoyer">
	</form>

	<br>
</body>
</html>