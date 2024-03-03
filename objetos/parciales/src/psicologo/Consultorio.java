package psicologo;

public class Consultorio {
	Paciente[][] atencion;
	
	public Consultorio() {
		atencion = new Paciente[5][6];
	}
	
	public boolean agendarPaciente(int dia, int turno, Paciente paciente) {
		if (dia < 5 && turno < 6) {
			if (atencion[dia][turno] == null) {
				atencion[dia][turno] = paciente;
				return true;
			}
		}
		return false;
	}
	
	public int agendarPacientePrimeroDisponible(Paciente paciente, int turno) {
		for (int i = 0; i < 5; i++) {
			if (atencion[i][turno] == null) {
					atencion[i][turno] = paciente;
					return i;
			}
		}//te amo 
		return -1;
	}
	
	public void liberarPaciente(String nombre) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (atencion[i][j] != null) {
					if (atencion[i][j].getNombre() == nombre) {
						atencion[i][j] = null;
					}
				}
			}
		}
	}
	
	public boolean pacienteAgendadoDia(int dia, String paciente) {
		for (int i = 0; i < 6; i++) {
			if (atencion[dia][i].getNombre() == paciente) {
				return true;
			}
		}
		return false;
	}
	
	
}
