package ControladorAtracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import services.AtraccionService;

@WebServlet("/attractions/edit.do")
public class EditAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private AtraccionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion attraction = attractionService.find(id);
		req.setAttribute("attraction", attraction);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Integer tipoDePromocion = Integer.parseInt(req.getParameter("tipoDePromocion"));
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Integer descuentoPorcentual = Integer.parseInt(req.getParameter("desceuntoPorcentual"));
		//List<Atraccion> atracciones = List<Atraccion>.parseList(req.getParameter("atracciones"));
	
		Promocion promocion = promocionesService.create(nombre, tipoDePromocion, costo, descuentoPorcentual, );
		if (promocion.isValid()) {
			resp.sendRedirect("/TP003/promociones/index.do");
		} else {
			req.setAttribute("promocion", promocion);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}

