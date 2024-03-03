package punto2;

public class Entrenador extends Empleado {
	private int campeonatos;

	public Entrenador(String nombre, double sueldoBasico, int campeonatos) {
		super(nombre, sueldoBasico);
		this.campeonatos = campeonatos;
	}
	
	public int getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(int campeonatos) {
		this.campeonatos = campeonatos;
	}
	
	public double getBono() {
		if (this.getCampeonatos() >= 1 && this.getCampeonatos() <= 4) {
			return 5000;
		}
		else if (this.getCampeonatos() >= 5 && this.getCampeonatos() <= 10) {
			return 30000;
		}
		else if (this.getCampeonatos() > 10) {
			return 50000;
		}
		return 0;
	}

	public double calcularSueldoACobrar() {
		return this.getSueldoBasico() + this.getBono();
	}
	

}
