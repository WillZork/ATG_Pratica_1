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
import java.util.Stack;

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
	
	/**
	 * @version 1.0
	 * @author Marcos Junior
	 * @param v
	 * @return
	 */
	public String DFS(int v) {
		ArrayList<Integer> vertices = procuraVertices();
		ArrayList<Integer> arvore = Arvore(v);
		String retorno = "";
		Stack<Integer> pilha = new Stack<Integer>();
		int i = 0;
		int j = 0;
		Integer left = arvore.get(left(i));
		Integer right = arvore.get(right(i)); 
		pilha.push(i);
		while(!pilha.isEmpty() && left(i) <= arvore.size() && right(i) <= arvore.size()) {		


			left  = arvore.get(left(i));
			right = arvore.get(right(i));	
			if(left < right && left > -1 && !pilha.contains(left(i))) {
				pilha.push(left(i));
				retorno += left;
				j = i;
				i = left(i);
			}else if(right > -1 && !pilha.contains(right(i))) {
				pilha.push(right(i));
				j = i;
				i = right(i);
				retorno += right;
			}else {
				i = j;
			}
		}
		return retorno;
	}
	
	/**
	 * @version 1.0
	 * @author Marcos Junior
	 * @param v
	 * @return
	 */
	public String BFS(int v) {
		ArrayList<Integer> vertices = procuraVertices();
		ArrayList<Integer> arvore = Arvore(v);
		String retorno = "";
		for(int i = 0; i < vertices.size(); i++) {
			retorno += vertices.get(i) + " - ";
			if(v == vertices.get(i)) 
				retorno += "0 -";
			else {
				retorno += level(arvore, vertices.get(i)) + " " + parent(arvore, vertices.get(i));
			}
			retorno += "\n";
		}
		return retorno;
	}
	/**
	 * @version 1.0
	 * @author Marcos Junior
	 * @param v
	 * @return
	 */
	private int parent(ArrayList<Integer> arvore, int no) {
		return arvore.get((arvore.indexOf(no) - 1) / 2);
	}
	/**
	 * @version 1.0
	 * @author Marcos Junior
	 * @param v
	 * @return
	 */
	private int right(int i) {
	      return (i * 2 + 1) + 1;
	}
	/**
	 * @version 1.0
	 * @author Marcos Junior
	 * @param v
	 * @return
	 */
	private int left(int i) {
	      return (i * 2 + 1);
	}
	/**
	 * @version 1.0
	 * @author Marcos Junior
	 * @param v
	 * @return
	 */
	private int level(ArrayList<Integer> arvore, int no) {
		int quantidade = 0;
		int posicao = arvore.indexOf(no);
		int i = 0;
		while(quantidade < posicao) {
			int total = quantidade + (int) Math.pow(2, i);
			if (total < posicao + 1) {
				i++;
			}
			quantidade = total;
		}
		return i;
	}
	
	/**
	 * @version 1.0
	 * @author Marcos Junior
	 * @param v
	 * @return
	 */
	private ArrayList<Integer> Arvore(int v) {
		
		ArrayList<Integer> retorno = new ArrayList<>();
		retorno.add(v);
		int verticeDaVez;
		for(int j = 0; j < getQtdVertices(); j++) {
			int tamanho = retorno.size();
			verticeDaVez = retorno.get(j);
			for(int i = 0; i < arrayOrigem.length; i ++) {
				if(verticeDaVez == arrayOrigem[i] && !retorno.contains(arrayDestino[i])) {
					retorno.add(arrayDestino[i]);
				}
				if(verticeDaVez == arrayDestino[i] && !retorno.contains(arrayOrigem[i])) {
					retorno.add(arrayOrigem[i]);
				}
			}
			if(tamanho == retorno.size()) {
				retorno.add(-1);
				retorno.add(-1);
			}
		}
		return retorno;
	}
	/**
	 * @version 1.0
	 * @author Marcos Junior
	 * @param v
	 * @return
	 */
	private ArrayList<Integer> procuraVertices() {
		ArrayList<Integer> vertices = new ArrayList<Integer>();
		
		for(int i = 0; i < arrayOrigem.length; i++) {
			Integer origem = arrayOrigem[i];
			Integer destino = arrayDestino[i];
			if(!vertices.contains(origem)) {
				vertices.add(origem);
			}
			if(!vertices.contains(destino)) {
				vertices.add(destino);
			}
		}
		vertices.sort((o1, o2) -> o1 - o2);
		return vertices;
	}
	/**
	 * Verifica se o Graph esta cadastrado
	 * 
	 * 
	 * @version 1.0
	 * @author Luan C
	 * @param v
	 * @return boolean
	 */
	public boolean connected() {
		boolean retorno = true;
		Integer[] origem = arrayOrigem;
		Integer[] destino = arrayDestino;
		for (int i = 0; i < destino.length; i++) {
			if(destino[i] == null || origem[i] == null)
				retorno = false;
		}
		return retorno;
	}
}


