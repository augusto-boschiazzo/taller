package punto2;

public class ppal {

	public static void main(String[] args) {
		Jugador jugador = new Jugador("Messi", 800000, 1038, 819);
		Entrenador entrenador = new Entrenador("Gallardo", 1000, 14);
		
		Empleado[] empleados = new Empleado[2];
		
		empleados[0] = jugador;
		empleados[1] = entrenador;
		
		for (Empleado e: empleados) {
			System.out.println(e.toString());
		}

	}

}
