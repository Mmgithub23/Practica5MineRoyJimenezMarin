package bloque.categoria;

import bloque.Bloque;
import bloque.HERRAMIENTAS;

public abstract class BloqueVegetal extends Bloque {

	public static final HERRAMIENTAS HERRAMIENTA = HERRAMIENTAS.HACHA;

	public BloqueVegetal(int x, int y, int z) {
		super(x, y, z);
	}

}
