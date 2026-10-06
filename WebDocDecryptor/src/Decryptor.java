import javax.swing.*;
import java.awt.*;

public class Decryptor {

	public static void main(String[] args) {
		//frame initialization
		JFrame frame = new JFrame("Decrypted Text");
		JLabel label = new JLabel();
		Font largeText = new Font("Times New Roman", Font.BOLD, 32);
		
		//Scraper initialization
		Scrape scraper = new Scrape("https://docs.google.com/document/d/e/2PACX-1vTMOmshQe8YvaRXi6gEPKKlsC6UpFJSMAk4mQjLm_u1gmHdVVTaeh7nBNFBRlui0sTZ-snGwZM4DBCT/pub");
		
		//Slicer initialization
		Slicer slicer = new Slicer(scraper.getHTML(), "<table", "</table>");
		
		label.setOpaque(true);
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setFont(largeText);
		
		frame.add(label);
		frame.setSize(600, 150);
		frame.add(new JScrollPane(label));
		
		//label.setText(slicer.getSlicedText());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//frame.setVisible(true);
		System.out.println(slicer.getSlicedText());
	}

}
