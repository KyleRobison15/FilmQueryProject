package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.*;


public class DatabaseAccessorObject implements DatabaseAccessor {
	// Establish connection to DB
	// Convert to Maven project and add dependencies (modify pom file as needed)
	private static String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";
	// Register driver:
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/////////////////////////////////////////////////// FILM ///////////////////////////////////////////////////

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			while (filmResult.next()) {
				film = createFilmFromQuery(filmResult);
			}

			filmResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet filmResult = stmt.executeQuery();
			while (filmResult.next()) {
				Film film = new Film();
				film = createFilmFromQuery(filmResult);
				films.add(film);
			}

			filmResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return films;
	}

	public Film createFilmFromQuery(ResultSet filmResult) {
		Film film = new Film();

		try {

			film.setFilmId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setReleaseYear(filmResult.getString("release_year"));
			film.setLanguageId(filmResult.getInt("language_id"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setSpecialFeatures(filmResult.getString("special_features"));
			film.setRating(filmResult.getString("rating"));
			film.setLanguage(findLanguageByFilmId(filmResult.getInt("id")));
			film.setCategory(findCategoryByFilmId(filmResult.getInt("id")));
			film.setActors(findActorsByFilmId(filmResult.getInt("id")));
			film.setFilmsInInventory(findInventoryByFilmId(filmResult.getInt("id")));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}

/////////////////////////////////////////////////// ACTOR ///////////////////////////////////////////////////

	@Override
	public Actor findActorById(int actorId) {

		Actor actor = null;

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			while (actorResult.next()) {
				actor = new Actor();
				actor.setActorId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));

			}

			actorResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return actor;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * " + 
						 "FROM actor " + 
						 "JOIN film_actor ON film_actor.actor_id = actor.id " +
						 "JOIN film ON film_actor.film_id = film.id " + 
						 "WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorsResult = stmt.executeQuery();
			while (actorsResult.next()) {

				int actorId = actorsResult.getInt("actor.id");
				String actorFirstName = actorsResult.getString("actor.first_name");
				String actorLastName = actorsResult.getString("actor.last_name");
				Actor actor = new Actor(actorId, actorFirstName, actorLastName);
				actors.add(actor);
			}

			actorsResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return actors;
	}

/////////////////////////////////////////////////// LANGUAGE ///////////////////////////////////////////////////

	@Override
	public Language findLanguageByFilmId(int filmId) {

		Language language = null;

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * " +
						 "FROM language " +
						 "JOIN film ON language.id = film.language_id " +
						 "WHERE film.id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet languageResult = stmt.executeQuery();
			while (languageResult.next()) {
				language = new Language();
				language.setId(languageResult.getInt("id"));
				language.setLanguageName(languageResult.getString("name"));
			}

			languageResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return language;
	}
	
/////////////////////////////////////////////////// CATEGORY ///////////////////////////////////////////////////
	
	@Override
	public Category findCategoryByFilmId(int filmId) {
		
		Category category = null;
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			
			String sql = "SELECT * "
					  +  "FROM category "
					  +  "JOIN film_category ON film_category.category_id = category.id "
					  +  "JOIN film ON film_category.film_id = film.id WHERE film.id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet categoryResult = stmt.executeQuery();
			while (categoryResult.next()) {
				category = new Category();
				category.setCategoryId(categoryResult.getInt("id"));
				category.setCategoryName(categoryResult.getString("name"));
			}
			
			categoryResult.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return category;
	}
	
/////////////////////////////////////////////////// INVENTORY ITEM ///////////////////////////////////////////////////
	
	@Override
	public List<InventoryItem> findInventoryByFilmId(int filmId) {
		
		List<InventoryItem> inventory = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			
			String sql = "SELECT * "
					   + "FROM inventory_item "
					   + "WHERE film_id = ? AND media_condition != 'lost'";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet inventoryResult = stmt.executeQuery();
			while (inventoryResult.next()) {
				int inventoryId = inventoryResult.getInt("inventory_item.id");
				int inventoryFilmId = inventoryResult.getInt("inventory_item.film_id");
				int storeId = inventoryResult.getInt("inventory_item.store_id");
				String mediaCondition = inventoryResult.getString("inventory_item.media_condition");
				String lastUpdate = inventoryResult.getString("inventory_item.last_update");

				InventoryItem item = new InventoryItem(inventoryId, inventoryFilmId, storeId, mediaCondition, lastUpdate);
				inventory.add(item);
			}
			
			inventoryResult.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inventory;
	}
	
	
	
}
