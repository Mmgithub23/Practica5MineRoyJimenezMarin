package juego;

import java.util.Random;
import java.util.Scanner;

import javax.management.ValueExp;

import bloque.Bloque;
import bloque.categoria.BloqueMineral;
import bloque.material.BloqueAlbero;
import bloque.material.BloqueArbol;
import bloque.material.BloqueArcilla;
import bloque.material.BloqueCobre;
import bloque.material.BloqueHierro;
import bloque.material.BloquePlanta;
import bloque.material.BloqueVacio;

/**
 * IES Cristobal de Monroy CFGS - Desarrollo de Aplicaciones Multiplataforma
 * Modulo - Programación
 * 
 * @category Practica V - MineMonroy
 * @author y0rg
 * @version 1.1
 */
public class Juego {

	// Indica el tamano del cub que contendra el mapa que vamos a crear
	public static final int TAMANO_MUNDO = 10;
	private static final int MITAD_MUNDO = (int) (Math.pow(TAMANO_MUNDO, 3) / 2);
	public static final Scanner teclado = new Scanner(System.in);

	/**
	 * Metodo principal, ejecuta el juego
	 */
	public static void main(String[] args) {

		// Creamos el mapa del juego
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];
		boolean seguir = true;
		int opcion;
		Jugador yo = null;
		// Lo rellenamos de bloques aleatorios de cualquir tipo, incluso tipo Bloque
		// (vacio)
		generarMundo(mundo3D);

		// Creamos el jugador para ello buscamos el primer bloque vacio disponible
		for (int i = 0; i < TAMANO_MUNDO && seguir; i++) {
			for (int j = 0; j < TAMANO_MUNDO && seguir; j++) {
				for (int k = 2; k < TAMANO_MUNDO && seguir; k++) {
					if (mundo3D[i][j][k] instanceof BloqueVacio) {
						yo = new Jugador("Jorge", i, j, k);
						// Imprimos las coordenadas
						System.out.println("Coordenadas:");
						System.out.println("X: " + i + " Y: " + j + " Z:" + k);
						// Finalizamos el bucle
						seguir = false;
					}
				}
			}
		}

		// Bucle para el juego reiniciamos la variable seguir para utilizarla aqui
		seguir = true;
		do {
			// Menu del juego
			System.out.println("Porfavor introduzca que opcion desea hacer");
			System.out.println("Mover [1]");
			System.out.println("Crear herramientas [2]");
			System.out.println("Estado [3]");
			System.out.println("Finalizar Juego [4]");
			opcion = teclado.nextInt();

			// Manejo las opciones
			switch (opcion) {
			case 1: {
				int posicioncalculada;
				System.out.println("Introduzca a que direccion");
				System.out.println("Derecha [1]");
				System.out.println("Izquierda [2]");
				System.out.println("Adelante [3]");
				System.out.println("Atras [4]");
				System.out.println("Arriba [5]");
				System.out.println("Abajo [6]");
				opcion = teclado.nextInt();
				// Switch para saber cual seria la coordenada del jugador acorde al movimiento y
				// el bloque el cual accede.
				switch (opcion) {
				// Derecha comprobando si sobrepasa los limites del mapa
				case 1: {
					if (yo.getY() + 1 == Juego.TAMANO_MUNDO) {
						posicioncalculada = 0;
						yo.mover(mundo3D[yo.getX()][posicioncalculada][yo.getZ()], Jugador.Y, posicioncalculada);
					} else {
						posicioncalculada = yo.getY() + 1;
						yo.mover(mundo3D[yo.getX()][posicioncalculada][yo.getZ()], Jugador.Y, posicioncalculada);
					}
					break;
				}
				// Izquierda comprobando si sobrepasa los limites del mapa
				case 2: {
					if (yo.getY() - 1 < 0) {
						posicioncalculada = TAMANO_MUNDO - 1;
						yo.mover(mundo3D[yo.getX()][posicioncalculada][yo.getZ()], Jugador.Y, posicioncalculada);
					} else {
						posicioncalculada = yo.getY() - 1;
						yo.mover(mundo3D[yo.getX()][posicioncalculada][yo.getZ()], Jugador.Y, posicioncalculada);
					}
					break;
				}
				// Adelante comprobando si sobrepasa los limites del mapa
				case 3: {
					if (yo.getX() + 1 == Juego.TAMANO_MUNDO) {
						posicioncalculada = 0;
						yo.mover(mundo3D[posicioncalculada][yo.getY()][yo.getZ()], Jugador.X, posicioncalculada);
					} else {
						posicioncalculada = yo.getX() + 1;
						yo.mover(mundo3D[posicioncalculada][yo.getY()][yo.getZ()], Jugador.X, posicioncalculada);
					}
					break;
				}
				// Atras comprobando si sobrepasa los limites del mapa
				case 4: {
					if (yo.getX() - 1 < 0) {
						posicioncalculada = TAMANO_MUNDO - 1;
						yo.mover(mundo3D[posicioncalculada][yo.getY()][yo.getZ()], Jugador.X, posicioncalculada);

					} else {
						posicioncalculada = yo.getX() - 1;
						yo.mover(mundo3D[posicioncalculada][yo.getY()][yo.getZ()], Jugador.X, posicioncalculada);
					}
					break;
				}
				// Arriba comprobando si sobrepasa los limites del mapa
				case 5: {
					if (yo.getZ() + 1 == Juego.TAMANO_MUNDO) {

						posicioncalculada = 0;
						yo.mover(mundo3D[yo.getX()][yo.getY()][posicioncalculada], Jugador.Z, posicioncalculada);
					} else {
						posicioncalculada = yo.getZ() + 1;
						yo.mover(mundo3D[yo.getX()][yo.getY()][posicioncalculada], Jugador.Z, posicioncalculada);
					}
					break;
				}
				// Abajo comprobando si sobrepasa los limites del mapa
				case 6: {
					if (yo.getZ() - 1 < 0) {
						posicioncalculada = TAMANO_MUNDO - 1;
						yo.mover(mundo3D[yo.getX()][yo.getY()][posicioncalculada], Jugador.Z, posicioncalculada);
					} else {
						posicioncalculada = yo.getZ() - 1;
						yo.mover(mundo3D[yo.getX()][yo.getY()][posicioncalculada], Jugador.Z, posicioncalculada);
					}
					break;
				}
				default:
					throw new IllegalArgumentException("Direccion invalida: ");
				}

				break;
			}
			case 2: {
				break;
			}

			case 3: {

				break;
			}
			case 4: {

				break;
			}

			default:
				System.out.println("Opcion Invalida");
			}

		} while (seguir);

