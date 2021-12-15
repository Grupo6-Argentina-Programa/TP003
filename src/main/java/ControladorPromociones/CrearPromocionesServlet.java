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
		
		System.out.println("llego a servlet");
		
		String nombre = req.getParameter("nombre");
		System.out.println("nombre ->" + nombre);
		
		Integer tipoDePromocion = Integer.parseInt(req.getParameter("tipodepromocion"));
		System.out.println("tipoDePromocion ->" + tipoDePromocion);
		
		Double costoTotal = Double.parseDouble(req.getParameter("costototal"));
		System.out.println("costoTotal ->" + costoTotal);
		
		Integer descuentoPorcentual = Integer.parseInt(req.getParameter("descuentoporcentual"));
		System.out.println("descuentoPorcentual ->" + descuentoPorcentual);
		
		Integer atraccion1 = Integer.parseInt(req.getParameter("atraccion1"));
		System.out.println("atraccion1 ->" + atraccion1);
		
		Integer atraccion2 = Integer.parseInt(req.getParameter("atraccion2"));
		System.out.println("atraccion2 ->" + atraccion2);
		
		Integer atraccionP = Integer.parseInt(req.getParameter("atraccionP"));
		System.out.println("atraccionP ->" + atraccionP);
		
		System.out.println("cargo todos los valores");
		System.out.println("posterioremnte creacion");
		
		Promocion promocion = null;
		
		//Promocion promocion = promocionesService.create(nombre, tipoDePromocion, costo, descuentoPorcentual, null );
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
