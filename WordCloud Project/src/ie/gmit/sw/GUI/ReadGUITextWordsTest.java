package ie.gmit.sw.GUI;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ReadGUITextWordsTest {

	@Test
	public void testReadGUITextWords() {
		
		ReadGUITextWords testcase = new ReadGUITextWords();
		testcase.setWordTextFromGUI("text");
		assertEquals("text", testcase.getWordTextFromGUI());
	}
	
	@Test
	public void testReadTextFromGUI() throws IOException {
		String word;
		ArrayList<String> testWords = new ArrayList<String>();

		ReadGUITextWords testcase = new ReadGUITextWords();
		
		testcase.setWordTextFromGUI("text");
		
		word = testcase.getWordTextFromGUI();
		
		String[] lines;
		String outWord;
		lines = word.split(" ");
		for (int i = 0; i < lines.length; i++) {
			
			lines[i] = lines[i].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
			lines[i].toLowerCase();
			outWord = lines[i].toLowerCase().trim();
			testWords.addAll(Arrays.asList(outWord));
		}
		assertEquals(testWords, testcase.readTextFromGUI(word));

	}

}
