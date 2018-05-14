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
import graph.WeightedGraph;

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
		WeightedGraph grafo = new WeightedGraph(5, new  Integer[] {1, 2, 5, 3, 4, 1}, new Integer[] {2, 5, 3, 4, 5, 5}, new Double[] {0.1, 0.2, 5.0, -9.5, 2.3, 1.0});
		System.out.println(grafo.graphRepresentationAM());
	}

}
