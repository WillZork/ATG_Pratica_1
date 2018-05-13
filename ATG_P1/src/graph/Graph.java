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
 * @version 1.0
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
	 * @author Luan C
	 * @version 1.0
	 */
	public Graph(int qtdVertices, Integer[] arrayOrigem, Integer[] arrayDestino) {
		this.qtdVertices = qtdVertices;
		this.arrayDestino = arrayDestino;
		this.arrayOrigem = arrayOrigem;
	}
	
	/**
	 * Metodo de representacao AM
	 * @return matrizResposta, String com a representacao do grafo
	 * @author Tatiane Andrade
	 * @version 1.0
	 */
	public String graphRepresentationAM () {
		String matrizResposta = "  ";
		Integer[][] matriz = new Integer[qtdVertices][qtdVertices];
		for(int j = 0; j < matriz.length; j++) {
			for(int k = 0; k < matriz.length; k++) {
				matriz[j][k] = 0;
			}
		}
		for(int i = 0; i < arrayOrigem.length; i++) {
			matriz[arrayOrigem[i]-1][arrayDestino[i]-1] = 1;
			matriz[arrayDestino[i]-1][arrayOrigem[i]-1] = 1;
		}
		for(int m = 1; m <= qtdVertices; m++) {
			matrizResposta += m + " ";
		}
		for(int j = 0; j < matriz.length; j++) {
			matrizResposta += "\n" + (j+1) + " ";
			for(int k = 0; k < matriz.length; k++) {
				matrizResposta += matriz[j][k] + " ";
			}
		}
		return matrizResposta;
	}
	
	public void graphRepresentationAL() {
		// TODO Auto-generated method stub
		
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
	
	public int getQtdArestas() {
		return arrayOrigem.length;
	}
}
