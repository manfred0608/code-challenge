package edu.cmu.manfred.tests.unit_tests;

import edu.cmu.manfred.types.EdgeNode;
import edu.cmu.manfred.types.GameGraph;
import edu.cmu.manfred.types.GameState;
import edu.cmu.manfred.types.NameNode;

public class BuildGraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameGraph graph = new GameGraph();
		String[] testcase = {"Elton John", "John Lennon", "James Elton", "Lebron James", "James Faulkner"};
		
		if(graph.initGraph(testcase) == GameState.SUCCESS){
			int size = graph.getSize();
			
			for(int i = 0; i < size; i++){
				NameNode node = graph.getNode(i);
				EdgeNode edge = node.getFirstNode();
				String s = node.getFirstName() + " " + node.getLastName();
				while(edge != null){
					s += (" -> " + edge.getIndex());
					edge = edge.getNext();
				}
				s += "-> \\";
				System.out.println(s);
			}
		}
	}

}
