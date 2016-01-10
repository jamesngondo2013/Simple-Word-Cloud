package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadDictionaryWordsFile implements FileReaderInterface {
	
	private static BufferedReader in = null;
	private static FileReader fr = null;
	private static String[] words = null;
	private static String outWords;
	private static String str;

	
	public ReadDictionaryWordsFile() {
		
	}
	
	public ArrayList<String> getDictionaryWords() throws IOException {
		// Read the contents of the file, add to string array, split the string content, remove all non characters
		// and adding each words toe arrayList
		
		ArrayList<String> DictionaryList = new ArrayList<String>();

		try {

			fr = new FileReader(UserInputRunnerConsole.getDictFileName());// get file name using
															
			in = new BufferedReader(fr);

			while ((str = in.readLine()) != null) {
				words = str.split(" ");
				
				//removing non characters from the string and adding to arrayList
				removeNonCharacters(words, DictionaryList, outWords);
				
			}

		} catch (FileNotFoundException e) {
			System.out.println("Files not found.");
		} 
		
		fr.close();
		in.close();
		
		return DictionaryList;
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

	public static void main(String[] args) throws IOException {
		//UserInput.scannerInput();		
		//ReadDictionaryWordsFile f = new ReadDictionaryWordsFile();
		//f.getDictionaryWords();
	}
}
