package ie.gmit.URL;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;
import org.junit.Test;

import ie.gmit.URL.ReadURL;

public class ReadURLTest {

	@Test
	public void testReadURL() throws IOException {
		String url = "www.bbc.com";
		try {
			StringExtractor se = new StringExtractor(url);
			
			String content = se.extractStrings(false);
			String contentWithLinks = se.extractStrings(true);
			System.out.println(content);
			System.out.println(contentWithLinks);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	
		
	}

}
