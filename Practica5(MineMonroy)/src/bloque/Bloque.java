package bloque;

import juego.Jugador;

public abstract class Bloque {

	//Tipos de bloques posibles.
	public static final int PLANTA = 0;
	public static final int ARBOL = 1;
	public static final int ARCILLA = 2;
	public static final int ALBERO = 3;
	public static final int HIERRO = 4;
	public static final int COBRE = 5;
	
	public static final int NUM_MATERIAS = 6; //Pues contamos desde 0.

	int x, y, z;
	
	protected int tipo;

	public Bloque(int x, int y, int z) throws IllegalArgumentException {
		if(x < 0 || y < 0 || z < 0) {
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
	
	public abstract void destruir(HERRAMIENTAS herramienta, Jugador jugador);

	@Override
	public String toString() {
		return "Coordenadas x=" + x + ", y=" + y + ", z=" + z + ", tipo=" + tipo + "]";
	}
	
	

}
