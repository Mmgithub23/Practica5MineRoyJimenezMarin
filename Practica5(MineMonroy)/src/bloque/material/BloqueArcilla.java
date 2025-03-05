package bloque.material;

import bloque.Bloque;
import bloque.HERRAMIENTAS;
import bloque.categoria.BloqueTierra;
import juego.Jugador;

public class BloqueArcilla extends BloqueTierra {

	public BloqueArcilla(int x, int y, int z) {
		super(x, y, z);
		this.tipo = Bloque.ARCILLA;
	}

	public void destruir(HERRAMIENTAS herramienta, Jugador jugador) {
		if (herramienta.equals(BloqueTierra.HERRAMIENTA)) {
			jugador.sumaMateria(tipo);
		}
		super.destruir();
	}
}
