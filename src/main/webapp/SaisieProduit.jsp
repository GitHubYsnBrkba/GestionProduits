<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saisie des produits</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" /> 
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Saisie un produit</div>
			<div class="panel-body">
				<form action="SaveProduit.do" method="post">
					<div class="form-group">
						<label class="control-label">Désignation</label>
						<input type="text" name="designation" value="${produit.designation}" class="form-control" required="required"/>
						<span></span>
					</div>
					
					<div class="form-group">
						<label class="control-label">Prix</label>
						<input type="text" name="prix" value="${produit.prix}" class="form-control" />
						<span></span>
					</div>
					
					<div class="form-group">
						<label class="control-label">Quantité</label>
						<input type="text" name="quantite" value="${produit.quantite}" class="form-control" />
						<span></span>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Enregistrer</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>