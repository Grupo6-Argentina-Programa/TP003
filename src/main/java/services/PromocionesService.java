package services;

import java.util.List;

import model.Promocion;

import persistence.commons.DAOFactory;

public class PromocionesService {

	public List<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();

	}

	

}

