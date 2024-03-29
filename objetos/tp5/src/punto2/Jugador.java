package punto2;

public class Jugador extends Empleado {
	private int partidos;
	private int goles;

	public Jugador(String nombre, double sueldoBasico, int partidos, int goles) {
		super(nombre, sueldoBasico);
		this.partidos = partidos;
		this.goles = goles;
	}
	
	public int getPartidos() {
		return partidos;
	}

	public void setPartidos(int partidos) {
		this.partidos = partidos;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}
	
	public double getPromedioDeGoles() {
		return this.getPartidos() / this.getGoles();
	}

	public double calcularSueldoACobrar() {
		if (this.getPromedioDeGoles() > 0.5) {
			return this.getSueldoBasico() * 2;
		}
		return this.getSueldoBasico();
	}
	

}
