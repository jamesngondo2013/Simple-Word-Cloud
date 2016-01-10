package ie.gmit.sw.GUI;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserInputRunnerGUI {

	private static String stopWordFileName;
	private static Scanner in = new Scanner(System.in);
	
	public static String getStopWordFileName() {
		return stopWordFileName;
	}

	public static void setStopWordFileName(String stopWordFileName) {
		UserInputRunnerGUI.stopWordFileName = stopWordFileName;
	}

	public void userInput() throws IOException
	{
		//get the system property indicated by the key
		String workingDir = System.getProperty("user.dir");	
		
		//Creates a new File instance by converting the given pathname string into an abstract pathname.
		File workingDirFile = new File(workingDir); 
		
		//checking to see if the user entered a correct text file names 
		int i = 0;
	    while (i == 0) {
	    	
	    	System.out.println("Please, Enter Stop Words File Name");
	    	stopWordFileName = in.nextLine();

	    	// check to see is the user clicked the cancel button and terminates the process
			if(stopWordFileName == null)
			{
				 System.out.println("Process Cancelled... THANKS BYE!");
				  System.exit(0);     	
		    }
			else
			{
				//An abstract representation of file and directory pathnames.
				File testfile = new File(workingDirFile, stopWordFileName);
				
				//checking to see if the user entered a correct text file names against the existing directory pathnames/ filenames
		        if(testfile.exists()){
		        	
		            System.out.println("Now Paste Your Text Content in the GUI");
		            
		            setStopWordFileName(stopWordFileName);
		            
		            //calling the createFrame() from the GUI design class
		            CreateGUI.createFrame();
		           
		            i = 1;
		        } else{
		        	
		        	System.out.println("You Entered Invalid Data");        	 	
		        }
			}
		}
			
	}

	public static void main(String[] args) throws IOException {

		UserInputRunnerGUI runner = new UserInputRunnerGUI();
		runner.userInput();
	}
}
