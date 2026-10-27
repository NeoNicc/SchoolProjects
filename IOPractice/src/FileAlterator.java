//Author: Nicholas Watson
//Date: 10/24/2026
//Class: COP 3337
//Program: converts a text file of sentences separated by "."
//and turns it into a text file of sentences separated by lines.

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileAlterator {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean fileGood = false;
		File file = null;
		
		//accept file input and check that it is valid
		//must include src/ in input 
		while (!fileGood) {
			System.out.println("Enter the name of the file to alter.");
			
			String fileName = scnr.nextLine(); //src/OriginalTextFile.txt
			
			try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			file = new File(fileName);
			
			fileGood = true;
			} catch (IOException e) {
				System.out.println("File was not found, please enter a valid file name.");
			}
		}
	
		//use alteration class to manipulate the file
		Alteration alteredFile = new Alteration(file);
		scnr.close();
	}
}
