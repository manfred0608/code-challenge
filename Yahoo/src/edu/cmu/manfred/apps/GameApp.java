package edu.cmu.manfred.apps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.cmu.manfred.games.NameChainGame;

// This is the application of running a NameChainGame
// Also the interface accetping the path of the input file
public class GameApp {
	public static List<String> play(String path) throws IOException{
		//Name set in order to remove duplicates in the input
		Set<String> nameSet = new HashSet<String>();
		File file = new File(path);
		FileReader fileReader;
		
		List<String> nameList = new ArrayList<String>();
		
		//Buffer to read line by line
		fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);

		String line = null;
		// if no more lines the readLine() returns null
		while ((line = br.readLine()) != null) {
			// reading lines until the end of the file
			//Ignore the space and transform to lower case
			String s = line.trim().toLowerCase();
			//If there is no duplicates in already in the name list
			//Add the name into the name list and also the name set
			if(!nameSet.contains(s)){
				nameList.add(s);
				nameSet.add(s);
			}
		}
		
		//Initialize the NameChainGame singleton instance
		NameChainGame game = NameChainGame.getInstance();
		try {
			//Prepare the input
			String[] names = (String[])nameList.toArray(new String[0]);
			
			//Start a new game with new input
			game.newGame(names);
			
			//Return with the longest name chain list
			return game.getResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Game Failed! Please start a new Game!");
			return null;
		}
	}
}
