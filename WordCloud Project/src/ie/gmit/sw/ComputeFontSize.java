package ie.gmit.sw;

public class ComputeFontSize {

	public static int getFontSize(int freq) {

		int fontSize = 18; // min font
		if (freq >= 1 && freq < 3) {
			fontSize +=6;
	
		} else if (freq > 3 && freq <5) {
			fontSize = fontSize * 2;

		} else if (freq >=5 && freq <7) {
			fontSize = fontSize * 3;
		}
		else if(freq >=7 && freq <=10)
		{
			fontSize = fontSize * 4;
		}
		else if(freq >10)
		{
			fontSize = fontSize * 5;
		}

		return fontSize;
	}
}
