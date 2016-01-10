package ie.gmit.URL;

import java.io.IOException;
import java.util.ArrayList;

import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;

public class ReadURL {

	static ArrayList<String> temp = new ArrayList<String>();
	private String webContent;
	private String websiteLink;

	public ReadURL() {
		getWebsiteLink();
		getWebContent();
	}

	public ReadURL(String webContent) {

		setWebContent(webContent);
	}

	public String getWebContent() {
		return webContent;
	}

	public void setWebContent(String webContent) {
		this.webContent = webContent;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public static void generateExtractContentFromWebsite(String url) throws IOException {
		try {
			StringExtractor se = new StringExtractor(url);
			// StringExtractor se = new
			// StringExtractor("http://www.bbc.com/news/world-europe-35261359");
			String content = se.extractStrings(false);
			// String contentWithLinks = se.extractStrings(true);
			// System.out.println(content);
			ProcessURLContents pro = new ProcessURLContents(content);

			temp = pro.readTextFromURL();
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {

		
	}

}
