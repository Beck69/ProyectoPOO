package tuberias.estructura;

public class Tuberia {
	
	//Atributos
	private int ancho;
	private int alto;
	private Celda[][] matriz;
	private Posicion posInic;
	
	//Constructor
	
	public Tuberia(int ancho, int alto, Posicion posinic){
		this.ancho=ancho;
		this.alto=alto;
		matriz = new Celda[this.ancho][this.alto];
		posInic=posinic;
		matriz[posInic.getX()][posInic.getY()] = new Celda(); 
	}
	
	
	//Metodos
	public boolean establecerCelda(Celda celda, Posicion pos){
		if ((this.matriz[pos.getX()][pos.getY()] == null) && (this.matriz[pos.getX()][pos.getY()].getNumVecinas()==1) || (this.matriz[pos.getX()][pos.getY()] != null))
		{
			celda.resetearVecindad();
			
			if (this.matriz[pos.getX()+1][pos.getY()] != null) 
				celda.crearVecina(this.matriz[pos.getX()][pos.getY()], Direccion.DERECHA);
			
			if (this.matriz[pos.getX()-1][pos.getY()] != null) 
				celda.crearVecina(this.matriz[pos.getX()][pos.getY()], Direccion.IZQUIERDA);
			
			if (this.matriz[pos.getX()][pos.getY()+1] != null) 
				celda.crearVecina(this.matriz[pos.getX()][pos.getY()], Direccion.ARRIBA);
			
			if (this.matriz[pos.getX()][pos.getY()-1] != null) 
				celda.crearVecina(this.matriz[pos.getX()][pos.getY()], Direccion.ABAJO);	
			
			this.matriz[pos.getX()][pos.getY()]=celda;
			this.matriz[pos.getX()][pos.getY()].darPosicion(pos);
			
			
			return true;
		}
		else return false;
	}
	
	
	public Celda obtenerVecina(Posicion posMat,Direccion dir){		
		switch(dir){
		case DERECHA:
			if (this.matriz[posMat.getX()+1][posMat.getY()]!=null)
				return this.matriz[posMat.getX()+1][posMat.getY()];
		case IZQUIERDA:
			if (this.matriz[posMat.getX()-1][posMat.getY()]!=null)
				return this.matriz[posMat.getX()-1][posMat.getY()];
		case ARRIBA:
			if (this.matriz[posMat.getX()][posMat.getY()+1]!=null)
				return this.matriz[posMat.getX()][posMat.getY()+1];
		case ABAJO:
			if (this.matriz[posMat.getX()][posMat.getY()-1]!=null)
				return this.matriz[posMat.getX()][posMat.getY()-1];
		default:
			return null;
		}
	
	}
	

	public boolean hayVecina(Posicion posMat,Direccion dir){
		
		switch(dir){
		case DERECHA:
			if (this.matriz[posMat.getX()+1][posMat.getY()]!=null)
				return true;
		case IZQUIERDA:
			if (this.matriz[posMat.getX()-1][posMat.getY()]!=null)
				return true;
		case ARRIBA:
			if (this.matriz[posMat.getX()][posMat.getY()+1]!=null)
				return true;
		case ABAJO:
			if (this.matriz[posMat.getX()][posMat.getY()-1]!=null)
				return true;
		default:
			return false;
		}
	
	}
	
	public Celda obtenerCelda(Posicion pos){
		if (this.matriz[pos.getX()][pos.getY()]==null) 
			return null;
		else
			return this.matriz[pos.getX()][pos.getY()];
		
	}
	
	public void crearTubo(Posicion inicio, Direccion dir, int longitud){
		for (int i = 0; i < longitud; i++) {
			Celda celda = new Celda();
			switch(dir){
			case DERECHA:	
			
			if ((inicio.getX()+longitud)>this.ancho) break;
			else	{
			Posicion var = new Posicion(inicio.getX()+i, inicio.getY());
			establecerCelda(celda, var);
			}
			
			case IZQUIERDA:
			if ((inicio.getX()-longitud)<0) break;
			else	{
			Posicion var1 = new Posicion(inicio.getX()-i, inicio.getY());
			establecerCelda(celda, var1);	
			}
			case ARRIBA:
			if ((inicio.getY()+longitud)>this.alto) break;
			else	{
			Posicion var2 = new Posicion(inicio.getX(), inicio.getY()+i);
			establecerCelda(celda, var2);	
			}
			
			case ABAJO:
			if ((inicio.getY()-longitud)<0) break;
			else	{
			Posicion var3 = new Posicion(inicio.getX(), inicio.getY()-i);
			establecerCelda(celda, var3);	
			}
			}
		}
	}
	
}
