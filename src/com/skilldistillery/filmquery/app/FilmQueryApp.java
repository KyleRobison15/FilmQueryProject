package com.skilldistillery.filmquery.app;

import java.util.List;
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
			System.out.println("2. Look up a films by a keyword search");
			System.out.println("3. Exit Application");
			System.out.println("---------------------------------------------");

			userChoice = input.nextInt();
			input.nextLine();
			usingMenu = doUserChoice(userChoice, input);
		}

	}

	private boolean doUserChoice(int userChoice, Scanner input) {

		switch (userChoice) {

		case 1:
			lookUpFilmById(input);
			return true;
		case 2:
			lookUpFilmByKeyword(input);
			return true;
		case 3:
			System.out.println("Thanks for using the Film Query App - Goodbye!");
			return false;
		default:
			System.out.println("Your entry was invalid. Please enter the number of the cooresponding menu item.");
			return true;

		}

	}

	public void lookUpFilmById(Scanner input) {

		try {
			System.out.println("Please enter the ID of the film.");
			int filmId = input.nextInt();
			input.nextLine();
			Film film = db.findFilmById(filmId);
			System.out.println("---------------------------------------------");
			film.displaySimpleFilmInfo();
			System.out.println("---------------------------------------------");

		} catch (NullPointerException e) {
			System.out.println("---------------------------------------------");
			System.out.println("Sorry, this ID was not found.");
		} catch (Exception e) {
			System.out.println("---------------------------------------------");
			System.out.println("Sorry, this ID was not found.");
		}
	}

	public void lookUpFilmByKeyword(Scanner input) {

		System.out.println("Please enter a keyword.");
		String keyword = input.nextLine();

		List<Film> films = db.findFilmsByKeyword(keyword);

		if (films.isEmpty()) {
			System.out.println("---------------------------------------------");
			System.out.println("Sorry, no films with this keyword were found.");
			System.out.println("---------------------------------------------");
			System.out.println();
		}

		else {
			for (Film film : films) {
				System.out.println("---------------------------------------------");
				film.displaySimpleFilmInfo();
				System.out.println("---------------------------------------------");
			}
		}
	}
}
