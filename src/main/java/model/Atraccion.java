package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import model.Enum.*;

public class Atraccion implements Comparable<Atraccion> {

	private int id;
	private String nombre;
	private double costo;
	private double duracion;

	private int cupoActual = 0;
	private int cupoMaximo;

	private final int posicionX;
	private final int posicionY;
	private Map<String, String> errors;

	private ENUMTIPO preferencia = ENUMTIPO.SinDefinir;

	// CONSTRUCTOR SOLO USADO POR DAO
	public Atraccion(int id, String nombre, double costo, double duracion, int cupoActual, int cupoMaximo,
			int posicionX, int posicionY) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupoActual = cupoActual;
		this.cupoMaximo = cupoMaximo;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	// Constructor por defecto
	public Atraccion(String nombre, double costo, double duracion, int cupoMaximo, int posicionX, int posicionY) {
		this.id = 0;
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupoMaximo = cupoMaximo;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

////////////////////////////////////////////////////////////////////////////////

	

	public int getId() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public int getCupoActual() {
		return cupoActual;
	}

	public void setCupoActual(int cupoActual) {
		this.cupoActual = cupoActual;
	}

	public ENUMTIPO getTipo() {
		return preferencia;
	}

	public void setPreferencia(ENUMTIPO tipoFavorito) {
		this.preferencia = tipoFavorito;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public double getDuracion() {
		return duracion;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

////////////////////////////////////////////////////////////////////////////////

	public boolean hayEspacio() {
		return cupoActual < cupoMaximo;
	}

	public void ocuparUnLugar() {
		cupoActual++;
	}

	public void liberarUnLugar() {
		if (cupoActual > 0) {
			cupoActual--;
		}
	}
	
	public boolean canHost(int i) {
		return cupoMaximo >= i;
	}

	public void host(int i) {
		this.cupoMaximo -= i;
	}

////////////////////////////////////////////////////////////////////////////////

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Atraccion atraccion = (Atraccion) o;
		return costo == atraccion.costo && Double.compare(atraccion.duracion, duracion) == 0
				&& cupoMaximo == atraccion.cupoMaximo && Objects.equals(nombre, atraccion.nombre)
				&& preferencia == atraccion.preferencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, costo, duracion, cupoMaximo, preferencia);
	}

	@Override
	public int compareTo(Atraccion atraccion) {
		if (this.costo == atraccion.getCosto()) {
			return Double.compare(this.duracion, atraccion.getDuracion());
		}
		return Double.compare(this.costo, atraccion.getCosto());
	}

	@Override
	public String toString() {
		return "Atraccion [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", duracion=" + duracion
				+ ", cupoActual=" + cupoActual + ", cupoMaximo=" + cupoMaximo + ", posicionX=" + posicionX
				+ ", posicionY=" + posicionY + ", preferencia=" + preferencia + "]";
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (duracion <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (cupoMaximo <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
		
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
		
	}

	public void setCupoMaximo(Integer cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	
}
