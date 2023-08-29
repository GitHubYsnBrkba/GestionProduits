<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des produits</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" /> 
</head>
<body>

	<div class="container col-md-9 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">Recherche des produits</div>
			<div class="panel-body">
				<form action="chercher.do" method="get">
					<label>Mot Clé</label>
					<input type="text" name="motcle" value="${model.mc}"/>
					<button type="submit" class="btn btn-primary">Chercher</button>
				</form>
				<table class="table table-striped">
					<tr>
						<th>ID</th><th>DESIGNATION</th><th>PRIX</th><th>QUANTITE</th>
					</tr>
					<c:forEach items="${model.produits}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.designation}</td>
							<td>${p.prix}</td>
							<td>${p.quantite}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>