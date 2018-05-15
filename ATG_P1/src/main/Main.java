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

import java.util.Arrays;
import java.util.Scanner;

import controller.Controller;
import graph.Graph;
import graph.WeightedGraph;
import reader.InputFileReader;

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
	 * @author Luan C, Williamberg Ferreira
	 * @version 1.1
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		controlador = new Controller();
		menu();
	}
	
	public static void menu() throws Exception {
		String option;
		String filePath;
		
		while (true) {
			System.out.println();
			System.out.println("============== Pr�tica 01 - ATG 2018.1 - UFCG ==============");
			System.out.println("(Biblioteca de grafos desenvolvida para o curso de aplica��es de teoria dos grafos.)");
			System.out.println("\nO que voce deseja fazer??");
			System.out.println("\n-Pressione 1 para ler um grafo n�o ponderado a partir de um arquivo .txt");
			System.out.println("\n-Pressione 2 para ler um grafo ponderado a partir de um arquivo .txt");
			System.out.println("-Pressione 3 para sair");
		
			Scanner input = new Scanner(System.in);
			System.out.print("\nDigite uma opcao valida: ");
			option = input.nextLine();
		
			if (option.equals("1")) {
				System.out.println("\n===== Leitura de Grafo =====");
				System.out.print("\nDigite o caminho do arquivo .txt: ");
				filePath = input.nextLine();
				controlador.readGraph(filePath);
			} else if (option.equals("2")) {
				break;
			} else if (option.equals("3")) {
				break;
			} else {
				System.out.println("\nPor favor, digite uma opcao valida!");
			}
		}
	}

}
