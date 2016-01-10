package ie.gmit.URL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProcessURLContents {

	private static String[] lines = null;
	private static String urlTextOutWords;

	public ProcessURLContents(String text) {
		setText(text);
	}

	public ProcessURLContents() {
		setText(text);
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<String> readTextFromURL() throws IOException {

		ArrayList<String> urlTextWords = new ArrayList<String>();

		// split the text and remove non characters and add each word to the
		// arraylist
		lines = getText().split(" ");
		splitWords(lines, urlTextWords, urlTextOutWords);

		return urlTextWords;
	}

	public void splitWords(String[] str, ArrayList<String> list, String outWord) {

		for (int i = 0; i < str.length; i++) {
			str[i] = str[i].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
			str[i].toLowerCase();
			outWord = str[i].toLowerCase().trim();
			list.addAll(Arrays.asList(outWord));
		}

	}

	public static void main(String[] args) {

	}
}