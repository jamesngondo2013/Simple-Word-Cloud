package ie.gmit.sw;

import java.io.File;
import java.util.Scanner;

public class UserInputRunnerConsole {

	private static Scanner console = new Scanner(System.in);

	private static String dictFileName;
	private static String stWordFileName;

	public UserInputRunnerConsole() {
		super();
	}
	
	public UserInputRunnerConsole(String dictname, String stopword) {
		setDictFileName(dictname);
		setStWordFileName(stopword);
	}

	public static String getDictFileName() {
		if(dictFileName.isEmpty())
		{
			System.out.println("Please enter Dictionary File Name");
		}
		else{
		
			return dictFileName;
		}
		return dictFileName;
	}

	public static void setDictFileName(String dictFileName) {
		UserInputRunnerConsole.dictFileName = dictFileName;
	}

	public static String getStWordFileName() {
		
		if(stWordFileName.isEmpty())
		{
			System.out.println("Please enter Stop Word File Name");
		}
		else
		{
			return stWordFileName;
		}
		
		return stWordFileName;
	}

	public static void setStWordFileName(String stWordFileName) {
		UserInputRunnerConsole.stWordFileName = stWordFileName;
	}

	// getting file names using scanner input
	public static void scannerInput() {

		// get the system property indicated by the key
		String workingDir = System.getProperty("user.dir");

		// Creates a new File instance by converting the given pathname string
		// into an abstract pathname.
		File workingDirFile = new File(workingDir);

		// checking to see if the user entered a correct text file names
		int i = 0;
		while (i == 0) {
			System.out.println("(1) Please, Enter Your Word Dictionary File Name...");
			dictFileName = console.nextLine();

			// An abstract representation of file and directory pathnames.
			File testfile = new File(workingDirFile, dictFileName);

			System.out.println("(2) Please, Enter Your Stop Words File Name...");
			stWordFileName = console.nextLine();
			File testfile2 = new File(workingDirFile, stWordFileName);

			// checking to see if the file names are not empty
			if( !(dictFileName.isEmpty()|| stWordFileName.isEmpty())){
				
				// checking to see if the user entered a correct text file names
				// against the existing directory pathnames/ filenames
				if (testfile.exists() && testfile2.exists()) {
					
					// set the user input as valid file names
					new UserInputRunnerConsole(dictFileName, stWordFileName);
					//setDictFileName(dictFileName);
					//setStWordFileName(stWordFileName);

					i = 1;
				} 
				else
				{
					// the user entered incorrect/ invalid text file names
					System.out.println("You entered the wrong File Names... \nPlease try again...");
				}
				
			}
			else
			{
				System.out.println("Please type file names");
			}
			
		}

	}

	public static void main(String[] args) throws Throwable {

		scannerInput();

		UniquesWords words = new UniquesWords();
		words.createUniqueWords();

	}

}
