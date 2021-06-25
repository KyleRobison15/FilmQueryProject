package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.*;


public interface DatabaseAccessor {
  public Film findFilmById(int filmId);
  public Actor findActorById(int actorId);
//  public Language findLanguageById(int languageId);
  public List<Film> findFilmsByKeyword(String keyword);
  public List<Actor> findActorsByFilmId(int filmId);
  
}
