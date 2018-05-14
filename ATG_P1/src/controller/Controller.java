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
 * Controller do Sistema
 * 
 * @author Luan C.
 * @version 1.0
 */
public class Controller {
	private ArrayList<Graph> grafos;

	/**
	 * Construtor do Controller
	 * 
	 * @author Luan C.
	 * @version 1.0
	 */
	public Controller() {
		grafos = new ArrayList<>();
	}

	/**
	 * Cria um objeto Graph
	 * 
	 * @param qtdVertices,
	 *            Integer com a quantidade de Vertices
	 * @param arrayOrigem,
	 *            Colecao armazenando os Vertices que originam as ligacoes
	 * @param arrayDestino,
	 *            Colecao que armazeda os Vertices que recebem as ligacoes
	 * @author Luan C
	 * @version 1.0
	 */
	public Graph criaGrafo(int qtdVertices, Integer[] arrayOrigem, Integer[] arrayDestino) {
		Graph grafo = new Graph(qtdVertices, arrayOrigem, arrayDestino);
		grafos.add(grafo);
		return grafo;
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
		grafos.add(grafo);
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
		if(containsGraph(grafo)) 
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
		if(containsGraph(grafo)) 
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
	 * @author Luan C
	 * @version 1.1
	 */
	public String graphRepresentation(Graph grafo, String type) throws Exception {
		String retorno = "";
		if (containsGraph(grafo)) {
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
		return "";
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
		boolean retorno = true;
		Integer[] origem = grafo.getArrayOrigem();
		Integer[] destino = grafo.getArrayDestino();
		for (int i = 0; i < destino.length; i++) {
			if(destino[i] == null || origem[i] == null)
				retorno = false;
		}
		return retorno;
	}
	
	String shortestPath(int v1, int v2) {
		return "";
	}
	
	String mst(Graph grafo) {
		return "";
	}

	/**
	 * Verifica se o Graph esta cadastrado
	 * @param grafo, Graph procurado
	 * @return boolean
	 */
	private boolean containsGraph(Graph grafo) {
		if (grafos.contains(grafo))
			return true;
		else
			return false;
	}
}
