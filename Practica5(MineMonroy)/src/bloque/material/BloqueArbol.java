package bloque.material;

import bloque.Bloque;
import bloque.HERRAMIENTAS;
import bloque.categoria.BloqueVegetal;
import juego.Jugador;

public class BloqueArbol extends BloqueVegetal {

	public BloqueArbol(int x, int y, int z) {
		super(x, y, z);
		this.tipo = Bloque.ARBOL;
	}

	public boolean destruir(HERRAMIENTAS herramienta, Jugador jugador) {
		boolean resultado = false;
		
		if (herramienta.equals(BloqueVegetal.HERRAMIENTA)) {
			jugador.sumaMateria(tipo);
			resultado = true;
		}
		super.destruir();
		return resultado;
	}
}
