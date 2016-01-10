package ie.gmit.sw;

import java.util.Random;

public class CalculateRandomValues {

	public int getRandomValueX()
	{
		Random rand = new Random();
		int x = rand.nextInt(1199) + 1;
		
		return x +(1);
		
	}
	public int getRandomValueY()
	{
		Random rand = new Random();
		
		int y = rand.nextInt(849) + 1;
		
		return y - (40);
		
	}
}
