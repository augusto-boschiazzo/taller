package final2022;

public abstract class Subsidio {
	private String nombre;
	private String plan;
	private String solicitud;
	
	public Subsidio(String nombre, String plan, String solicitud) {
		super();
		this.nombre = nombre;
		this.plan = plan;
		this.solicitud = solicitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	
	public abstract double getMontoTotal();
	
	public String toString() {
		String aux = "Nombre del investigador: " + this.nombre + " Plan de trabajo: " + this.plan + " Fecha de solicitud: " + this.solicitud + " Monto total: " + this.getMontoTotal();
		return aux;
	}
	

}
