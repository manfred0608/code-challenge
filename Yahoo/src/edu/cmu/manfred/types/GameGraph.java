package edu.cmu.manfred.types;

//The graph data structure in the NameChainGame
public class GameGraph {
	// Arrays that stores all the namenodes in the graph
	private NameNode[] nameNodes;
	// Number of namenodes in the graph
	private int size;

	// Initialize all the name nodes in the graph
	// Time complexity: O(n)
	private int initVertex(String[] names) {
		// Initailize all the class variables
		nameNodes = new NameNode[names.length];
		size = names.length;

		for (int i = 0; i < size; i++) {

			// Converting all the name to lower case
			String lName = names[i].trim().toLowerCase();
			String[] temp = lName.split("\\s");

			// If any of the persons' name is invalid format
			// Return with the game FAILED status
			if (!isValidName(temp))
				return GameState.FAILED;

			// Initialize the current name node with first name and last name
			nameNodes[i] = new NameNode(temp[0], temp[1]);
		}
		return GameState.SUCCESS;
	}

	// Getters and setters of class variables
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// Get a name node on in the graph with index
	public NameNode getNode(int index) {
		if (index < 0 || index >= nameNodes.length)
			return null;

		return nameNodes[index];
	}

	// Adding edges to each name node
	// By find the connection beween each two persons's name
	// Condition: Person I's last name == Person J's first name
	// Time Complexity: O(n ^ 2)
	private void initEdges() {
		for (int i = 0; i < nameNodes.length; i++) {
			for (int j = 0; j < nameNodes.length; j++) {
				if (i != j) {
					String iLast = nameNodes[i].getLastName();
					String jFirst = nameNodes[j].getFirstName();

					if (iLast.equals(jFirst))
						nameNodes[i].appendEdge(j);
				}
			}
		}
	}

	// Initialize the game graph by calling the initVertex and initEdge
	// Return FAILED status if there is any error occurs
	public int initGraph(String[] names) {
		if (initVertex(names) == GameState.SUCCESS) {
			initEdges();
			return GameState.SUCCESS;
		} else {
			return GameState.FAILED;
		}
	}

	// Check if a person's name containing only first name and last name
	public static boolean isValidName(String[] ss) {
		if (ss.length != 2)
			return false;
		else
			return true;
	}
}
