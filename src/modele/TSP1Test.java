package modele;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import javafx.util.Pair;

public class TSP1Test {
	TSP1 tsp;
	int nbVertices;
	double[][] cost;
	ArrayList<Pair<Integer, Integer>> paires;
	
	@Before
	public void initialisation() {
		tsp = new TSP1();
		
		nbVertices = 5;
		
		cost = new double[nbVertices][nbVertices];
		
		paires =  new ArrayList<>((nbVertices-1)/2);
		
		
		
		cost[0][1] = 1;
		cost[0][2] = 2;
		cost[0][3] = 2;
		cost[0][4] = 1;
		cost[1][0] = 1;
		cost[1][2] = 1;
		cost[1][3] = 2;
		cost[1][4] = 2;
		cost[2][0] = 2;
		cost[2][1] = 1;
		cost[2][3] = 1;
		cost[2][4] = 2;
		cost[3][0] = 2;
		cost[3][1] = 1;
		cost[3][2] = 1;
		cost[3][4] = 1;
		cost[4][0] = 1;
		cost[4][1] = 2;
		cost[4][2] = 2;
		cost[4][3] = 1;
		for(int i = 0; i<nbVertices; ++i) {
			cost[i][i] = -1;
		}
	}
	
	/**
	 * Teste que l'algo retourne la route logique pour un graphe de taille 5 avec des précédences prédéfinies
	 */
	@Test
	public void testSearchSolution1() {
		paires.add(new Pair<Integer, Integer>(1, 3));
		paires.add(new Pair<Integer, Integer>(2, 4));
		Integer[] bestSol = tsp.searchSolution(30000, cost, paires, 0);
		for(int i = 0; i< bestSol.length; ++i) {
			System.out.println(bestSol[i]);
			assertEquals((Integer)i, bestSol[i]);
		}
	}
	
	@Test
	public void testSearchSolution2() {
		paires.add(new Pair<Integer, Integer>(3, 1));
		paires.add(new Pair<Integer, Integer>(2, 0));
		Integer[] bestSol = tsp.searchSolution(30000, cost, paires, 4);
		for(int i = 0; i< bestSol.length; ++i) {
			System.out.println(bestSol[i]);
			assertEquals(nbVertices-i-1, (int)bestSol[i]);
		}
	}
	
	@Test
	public void testBound1(){
		tsp.searchSolution(30000, cost, paires, 0);
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> unvisited = new ArrayList<Integer>();
		visited.add(0);
		visited.add(1);
		unvisited.add(2);
		unvisited.add(3);
		unvisited.add(4);
		double bound = tsp.bound(0, 1, unvisited, visited, paires);
		System.out.println("\nlower bound: "+bound);
		assertTrue(bound <= 4.0);
	}
	
	@Test
	public void testBound2(){
		tsp.searchSolution(30000, cost, paires, 0);
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> unvisited = new ArrayList<Integer>();
		visited.add(0);
		unvisited.add(1);
		unvisited.add(2);
		unvisited.add(3);
		unvisited.add(4);
		double bound = tsp.bound(0, 0, unvisited, visited, paires);
		System.out.println("\nlower bound: "+bound);
		assertTrue(bound <= 5.0);
	}
}
