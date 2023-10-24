package n1e3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class App {
	
	public static void main(String[] args) {
		
		String path = "G:\\Mi unidad\\Eclipse_Workspace\\S1E5";
		
		ArrayList<String> dir = sortedDir(path);
		
		printArray(dir);
		
		saveArray(dir);
		
		

	}
	
	public static ArrayList<String> sortedDir(String path) {
		
		File dir = new File(path);
		
		
		File[] dirList = dir.listFiles();
		Arrays.sort(dirList);
		ArrayList<String> names = new ArrayList<String>();
		
		String type;
		String date;
		
		for (int i = 0; i < dirList.length; i++) {
			if(dirList[i].isDirectory()) {
				type = "(D)";
			} else {
				type = "(F)";
			}
			
			date = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(
				    new Date(dirList[i].lastModified()));
			
			names.add(dirList[i].getName() + " " + type + " " + date);
		}
		
			
		return names;
		
	}
	
	
	public static void printArray(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}
	
	public static void saveArray(ArrayList<String> array) {
		
		try {
			FileWriter file = new FileWriter("G:\\Mi unidad\\Eclipse_Workspace\\S1E5\\src\\n1e3\\lista.txt");
			PrintWriter pw = new PrintWriter(file);
			for (int i = 0; i < array.size(); i++) {
				pw.println(array.get(i));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
