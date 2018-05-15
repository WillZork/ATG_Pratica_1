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
import reader.InputFileReader;

/**
 * Controller do Sistema
 * 
 * @author Luan C.
 * @version 1.0
 */
public class Controller {

	/**
	 * Cria um objeto Graph a partir do array de leitura.
	 * 
	 * @param qtdVertices,
	 *            Integer com a quantidade de Vertices
	 * @param arrayOrigem,
	 *            Colecao armazenando os Vertices que originam as ligacoes
	 * @param arrayDestino,
	 *            Colecao que armazeda os Vertices que recebem as ligacoes
	 * @author Luan C, Williamberg Ferreira
	 * @version 1.0
	 */
	
	public Graph criaGrafo(int vertice, Integer[] arrayOrigem, Integer[] arrayDestino) {

		Graph grafo = new Graph(vertice, arrayOrigem, arrayDestino);
		return grafo;
	}
	
	public Graph readGraph(String path) throws Exception {
		Integer[] arrayInput = InputFileReader.readGraph(path);
		int qtdVertices = 0;
		Integer[] arrayOrigem = new Integer[(arrayInput.length)/2];
		Integer[] arrayDestino = new Integer[(arrayInput.length)/2];
		
		for (int i = 0; i < arrayInput.length; i++) {
			if (i == 0) {
				qtdVertices = arrayInput[i];
			} else if (i % 2 != 0) {
				arrayOrigem[i] = arrayInput[i];
			} else { // indice par
				arrayDestino[i] = arrayInput[i];
			}
		}
		return criaGrafo(qtdVertices, arrayOrigem, arrayDestino);
	}

	/**
	 * Cria um objeto WeightedGraph
	 * 
	 * @param qtdVertices,
	 *            Integer com a quantidade de Vertices
	 * @param arrayOrigem,
	 *            Colecao de inteiros armazenando os Vertices que originam as
	 *            ligacoes
	 * @param arrayDestino,
	 *            Colecao de inteiros que armazeda os Vertices que recebem as
	 *            ligacoes
	 * @param arrayPesos,
	 *            Colecao de Doubles que armazenam os pesos de cada aresta
	 * @author Luan C
	 * @version 1.0
	 */
	public Graph criaGrafoComPeso(int qtdVertices, Integer[] arrayOrigem, Integer[] arrayDestino, Double[] arrayPesos) {
		WeightedGraph grafo = new WeightedGraph(qtdVertices, arrayOrigem, arrayDestino, arrayPesos);
		return grafo;
	}

	/**
	 * Retorna a quantidade de vertices em um grafo
	 * 
	 * @param grafo,Graph que sera pesquisado
	 * @return Integer
	 * @author Luan C
	 * @version 1.0
	 * @throws Exception 
	 */

	public int getVertexNumber(Graph grafo) throws Exception {
		if(grafo != null) 
			return grafo.getQtdVertices();
		else
			throw new Exception("Grafo nao Existe");
	}

	/**
	 * Retorna a quantidade de arestas no grafo
	 * 
	 * @param grafo,
	 *            Graph pesquisado
	 * @return Integer
	 * @author Luan C
	 * @version 1.0
	 * @throws Exception 
	 */
	public int getEdgeNumber(Graph grafo) throws Exception {
		if(grafo != null) 
			return grafo.getQtdArestas();
		else
			throw new Exception("Grafo nao Existe");
	}

	/**
	 * Retorna o grau medio do grafo
	 * 
	 * @param grafo, Graph pesquisado
	 * @return Float
	 * @author Luan C
	 * @version 1.0
	 */
	public float getMeanEdge(Graph grafo) { 
		return grafo.getMeanEdge();
	}

	/**
	 * Retorna a representacao desejada pelo usuario
	 * @param grafo, Graph
	 * @param type, String
	 * @return String
	 * @throws Exception	
	 * @author Tatiane Andrade
	 * @version 1.0
	 */
	public String graphRepresentation(Graph grafo, String type) throws Exception {
		String retorno = "";
		if (grafo != null) {
			if (type.equals("AM")) {
				retorno = grafo.graphRepresentationAM();
			}else if(type.equals("AL")){
				retorno = grafo.graphRepresentationAL();
			}else {
				throw new Exception("Opcao invalida");
			}
		}
		return retorno;
	}
	
	public String BFS(Graph grafo, int v) {
		return grafo.BFS(v);
	}
	
	public String DFS(Graph grafo, int v) {
		return "";
	}
	
	/**
	 * Retorna se o grafo e conectado ou nao
	 * @param grafo, Graph
	 * @return boolean
	 */
	public boolean connected(Graph grafo) {
		return grafo.connected();
	}
	
	String shortestPath(int v1, int v2) {
		return "";
	}
	
	String mst(Graph grafo) {
		return "";
	}

}
