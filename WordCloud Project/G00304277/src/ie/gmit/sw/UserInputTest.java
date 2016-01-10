package ie.gmit.sw;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserInputTest {

	@Test
	public void testUserInputTest() {
		//UserInputRunner test = new UserInputRunner();
		UserInputRunnerConsole.setDictFileName("crisis.txt");
		UserInputRunnerConsole.setStWordFileName("stopwords.txt");
		
		assertEquals("crisis.txt", UserInputRunnerConsole.getDictFileName());
		assertEquals("stopwords.txt", UserInputRunnerConsole.getStWordFileName());
	}

}
