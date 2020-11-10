package modele;

import java.util.*;

import javafx.util.Pair;


public class SeqIter implements Iterator<Integer> {
	ArrayList<Integer> candidates;
	private Graph g;

	/**
	 * Create an iterator to traverse the set of vertices in <code>unvisited</code> 
	 * which are successors of <code>currentVertex</code> in <code>g</code>
	 * Vertices are traversed in the same order as in <code>unvisited</code>
	 * @param unvisited
	 * @param currentVertex
	 * @param g
	 */
	public SeqIter(Collection<Integer> unvisited, Collection<Integer> visited, int currentVertex, Graph g, ArrayList<Pair<Integer, Integer>> paires){
		this.g = g;
		this.candidates = new ArrayList<Integer>(unvisited.size()+1);
		for (Integer s : unvisited){
			if (g.isArc(currentVertex, s))
				for(Pair<Integer, Integer> p : paires) {
					Integer key = p.getKey();
					Integer value = p.getValue();
					if(s == key) {
						candidates.add(s);
						break;
					}else if(s == value) {
						if(visited.contains(key) || currentVertex == key) {
							candidates.add(s);
							break;
						}
					}
				}
		}
	}
	
	@Override
	public boolean hasNext() {
		return !candidates.isEmpty();
	}

	@Override
	public Integer next() {
		return candidates.remove(candidates.size()-1); //return and remove last element
	}
	
	
	/**
	 * Improved next() method
	 * @param origin
	 * @param paires
	 * @param visited
	 * @return cheapest available neighbor
	 */
	protected Integer bestNext(Integer origin, ArrayList<Pair<Integer, Integer>> paires, Collection<Integer> visited) { //origin can be or not part of the unvisited
		double min = Integer.MAX_VALUE;
		int minVertex = -1; //id of cheapest neighbour
		
		Iterator<Integer> it = new SeqIter(candidates, visited, origin, g, paires);
		 
		while(it.hasNext()) {
			int dest = it.next();
			double c = g.getCost(origin, dest);
			if(c != -1 && c < min) {
				min = c;
				minVertex = dest;
			}
		}
		return candidates.remove(candidates.indexOf(minVertex));
	}
	

	@Override
	public void remove() {}

}
