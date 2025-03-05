package juego;

import bloque.Bloque;

/**
 * Clase que representa el jugador del MineMonroy
 * 
 * @author y0rg
 *
 */
/**
 * 
 */
public class Jugador {

	// Nombre del jugador
	String nombre;
	// Array de coordenadas del jugador en orden: X,Y,Z
	private int coordenadas[] = new int[3];
	//Posicion de la X , Y , Z en el array
	public static final int X = 0, Y = 1, Z = 2;
	// Durabilidad de cada herramienta en orden: Hacha, Pala , Pico
	private  int durabilidadherramients[] = { 5, 5, 5 };

	// Lista de materias primas del jugador
	int[] materiasPrimas = new int[Bloque.NUM_MATERIAS];

	public Jugador(String nombre, int x, int y, int z) {
		this.nombre = nombre;
		coordenadas[0] = x;
		coordenadas[1] = y;
		coordenadas[2] = z;
	}

	/**
	 * No hace falta explicarlo... o si?
	 */
	public String toString() {
		return this.nombre + " - Materias primas recolectadas\n" + "Plantas: " + materiasPrimas[Bloque.PLANTA]
				+ "\nArboles: " + materiasPrimas[Bloque.ARBOL] + "\nArcilla: " + materiasPrimas[Bloque.ARCILLA]
				+ "\nAlbero: " + materiasPrimas[Bloque.ALBERO] + "\nHierro: " + materiasPrimas[Bloque.HIERRO]
				+ "\nCobre: " + materiasPrimas[Bloque.COBRE];
	}

	/**
	 * Metodo que añade una unidad de una materia "tipo"
	 * 
	 * @param tipo, entero que representa el tipo de Materia.
	 * @see bloque.Bloque.java
	 */
	public void sumaMateria(int tipo) {
		switch (tipo) {
		case Bloque.ALBERO: {
			materiasPrimas[Bloque.ALBERO]++;
			break;
		}
		case Bloque.ARBOL: {
			materiasPrimas[Bloque.ARBOL]++;
			break;
		}
		case Bloque.ARCILLA: {
			materiasPrimas[Bloque.ARCILLA]++;
			break;
		}
		case Bloque.COBRE: {
			materiasPrimas[Bloque.COBRE]++;
			break;
		}
		case Bloque.HIERRO: {
			materiasPrimas[Bloque.HIERRO]++;
			break;
		}
		case Bloque.PLANTA: {
			materiasPrimas[Bloque.PLANTA]++;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}

	}

	// Getters de las coordenadas

	public int getX() {
		return coordenadas[0];
	}

	public int getY() {
		return coordenadas[1];
	}

	public int getZ() {
		return coordenadas[2];
	}

	/**
	 * Metodo para mover al jugador Este metodo tiene 6 direcciones siendo
	 * derecha,izquierda,arriba,abajo,adelante,atras Dependiendo de la direccion se
	 * movera acorde a un mundo tridimensional Una vez que el jugador se mueva hara
	 * una accion de destruir bloque En caso de ser una direccion invalidad lanzara
	 * una execpcion
	 */

	public void mover(Bloque bloquedestruir,int switchdireccion,int nuevadireccion) {

		//TODO Hacer logica direccion
		

	}

}
