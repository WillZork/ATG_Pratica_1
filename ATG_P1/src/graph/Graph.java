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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Objeto Graph
 * @author Luan C
 * @version 1.0
 */
public class Graph {
	protected int qtdVertices;
	protected Integer[] arrayOrigem;
	protected Integer[] arrayDestino;
	protected static final String N = System.lineSeparator();

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
	 * Retorna o grau medio do grafo
	 * @return Float
	 * @author Luan C
	 * @version 1.0
	 */
	public float getMeanEdge() {
		float retorno = 0;
		retorno = (float) ((2.0 * getQtdArestas()) * (1.0/getQtdVertices())); 
		return retorno;
	}
	
	/**
	 * Metodo de representacao AM
	 * @return matrizResposta, String com a representacao do grafo
	 * @author Tatiane Andrade
	 * @version 1.0
	 * @author Luan C
	 * @version 1.1
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
	
	/**
	 * Metodo de representacao AL
	 * @return matrizResposta, String com a representacao do grafo
	 * @author Luan C
	 * @version 1.0
	 * @author Tatiane Andrade
	 * @version 1.1
	 */
	public String graphRepresentationAL() {
		 Map<Integer, ArrayList<Integer>> AL = new HashMap<Integer,ArrayList<Integer>>();
		 int flag = 1;
		 ArrayList<Integer> ligacoes;
		 while(flag <= this.qtdVertices){
			 ligacoes = new ArrayList<Integer>();
			 for (int i = 0; i < arrayOrigem.length; i++) {
				 if(arrayOrigem[i] == flag){
					 ligacoes.add(arrayDestino[i]);
				 }
				 if(arrayDestino[i] == flag) {
					 ligacoes.add(arrayOrigem[i]);
				 }
			 }
			 ligacoes.sort((o1, o2) -> o1 - o2);
			 AL.put(flag, ligacoes);
			 flag++;
		 }
		 String retorno = "";
		 String ligacao = "";
		 for (int i = 1; i < flag; i++) {
			 for (Integer valor : AL.get(i)) {
				ligacao += " " + valor;
			}			
			retorno += N + i + " -" + ligacao;
			ligacao = "";
		}
		return retorno;
	}

	// gets e sets 
	
	public int getQtdVertices() {
		return qtdVertices;
	}

	public Integer[] getArrayOrigem() {
		return arrayOrigem;
	}

	public Integer[] getArrayDestino() {
		return arrayDestino;
	}
	
	public int getQtdArestas() {
		return arrayOrigem.length;
	}
}
