package ie.gmit.sw.Runner;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ie.gmit.URL.CreateURLUniquesWords;
import ie.gmit.URL.UserInputRunnerURL;
import ie.gmit.sw.*;
import ie.gmit.sw.GUI.UserInputRunnerGUI;

public class Runner {

	private static Scanner in = new Scanner(System.in);
	private static boolean ans = false;

	public static void main(String[] args) throws IOException {

		int optionNumber;

		System.out.println(" WELCOME TO WORD CLOUD MAIN MENU");
		System.out.println("==================================");
		System.out.println("1) Console");
		System.out.println("2) Graphical User Interface (GUI)");
		System.out.println("3) URL/ Web Content");

		try {
			do {

				System.out.println("Please, Enter Your Option...");
				optionNumber = in.nextInt();

				if (optionNumber == 1) {
					System.out.println("Console Option");
					UserInputRunnerConsole.scannerInput();

					UniquesWords words = new UniquesWords();
					words.createUniqueWords();
					ans = true;
				} else if (optionNumber == 2) {
					System.out.println("GUI Option");
					UserInputRunnerGUI runner = new UserInputRunnerGUI();
					runner.userInput();
					ans = true;
				} else if (optionNumber == 3) {
					System.out.println("URL/ Web Content Option");
					CreateURLUniquesWords unique = new CreateURLUniquesWords();

					UserInputRunnerURL.scannerInput();
					unique.createUniqueWords();
					ans = true;
				} else
					System.out.println("Invalid Input.");

			} while (ans == false);

		} catch (InputMismatchException ex) {
			System.out.println("Please Enter Numbers 1-3 Only");
		}

	}
}
