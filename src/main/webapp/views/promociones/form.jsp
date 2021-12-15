<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">

	<div class="mb-3">
		<label for="nombre" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="nombre" required
			value="${promocion.nombre}">
	</div>

	<div class="mb-3">
		<label for="tipoDePromocion"
			class='col-form-label ${promocion.errors.get("Tipo") != null ? "is-invalid" : "" }'>TipoDePromocion:
			(Valores: (1: Prom. Absoluta) (2: Prom. Procentual) (1: Prom. AxB))</label> <input
			class="form-control" type="number" id="tipodepromocion"
			name="tipodepromocion" required value="${promocion.tipodepromocion}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("TipoDePromocion")}'></c:out>
		</div>

		<div class="mb-3">
			<label for="costo"
				class='col-form-label ${promocion.errors.get("costoTotal") != null ? "is-invalid" : "" }'>CostoTotal:
				(Valido solo para Prom. Absoluta)</label> <input class="form-control"
				type="number" id="cost" name="costototal" required
				value="${promocion.costoTotal}"></input>
			<div class="invalid-feedback">
				<c:out value='${promocion.errors.get("CostoTotal")}'></c:out>
			</div>
		</div>

		<div class="mb-3">
			<label for="descuentoPorcentual"
				class='col-form-label ${promocion.errors.get("descuentoPorcentual") != null ? "is-invalid" : "" }'>DecuentoPorcentual:
				(Valido solo para Prom. Porcentual)</label> <input class="form-control"
				type="number" id="capacity" name="descuentoporcentual" required
				value="${promocion.descuentoporcentual}"></input>
			<div class="invalid-feedback">
				<c:out value='${promocion.errors.get("DescuentoPorcentual")}'></c:out>
			</div>
		</div>

		<div class="mb-3">
			<label for="descuentoPorcentual"
				class='col-form-label ${promocion.errors.get("atracciones") != null ? "is-invalid" : "" }'>Atraccion
				1 (Id): </label> <input class="form-control" type="number" id="capacity"
				name="atraccion1" required value="${promocion.atraccion1}"></input>
			<div class="invalid-feedback">
				<c:out value='${promocion.errors.get("atracciones")}'></c:out>
			</div>
		</div>

		<div class="mb-3">
			<label for="descuentoPorcentual"
				class='col-form-label ${promocion.errors.get("atracciones") != null ? "is-invalid" : "" }'>Atraccion
				2 (Id): </label> <input class="form-control" type="number" id="capacity"
				name="atraccion2" required value="${promocion.atraccion2}"></input>
			<div class="invalid-feedback">
				<c:out value='${promocion.errors.get("atracciones")}'></c:out>
			</div>
		</div>

		<div class="mb-3">
			<label for="descuentoPorcentual"
				class='col-form-label ${promocion.errors.get("atracciones") != null ? "is-invalid" : "" }'>Atraccion
				Plus (Id): (Valido solo para Prom. AxB)</label> <input class="form-control"
				type="number" id="capacity" name="atraccionP" required
				value="${promocion.atraccionP}"></input>
			<div class="invalid-feedback">
				<c:out value='${promocion.errors.get("atracciones")}'></c:out>
			</div>
		</div>

	</div>

	<div>
		<button type="submit" class="btn btn-primary">Guardar</button>
		<a onclick="window.history.back();" class="btn btn-secondary"
			role="button">Cancelar</a>
	</div>