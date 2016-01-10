package ie.gmit.sw.GUI;

import javax.swing.JFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ie.gmit.sw.*;
import ie.gmit.sw.SimpleWordCloud;

/*
 * This class is responsible for extracting duplicate and
 * unique values from the user text and text file. Duplicate words and unique words are then added to separate
 * arrayLists. Only unique words are added to the cloud word tags to display the most occuring words.
 * We also check for the occurrence/ frequency of unique words and add them to the map. 
 * 
 */
//GUI Program - ReadFileGUIDesign class
public class ProcessUniqueWords extends JFrame {

	static FontDisplayStyles styles = new FontDisplayStyles();
	static ReadGUITextWords guiText = new ReadGUITextWords();

	private static ArrayList<String> DictionaryList;
	private static ArrayList<String> stopWords;
	private static String[] uniqueWords;

	private static ArrayList<String> duplicatevalues = new ArrayList<String>();
	private static ArrayList<String> uniquevalues = new ArrayList<String>();
	private static Map<String, Integer> OccurrenceMap = new HashMap<>();

	private static final long serialVersionUID = 333L;
	
	public static void createUniqueWords() throws IOException {

		ReadStopWordsFile rstwords = new ReadStopWordsFile();
		
		//reading string content from GUI and splitting the words and adding to new Dictionary arrayList
		DictionaryList = guiText.readTextFromGUI(ReadGUITextWords.getWordTextFromGUI());
		//populating the stop words arrayList with contents from text file
		stopWords = rstwords.getStopWords();

		//looping over the Dictionary arrayList and checking against the stopwords arrayList to see if 
		//there any common words and adding those words to the duplicate arrayList - otherwise add them
		//as unique values to the uniqueuniqueWordsalues arrayList
		for (String item : DictionaryList) {
			if (stopWords.contains(item)) {
				duplicatevalues.add(item);
			} else {
				uniquevalues.add(item);
			}
		}
		for (String item : uniquevalues) {

			// Looping over all the unique items in the list and checking to see
			// if the OccurrenceMap has a value
			// mapped to the key - if not, add to the map the value - else check
			// the map and increment the value
			// then add it back to the map
			if (item.length() > 0) {
				if (OccurrenceMap.get(item) == null) {
					OccurrenceMap.put(item, 1);
				} else {
					int value = OccurrenceMap.get(item).intValue();
					value++;
					OccurrenceMap.put(item, value);
				}
			}

		}

		// creating an array of words from a uniquevalues arratList to be added
		// to cloud tags
		uniqueWords = new String[uniquevalues.size()];
		uniqueWords = uniquevalues.toArray(uniqueWords);

		// checking the occurence of words in the map
		Set<Map.Entry<String, Integer>> entrySet = OccurrenceMap.entrySet();
		//System.out.println("Words" + "\t\t" + "# of Occurances");
		//System.out.println("===================================");
		
		 List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entrySet);
	        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	            public int compare(Map.Entry<String, Integer> o1,
	                    Map.Entry<String, Integer> o2) {
	                return o2.getValue().compareTo(o1.getValue());
	            }
	        });

	       // for (Map.Entry<String, Integer> entry : list) {
	       
	            //System.out.println(entry.getKey() + "\t\t" + entry.getValue());
	       // }
	        int counter = 0;
			for (Map.Entry<String, Integer> entry : list) {

				counter++;
				if (counter == 85) {
					break;
				}
				//System.out.println(entry.getKey() + "\t\t" + entry.getValue());

				int fontSize = ComputeFontSize.getFontSize(entry.getValue());
				//System.out.println(fontSize);
				// PaintThing(fontSize,word);
				
				SimpleWordCloud simpleword = new SimpleWordCloud();
				simpleword.drawWords(entry.getKey(), fontSize);

			}
			SimpleWordCloud.Write();
			FontDisplayStyles.displayArrayListSize(duplicatevalues, uniqueWords, DictionaryList, stopWords);
	}

}