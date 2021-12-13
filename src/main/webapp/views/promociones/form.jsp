<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="nombre" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="nombre"
			required value="${promocion.nombre}">
	</div>
	<div class="mb-3">
		<label for="costo"
			class='col-form-label ${promocion.errors.get("costoTotal") != null ? "is-invalid" : "" }'>CostoTotal:</label>
		<input class="form-control" type="number" id="cost" name="costo"
			required value="${promocion.costoTotal}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("costoTotal")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="duracionTotal"
			class='col-form-label ${promocion.errors.get("duracionTotal") != null ? "is-invalid" : "" }'>DuracionTotal:</label>
		<input class="form-control" type="number" id="duracionTotal" name="duracionTotal"
			required value="${promocion.duracionTotal}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("duracionTotal")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
	<label for="tipoDePromocion"
			class='col-form-label ${promocion.errors.get("Tipo") != null ? "is-invalid" : "" }'>TipoDePromocion:</label>
		<input class="form-control" type="number" id="capacity" name="tipoDePromocion"
			required value="${promocion.TipoDePromocion}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("tidoDepromocion")}'></c:out>
		</div>
		
	<div class="mb-3">
		<label for="descuentoPorcentual"
			class='col-form-label ${promocion.errors.get("descuentoPorcentual") != null ? "is-invalid" : "" }'>DecuentoPorcentual:</label>
		<input class="form-control" type="number" id="capacity" name="descuentoPorcentual"
			required value="${promocion.DescuentoPorcentual}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("DescuentoPorcentual")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="capacity"
			class='col-form-label ${promocion.errors.get("atracciones") != null ? "is-invalid" : "" }'>Atracciones:</label>
		<input class="form-control" type="number" id="capacity" name="atracciones"
			required value="${promocion.atracciones[0]}"></input>
		<input	required value="${promocion.atracciones[1]}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("Atracciones")}'></c:out>
		</div>
	</div>
	
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
