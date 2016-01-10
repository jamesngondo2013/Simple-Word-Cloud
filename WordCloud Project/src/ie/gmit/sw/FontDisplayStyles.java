package ie.gmit.sw;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FontDisplayStyles {

	
	public FontDisplayStyles() {
		super();
		
	}

	//create random font colors to the Word cloud tags
	public static void createrandomFont(JLabel label, JPanel panel) {
		int a = (int) (Math.random() * 255 - 0);
		int b = (int) (Math.random() * 255 - 0);
		int c = (int) (Math.random() * 255 - 0);
		label.setForeground(new java.awt.Color(a, b, c));
		panel.add(label);

	}
	
	// display method that displays different sizes of arrayList
	public static void displayArrayListSize(ArrayList<String> dupl, String[] word, ArrayList<String> orgDict, ArrayList<String> orgStopW) {
		System.out.println("==================");
		System.out.println("Duplicate Words..." + dupl.size());
		System.out.println("Uniques Words..." + word.length);

		System.out.println("Original Dict Words..." + orgDict.size());
		System.out.println("Original Stop Words..." + orgStopW.size());
		System.out.println("===================");
		System.out.println("OPERATION COMPLETED SUCCESSFULLY!!!");

	}
	
	
	

}
