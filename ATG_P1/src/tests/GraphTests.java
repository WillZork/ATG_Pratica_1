/**
 * 
 * Classe de teste
 * 
 * @author Marcos Junior
 * @version 1.0
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import graph.Graph;

public class GraphTests {

	Controller grafos;
	Graph grafo;
	int vertices;
	Integer[] ArrayO = new Integer[]{1, 2, 5, 4, 1};
	Integer[] ArrayD = new Integer[]{2, 5, 3, 5, 5};
	
	@Before
	public void setUp() throws Exception {
		grafos = new Controller();
		vertices = 5;
		grafo = grafos.criaGrafo(vertices, ArrayO, ArrayD);		
	}
	
	/**
	 * 
	 * @author Marcos Junior
	 * @versao 1.0
	 * 
	 */

	@Test
	public void testGetVertexNumber() {
		try {
			assertEquals(vertices, grafos.getVertexNumber(grafo));
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	/**
	 * 
	 * @author Marcos Junior
	 * @versao 1.0
	 * 
	 */
	@Test
	public void testGetEdgeNumber() {
		try {
			assertEquals(ArrayO.length, grafos.getEdgeNumber(grafo));
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	/**
	 * 
	 * @author Marcos Junior
	 * @versao 1.0
	 * 
	 */
	@Test
	public void testGetMeanEdge() {
		try {
			assertEquals(2.0, grafos.getMeanEdge(grafo), 0.001);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	/**
	 * 
	 * @author Marcos Junior
	 * @versao 1.0
	 * 
	 */
	@Test
	public void testGraphRepresentationAM() {
		String represetation = "  1 2 3 4 5 "
							 + "\n1 0 1 0 0 1 "
							 + "\n2 1 0 0 0 1 "
							 + "\n3 0 0 0 0 1 "
							 + "\n4 0 0 0 0 1 "
							 + "\n5 1 1 1 1 0 ";
		try {
			assertEquals(represetation, grafos.graphRepresentation(grafo, "AM"));
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	/**
	 * 
	 * @author Marcos Junior
	 * @versao 1.0
	 * 
	 */
	@Test
	public void testGraphRepresentationAL() {
		String represetation = "\n1 - 2 5"
							 + "\n2 - 1 5"
							 + "\n3 - 5"
							 + "\n4 - 5"
							 + "\n5 - 1 2 3 4";
		try {
			assertEquals(represetation, grafos.graphRepresentation(grafo, "AL"));
		}catch (Exception e) {
			fail(e.getMessage());
		}
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
