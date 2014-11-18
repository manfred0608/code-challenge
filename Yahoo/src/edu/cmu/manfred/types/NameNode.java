package edu.cmu.manfred.types;

//The NameNode class represents a person's name
//All the instance of NameNode class are stored in the GameGraph
public class NameNode {
	//These two variables in a name node represents a person's first name and last name
	private String firstName;
	private String lastName;
	
	//All the out-edges are stored in a linked list, each node on the list is an edgenode
	
	//Head node of the linked list of edges
	private EdgeNode firstNode;
	//Tail node of the linked list of edges
	private EdgeNode lastNode;
	
	//Default constructor with firstname and lastname assigned
	public NameNode(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		firstNode = null;
		lastNode = firstNode;
	}
	
	//Point the node to another node with the postion of index
	//By adding an edge node on the linked list
	public void appendEdge(int index){
		EdgeNode edge = new EdgeNode(index);
		
		if(firstNode == null)
			firstNode = edge;
		else
			lastNode.next = edge;
		
		lastNode = edge;
	}	
	
	//Getters and setters of class variables
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EdgeNode getFirstNode() {
		return firstNode;
	}
	public void setFirstNode(EdgeNode firstNode) {
		this.firstNode = firstNode;
	}
}
