<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Promociones</title>
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
					<th>atraccionA</th>
					<th>atraccionB</th>
					<th>Acciones</th>
				</tr>
			</thead>
			
			
	
			
		  <tbody>
				 <c:forEach items="${promociones}" var="Promocion">
				 	<tr>
						<td><strong><c:out value="${promocion.nombre}"></c:out></strong>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Cras pretium eros urna. Sed quis erat congue, bibendum tortor
								malesuada, iaculis diam. Ut ut imperdiet sapien.</p></td>
						<td><c:out value="${Promocion.tipo}"></c:out></td>
						<td><c:out value="${Promocion.costo}"></c:out></td>
						<td><c:out value="${Promocion.duracion}"></c:out></td>
                        <td><c:out value="${Promocion.descuentoPorcentual}"></c:out></td>
                        <td><c:out value="${Promocion.atraccionA}"></c:out></td>
                        <td><c:out value="${Promocion.atraccionB}"></c:out></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>