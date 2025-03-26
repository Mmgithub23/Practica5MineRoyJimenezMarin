package juego;

import java.util.Random;
import java.util.Scanner;

import bloque.Bloque;
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

		// Declaramos el mundo y su copia cuyo tamaño es todo los bloques del mundo
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];
		// Variable de opcion para menu
		int opcion;
		boolean seguir = true;
		Jugador yo = null;
		// Generamos el mundo
		generarMundo(mundo3D);

		// Buscamos el bloque de aire por capa
		for (int z = 2; z < TAMANO_MUNDO && seguir; z++) {
			for (int x = 0; x < TAMANO_MUNDO && seguir; x++) {
				for (int y = 0; y < TAMANO_MUNDO && seguir; y++) {
					if (mundo3D[x][y][z] instanceof BloqueVacio) {
						yo = new Jugador("Jorge", x, y, z);
						// Imprimos las coordenadas
						System.out.println("Coordenadas:");
						System.out.println("X: " + x + " Y: " + y + " Z:" + z);
						// Finalizamos el bucle
						seguir = false;
					}
				}
			}
		}

		// Bucle para el juego
		do {
			// Menu del juego
			System.out.println("Porfavor introduzca que opcion desea hacer");
			System.out.println("Mover [1]");
			System.out.println("Crear herramientas [2]");
			System.out.println("Estado [3]");
			opcion = teclado.nextInt();

			// Manejo de las opciones. Añadimos un try catch para las excepciones

			try {
				switch (opcion) {
				case 1: {
					int posicioncalculada;
					System.out.println("Introduzca a que direccion");
					System.out.println("              Arriba [5]        ");
					System.out.println("                 ^              ");
					System.out.println("                 |              ");
					System.out.println("             Adelante [3]       ");
					System.out.println("                 ^              ");
					System.out.println("                 |              ");
					System.out.println("Izquierda [2] <- X ->Derecha [1]");
					System.out.println("                 |              ");
					System.out.println("                 v              ");
					System.out.println("              Atras [4]         ");
					System.out.println("                 |              ");
					System.out.println("                 v              ");
					System.out.println("              Abajo [6]         ");
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
					yo.crearherramientas();
					break;
				}

				case 3: {
					System.out.println(yo.toString());
					break;
				}
				// Opcion secreta que es 4.
				case 4: {
					imprimirmundo(mundo3D);
					break;
				}
				case 5: {
					imprimirbloquescercanos(mundo3D, yo.getX(), yo.getY(), yo.getZ());
					break;
				}

				default:
					throw new IllegalArgumentException("Opcion Invalida");
				}
			} catch (Exception e) {
				e.printStackTrace();
				;
			}

		} while (!yo.victoria());

		System.out.println();
		System.out.println("ENHORABUENA HAS GANADO ");

	}

	// Metodo para generar el mundo. Usa 3 coordenadas aleatorias para generar los
	// bloques de aire. Si la posicion en el array esta vacia genera un bloque de
	// aire.
	// Recorrare este bucle por la mitad del mundo entero.
	// Una vez generado todo los bloques de aire recorrera el array entero buscando
	// las posiciones vacias en el array y generando un bloque aleatoria para esa
	// posicion en el
	// array.
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

	/**
	 * Metodo para generar bloques de tipo aleatorio
	 * 
	 * @param x posicion x en la que se encuentra el bloque
	 * @param y posicion y en la que se encuentra el bloque
	 * @param z posicion z en la que se encuentra el bloque
	 * @return el bloque creado
	 */
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

	// Recorre todo el mundo imprimiendo cada bloque
	public static void imprimirmundo(Bloque mundoarray[][][]) {
		for (int i = 0; i < TAMANO_MUNDO; i++) {
			for (int j = 0; j < TAMANO_MUNDO; j++) {
				for (int k = 0; k < TAMANO_MUNDO; k++) {
					System.out.println(mundoarray[i][j][k].toString());
				}
			}
		}
	}

	// Metodo para mirar los bloques a tu alrededor
	public static void imprimirbloquescercanos(Bloque mundoarray[][][], int x, int y, int z) {
		// Bucle arriba primero comprobamos que no supere el limite superior

		for (int i = y - 1, b = i; i < b + 3; i++) {
			// Por cada posicion miramos que no supere los limites del mundo tanto superior
			// e inferior

			// Comprueba que no este en la primera iteracion
			if (i >= b + 1) {
				System.out.print(" ");
			}

			if (i < TAMANO_MUNDO && i > -1 && x + 1 < TAMANO_MUNDO) {
				String aux = mundoarray[x + 1][i][z].tipoaString();

				if (mundoarray[x + 1][i][z].getX() == -1) {
					System.err.print(aux);
				} else {
					System.out.print(aux);
				}

				// Imprime espacios para que este todo centrado
				for (int c = aux.length(); c < 13; c++) {

					System.out.print(" ");

				}

				System.out.print("|");
			} else {
				System.out.print("LIMITE MUNDO |");
			}

		}

		System.out.println();
		if (y - 1 > -1) {
			String aux = mundoarray[x][y - 1][z].tipoaString();
			if (mundoarray[x][y - 1][z].getX() == -1) {
				System.err.print(aux);
			} else {
				System.out.print(aux);
			}
			// Imprime espacios para que este todo centrado
			for (int c = aux.length(); c < 13; c++) {
				System.out.print(" ");
			}
			System.out.print("|");
		} else {
			System.out.print("LIMITE MUNDO |");
		}

		System.out.print(" TU UBICACION |");

		if (y + 1 < TAMANO_MUNDO) {
			String aux = mundoarray[x][y + 1][z].tipoaString();
			if (mundoarray[x][y + 1][z].getX() == -1) {
				System.err.print(" " + aux);
			} else {
				System.out.print(" " + aux);
			}
			// Imprime espacios para que este todo centrado
			for (int c = aux.length(); c < 13; c++) {
				System.out.print(" ");
			}
			System.out.print("|");
		} else {
			System.out.print("LIMITE MUNDO |");
		}

		System.out.println();

		for (int i = y - 1, b = i; i < b + 3; i++) {
			// Por cada posicion miramos que no supere los limites del mundo tanto superior
			// e inferior

			// Comprueba que no este en la primera iteracion
			if (i >= b + 1) {
				System.out.print(" ");
			}

			if (i < TAMANO_MUNDO && i > -1 && x - 1 > -1) {
				String aux = mundoarray[x - 1][i][z].tipoaString();

				if (mundoarray[x - 1][i][z].getX() == -1) {
					System.err.print(aux);
				} else {
					System.out.print(aux);
				}

				// Imprime espacios para que este todo centrado
				for (int c = aux.length(); c < 13; c++) {
					System.out.print(" ");
				}

				System.out.print("|");
			} else {
				System.out.print("LIMITE MUNDO |");
			}

		}
		System.out.println();

	}

}
