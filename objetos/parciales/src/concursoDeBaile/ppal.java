package concursoDeBaile;

public class ppal {

	public static void main(String[] args) {
		Participante participante1 = new Participante("Augus", "1234", 21);
		Participante participante2 = new Participante("Cami", "1235", 19);
		Pareja pareja1 = new Pareja(participante1, participante2, "Tango");
		
		Participante participante3 = new Participante("Balo", "123", 40);
		Participante participante4 = new Participante("Serres", "12356", 10);
		Pareja pareja2 = new Pareja(participante3, participante4, "Salsa");
		
		Concurso concurso = new Concurso(10);
		concurso.agregarPareja(pareja1);
		concurso.agregarPareja(pareja2);
		
		System.out.println(concurso.toString());

	}

}
