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
 * Objeto WeightedGraph
 * @author Luan C
 * @version 1.0
 */
public class WeightedGraph extends Graph {

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
	
	/**
	 * Metodo de representacao AM
	 * @return matrizResposta, String com a representacao do grafo
	 * @author Tatiane Andrade
	 * @version 1.0
	 */
	@Override
	public String graphRepresentationAM () {
		String matrizResposta = "  ";
		String[][] matriz = new String[qtdVertices][qtdVertices];
		for(int j = 0; j < matriz.length; j++) {
			for(int k = 0; k < matriz.length; k++) {
				matriz[j][k] = "0";
			}
		}
		for(int i = 0; i < arrayOrigem.length; i++) {
			matriz[arrayOrigem[i]-1][arrayDestino[i]-1] = arrayPesos[i] +"";
			matriz[arrayDestino[i]-1][arrayOrigem[i]-1] = arrayPesos[i] + "";
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
	 * @author Tatiane Andrade
	 * @version 1.0
	 */
	public String graphRepresentationAL() {
		 Map<Integer, ArrayList<String>> AL = new HashMap<Integer,ArrayList<String>>();
		 int flag = 1;
		 ArrayList<String> ligacoes;
		 while(flag <= this.qtdVertices){
			 ligacoes = new ArrayList<String>();
			 for (int i = 0; i < arrayOrigem.length; i++) {
				 if(arrayOrigem[i] == flag){
					 ligacoes.add(arrayDestino[i]+"("+arrayPesos[i]+")");
				 }
				 if(arrayDestino[i] == flag) {
					 ligacoes.add(arrayOrigem[i]+"("+arrayPesos[i]+")");
				 }
			 }
			 ligacoes.sort((o1, o2) -> o1.charAt(0) - o2.charAt(0));
			 AL.put(flag, ligacoes);
			 flag++;
		 }
		 String retorno = "";
		 String ligacao = "";
		 for (int i = 1; i < flag; i++) {
			 for (String valor : AL.get(i)) {
				ligacao += " " + valor;
			}			
			retorno += N + i + " -" + ligacao;
			ligacao = "";
		}
		return retorno;
	}

	// gets e sets
	

	public Double[] getArrayPesos() {
		return arrayPesos;
	}
	
}
