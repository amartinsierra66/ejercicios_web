package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Pagina;

public class BuscadorServiceImpl implements BuscadorService {
	List<Pagina> items=List.of(new Pagina("Casa del libro","http://casadellibro.es", new String[]{"libros","lectura","ocio"},"Libros y más cosas"),
			new Pagina("La web del gamer","http://gamers.es", new String[]{"juegos","ordenadores","ocio"},"Todo sobre video juegos"),
			new Pagina("My computer","http://computerall.es", new String[]{"informática","ordenadores"},"Ordenadores al mejor precio"),
			new Pagina("Fnac","http://fnac.es", new String[]{"juegos","ordenadores","libros"},"Bienvenido al mundo del ocio y la cultura"),
			new Pagina("Todo pelis","http://filmers.es", new String[]{"cine","peliculas","ocio"},"Entra en el mundo del cine"));		
	@Override
	public List<Pagina> buscar(String clave) {
		
		/*return items.stream()
				.filter(p->Arrays.stream(p.getSeo())
								.anyMatch(s->s.equals(clave)))
				.collect(Collectors.toList());*/
		return items.stream()
				.filter(p->Arrays.asList(p.getSeo()).contains(clave))
				.collect(Collectors.toList());
	}

}
