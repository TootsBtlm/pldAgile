package modele;

import java.util.ArrayList;

import javafx.util.Pair;

public class RunTSP {
	public static void main(String[] args) {
		TSP tsp = new TSP1();
		int nbVertices = 15;
		ArrayList<Pair<Integer, Integer>> paires = new ArrayList<>((nbVertices-1)/2);
		for(int i = 0; i<nbVertices-1; i+=2)
			paires.add(new Pair<Integer, Integer>(i, i+1));
		//paires.add(new Pair<Integer, Integer>(0, 2));
			
		double[][] cost = new double[nbVertices][nbVertices];
		
		int iseed = 1;
		for (int i=0; i<nbVertices; i++){
		    for (int j=0; j<nbVertices; j++){
		        if (i == j) cost[i][j] = -1;
		        else {
		            int it = 16807 * (iseed % 127773) - 2836 * (iseed / 127773);
		            if (it > 0)	iseed = it;
		            else iseed = 2147483647 + it;
		            cost[i][j] = 10 + iseed % (40-10+1);
		        }
		    }
		}
		Integer depart = 14;
		long startTime = System.currentTimeMillis();
		tsp.searchSolution(30000, cost, paires, depart);
		System.out.print("Solution of cost "+tsp.getSolutionCost()+" found in "
				+(System.currentTimeMillis() - startTime)+"ms : ");
		for (int i=0; i<nbVertices; i++)
			System.out.print(tsp.getSolution(i)+" ");
		System.out.println(depart);
	}
	
	/*public static void test () {
		TSP tsp = new TSP1();
		for (int nbVertices = 8; nbVertices <= 24; nbVertices += 2){
			System.out.println("Graphs with "+nbVertices+" vertices:");
			Graph g = new CompleteGraph(nbVertices);
			long startTime = System.currentTimeMillis();
			//tsp.searchSolution(30000, g);
			System.out.print("Solution of cost "+tsp.getSolutionCost()+" found in "
					+(System.currentTimeMillis() - startTime)+"ms : ");
			for (int i=0; i<nbVertices; i++)
				System.out.print(tsp.getSolution(i)+" ");
			System.out.println("0");
		}
	}*/

}
