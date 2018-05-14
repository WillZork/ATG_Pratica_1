/**
 * UFCG - Universidade Federal de Campina Grande
 * Aplicacao de Teoria dos Grafos
 * - Luan Carlos da Silva Bezerra
 * -
 * -
 * -
 * -
 */
package main;

import controller.Controller;
import graph.Graph;

/**
 * Metodo Main
 * @author Luan C
 * @version 1.0
 */
public class Main {
	private static Controller controlador;

	/**
	 * Inicio
	 * @param args
	 * @author Luan C
	 * @version 1.0
	 */
	public static void main(String[] args) {
		controlador = new Controller();
		Graph grafo = new Graph(5, new  Integer[] {1, 2, 5, 4, 1}, new Integer[] {2, 5, 3, 5, 5});
		System.out.println(grafo.graphRepresentationAL());
	}

}
