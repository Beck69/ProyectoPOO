package tuberias.estructura;

public class Celda {

	// Atributos
	private final int capacidad;
	private int caudal;
	private Posicion posicion;
	private int numVecinas;
	private Celda[] vecinas = new Celda[3];

	// Constructores

	public Celda(int capacidad) {
		this.caudal = 0;
		this.capacidad = capacidad;
		this.posicion = null;
		numVecinas = 0;
	}

	public Celda() {
		this(5);
	}

	// Metodos de consulta
	public int getCapacidad() {
		return capacidad;
	}

	public int getCaudal() {
		return caudal;
	}

	public boolean isSaturada() {
		if (caudal == capacidad)
			return true;
		else
			return false;
	}

	public boolean isVacia() {
		if (caudal == 0)
			return true;
		else
			return false;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public int getNumVecinas() {
		return numVecinas;
	}

	// Funcionalidad
	public void incremento() {
		if (caudal < capacidad)
			this.caudal += 1;
	}

	public void decremento() {
		if (caudal > 0)
			this.caudal -= 1;
	}

	public void crearVecina(Celda celdaVecina, Direccion dir) {
		this.vecinas[dir.ordinal()] = celdaVecina;
		numVecinas++;

	}

	public Celda consultarVecina(Direccion dir) {
		return vecinas[dir.ordinal()];
	}

	public void resetearVecindad() {
		for (int i = 0; i < vecinas.length; i++) {
			vecinas[i] = null;
			numVecinas = 0;
		}
	}

	public void darPosicion(Posicion pos) {
		this.posicion = pos;
	}

	protected void añadirAgua() {
		if (!isSaturada())
			incremento();
		else
			this.propagarAgua();

	}

	protected void propagarAgua() {
		for (Celda celda : vecinas) {
			if ((celda != null) && (celda.posicion != this.posicion)
					&& (!celda.isSaturada()))
				celda.añadirAgua();
		}
	}

	protected void extraerAgua() {

		if (!isVacia())
			decremento();
		else
			this.propagarExtraccion();

	}

	protected void propagarExtraccion() {
		for (Celda celda : vecinas) {
			if ((celda != null) && (celda.posicion != this.posicion)
					&& (!celda.isVacia()))
				celda.extraerAgua();
		}
	}

	/*
	 * public void establecerVecina(Direccion dir){
	 * 
	 * switch(dir){ case DERECHA: vecinas[1]=true; case IZQUIERDA:
	 * vecinas[2]=true; case ARRIBA: vecinas[3]=true; case ABAJO:
	 * vecinas[4]=true; } } public void celdaVecina(Direccion dir){
	 * 
	 * Posicion vecina=new Posicion();
	 * 
	 * switch(dir){ case DERECHA: if (!vecinas[1]) vecina=null; else
	 * vecina=this.posicion.adyacente(dir); case IZQUIERDA: if (!vecinas[2])
	 * vecina=null; else vecina=this.posicion.adyacente(dir); case ARRIBA: if
	 * (!vecinas[3]) vecina=null; else vecina=this.posicion.adyacente(dir); case
	 * ABAJO: if (!vecinas[4]) vecina=null; else
	 * vecina=this.posicion.adyacente(dir); } return vecina; } public void
	 * resetVecindad(){ for (int i = 0; i < vecinas.length; i++) {
	 * vecinas[i]=false; } }
	 */

}
