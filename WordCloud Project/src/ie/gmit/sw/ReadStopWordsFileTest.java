package ie.gmit.sw;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class ReadStopWordsFileTest {

	@Test
	public void testReadStopWordsFile() throws IOException {
		
		ReadStopWordsFile testcases = new ReadStopWordsFile();
		
		UserInputRunnerConsole.setStWordFileName("stopwords.txt");
		assertEquals("stopwords.txt", UserInputRunnerConsole.getStWordFileName());
		
		FileReader fr = new FileReader(UserInputRunnerConsole.getStWordFileName());// get file name using
		
		BufferedReader in = new BufferedReader(fr);

		ArrayList<String> me = new ArrayList<>();
		String str, outwords = null;
		String[] words;
		while (( str = in.readLine()) != null) {
			words = str.split(" ");
			
			for(int i=0; i<words.length;i++)
			{
				words[i] = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
				words[i].toLowerCase();
				outwords = words[i].trim().toLowerCase();
				
				me.add(outwords);
			}
			 
		}
		fr.close();
		in.close();
        assertEquals(me, testcases.getStopWords());
	}

}
