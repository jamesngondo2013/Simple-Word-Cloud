package ie.gmit.sw.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;
import ie.gmit.sw.UniquesWords;;

//This class is responsible for designing the GUI frame

public class CreateGUI {

	private static JTextArea textArea, filenameTextArea;
	private static SearchButtonHandler searchHandler;
	
	static ReadGUITextWords guiText = new ReadGUITextWords();

	public static void createFrame() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Word Cloud");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panel.setOpaque(true);
				panel.setBackground(Color.green);

				textArea = new JTextArea(25, 70);
				textArea.setWrapStyleWord(true);
				textArea.setEditable(true);
				textArea.setFont(Font.getFont(Font.SANS_SERIF));

				JScrollPane scroller = new JScrollPane(textArea);
				scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

				filenameTextArea = new JTextArea(10, 10);
				filenameTextArea.setWrapStyleWord(true);
				filenameTextArea.setEditable(true);
				filenameTextArea.setFont(Font.getFont(Font.SANS_SERIF));

				JPanel inputpanel = new JPanel();
				inputpanel.setLayout(new FlowLayout());
				inputpanel.setBackground(Color.green);

				JButton button = new JButton("Generate Word Cloud");
				searchHandler = new SearchButtonHandler();
				button.addActionListener(searchHandler);
				button.setForeground(Color.blue);

				DefaultCaret caret = (DefaultCaret) textArea.getCaret();
				caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
				panel.add(scroller);

				inputpanel.add(button);
				panel.add(inputpanel);
				frame.getContentPane().add(BorderLayout.CENTER, panel);
				frame.pack();
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				frame.setResizable(false);

			}
		});
	}
	
	// Nested class that binds the Generate Cloud Word button
	private static class SearchButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	
		        if((textArea.getText().trim().length() == 0)){
		        	
		        	JOptionPane.showMessageDialog(null, "Please enter text","Rectangle",JOptionPane.INFORMATION_MESSAGE);   	
		           
		        } else{
		        	 
		        	guiText.setWordTextFromGUI(textArea.getText());
		        	
		        	try {
		        		ProcessUniqueWords.createUniqueWords();
					} catch (IOException e1) {		
						System.out.println("Program failed to process your request");
					}
		        	
		        	textArea.setText("");
		        	System.exit(0);
		        }
		    }			
	}

}
