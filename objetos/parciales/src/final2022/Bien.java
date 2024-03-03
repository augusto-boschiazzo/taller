package final2022;

public class Bien {
	private String descripcion;
	private double costo;
	private int cantidad;
	
	public Bien(String descripcion, double costo, int cantidad) {
		this.descripcion = descripcion;
		this.costo = costo;
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getTotal() {
		return this.cantidad * this.costo;
	}
	

}
