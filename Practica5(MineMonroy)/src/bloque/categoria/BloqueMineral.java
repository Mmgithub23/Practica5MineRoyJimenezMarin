package bloque.categoria;

import bloque.Bloque;
import bloque.HERRAMIENTAS;

public abstract class BloqueMineral extends Bloque {

	public static final HERRAMIENTAS HERRAMIENTA = HERRAMIENTAS.PICO;

	public BloqueMineral(int x, int y, int z) {
		super(x, y, z);
	}

}
