package com.johnSerwatka.handson6;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
public class HandsOn {

	public static void main(String[] args) throws Exception {
		// declaration/new object block
		StringBuilder buildStr = new StringBuilder();
		FileWriter outputStream;
		String fileContentsRead = "";
		
		// String array of songs
		String songs[] = {"Rock With You", "Smooth Criminal", "Wanna Be Startin' Something", "Thriller", "Beat It"};
		//string builder object of songs
		buildStr = build(songs);
		
		// try catch for writing and reading files
		try {
			//make file using the build method
			outputStream = new FileWriter("songs.txt");
			outputStream.write(buildStr.toString());
			outputStream.close();
			
			// read songs.txt file and prints the contents to the console
			BufferedReader reader = new BufferedReader(new FileReader("songs.txt"));
			String line;
			while((line = reader.readLine()) != null) {
				fileContentsRead = fileContentsRead + line;
			}
			reader.close();
			System.out.println(fileContentsRead);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when writing songs.txt.");
		}
	}
	public static StringBuilder build(String[] stringArray) throws Exception {
		// checks if the passed string is empty and throws an exception if it is
		if (stringArray.length == 0) {
			throw new Exception("Empty String");
		}
		// builds the string from the array minus the last value
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < stringArray.length - 1; i++) {
			builder = builder.append(stringArray[i] + ",");
		}
		// last addition without the comma
		builder = builder.append(stringArray[stringArray.length - 1]);
		return builder;
	}
}
