package service;

import java.util.List;

import model.Libro;

public interface LibrosService {
	Libro libroPorIsbn(int isbn);
	List<Libro> librosPorTematica(String tematica);
}
