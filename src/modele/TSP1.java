package modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javafx.util.Pair;

public class TSP1 extends TemplateTSP {
	@Override
	protected double bound(Integer depart, Integer currentVertex, Collection<Integer> unvisited, Collection<Integer> visited, ArrayList<Pair<Integer, Integer>> paires) {
		double l = cheapestNeighbour(currentVertex, unvisited, visited, paires); //l is cheapest arc from current to unvisited
		Iterator<Integer> it = iterator(unvisited.iterator().next(), unvisited, visited, g, paires); //on cree un iterator a partir d'un element aléatoire
		double total = 0;
		while(it.hasNext()) {
			int next = it.next();
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
	
	protected double cheapestNeighbour(Integer origin, Collection<Integer> unvisited, Collection<Integer> visited, ArrayList<Pair<Integer, Integer>> paires) { //origin can be or not part of the unvisited
		Iterator<Integer> it = iterator(origin, unvisited, visited, g, paires);
		double min = Integer.MAX_VALUE;
		while(it.hasNext()) {
			int dest = it.next();
			double c = g.getCost(origin, dest);
			if(c != -1 && c < min) {
				min = c;
			}
		}
		return min;
	}
}