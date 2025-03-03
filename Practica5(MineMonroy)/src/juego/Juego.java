package juego;

import java.util.Random;import javax.management.ValueExp;

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
 * IES Cristobal de Monroy
 * CFGS - Desarrollo de Aplicaciones Multiplataforma
 * Modulo - Programación
 * @category Practica V - MineMonroy
 * @author y0rg
 * @version 1.1
 */
public class Juego {
	
	//Indica el tamano del cub que contendra el mapa que vamos a crear
	public static final int TAMANO_MUNDO = 10;
	private static final int MITAD_MUNDO =  (int) (Math.pow(TAMANO_MUNDO, 3) / 2);


	
	/**
	 * Metodo principal, ejecuta el juego
	 */
	public static void main(String[] args) {

		//Creamos el mapa del juego
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];
		
		//Lo rellenamos de bloques aleatorios de cualquir tipo, incluso tipo Bloque (vacio)
		generarMundo(mundo3D);
		

		//Creamos el jugador
		Jugador yo = new Jugador("Jorge");

		//Imprimir mundo
//		for (int i= 0; i <TAMANO_MUNDO; i++) {
//			for (int j= 0; j <TAMANO_MUNDO; j++) {
//				for (int k= 0; k <TAMANO_MUNDO; k++) {
//					System.out.println(mundo3D[i][j][k].toString());
//				}
//			}
//		}
		
		//El Jugador recorre el mapa entero recolectando materias primas
		for (int i= 0; i <TAMANO_MUNDO; i++) {
			for (int j= 0; j <TAMANO_MUNDO; j++) {
				for (int k= 0; k <TAMANO_MUNDO; k++) {
					//EN este caso solo utiliza el "Pico"
					mundo3D[i][j][k].destruir(BloqueMineral.HERRAMIENTA, yo);
				}
			}
		}
		
		//Mostramos el resultado de la recolección
		System.out.println(yo);
		
		
	}

	
	/**
	 * Metodo para generar bloques de tipo aleatorio
	 * @param x posicion x en la que se encuentra el bloque
	 * @param y posicion y en la que se encuentra el bloque
	 * @param z posicion z en la que se encuentra el bloque
	 * @return el bloque creado
	 */
	
	public static void generarMundo(Bloque mundoarray[][][]) {
		boolean invalido = true;
		int x_random,y_random,z_random;
		Random rd = new Random();
		for (int i= 0; i <MITAD_MUNDO; i++) {
			do {
				x_random = rd.nextInt(TAMANO_MUNDO);
				y_random = rd.nextInt(TAMANO_MUNDO);
				z_random = rd.nextInt(2,TAMANO_MUNDO);
				if(mundoarray[x_random][y_random][z_random] == null) {
					mundoarray[x_random][y_random][z_random] = new BloqueVacio(x_random,y_random,z_random);
					invalido = false;
				}
			} while (invalido);
			invalido = true;
		}
		
		for (int i= 0; i <TAMANO_MUNDO; i++) {
			for (int j= 0; j <TAMANO_MUNDO; j++) {
				for (int k= 0; k <TAMANO_MUNDO; k++) {
					if(mundoarray[i][j][k] == null) {
						mundoarray[i][j][k] = generaBloqueAleatorio(i,j,k);
					}
					
				}
			}
		}
		
		
	}
	
	public static Bloque generaBloqueAleatorio(int x, int y, int z) {

		Bloque bloque = null;
		Random rd = new Random();

		//Ponemos el numero de materias +2, se sale del rango (default)
		//para que los casos +1 y +2 que no estan contemplados, generen bloques vacios
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
		default:{
			bloque = new BloquePlanta(x, y, z);
		}

		}
		return bloque;
	}

}
