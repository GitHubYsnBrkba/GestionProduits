<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation de produit</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" /> 
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Confirmation</div>
			<div class="panel-body">
				<div class="form-group">
					<label>ID : </label>
					<label>${produit.id}</label>
				</div>
				<div class="form-group">
					<label>D�signation : </label>
					<label>${produit.designation}</label>
				</div>
				<div class="form-group">
					<label>Prix : </label>
					<label>${produit.prix}</label>
				</div>
				<div class="form-group">
					<label>Quantit� : </label>
					<label>${produit.quantite}</label>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>