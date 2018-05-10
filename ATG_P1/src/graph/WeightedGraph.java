/**
 * UFCG - Universidade Federal de Campina Grande
 * Aplicacao de Teoria dos Grafos
 * - Luan Carlos da Silva Bezerra
 * -
 * -
 * -
 * -
 */
package graph;

/**
 * Objeto WeightedGraph
 * @author Luan C
 * @version 1.0
 */
public class WeightedGraph extends Graph {

	private int qtdVertices;
	private Integer[] arrayOrigem;
	private Integer[] arrayDestino;
	private Double[] arrayPesos;

	/**
	 * Construtor de WeightedGraph
	 * @param qtdVertices, Integer com a quantidade de Vertices
	 * @param arrayOrigem, Colecao de inteiros armazenando os Vertices que originam as ligacoes
	 * @param arrayDestino, Colecao de inteiros que armazeda os Vertices que recebem as ligacoes
	 * @param arrayPesos, Colecao de Doubles que armazenam os pesos de cada aresta
	 * @author Luan C
	 * @version 1.0
	 */
	public WeightedGraph(int qtdVertices, Integer[] arrayOrigem, Integer[] arrayDestino, Double[] arrayPesos) {
		super(qtdVertices, arrayOrigem, arrayDestino);
		this.arrayPesos = arrayPesos;
	}

	// gets e sets
	
	public int getQtdVertices() {
		return qtdVertices;
	}

	public Integer[] getArrayOrigim() {
		return arrayOrigem;
	}

	public Integer[] getArrayDestino() {
		return arrayDestino;
	}

	public Double[] getArrayPesos() {
		return arrayPesos;
	}
	
	public int getQtdArestas() {
		return arrayOrigem.length;
	}
}
