package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UniquesWords {

	private static ArrayList<String> DictionaryList;
	private static ArrayList<String> stopWords;
	private static String[] words;

	private static ArrayList<String> duplicatevalues = new ArrayList<String>();
	private static ArrayList<String> uniquevalues = new ArrayList<String>();
	private static Map<String, Integer> OccurrenceMap = new HashMap<>();

	public void createUniqueWords() throws IOException {

		ReadDictionaryWordsFile dictf = new ReadDictionaryWordsFile();
		
		ReadStopWordsFile stopf = new ReadStopWordsFile();
		
		// populating the new DictionaryList and stopWords arrayList using values generated from
		// the ReadDictionaryWordsFile class that is responsible for read file contents
		// and processing each word
		DictionaryList = dictf.getDictionaryWords();
		stopWords = stopf.getStopWords();

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
		words = new String[uniquevalues.size()];
		words = uniquevalues.toArray(words);

		//
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

	        //for (Map.Entry<String, Integer> entry : list) {
	       
	            //System.out.println(entry.getKey() + "\t\t" + entry.getValue());
	            
	        //}
	        
	        int counter = 0;
			for (Map.Entry<String, Integer> entry : list) {

				counter++;
				if (counter == 100) {
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
			FontDisplayStyles.displayArrayListSize(duplicatevalues, words, DictionaryList, stopWords);
	}

}
