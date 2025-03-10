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
		if (super.getX() != -1) {
			if (herramienta.equals(BloqueMineral.HERRAMIENTA)) {
					jugador.sumaMateria(tipo);
					resultado = true;
					System.out.println("Bloque de hierro recolectado con exito");
				}
				super.destruir();
		} else {
			resultado = true;
		}
	
		return resultado;
	}
}
