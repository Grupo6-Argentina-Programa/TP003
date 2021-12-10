<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>


</head>
<body class="container">
<jsp:include page="partials/nav.jsp"></jsp:include>
	<main class="container">
		<div class="bg-light p-4 rounded">
			<h1>
				¡Bienvenido, <c:out value="${user.usuario}" />!
			</h1>
		</div>
	</main>
	
	
	<img src="res/20171231215950_parque_lanin.jpg" class="img-fluid" alt="...">
</body>
</html>
