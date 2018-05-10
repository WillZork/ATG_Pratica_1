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
 * Objeto Graph
 * @author Luan C
 *
 */
public class Graph {
	private int qtdVertices;
	private Integer[] arrayOrigem;
	private Integer[] arrayDestino;

	/**
	 * Construtor do Graph
	 * @param qtdVertices, Integer com a quantidade de Vertices
	 * @param arrayOrigem, Colecao armazenando os Vertices que originam as ligacoes
	 * @param arrayDestino, Colecao que armazeda os Vertices que recebem as ligacoes
	 */
	public Graph(int qtdVertices, Integer[] arrayOrigem, Integer[] arrayDestino) {
		this.qtdVertices = qtdVertices;
		this.arrayDestino = arrayDestino;
		this.arrayOrigem = arrayOrigem;
	}

	public int getQtdVertices() {
		return qtdVertices;
	}

	public Integer[] getArrayOrigim() {
		return arrayOrigem;
	}

	public Integer[] getArrayDestino() {
		return arrayDestino;
	}
}
