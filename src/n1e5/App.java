package n1e5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class App {
	
	public static void main(String[] args) {
		
		
		Instrument serializable = new Instrument("Prueba", 10);
		String file = "file.ser";
		
		serialization(serializable, file);
		deserialization(file);
		

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
	
	public static void readFile(String path) {
		
		try {
			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void serialization(Object obj, String path) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
			output.writeObject(obj);
			System.out.println("Objecte serialitzat");
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deserialization(String path) {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
			Instrument obj1 = (Instrument) input.readObject();
			System.out.println("Objecte desserialitzat: \n" + obj1.toString());
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printArray(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}
	
	public static void saveArray(ArrayList<String> array) {
		
		try {
			FileWriter file = new FileWriter("./src/n1e4/lista.txt");
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