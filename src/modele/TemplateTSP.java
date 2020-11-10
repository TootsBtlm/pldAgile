package modele;

import java.util.*;
import javafx.util.*;


public abstract class TemplateTSP implements TSP {
	private Integer[] bestSol;
	protected Graph g;
	private double bestSolCost;
	private int timeLimit;
	private long startTime;
	
	public Integer[] searchSolution(int timeLimit, double[][] cout, ArrayList<Pair<Integer, Integer>> paires, Integer depart){
		if (timeLimit <= 0) return null;
		startTime = System.currentTimeMillis();	
		this.timeLimit = timeLimit;
		this.g = new CompleteGraph(cout);
		bestSol = new Integer[g.getNbVertices()];
		Collection<Integer> unvisited = new ArrayList<Integer>(g.getNbVertices()-1);
		for (int i=0; i<g.getNbVertices(); i++) {
			if(i != depart)
				unvisited.add(i);
		}
		Collection<Integer> visited = new ArrayList<Integer>(g.getNbVertices());
		visited.add(depart); // The first visited vertex is 0
		bestSolCost = Integer.MAX_VALUE;
		branchAndBound(depart, depart, unvisited, visited, 0.0, paires);
		return bestSol;
	}
	
	public Integer getSolution(int i){
		if (g != null && i>=0 && i<g.getNbVertices())
			return bestSol[i];
		return -1;
	}
	
	public double getSolutionCost(){
		if (g != null)
			return bestSolCost;
		return -1;
	}
	
	/**
	 * Method that must be defined in TemplateTSP subclasses
	 * @param currentVertex
	 * @param unvisited
	 * @return a lower bound of the cost of paths in <code>g</code> starting from <code>currentVertex</code>, visiting 
	 * every vertex in <code>unvisited</code> exactly once, and returning back to vertex <code>0</code>.
	 */
	protected abstract double bound(Integer depart, Integer currentVertex, Collection<Integer> unvisited, Collection<Integer> visited, ArrayList<Pair<Integer, Integer>> paires);
	
	/**
	 * Method that must be defined in TemplateTSP subclasses
	 * @param currentVertex
	 * @param unvisited
	 * @param g
	 * @return an iterator for visiting all vertices in <code>unvisited</code> which are successors of <code>currentVertex</code>
	 */
	protected abstract Iterator<Integer> iterator(Integer currentVertex, Collection<Integer> unvisited, Collection<Integer> visited, Graph g, ArrayList<Pair<Integer, Integer>> paires);
	
	/**
	 * Template method of a branch and bound algorithm for solving the TSP in <code>g</code>.
	 * @param currentVertex the last visited vertex
	 * @param unvisited the set of vertex that have not yet been visited
	 * @param visited the sequence of vertices that have been already visited (including currentVertex)
	 * @param currentCost the cost of the path corresponding to <code>visited</code>
	 */	
	private void branchAndBound(final int depart, int currentVertex, Collection<Integer> unvisited, 
			Collection<Integer> visited, double currentCost, ArrayList<Pair<Integer, Integer>> paires){
				if (System.currentTimeMillis() - startTime > timeLimit) return;
	    if (unvisited.size() == 0){
	    	if (g.isArc(currentVertex, depart)){ 
	    		if (currentCost+g.getCost(currentVertex,depart) < bestSolCost){ 
	    			visited.toArray(bestSol);
	    			bestSolCost = currentCost+g.getCost(currentVertex,depart);
	    		}
	    	}
	    } else if (currentCost+bound(depart, currentVertex,unvisited, visited, paires) < bestSolCost){
	    	
	        SeqIter it = (SeqIter) iterator(currentVertex, unvisited, visited, g, paires);
	        int pivotVertex = currentVertex;
	        while (it.hasNext()){
	        	//System.out.println("unvisited: "+unvisited);
	        	Integer nextVertex = it.bestNext(pivotVertex, paires, visited);
	        	if(nextVertex!=-1) {
		        	pivotVertex = nextVertex;
		        	visited.add(nextVertex);
		            unvisited.remove(nextVertex);
		            branchAndBound(depart, nextVertex, unvisited, visited, 
		            		currentCost+g.getCost(currentVertex, nextVertex), paires);
		            visited.remove(nextVertex);
		            unvisited.add(nextVertex);
	        	}else break;
	        }	    
	    }
	}
}
