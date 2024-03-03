package final2022;

public class SubsidioBienes extends Subsidio{
	private int dimF;
	private int dimL;
	private Bien [] bienes;
	
	public SubsidioBienes(String nombre, String plan, String solicitud, int dimF) {
		super(nombre, plan, solicitud);
		this.dimF = dimF;
		this.dimL = 0;
		this.bienes = new Bien[dimF];
	}

	public Bien[] getBienes() {
		return bienes;
	}
	
	public void agregarBien(Bien bien) {
		if (dimL < dimF) {
			bienes[dimL] = bien;
			dimL++;
		}
	}
	
	public double getMontoTotal() {
		double total = 0;
		for (int i = 0; i < dimL; i++) {
			total += bienes[i].getTotal();
		}
		return total;
	}
	
	public String toString() {
		String aux = super.toString() + " Descripcion de los bienes solicitados: ";
		for (int i = 0; i < dimL; i++) {
			aux += bienes[i].getDescripcion() + " ";
		}
		return aux;
	}
	

}
