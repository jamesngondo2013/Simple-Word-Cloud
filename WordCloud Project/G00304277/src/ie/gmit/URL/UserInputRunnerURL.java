package ie.gmit.URL;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserInputRunnerURL {

	private static String websiteLink;

	private static String stWordFileName;
	private static Scanner console = new Scanner(System.in);

	public UserInputRunnerURL() {
		super();
	}

	// getting file names using scanner input
	public static void scannerInput() throws IOException {

		// get the system property indicated by the key
		String workingDir = System.getProperty("user.dir");

		// Creates a new File instance by converting the given pathname string
		// into an abstract pathname.
		File workingDirFile = new File(workingDir);

		// checking to see if the user entered a correct text file names
		int i = 0;
		while (i == 0) {

			System.out.println("Please, Enter Your Website Link Here... (www)");
			websiteLink = console.nextLine();

			System.out.println("Please, Enter Your Stop Words File Name");
			stWordFileName = console.nextLine();
			File testfile2 = new File(workingDirFile, stWordFileName);

			// checking to see if the file names are not empty
			if (!(websiteLink.isEmpty() || stWordFileName.isEmpty())) {

				// checking to see if the user entered a correct text file names
				// against the existing directory pathnames/ filenames
				if (testfile2.exists()) {

					ReadURL.generateExtractContentFromWebsite(websiteLink);
					ReadStopWordsFile.setFilename(stWordFileName);

					i = 1;
				} else {
					// the user entered incorrect/ invalid text file names
					System.out.println("You entered the wrong File Names... \nPlease try again");
				}

			} else {
				System.out.println("You Entered Invalid Data");
			}

		}

	}

	public static void main(String[] args) throws Throwable {

		CreateURLUniquesWords unique = new CreateURLUniquesWords();

		scannerInput();
		unique.createUniqueWords();

	}

}
