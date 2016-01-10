package ie.gmit.sw;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputeFontSizeTest {

	@Test
	public void testComputeFontSize() {
		
		int freq = 1;
		assertEquals(24, ComputeFontSize.getFontSize(freq));

	}

}
