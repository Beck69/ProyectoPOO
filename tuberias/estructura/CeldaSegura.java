package tuberias.estructura;

public class CeldaSegura extends Celda {

	// Constructor
	public CeldaSegura() {
		super(0);
	}

	// Funciones

	@Override
	public void aņadirAgua() {
		super.propagarAgua();
	}

	@Override
	public void extraerAgua() {
		super.extraerAgua();
	}
}
