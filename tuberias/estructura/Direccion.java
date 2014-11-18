package tuberias.estructura;

import java.util.Random;

public enum Direccion {

	ARRIBA,ABAJO,DERECHA,IZQUIERDA;
	
	//Metodos
	public Direccion opuesta(){
		
		switch(this){
		case DERECHA:
			return IZQUIERDA;
		case IZQUIERDA:
			return DERECHA;
		case ARRIBA:
			return ABAJO;
		case ABAJO:
			return ARRIBA;
		}
		return null;
		
	}
	
	public static Direccion aleatoria(){
		Random generador = new Random();
		Direccion[] direcciones = Direccion.values(); //Genera un array con todos los elementos del enumerado Direccion.
		return direcciones[generador.nextInt(direcciones.length)]; //Saca una direccion aleatoria
			
	}
}
