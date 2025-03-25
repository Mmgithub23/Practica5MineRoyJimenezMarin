package bloque;

import juego.Jugador;

public abstract class Bloque implements Comparable<Bloque> {

	// Tipos de bloques posibles.
	public static final int PLANTA = 0;
	public static final int ARBOL = 1;
	public static final int ARCILLA = 2;
	public static final int ALBERO = 3;
	public static final int HIERRO = 4;
	public static final int COBRE = 5;

	public static final int NUM_MATERIAS = 6; // Pues contamos desde 0.

	int x, y, z;

	protected int tipo;

	public Bloque(int x, int y, int z) throws IllegalArgumentException {
		if (x < 0 || y < 0 || z < 0) {
			throw new IllegalArgumentException("Coordenadas no validas");
		}
		this.x = x;
		this.y = y;
		this.z = z;
		this.tipo = -1;
	}

	public void destruir() {
		this.x = -1;
		this.y = -1;
		this.z = -1;
	}

	public abstract boolean destruir(HERRAMIENTAS herramienta, Jugador jugador);

	@Override
	public String toString() {
		return "Coordenadas x=" + x + ", y=" + y + ", z=" + z + ", tipo= " + tipoaString();
	}

	// Metodo que suma la x,y,z
	private int getSuma() {
		return x + y + z;
	}

	@Override
	/*
	 * Explicacion de ordenacion. Para encontrar el bloque con las coordenadas X,Y,Z
	 * tenemos que sumar estas 3 coordenadas y ordenarlas por la suma de estas.
	 */
	public int compareTo(Bloque otro) {
		return Integer.compare(this.getSuma(), otro.getSuma());
	}

	// Switch para tener en un string el tipo de bloque
	public String tipoaString() {
		String tipostring = "aire";
		switch (tipo) {
		case PLANTA: {
			tipostring = "planta";
			break;
		}
		case ARBOL: {
			tipostring = "arbol";
			break;
		}
		case ARCILLA: {
			tipostring = "arcilla";
			break;
		}
		case ALBERO: {
			tipostring = "albero";
			break;
		}
		case HIERRO: {
			tipostring = "hierro";
			break;
		}
		case COBRE: {
			tipostring = "cobre";
			break;
		}

		}

		return tipostring;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

}
