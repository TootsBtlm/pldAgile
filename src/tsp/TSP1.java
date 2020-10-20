package tsp;

import java.util.Collection;
import java.util.Iterator;

public class TSP1 extends TemplateTSP {
	@Override
	protected int bound(Integer currentVertex, Collection<Integer> unvisited) {
		int l = cheapestNeighbour(currentVertex, unvisited); //l is cheapest arc from current to unvisited
		Iterator<Integer> it = iterator(unvisited.iterator().next(), unvisited, g); //on cree un iterator a partir d'un element aléatoire
		int total = 0;
		while(it.hasNext()) {
			int next = it.next();
			int min = cheapestNeighbour(next, unvisited);
			int c = g.getCost(next, 0);
			if(c < min) min = c; // min is the cheapest arc from the current unvisited element to another unvisited or to 0
			total+=min;
		}
		return (l + total);
	}

	@Override
	protected Iterator<Integer> iterator(Integer currentVertex, Collection<Integer> unvisited, Graph g) {
		return new SeqIter(unvisited, currentVertex, g);
	}
	
	protected Integer cheapestNeighbour(Integer origin, Collection<Integer> unvisited) { //origin can be or not part of the unvisited
		Iterator<Integer> it = iterator(origin, unvisited, g);
		int min = Integer.MAX_VALUE;
		while(it.hasNext()) {
			int dest = it.next();
			int c = g.getCost(origin, dest);
			if(c != -1 && c < min) {
				min = c;
			}
		}
		return min;
	}

}
