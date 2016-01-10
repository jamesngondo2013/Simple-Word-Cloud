package ie.gmit.sw.GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import ie.gmit.sw.*;

public class ReadStopWordsFile implements FileReaderInterface {

	private static BufferedReader brStopWord = null;
	private static FileReader frStopWord = null;
	private static String[] stopword = null;
	private static String strStopWord;
	private static String outStopwords;
	

	public ReadStopWordsFile() {
		
	}
	
	//read stop words text file line by line, split the words, remove all non character symbols
	//and add each word to arrayList
	public ArrayList<String> getStopWords() throws IOException {

		ArrayList<String> stopWordsSet = new ArrayList<String>();

		try {
			frStopWord = new FileReader(UserInputRunnerGUI.getStopWordFileName());
			brStopWord = new BufferedReader(frStopWord);

			while ((strStopWord = brStopWord.readLine()) != null) {
				stopword = strStopWord.split(" ");

				//remove all non character symbols
				removeNonCharacters(stopword, stopWordsSet, outStopwords);

			}
		} catch (FileNotFoundException e) {
			System.out.println("Files not found.");
		} catch (IOException e) {
			System.out.println("Problem with reading files.");
		}
		brStopWord.close();
		frStopWord.close();

		return stopWordsSet;
	}

	//Loop over the array of strings and remove all non character symbols and adding every word to the listArray
		public void removeNonCharacters(String[] str, ArrayList<String> list, String outWord) {
			
			for (int i = 0; i < str.length; i++) {
				//remove all non character symbols
				str[i] = str[i].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
				str[i].toLowerCase();
				outWord = str[i].toLowerCase().trim();
				
				//adding every word to the listArray
				list.addAll(Arrays.asList(outWord));

			}

		}

	public static void main(String[] args) throws IOException {
		//ReadStopWordsFile st = new ReadStopWordsFile();
		//st.getStopWords();
	}

}
