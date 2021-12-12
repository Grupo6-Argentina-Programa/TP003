package services;

import java.util.List;

import model.Atraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class AtraccionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(String nombre, Double costo, Double duracion, Integer cupoActual, Integer cupoMaximo,
			Integer posicionX, Integer posicionY) {

		Atraccion atraccion = new Atraccion(-1, nombre, costo, duracion, cupoActual, cupoMaximo, posicionX, posicionY);

		if (atraccion.isValid()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			atraccionDAO.insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public Atraccion update(Integer id, String nombre, Double costo, Double duracion, Integer cupoActual,
			Integer cupoMaximo, Integer posicionX, Integer posicionY) {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.findByID(id);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setDuracion(duracion);
		atraccion.setCupoMaximo(cupoMaximo);
		atraccion.setPosicionX(posicionX);
		atraccion.setPosicionY(posicionY);
		if (atraccion.isValid()) {
			atraccionDAO.update(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}
		return atraccion;
	}

	public void delete(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = new Atraccion(id, null, 0, 0, 0, 0, 0, 0);
		atraccionDAO.delete(atraccion);
	}

	public Atraccion find(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.findByID(id);
	}

}
