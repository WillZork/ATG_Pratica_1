/**
 * UFCG - Universidade Federal de Campina Grande
 * Aplicacao de Teoria dos Grafos
 * - Luan Carlos da Silva Bezerra
 * -
 * -
 * -
 * -
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import graph.Graph;

public class WeightedGraphTests {
	Controller grafos;
	Graph grafo;
	int vertices;
	Integer[] ArrayO = new Integer[]{1, 2, 5, 3, 4, 1};
	Integer[] ArrayD = new Integer[]{2, 5, 3, 4, 5, 5};
	Double [] ArrayP = new Double[] {0.1, 0.2, 5.0, -9.5, 2.3, 1.0};
	@Before
	public void setUp() {
		grafos = new Controller();
		vertices = 5;
		grafo = grafos.criaGrafoComPeso(vertices, ArrayO, ArrayD, ArrayP);
	}
	
	@Test
	public void testGetVertexNumber() throws Exception {
		assertEquals(vertices, grafos.getVertexNumber(grafo));	
	}
	
	@Test
	public void testGetEdgeNumber() throws Exception {
		assertEquals(6, grafos.getEdgeNumber(grafo));
	}
	
	@Test
	public void testGetMeanEdge() {
		assertEquals(2.4, grafos.getMeanEdge(grafo), 0.001);
	}
	
	@Test
	public void testGraphRepresentationAM() throws Exception {
		String represetation = "  1 2 3 4 5 "
						 + "\n1 0 0.1 0 0 1 "
						 + "\n2 0.1 0 0 0 0.2 "
						 + "\n3 0 0 0 -9.5 5 "
						 + "\n4 0 0 -9.5 0 2.3 "
						 + "\n5 1 0.2 5 2.3 0 ";
		assertEquals(represetation, grafos.graphRepresentation(grafo, "AM"));
	}
	
	@Test
	public void testGraphRepresentationAL() throws Exception {
		String represetation = "\n1 - 2(0.1) 5(1)"
						   +"\n2 - 1(0.1) 5(0.2)"
						   +"\n3 - 4(-9.5) 5(5)"
						   +"\n4 - 3(-9.5) 5(2.3)"
						   +"\n5 - 1(1) 2(0.2) 3(5) 4(2.3)";
		assertEquals(represetation, grafos.graphRepresentation(grafo, "AL"));
	}
	
	@Test
	public void testBFS() {
		
	}
	
	@Test
	public void testDFS() {
		
	}
	
	@Test
	public void testConnected() {
		
	}
	
	@Test
	public void testShortestPath() {
		
	}
	
	@Test
	public void testMst() {
		
	}

}
