package n1e1;

import java.io.File;
import java.util.Arrays;

public class App {
	
	public static void main(String[] args) {
		
		String path = "G:\\Mi unidad\\Eclipse_Workspace\\S1E5";
		
		sortDir(path);
		

	}
	
	public static void sortDir(String path) {
		
		File dir = new File(path);
		
		if(dir.isDirectory()) {
			File[] dirList = dir.listFiles();
			String[] names = new String[dirList.length];
			for (int i = 0; i < dirList.length; i++) {
				names[i] = dirList[i].getName();
			}
		
			Arrays.sort(names);
			System.out.println(Arrays.toString(names));
		} else {
			System.out.println("No ha sido recibido un directorio correcto");
		}
	}

}
