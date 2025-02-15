<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<meta charset="UTF-8">
<title>Aeroport</title>
</head>
<body>
<h2>Tableau Vols</h2>


			<table>
              <tr>
                <th>Compagnie</th>
                <th>Heure Départ</th>
                <th>Heure Arrivée</th>
                <th>Départ Aeroport</th>
                <th>Arival Aeroport</th>
                <th>Prix</th>
              </tr>
		<c:forEach items="${vols}" var="vol">
              <tr>
                <td>${vol.compagnie.nom}</td>
                <td>${vol.dateHeureDepart}</td>
                <td>${vol.dateHeureArrivee}</td>
                <td>${vol.aeroportDepart.nom}</td>
                <td>${vol.aeroportArrivee.nom}</td>
                <td>${vol.prixEnEuro} </td>
              </tr>
		</c:forEach>
            </table>
			<!-- <a href="volServlet?id=${vol.id}">Modifier</a> -->
	<br>

	<form action="ajoutVol" method="post">
        <label>Heure d'arrivée :</label>
        <input type="datetime-local" name="dateArrivee">

        <label>Heure de départ :</label>
        <input type="datetime-local" name="dateDepart" required>

        <label>Prix en Euro :</label>
        <input type="number" name="prix"><br>

        <label>Aéroport de Départ :</label>
        <select name="idAeroportDepart" >
            <c:forEach items="${aeroports}" var="aeroport">
                <option value="${aeroport.id}">${aeroport.nom}</option>
            </c:forEach>
        </select><br>

        <label>Aéroport d'Arrivée :</label>
        <select name="idAeroportArrivee" required>
            <c:forEach items="${aeroports}" var="aeroport">
                <option value="${aeroport.id}">${aeroport.nom}</option>
            </c:forEach>
        </select><br>

        <label>Compagnie :</label>
        <select name="idCompagnie" >
            <c:forEach items="${compagnies}" var="compagnie">
                <option value="${compagnie.id}">${compagnie.nom}</option>
            </c:forEach>
        </select><br>

        <input type="submit" value="Envoyer">
    </form>


	<br>
</body>
</html>