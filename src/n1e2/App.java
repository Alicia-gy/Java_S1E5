package n1e2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class App {
	
	public static void main(String[] args) {
		
		String path = "./src/";
		
		sortDir(path);
		

	}
	
	public static void sortDir(String path) {
		
		File dir = new File(path);
		
		if(dir.isDirectory()) {
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
			
			for (int i = 0; i < names.size(); i++) {
				System.out.println(names.get(i));
			}

		} else {
			System.out.println("No ha sido recibido un directorio correcto");
		}
	}

}
