package com.arturnowicki.movies1.controllers;

import java.sql.SQLException;
import java.util.List;

import com.arturnowicki.movies1.database.data.Movie;

public interface MoviesManagerInterface {

	public void addOrUpdate(Movie movie) throws SQLException;
	
	public void delete(int movieId) throws SQLException;
	
	public void download(int movieId) throws SQLException;
	
	public List<Movie> search() throws SQLException;

}
