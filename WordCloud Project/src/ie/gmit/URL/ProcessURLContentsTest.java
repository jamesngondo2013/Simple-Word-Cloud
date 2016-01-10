package ie.gmit.URL;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ie.gmit.sw.GUI.ReadGUITextWords;

public class ProcessURLContentsTest {

	@Test
	public void testProcessURLContents() throws IOException {
		String word;
		ArrayList<String> testWords = new ArrayList<String>();

		ProcessURLContents testcase = new ProcessURLContents();
		
		testcase.setText("text");
		
		word = testcase.getText();
		
		String[] lines;
		String outWord;
		lines = word.split(" ");
		for (int i = 0; i < lines.length; i++) {
			
			lines[i] = lines[i].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
			lines[i].toLowerCase();
			outWord = lines[i].toLowerCase().trim();
			testWords.addAll(Arrays.asList(outWord));
		}
		assertEquals(testWords, testcase.readTextFromURL());
	}

}
