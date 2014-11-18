package edu.cmu.manfred.types;

//EdgeNode is the edge linking two NameNode is a game graph
public class EdgeNode {
	// Next edge of the same name node on the edge linked list
	EdgeNode next;

	// The index of the name node that the edge points to
	int index;

	// Default constructor assigned with the index of the name node that the
	// edge points to and the next edge on the linked list
	public EdgeNode(int index) {
		this.index = index;
		this.next = null;
	}

	// Getters and setters of class variables
	public EdgeNode getNext() {
		return next;
	}

	public void setNext(EdgeNode next) {
		this.next = next;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
