import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Hint {
	private String hint;
	
	public Hint() {
		hint = "";
	}
	
	public String getHint(int n) {
		Scanner inputStream = null;
		String [] line = new String[30];
		int i = 1;
		
		try {
			inputStream = new Scanner(new File("/Users/parkseungri/Desktop/Hint.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file");
			System.exit(0);
		}
		
		while(inputStream.hasNextLine()) {
			inputStream.hasNextInt();
			line[i] = inputStream.nextLine();
			i++;
		}
		
		inputStream.close();
		
		this.hint = line[n];
		return hint;
	}
}

