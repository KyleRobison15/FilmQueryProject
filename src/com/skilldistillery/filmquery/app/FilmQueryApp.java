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
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int userChoice = 0;
		int menu = 1;
		boolean usingMenu = true;
		Film film = null;

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
			usingMenu = doUserChoice(menu, userChoice, film, input);
		}

	}

	private boolean doUserChoice(int menu, int userChoice, Film film, Scanner input) {
		
		if (menu == 1) {

			switch (userChoice) {

			case 1:
				film = lookUpFilmById(input, film);
				System.out.println("---------------------------------------------");
				film.displaySimpleFilmInfo();
				System.out.println("---------------------------------------------");
				userChoice = filmSubMenu(input, film);
				if(userChoice == 3) {
					return false;
				}
				else {
					return true;
				}
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

		else if (menu == 2) {

			switch (userChoice) {

			case 1:
				System.out.println("---------------------------------------------");
				film.displayAllFilmInfo();
				System.out.println("---------------------------------------------");
				return true;
			case 2:
				startUserInterface(input);
				return true;
			case 3:
				System.out.println("Thanks for using the Film Query App - Goodbye!");
				return false;
			default:
				System.out.println("Your entry was invalid. Please enter the number of the cooresponding menu item.");
				return true;
			}
		} 
		
		else {
			return false;
		}
		
	}

	public Film lookUpFilmById(Scanner input, Film film) {
		
		try {
			System.out.println("Please enter the ID of the film.");
			int filmId = input.nextInt();
			input.nextLine();
			film = db.findFilmById(filmId);

		} catch (NullPointerException e) {
			System.out.println("---------------------------------------------");
			System.out.println("Sorry, this ID was not found.");
		} catch (Exception e) {
			System.out.println("---------------------------------------------");
			System.out.println("Sorry, this ID was not found.");
		}
		
		return film;
	}

	public int filmSubMenu(Scanner input, Film film) {
		int userChoice;
		int menu = 2;

		System.out.println("------------------ SUB MENU -----------------");
		System.out.println("Please select an option from the menu below.");
		System.out.println("---------------------------------------------");
		System.out.println("1. View all film details");
		System.out.println("2. Return to Main Menu");
		System.out.println("3. Exit Application");
		System.out.println("---------------------------------------------");

		userChoice = input.nextInt();
		input.nextLine();
		doUserChoice(menu, userChoice, film, input);
		return userChoice;
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
