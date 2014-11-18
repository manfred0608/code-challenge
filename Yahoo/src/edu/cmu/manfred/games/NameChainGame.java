package edu.cmu.manfred.games;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.manfred.types.EdgeNode;
import edu.cmu.manfred.types.GameGraph;
import edu.cmu.manfred.types.GameState;
import edu.cmu.manfred.types.NameNode;

;

//Controler of the NameChainGame
//Singleton patter is applied to assure the single instance
public class NameChainGame {
	// Staus flag, whether a name node is visited
	// during each round of search
	private static int VISITED = 1;
	private static int NOTVISITED = 0;

	// The longest name result
	// might contains several result with the same length
	private List<String> res;

	// The number of nodes connected on the longest route
	private int maxLevel = 0;

	// Singleton NameChainGame instance in a game
	private static NameChainGame game = null;

	// Stores the graph in the current game
	private GameGraph graph = null;

	// Private Constructors for singleton pattern
	private NameChainGame() {
		res = new ArrayList<String>();
	}

	// Get instance methods for implementing singleton pattern
	public static NameChainGame getInstance() {
		if (game == null)
			return new NameChainGame();
		else
			return game;
	}

	// Starting a new game when persons name input changes
	public void newGame(String[] names) throws Exception {
		// Invalid input check
		if (names == null || names.length == 0)
			throw new Exception("No input from file! Please start a new game.");

		// Re-initialized the graph
		// Return with the STATUS of initialization
		graph = new GameGraph();
		int res = graph.initGraph(names);
		if (res == GameState.SUCCESS)
			run();
		else
			throw new Exception(
					"People names input is invalid! Please start a new game.");
		return;
	}

	// Iterate through all the name nodes
	// Starting with each node for dfs
	// finding the longest route
	// Time Complexity: O(N + E)
	// with N: the number of name nodes
	// E: the number of edge nodes
	private void run() {
		for (int i = 0; i < graph.getSize(); i++) {
			int[] states = new int[graph.getSize()];

			NameNode current = graph.getNode(i);
			dfs(current, i, states, 1,
					current.getFirstName() + " " + current.getLastName());
		}
		return;
	}

	// Start with the current node, go to all the adjacent nodes pointing to
	// Storing the level and current longest string
	// Also the states array telling whether the name node has been visited in a
	// single round of search
	private void dfs(NameNode node, int index, int[] states, int level, String s) {
		// Get the first edge on the linked list
		EdgeNode curEdge = node.getFirstNode();
		// Mark the current name node as VISITED
		states[index] = VISITED;
		// Update level with adding one
		level++;

		// If there is no out-degree of the name node, end the current search
		// After that, updating the longest route information
		if (curEdge == null) {
			if (level > maxLevel) {
				maxLevel = level;
				res.clear();
				res.add(s);
			} else if (level == maxLevel) {
				res.add(s);
			}
		}

		// If there is any out-degree of the current name node,
		// for each, dfs goes to a deeper level
		while (curEdge != null) {
			// If the name node that the edge pointing have not been visited
			if (states[curEdge.getIndex()] == NOTVISITED) {
				NameNode name = graph.getNode(curEdge.getIndex());
				// DFS continues with the next name node
				dfs(name, curEdge.getIndex(), states, level,
						s + " " + name.getLastName());

				// If the name node that the edge pointing have been visited
				// Stop current search, update the longest name chain and max
				// level if necessary
			} else if (states[curEdge.getIndex()] == VISITED) {
				if (level > maxLevel) {
					maxLevel = level;
					res.clear();
					res.add(s);
				} else if (level == maxLevel) {
					res.add(s);
				}
			}
			//Go to the next edge on the current name node
			curEdge = curEdge.getNext();
		}
		//Reset the state of the current name node
		states[index] = NOTVISITED;
	}

	public List<String> getResult() {
		return res;
	}
}
