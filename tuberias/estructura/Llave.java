 package tuberias.estructura;

public class Llave extends Celda {

	//Atributos
	private boolean abierta;
	
	//Constructor 
	
	public Llave(int capacidad, boolean abierta) {
		super(capacidad);
		this.abierta = abierta;
	}

	
	//Funciones
	public void abrir(){
		abierta = true;
	}
	
	
	public void cerrar(){
		abierta = false;
	}
	
	public void commutar(){
		abierta = !abierta;
	}
	
	@Override
	public void aņadirAgua(){
		if (abierta) super.aņadirAgua();
	}
	
	@Override
	public void extraerAgua(){
		if (abierta) super.extraerAgua();;
	}
}
