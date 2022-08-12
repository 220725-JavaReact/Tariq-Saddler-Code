package calc;
import java.sql.Timestamp;
import java.util.Date;
import java.time.LocalDate;


import java.io.FileWriter;
import java.io.IOException;

public class logging {
	
	
	
	LocalDate myObj = LocalDate.now(); // Create a date object
    //System.out.println(myObj);
	public enum logLevel{
		info, debug, verbose, warning, fatal, error;
	}
	
	public static void writeToFile(String message)
	{
		//Create a file writer
		try {
			FileWriter fileWriter = new FileWriter("LogFile.txt");
			fileWriter.append(message + LocalDate.now());
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeErrorToFile(String message)
	{
		//Create a file writer
		try {
			FileWriter fileWriter = new FileWriter("LogFile.txt");
			fileWriter.append(message + LocalDate.now());
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
