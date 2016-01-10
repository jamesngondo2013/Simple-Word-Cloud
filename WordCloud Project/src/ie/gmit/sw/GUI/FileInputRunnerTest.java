package ie.gmit.sw.GUI;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileInputRunnerTest {

	@Test
	public void testFileInputRunner() {
		UserInputRunnerGUI.setStopWordFileName("stopwords.txt");
		assertEquals("stopwords.txt", UserInputRunnerGUI.getStopWordFileName());
	}

}
