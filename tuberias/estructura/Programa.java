package tuberias.estructura;

public class Programa {

	public static void main(String[] args) {

		Posicion punto1 = new Posicion (2,3);
		Posicion punto2 = new Posicion (punto1.adyacente(Direccion.ABAJO));
		Posicion punto3 = new Posicion (punto2.adyacente(Direccion.ABAJO.opuesta()));
		System.out.println("punto1.x = " + punto1.getX());
		System.out.println("punto1.y = " + punto1.getY());
		System.out.println("punto2.x = " + punto2.getX());
		System.out.println("punto2.y = " + punto2.getY());
		System.out.println("punto3.x = " + punto3.getX());
		System.out.println("punto3.y = " + punto3.getY());
		Direccion aleatooria = Direccion.aleatoria();
		Posicion punto4 = new Posicion (punto3.adyacente(aleatooria));
		System.out.println("punto4.x = " + punto4.getX());
		System.out.println("punto4.y = " + punto4.getY());
		Posicion punto5 = new Posicion (4,7);
		System.out.println("¿punto1 es adyacente a punto5? " + punto1.es_adyacente(punto5, Direccion.ABAJO));
		System.out.println("¿punto1 es adyacente a punto2? " + punto1.es_adyacente(punto2, Direccion.ARRIBA));
		System.out.println("La distancia entre punto1 y punto5? " + punto1.distancia(punto5));

		
		

	}

}
