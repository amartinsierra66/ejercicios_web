package service;

import java.util.List;

import model.Pais;

public interface PaisesService {

	List<String> contienentes();

	List<Pais> paisesPorContinente(String continente);

	long poblacionContinente(String continente);

}