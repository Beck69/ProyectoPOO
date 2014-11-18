package tuberias.estructura;

public class Posicion {
	
	//Atributos
	private final int x;
	private final int y;
	
	//Constructor
	public Posicion(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public Posicion(){
		this(0,0);
	}
	
	public Posicion(Posicion pos){
		this(pos.x,pos.y);
	}
	
	//Metodos de acceso
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	//Operaciones
	public Posicion adyacente(Direccion dir){
		switch(dir){
		case DERECHA:
			int nuevax=this.x+1;
			return new Posicion(nuevax,y);
		case IZQUIERDA:
			int nuevaax=this.x-1;
			return new Posicion(nuevaax,y);
		case ARRIBA:
			int nuevay=this.y+1;
			return new Posicion(x,nuevay);
		case ABAJO:
			int nuevaay=this.y-1;
			return new Posicion(x,nuevaay);
		}
		return null;
	}
	
	public boolean es_adyacente(Posicion pos, Direccion dir){
		switch(dir){
		case DERECHA:
			return (this.x-pos.x)==1;
		case IZQUIERDA:
			return (this.x-pos.x)==-1;
		case ARRIBA:
			return (this.y-pos.y)==1;
		case ABAJO:
			return (this.y-pos.y)==-1;
		}
		return false;
	}
	
	public double distancia(Posicion pos){
		int disx=this.x-pos.x;
		int disy=this.y-pos.y;
		return Math.sqrt(Math.pow(disx, 2)+Math.pow(disy, 2));
		
	}
}
