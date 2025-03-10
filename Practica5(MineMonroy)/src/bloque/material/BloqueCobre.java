package bloque.material;

import bloque.Bloque;
import bloque.HERRAMIENTAS;
import bloque.categoria.BloqueMineral;
import juego.Jugador;

public class BloqueCobre extends BloqueMineral {

	public BloqueCobre(int x, int y, int z) {
		super(x, y, z);
		this.tipo = Bloque.COBRE;
	}

	public boolean destruir(HERRAMIENTAS herramienta, Jugador jugador) {
		boolean resultado = false;
		if(super.getX() != -1) {
			if (herramienta.equals(BloqueMineral.HERRAMIENTA)) {
				jugador.sumaMateria(tipo);
				resultado = true;
				System.out.println("Bloque de cobre recolectado con exito");
			}
			super.destruir();
		}else {
			resultado = true;
		}
		return resultado;
	}
}
