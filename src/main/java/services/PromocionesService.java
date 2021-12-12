package services;

import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.TipoDeAtraccion;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.TipoDeAtraccionDAO;
import persistence.commons.DAOFactory;

public class PromocionesService {

	public List<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();

	}

	public Promocion create(String nombre, int tipoDePromocion, Double costo, Integer descuentoPorcentual,
			List<Atraccion> atracciones) {

		Promocion promocion = new Promocion(-1, nombre, tipoDePromocion, costo, descuentoPorcentual, atracciones);

		if (promocion.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}

	public Promocion update(Integer id, String nombre, int tipoDePromocion, Double costo, Integer descuentoPorcentual,
			List<Atraccion> atracciones) {

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Promocion promocion = promocionDAO.findByID(id);

		promocion.setNombre(nombre);
		promocion.setTipoDePromocion(tipoDePromocion);
		promocion.setCosto(costo);
		promocion.setDescuentoPorcentual(descuentoPorcentual);
		promocion.agregarAtracciones(atracciones);

		if (promocion.isValid()) {
			promocionDAO.update(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}

	public void delete(Integer id) {
		deletePromocion(id);
		deleteTipoDeAtraccion(id);
	}

	public Promocion find(Integer id) {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		return promocionDAO.findByID(id);
	}

////////////////////////////////////////////////////////////////////////////////

	private void deletePromocion(Integer id) {
		Promocion promocion = new Promocion(id, null, 0, 0, 0, null);
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.delete(promocion);
	}

	private void deleteTipoDeAtraccion(Integer id) {
		TipoDeAtraccionDAO DAO = DAOFactory.getTipoDeAtraccionDAO();
		TipoDeAtraccion tipodeatraccion = DAO.findByReferenceAndType(id, "Promocion");
		DAO.delete(tipodeatraccion);
	}

}
