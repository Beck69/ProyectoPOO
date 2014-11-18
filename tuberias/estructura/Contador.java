package tuberias.estructura;

public class Contador extends Celda {

	// Atributos
	private int contador;

	// Constructor
	public Contador() {
		super(1);
		contador = 0;
	}

	// Metodos de acceso
	public int getContador() {
		return contador;
	}

	// Funciones
	@Override
	public void a�adirAgua() {
		super.a�adirAgua();
		contador += 1;
		this.extraerAgua();
	}
}
