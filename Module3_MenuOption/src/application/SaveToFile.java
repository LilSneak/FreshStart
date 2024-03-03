package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveToFile {
	
	public String save(String info) {
		
		try {
			PrintWriter outputStream = new PrintWriter("log.txt");
			outputStream.write(info);
			outputStream.close();
		
		} catch(FileNotFoundException e) {
		e.printStackTrace();
		}
		String isDone = "SAVE SUCCESSFUL";
		return isDone;
	}
}
