package bloque.material;

import bloque.Bloque;
import bloque.HERRAMIENTAS;
import bloque.categoria.BloqueVegetal;
import juego.Jugador;

public class BloquePlanta extends BloqueVegetal {

	public BloquePlanta(int x, int y, int z) {
		super(x, y, z);
		this.tipo = Bloque.PLANTA;
	}

	public boolean destruir(HERRAMIENTAS herramienta, Jugador jugador) {
		boolean resultado = false;
		if (super.getX() != -1) {
			if (herramienta.equals(BloqueVegetal.HERRAMIENTA)) {
				jugador.sumaMateria(tipo);
				resultado = true;
				System.out.println("Bloque de planta recolectado con exito");
			}
			super.destruir();
		} else {
			resultado = true;
		}
		return resultado;
	}
}
