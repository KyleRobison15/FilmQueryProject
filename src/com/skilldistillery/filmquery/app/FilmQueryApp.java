package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int userChoice = 0;
		boolean usingMenu = true;

		while (usingMenu) {
			System.out.println("------- WELCOME TO THE FILM QUERY APP -------");
			System.out.println("Please select an option from the menu below.");
			System.out.println("---------------------------------------------");
			System.out.println("1. Look up a film by its ID");
			System.out.println("2. Look up a film by a keyword search");
			System.out.println("3. Exit Application");
			System.out.println("---------------------------------------------");

			userChoice = input.nextInt();
			input.nextLine();
			usingMenu = doUserChoice(userChoice);
		}
		
		
	}

	private boolean doUserChoice(int userChoice) {

		switch (userChoice) {

		case 1:
			// TODO Add method call to look up film by it's ID
			return true;
		case 2:
			// TODO Add method call to look up film by keyword search
			return true;
		case 3:
			System.out.println("Thanks for using the Film Query App - Goodbye!");
			return false;
		default:
			System.out.println("Your entry was invalid. Please enter the number of the cooresponding menu item.");
			return true;

		}

	}

}
