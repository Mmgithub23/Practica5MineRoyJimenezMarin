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
		coordenadas[X] = x;
		coordenadas[Y] = y;
		coordenadas[Z] = z;
		for (int i = 0; i < Bloque.NUM_MATERIAS; i++) {
			materiasPrimas[i] = 0;
		}
	}

	/**
	 * No hace falta explicarlo... o si?
	 */
	public String toString() {
		return "Nombre: " + this.nombre + " Coordenadas: X: " + this.coordenadas[X] + " Y: " + this.coordenadas[Y]
				+ " Z: " + this.coordenadas[Z] + " Durabilidad herramientas: Hacha: "
				+ this.durabilidadherramienta[HERRAMIENTAS.HACHA.ordinal()] + " Pala: "
				+ this.durabilidadherramienta[HERRAMIENTAS.PALA.ordinal()] + " Pico: "
				+ this.durabilidadherramienta[HERRAMIENTAS.PICO.ordinal()] + " - Materias primas recolectadas\n"
				+ "Plantas: " + materiasPrimas[Bloque.PLANTA] + "\nArboles: " + materiasPrimas[Bloque.ARBOL]
				+ "\nArcilla: " + materiasPrimas[Bloque.ARCILLA] + "\nAlbero: " + materiasPrimas[Bloque.ALBERO]
				+ "\nHierro: " + materiasPrimas[Bloque.HIERRO] + "\nCobre: " + materiasPrimas[Bloque.COBRE];
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
			if (durabilidadherramienta[HERRAMIENTAS.HACHA.ordinal()] > 0) {
				if (bloquedestruir.destruir(HERRAMIENTAS.HACHA, this)) {
					cambiarcordenada(switchdireccion, nuevadireccion);
				}
				// Si el bloque no es un bloque vacio restara la durabilidad
				if (!(bloquedestruir instanceof BloqueVacio)) {
					durabilidadherramienta[HERRAMIENTAS.HACHA.ordinal()]--;
				}

			} else {
				throw new IllegalArgumentException("No tienes durabilidad suficiente con esta herramienta");
			}

			break;
		}
		case 2: {
			if (durabilidadherramienta[HERRAMIENTAS.PALA.ordinal()] > 0) {
				if (bloquedestruir.destruir(HERRAMIENTAS.PALA, this)) {
					cambiarcordenada(switchdireccion, nuevadireccion);
				}
				// Si el bloque no es un bloque vacio restara la durabilidad
				if (!(bloquedestruir instanceof BloqueVacio)) {
					durabilidadherramienta[HERRAMIENTAS.PALA.ordinal()]--;
				}
			} else {
				throw new IllegalArgumentException("No tienes durabilidad suficiente con esta herramienta");
			}

			break;
		}
		case 3: {
			if (durabilidadherramienta[HERRAMIENTAS.PICO.ordinal()] > 0) {
				if (bloquedestruir.destruir(HERRAMIENTAS.PICO, this)) {
					cambiarcordenada(switchdireccion, nuevadireccion);
				}
				// Si el bloque no es un bloque vacio restara la durabilidad
				if (!(bloquedestruir instanceof BloqueVacio)) {
					durabilidadherramienta[HERRAMIENTAS.PICO.ordinal()]--;
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

	// Metdo crear herramientas comprueba si se tiene las materias suficientes. La
	// creacion de herramientas es: Hacha,Pala,Pico

	public void crearherramientas() {
		// Comprobacion si tiene los suficientes materiales para una hacha
		if (materiasPrimas[Bloque.HIERRO] > 0 && materiasPrimas[Bloque.ARBOL] > 0) {
			// Reinicia la durabilidad de la hacha y resta los materiales correspondientes
			durabilidadherramienta[HERRAMIENTAS.HACHA.ordinal()] = 5;
			materiasPrimas[Bloque.HIERRO]--;
			materiasPrimas[Bloque.ARBOL]--;
			System.out.println("Hacha construida");
			// Comprobacion si tiene los suficientes materiales para una pala
			if (materiasPrimas[Bloque.HIERRO] > 1 && materiasPrimas[Bloque.ARBOL] > 1) {
				durabilidadherramienta[HERRAMIENTAS.PALA.ordinal()] = 5;
				materiasPrimas[Bloque.HIERRO] -= 2;
				materiasPrimas[Bloque.ARBOL] -= 2;
				System.out.println("Pala construida");
			} else {
				System.out.println("No se ha podido crear una pala");
			}

			// Comprobacion si tiene los suficientes materiales para un pico
			if (materiasPrimas[Bloque.HIERRO] > 0 && materiasPrimas[Bloque.COBRE] > 0
					&& materiasPrimas[Bloque.ARBOL] > 1) {
				durabilidadherramienta[HERRAMIENTAS.PICO.ordinal()] = 5;
				materiasPrimas[Bloque.HIERRO] -= 2;
				materiasPrimas[Bloque.ARBOL] -= 2;
				System.out.println("Pala construida");
			} else {
				System.out.println("No se ha podido crear un pico");
			}

		} // Si no tiene los materiales suficientes para una hacha tampoco va a poder
			// hacer otros materiales por ende nos saltamos las comprobaciones
		else {
			System.out.println("Falta de materias basicas");
		}
	}

}
