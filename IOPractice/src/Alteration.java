import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Alteration {
	private static int tempNum = 0;
	private File originalFile = null;
	private String tempFileName = "";
	
	public Alteration(File fileName) {
		++tempNum;
		this.originalFile = fileName;
		
		//construct a temporary file name for the temp file
		this.tempFileName = fileName.getParent() + java.io.File.separator + fileName.getName() + tempNum;
		
		//call to all helper methods to save time in main function
		alterate(); //splits the original file text and saves it in temp file
		closeOut(); //rewrites the original file with temp file contents & deletes temp file
		showFileContents(); //prints contents of newly altered original file
	}
	
	private void alterate() {
		//try with resources to check files open and auto close buffers
		try (
			BufferedReader reader = new BufferedReader(new FileReader(originalFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName));
		) {
			String originalLine = "";
			while((originalLine = reader.readLine()) != null) {
				String[] alteredLine = originalLine.split("\\.\\s*"); //splits sentences whether they have a space or not after the "."
				
				for (String line : alteredLine) {
					writer.write(line);
					writer.newLine();
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void closeOut() {
		try (
			BufferedReader reader = new BufferedReader(new FileReader(tempFileName));
			BufferedWriter writer = new BufferedWriter(new FileWriter(originalFile));
		) {
			String currentLine = "";
			
			boolean first = true; //checks if it's the first iteration to mitigate unnecessary newlines
			while((currentLine = reader.readLine()) != null) {
				if (!first) {
					writer.newLine();
				}
				
				writer.write(currentLine);
				first = false;
			}			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		//attempts to delete temp file with a message on failure
		File toDelete = new File(tempFileName);
		boolean deleted = toDelete.delete();
		if (!deleted) {
			System.out.println("Failed to delete temp file.");
		}
	}
	
	private void showFileContents() {
		try (BufferedReader reader = new BufferedReader(new FileReader(originalFile))) {
			String currentLine = "";
			while ((currentLine = reader.readLine()) != null) {
				System.out.println(currentLine);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
