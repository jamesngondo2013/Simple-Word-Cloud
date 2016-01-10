package ie.gmit.sw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public interface RandomFonts {

	Color createRandomFontColor(Random rand);
	
	Font getRandomFont(int fontSize);
}
