import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Answer{
	private String answer;
	
	public Answer() {
		answer = "";
	}
	
	public String getAnswer(int n) {
		Scanner inputStream = null;
		String [] line = new String[30];
		int i = 1;
		
		try {
			inputStream = new Scanner(new File("/Users/parkseungri/Desktop/Answer.txt"));
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
		
		this.answer = line[n];
		return answer;
	}
}

