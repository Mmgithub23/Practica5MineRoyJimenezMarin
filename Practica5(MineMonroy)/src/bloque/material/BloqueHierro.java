package bloque.material;

import bloque.Bloque;
import bloque.HERRAMIENTAS;
import bloque.categoria.BloqueMineral;
import juego.Jugador;

public class BloqueHierro extends BloqueMineral {

	public BloqueHierro(int x, int y, int z) {
		super(x, y, z);
		this.tipo = Bloque.HIERRO;
	}

	public boolean destruir(HERRAMIENTAS herramienta, Jugador jugador) {
		boolean resultado = false;
		if (herramienta.equals(BloqueMineral.HERRAMIENTA)) {
			jugador.sumaMateria(tipo);
			resultado = true;
		}
		super.destruir();
		return resultado;
	}
}
