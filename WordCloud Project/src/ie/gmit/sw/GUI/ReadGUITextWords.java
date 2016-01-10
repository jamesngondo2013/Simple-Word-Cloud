package ie.gmit.sw.GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import ie.gmit.sw.*;

public class ReadGUITextWords implements FileReaderInterface {

	//private static Scanner console = new Scanner(System.in);

	private static String[] lines = null;
	private static String guiTextOutWords;
	
	private static String wordText;

	public ReadGUITextWords() {

	}

	public static String getWordTextFromGUI() {
		return wordText;
	}

	public void setWordTextFromGUI(String wordText) {
		ReadGUITextWords.wordText = wordText;
	}

	// read text from GUI
	public ArrayList<String> readTextFromGUI(String text) throws IOException {

		ArrayList<String> guiTextWords = new ArrayList<String>();

		//get the string from GUI using getters/setters methods
		text = ReadGUITextWords.getWordTextFromGUI();
		
		//split the text and remove non characters and add each word to the arraylist
		lines = text.split(" ");
		removeNonCharacters(lines, guiTextWords, guiTextOutWords);

		return guiTextWords;

	}

	public void removeNonCharacters(String[] str, ArrayList<String> list, String outWord) {

		for (int i = 0; i < str.length; i++) {
			// remove all non character symbols
			str[i] = str[i].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
			str[i].toLowerCase();
			outWord = str[i].toLowerCase().trim();

			// adding every word to the listArray
			list.addAll(Arrays.asList(outWord));

		}

	}

}
