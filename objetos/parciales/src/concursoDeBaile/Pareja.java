package concursoDeBaile;

public class Pareja {
	Participante[] participantes;
	String estilo;
	
	public Pareja(Participante participante1, Participante participante2, String estilo) {
		this.participantes = new Participante[2];
		this.participantes[0] = participante1;
		this.participantes[1] = participante2;
		this.estilo = estilo;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public Participante[] getParticipantes() {
		return participantes;
	}
	
	public int diferenciaDeEdad() {
		int aux = participantes[0].getEdad() - participantes[1].getEdad();
		if (aux < 0) 
			aux = aux * -1;
		return aux;
	}
	
	public String toString() {
		String aux = "";
		for (int i = 0; i < 2; i++) {
			aux += "	Participante " + (i+1) + ": \n			" + participantes[i].toString() + "\n"; 
		}
		aux += "\n";
		aux += "	Diferencia de edad de la pareja: " + this.diferenciaDeEdad();
		return aux;
	}
	

}
