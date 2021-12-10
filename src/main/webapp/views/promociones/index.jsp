<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Promociones</title>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<div class="bg-light p-4 mb-3 rounded">
		<h1>Estas son las promociones de la Tierra Media</h1>
	</div>



	<table class="table table-stripped table-hover">
		<thead>
			<tr>
				<th>Tipo</th>
				<th>Costo</th>
				<th>Duracion</th>
				<th>descuentoPorcentual</th>
                <th>Distancia</th>
			</tr>
		</thead>




		<tbody>
			<c:forEach items="${promociones}" var="promocion">
				<tr>
					<td><strong><c:out value="${promocion.nombre}"></c:out></strong>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Cras pretium eros urna. Sed quis erat congue, bibendum tortor
							malesuada, iaculis diam. Ut ut imperdiet sapien.</p></td>
					<td><c:out value="${promocion.tipoDePromocion}"></c:out></td>
					<td><c:out value="${promocion.costo}"></c:out></td>
                    
					<td><c:out value="${promocion.descuentoPorcentual}"></c:out></td>
                    <td><c:out value="${user.distance(promocion)}"></c:out></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>