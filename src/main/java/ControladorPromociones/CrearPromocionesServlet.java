package ControladorPromociones;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import services.AtraccionService;
import services.PromocionesService;

@WebServlet("/promociones/create.do")
public class CrearPromocionesServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private PromocionesService promocionesService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionesService = new PromocionesService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promociones/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		Integer tipoDePromocion = Integer.parseInt(req.getParameter("tipoDePromocion"));
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Integer descuentoPorcentual = Integer.parseInt(req.getParameter("desceuntoPorcentual"));
		//List<Atraccion> atracciones = List<Atraccion>.parseList(req.getParameter("atracciones"));
	
		Promocion promocion = promocionesService.create(nombre, tipoDePromocion, costo, descuentoPorcentual, null );
		if (promocion.isValid()) {
			resp.sendRedirect("/TP003/promociones/index.do");
		} else {
			req.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/attractions/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
