/**
 * UFCG - Universidade Federal de Campina Grande
 * Aplicacao de Teoria dos Grafos
 * - Luan Carlos da Silva Bezerra
 * -
 * -
 * -
 * -
 */
package controller;

import java.util.ArrayList;

import graph.Graph;
import graph.WeightedGraph;

/**
 * 
 * @author Luan C.
 *
 */
public class Controller {
	private ArrayList<Graph> grafos;

	/**
	 * Construtor do Controller
	 * @author Luan C.
	 */
	public Controller() {
		grafos = new ArrayList<>();
	}

	/**
	 * Cria um objeto Graph
	 * @param qtdVertices, Integer com a quantidade de Vertices
	 * @param arrayOrigem, Colecao armazenando os Vertices que originam as ligacoes
	 * @param arrayDestino, Colecao que armazeda os Vertices que recebem as ligacoes
	 */
	public void criaGrafo(int qtdVertices, Integer[] arrayOrigem, Integer[] arrayDestino) {
		Graph grafo = new Graph(qtdVertices, arrayOrigem, arrayDestino);
		grafos.add(grafo);
	}

	/**
	 * Cria um objeto WeightedGraph
	 * @param qtdVertices, Integer com a quantidade de Vertices
	 * @param arrayOrigem, Colecao de inteiros armazenando os Vertices que originam as ligacoes
	 * @param arrayDestino, Colecao de inteiros que armazeda os Vertices que recebem as ligacoes
	 * @param arrayPesos, Colecao de Doubles que armazenam os pesos de cada aresta
	 */
	public void criaGrafoComPeso(int qtdVertices, Integer[] arrayOrigem, Integer[] arrayDestino, Double[] arrayPesos) {
		WeightedGraph grafo = new WeightedGraph(qtdVertices, arrayOrigem, arrayDestino, arrayPesos);
		grafos.add(grafo);
	}
}
