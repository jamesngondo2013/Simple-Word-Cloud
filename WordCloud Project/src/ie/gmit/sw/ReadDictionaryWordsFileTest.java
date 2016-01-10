package ie.gmit.sw;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class ReadDictionaryWordsFileTest {

	@SuppressWarnings("resource")
	@Test
	public void testgetDictionaryWords() throws IOException {
		
		ReadDictionaryWordsFile testcases = new ReadDictionaryWordsFile();
		
		UserInputRunnerConsole.setDictFileName("crisis.txt");
		assertEquals("crisis.txt", UserInputRunnerConsole.getDictFileName());
		
		
		
		FileReader fr = new FileReader(UserInputRunnerConsole.getDictFileName());// get file name using
		
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
        assertEquals(me, testcases.getDictionaryWords());
	}

	

}
