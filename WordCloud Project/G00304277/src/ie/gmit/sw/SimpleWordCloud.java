package ie.gmit.sw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SimpleWordCloud extends JPanel implements RandomFonts {

	/**
	 * 
	 */
	public static BufferedImage image = new BufferedImage(1200, 650, BufferedImage.TYPE_4BYTE_ABGR);
	public static Graphics2D graphics = image.createGraphics();
	private static final long serialVersionUID = 1L;
	private int xPos;
	private int yPos;

	public SimpleWordCloud() throws IOException {
		setBackground(Color.white);
	}

	public void drawWords(String strword, int fontSize) throws IOException {

		Random rand = new Random();

		List<Rectangle2D> used = new ArrayList<>(25);

		Font f = getRandomFont(fontSize);

		Color randomColor = createRandomFontColor(rand);

		FontMetrics fm = graphics.getFontMetrics(f);
		Rectangle2D bounds = fm.getStringBounds(strword, graphics);
		//System.out.println("Putting " + strword);

		do {
			xPos = rand.nextInt(1200 - (int) bounds.getWidth());
			yPos = rand.nextInt(700 - (int) bounds.getHeight());

			bounds.setFrame(xPos, yPos, bounds.getWidth(), bounds.getHeight());
			graphics.drawString(strword, xPos, yPos + fm.getAscent());
		} while (collision(used, bounds));
		used.add(bounds);
		graphics.setFont(f);
		graphics.setColor(randomColor);
		//System.out.println("X " + (float) bounds.getX() + " Y: " + (float) bounds.getY() + fm.getAscent());
		
	}

	public Dimension getPreferredSize() {
		return new Dimension(1200, 650);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawImage(image, 0, 0, this);
		g2d.dispose();
	}

	public boolean collision(List<Rectangle2D> used, Rectangle2D bounds) {
		boolean collides = false;
		for (Rectangle2D check : used) {
			if (bounds.intersects(check)) {
				collides = true;
				break;
			}
		}
		return collides;
	}
	// ==================================

	public static void Write() throws IOException {

		ImageIO.write(image, "png", new File("image-G00304277.png"));
		System.out.println("Image saved as image.png");

	}

	public void dispose() {
		// graphics.dispose();
	}

	public Color createRandomFontColor(Random rand) {
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, g, b);
		return randomColor;
	}

	public Font getRandomFont(int fontSize) {
		Font fonts = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);

		return fonts;
	}

}
