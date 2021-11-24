package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Libro;

public class LibrosServiceImpl implements LibrosService {
	private static List<Libro> libros;
	static {
		libros=new ArrayList<>();
		libros.add(new Libro(111,"Java básico","programación"));
		libros.add(new Libro(222,"Python avanzado","programación"));
		libros.add(new Libro(333,"HTML","web"));
		libros.add(new Libro(444,"Cisco","redes"));
		libros.add(new Libro(555,"JavaScript","programación"));
		libros.add(new Libro(666,"WordPress","web"));
	}
	@Override
	public Libro libroPorIsbn(int isbn) {
		return libros.stream()
				.filter(l->l.getIsbn()==isbn)
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Libro> librosPorTematica(String tematica) {
		return libros.stream()
				.filter(l->l.getTematica().equals(tematica))
				.collect(Collectors.toList());
	}

}
