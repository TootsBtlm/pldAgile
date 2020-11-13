package modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javafx.util.Pair;

public class TSP1 extends TemplateTSP {
	@Override
	public double bound(Integer depart, Integer currentVertex, Collection<Integer> unvisited, Collection<Integer> visited, ArrayList<Pair<Integer, Integer>> paires) {
		double l = cheapestNeighbour(currentVertex, unvisited, visited, paires); //l is cheapest arc from current to unvisited
		SeqIter it = new SeqIter(unvisited, visited, currentVertex, g, paires); //on cree un iterator a partir d'un element aléatoire
		double total = 0;
		int next=0;
		while(it.hasNeighbour()) {
			next = it.simpleNext();
			double min = cheapestNeighbour(next, unvisited, visited, paires);
			double c = g.getCost(next, depart);
			if(c < min) min = c; // min is the cheapest arc from the current unvisited element to another unvisited or to 0
			total+=min;
		}
		return (l + total);
	}

	@Override
	protected Iterator<Integer> iterator(Integer currentVertex, Collection<Integer> unvisited, Collection<Integer> visited, Graph g, ArrayList<Pair<Integer, Integer>> paires) {
		return new SeqIter(unvisited, visited, currentVertex, g, paires);
	}
	
	/**
	 * 
	 * @param origin
	 * @param unvisited
	 * @param visited
	 * @param paires
	 * @return Cost of the cheapest neighbor available in unvisited
	 */
	protected double cheapestNeighbour(Integer origin, Collection<Integer> unvisited, Collection<Integer> visited, ArrayList<Pair<Integer, Integer>> paires) { //origin can be or not part of the unvisited
		SeqIter it = new SeqIter(unvisited, visited, origin, g, paires);
		double min = Integer.MAX_VALUE;
		while(it.hasNeighbour()) {
			int dest = it.simpleNext();
			double c = g.getCost(origin, dest);
			if(c != -1 && c < min) {
				min = c;
			}
		}
		return min;
	}
}