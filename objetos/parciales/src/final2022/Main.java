package final2022;

public class Main {

	public static void main(String[] args) {
		SubsidioEstadia sub1 = new SubsidioEstadia("Cami", "Progresar", "Hoy", "Bariloche", 100, 7, 10);
		SubsidioBienes sub2 = new SubsidioBienes("Augus", "Argentina programa", "Ayer", 5);
		
		Bien bien = new Bien("Play 5", 100, 3);
		Bien mal = new Bien("Xbox", 150, 2);
		sub2.agregarBien(bien);
		sub2.agregarBien(mal);
		
		System.out.println(sub1.toString());
		System.out.println(sub2.toString());
	}

}
