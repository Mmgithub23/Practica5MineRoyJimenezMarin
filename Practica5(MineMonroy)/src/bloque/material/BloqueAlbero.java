package bloque.material;

import bloque.Bloque;
import bloque.HERRAMIENTAS;
import bloque.categoria.BloqueTierra;
import juego.Jugador;

public class BloqueAlbero extends BloqueTierra {

	public BloqueAlbero(int x, int y, int z) {
		super(x, y, z);
		this.tipo = Bloque.ALBERO;
	}

	public boolean destruir(HERRAMIENTAS herramienta, Jugador jugador) {
		boolean resultado = false;
		
		if (herramienta.equals(BloqueTierra.HERRAMIENTA)) {
			jugador.sumaMateria(tipo);
			resultado = true;
		}
		super.destruir();
		return resultado;
	}
}
