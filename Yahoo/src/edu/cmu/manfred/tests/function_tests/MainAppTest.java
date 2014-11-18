package edu.cmu.manfred.tests.function_tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import edu.cmu.manfred.apps.GameApp;

//Function Test for void play() in GameApp
//Reading different files as input
public class MainAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "./file/input/";
		String output = "./file/output/";
		File dir = new File(path);
		File dest_dir = new File(output);
		
		try {
			for(int i = 0; i < dir.listFiles().length; i++){
				String fileName = dir.listFiles()[i].getName();
				File out = new File(dest_dir.getAbsolutePath() + "/" + fileName);
				BufferedWriter bw = new BufferedWriter(new FileWriter(out, true));
				
				//Formulate output for each output files
				bw.write("Test Case File:" + fileName + "\n");
				bw.write("Result:\n");
				List<String> res = GameApp.play(dir.listFiles()[i].getAbsolutePath());
				if(res != null){
					for(int j = 0; j < res.size(); j++){
						bw.write(res.get(j) + "\n");
					}
				}
				bw.write("-------------------------------------------");
				bw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}
