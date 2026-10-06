import java.net.*;
import java.io.*;

public class Scrape {
	private URI uri;
	private URL url;
	private InputStream input;
	
	public Scrape(String site) {
		try {
			this.uri = new URI(site);
			this.url = this.uri.toURL();
			this.input = url.openStream();
			
			System.out.println("connection success");
		} catch (URISyntaxException e){
			System.err.println("Failed URL: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Connection Failed: " + e.getMessage());
		}
	}
	
	public String getHTML() {
		StringBuilder content = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.input))) {
			String line;
			
			while((line = reader.readLine()) != null) {
				content.append(line).append("---");
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return content.toString();
	} 
}
