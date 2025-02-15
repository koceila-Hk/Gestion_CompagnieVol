<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Liste Compagnies</h2>
	<ul>
		<c:forEach items="${compagnies}" var="compagnie">
			<li>${compagnie.nom}</li>
			<a href="removeCompany?id=${compagnie.id}">Supprimer</a>

		</c:forEach>
	</ul>
	<br>
	<form action="ajouterCompany" method="post">
		<label>Nom</label><input type="text" name="NOM_COMPANY"><br>
		<input type="submit" value="Envoyer">
	</form>
	<br>
</body>
</html>