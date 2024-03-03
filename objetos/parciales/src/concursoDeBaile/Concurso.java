package concursoDeBaile;

public class Concurso {
	private Pareja[] parejas;
	private int dimL = 0;
	private int dimF;

	public Concurso(int dimF) {
		this.parejas = new Pareja[dimF];
		this.dimF = dimF;
	}
	
	public void agregarPareja(Pareja pareja) {
		if (dimL < dimF) {
			this.parejas[dimL] = pareja;
			dimL++;
		}
	}
	
	public Pareja mayorDiferencia() {
		int max = 0;
		Pareja mayor = null;
		for (int i = 0; i < dimL; i++) {
			if (parejas[i].diferenciaDeEdad() > max) {
				max = parejas[i].diferenciaDeEdad();
				mayor = parejas[i];
			}
		}
		return mayor;
	}
	
	public String toString() {
		String aux = "";
		for (int i = 0; i < dimL; i++) {
			aux += "Pareja " + (i+1) + ": \n" + parejas[i].toString() + "\n 	Estilo de baile: " + parejas[i].estilo + "\n";
		}
		aux += "\n \n";
		aux += "---------------------------------------------- \n";
		aux += "\n";
		aux += "Pareja de mayor diferencia: \n" + this.mayorDiferencia();
		return aux;
	}
	

}
