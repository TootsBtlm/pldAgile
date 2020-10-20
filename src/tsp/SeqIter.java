package tsp;

import java.util.*;


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
	public SeqIter(Collection<Integer> unvisited, int currentVertex, Graph g){
		this.g = g;
		this.candidates = new ArrayList<Integer>(unvisited.size()+1);
		for (Integer s : unvisited){
			if (g.isArc(currentVertex, s))
				candidates.add(s);
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
	
	protected Integer bestNext(Integer origin) { //origin can be or not part of the unvisited
		int min = Integer.MAX_VALUE;
		int minVertex = -1; //id of cheapest neighbour
		
		Iterator<Integer> it = new SeqIter(candidates, origin, g);
		 
		while(it.hasNext()) {
			int dest = it.next();
			int c = g.getCost(origin, dest);
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
