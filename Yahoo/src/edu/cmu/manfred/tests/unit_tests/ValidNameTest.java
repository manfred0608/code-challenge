package edu.cmu.manfred.tests.unit_tests;

import edu.cmu.manfred.types.GameGraph;

public class ValidNameTest {
	public static void main(String[] args){
		String[] s1 = {};
		String[] s2 = {"a"};
		String[] s3 = {"a", "d", "d"};
		String[] s4 = {"a", "d"};
		String[] s5 = {""};
		String[] s6 = {" "};
		System.out.println(GameGraph.isValidName(s1));
		System.out.println(GameGraph.isValidName(s2));
		System.out.println(GameGraph.isValidName(s3));
		System.out.println(GameGraph.isValidName(s4));
		System.out.println(GameGraph.isValidName(s5));
		System.out.println(GameGraph.isValidName(s6));
	}
}
