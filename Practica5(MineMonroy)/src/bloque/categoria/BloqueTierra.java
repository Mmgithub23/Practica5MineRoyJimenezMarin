package bloque.categoria;

import bloque.Bloque;
import bloque.HERRAMIENTAS;

public abstract class BloqueTierra extends Bloque {

	public static final HERRAMIENTAS HERRAMIENTA = HERRAMIENTAS.PALA;

	public BloqueTierra(int x, int y, int z) {
		super(x, y, z);
	}

}
