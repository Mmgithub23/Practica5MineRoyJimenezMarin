package juego;

import bloque.Bloque;
import bloque.HERRAMIENTAS;
import bloque.material.BloqueVacio;

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
	// Posicion de la X , Y , Z en el array
	public static final int X = 0, Y = 1, Z = 2;
	// Durabilidad de cada herramienta en orden: Hacha, Pala , Pico
	private int durabilidadherramienta[] = { 5, 5, 5 };

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
		return coordenadas[X];
	}

	public int getY() {
		return coordenadas[Y];
	}

	public int getZ() {
		return coordenadas[Z];
	}

	/**
	 * Metodo para mover al jugador Este metodo tomo como valores de entrada el
	 * bloque el cual va a interactuar,un int que le dice que coordenada es la
	 * afecta y la nueva direccion que tomara esta coordenada.
	 */

	public void mover(Bloque bloquedestruir, int switchdireccion, int nuevadireccion) {

		System.out.println("Eliga la herramienta");
		System.out.println("Hacha [1]");
		System.out.println("Pala [2]");
		System.out.println("Pico [3]");
		switch (Juego.teclado.nextInt()) {
		case 1: {
			if (durabilidadherramienta[0] > 0) {
				if (bloquedestruir.destruir(HERRAMIENTAS.HACHA, this)) {
					cambiarcordenada(switchdireccion, nuevadireccion);
				}
				//Si el bloque no es un bloque vacio no restara la durabilidad 
				if (!(bloquedestruir instanceof BloqueVacio)) {
					durabilidadherramienta[0]--;
				}

			} else {
				throw new IllegalArgumentException("No tienes durabilidad suficiente con esta herramienta");
			}

			break;
		}
		case 2: {
			if (durabilidadherramienta[1] > 0) {
				if (bloquedestruir.destruir(HERRAMIENTAS.PALA, this)) {
					cambiarcordenada(switchdireccion, nuevadireccion);
				}
				//Si el bloque no es un bloque vacio no restara la durabilidad 
				if (!(bloquedestruir instanceof BloqueVacio)) {
					durabilidadherramienta[0]--;
				}
			} else {
				throw new IllegalArgumentException("No tienes durabilidad suficiente con esta herramienta");
			}

			break;
		}
		case 3: {
			if (durabilidadherramienta[2] > 0) {
				if (bloquedestruir.destruir(HERRAMIENTAS.PICO, this)) {
					cambiarcordenada(switchdireccion, nuevadireccion);
				}
				//Si el bloque no es un bloque vacio no restara la durabilidad 
				if (!(bloquedestruir instanceof BloqueVacio)) {
					durabilidadherramienta[0]--;
				}
			} else {
				throw new IllegalArgumentException("No tienes durabilidad suficiente con esta herramienta");
			}

			break;
		}

		default:
			throw new IllegalArgumentException("Opcion Invalida");
		}

	}

	// Este metodo maneja el switch para cambiar la coordenada. Se mueve a un metodo
	// para una mejor lectura de codigo
	private void cambiarcordenada(int switchdireccion, int nuevadireccion) {
		switch (switchdireccion) {
		case X: {
			coordenadas[X] = nuevadireccion;
			break;
		}
		case Y: {
			coordenadas[Y] = nuevadireccion;
			break;
		}
		case Z: {
			coordenadas[Z] = nuevadireccion;
			break;
		}

		}

	}
}
