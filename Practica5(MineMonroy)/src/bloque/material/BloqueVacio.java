package bloque.material;

import bloque.Bloque;
import bloque.HERRAMIENTAS;
import juego.Jugador;

public class BloqueVacio extends Bloque {

	public BloqueVacio(int x, int y, int z) {
		super(x, y, z);
	}

	public void destruir(HERRAMIENTAS herramienta, Jugador jugador) {
		super.destruir();
	}

}