		// Imprimir mundo
//		for (int i= 0; i <TAMANO_MUNDO; i++) {
//			for (int j= 0; j <TAMANO_MUNDO; j++) {
//				for (int k= 0; k <TAMANO_MUNDO; k++) {
//					System.out.println(mundo3D[i][j][k].toString());
//				}
//			}
//		}

		// El Jugador recorre el mapa entero recolectando materias primas
//		for (int i= 0; i <TAMANO_MUNDO; i++) {
//			for (int j= 0; j <TAMANO_MUNDO; j++) {
//				for (int k= 0; k <TAMANO_MUNDO; k++) {
//					//EN este caso solo utiliza el "Pico"
//					mundo3D[i][j][k].destruir(BloqueMineral.HERRAMIENTA, yo);
//				}
//			}
//		}

		// Mostramos el resultado de la recolección
		System.out.println(yo);

	}

	/**
	 * Metodo para generar bloques de tipo aleatorio
	 * 
	 * @param x posicion x en la que se encuentra el bloque
	 * @param y posicion y en la que se encuentra el bloque
	 * @param z posicion z en la que se encuentra el bloque
	 * @return el bloque creado
	 */

	public static void generarMundo(Bloque mundoarray[][][]) {
		boolean invalido = true;
		int x_random, y_random, z_random;
		Random rd = new Random();
		for (int i = 0; i < MITAD_MUNDO; i++) {
			do {
				x_random = rd.nextInt(TAMANO_MUNDO);
				y_random = rd.nextInt(TAMANO_MUNDO);
				z_random = rd.nextInt(2, TAMANO_MUNDO);
				if (mundoarray[x_random][y_random][z_random] == null) {
					mundoarray[x_random][y_random][z_random] = new BloqueVacio(x_random, y_random, z_random);
					invalido = false;
				}
			} while (invalido);
			invalido = true;
		}

		for (int i = 0; i < TAMANO_MUNDO; i++) {
			for (int j = 0; j < TAMANO_MUNDO; j++) {
				for (int k = 0; k < TAMANO_MUNDO; k++) {
					if (mundoarray[i][j][k] == null) {
						mundoarray[i][j][k] = generaBloqueAleatorio(i, j, k);
					}

				}
			}
		}

	}

	public static Bloque generaBloqueAleatorio(int x, int y, int z) {

		Bloque bloque = null;
		Random rd = new Random();

		int tipo;

		tipo = rd.nextInt(Bloque.NUM_MATERIAS);

		switch (tipo) {
		case Bloque.ALBERO: {
			bloque = new BloqueAlbero(x, y, z);
			break;
		}
		case Bloque.ARBOL: {
			bloque = new BloqueArbol(x, y, z);
			break;
		}
		case Bloque.ARCILLA: {
			bloque = new BloqueArcilla(x, y, z);
			break;
		}
		case Bloque.COBRE: {
			bloque = new BloqueCobre(x, y, z);
			break;
		}
		case Bloque.HIERRO: {
			bloque = new BloqueHierro(x, y, z);
			break;
		}
		case Bloque.PLANTA: {
			bloque = new BloquePlanta(x, y, z);
			break;
		}

		}
		return bloque;
	}

}
