/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import locator.DatosLocator;
import model.Pais;

@Named("paisesService")
@RequestScoped
public class PaisesServiceImpl implements PaisesService {
    
    
    @Override
	public List<String> contienentes(){
    	return DatosLocator.streamPaises()
                .map(p->p.getContinente())
                .distinct()
                .collect(Collectors.toList());
    }
    
    @Override
	public List<Pais> paisesPorContinente(String continente){
        
            return DatosLocator.streamPaises()
                    .filter(p->p.getContinente().equals(continente))
                    .collect(Collectors.toList());
       
    }
    
    @Override
	public long poblacionContinente(String continente){
        
            return DatosLocator.streamPaises()
            	.filter(p->p.getContinente().equals(continente))
                .mapToLong(p->p.getHabitantes())
                .sum();
        
    }
}
