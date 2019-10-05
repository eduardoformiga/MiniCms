package br.com.eduardoformiga.minicms.iservice;

import br.com.eduardoformiga.minicms.exceptionHandler.CityNotFoundException;
import br.com.eduardoformiga.minicms.model.City;

import java.util.List;


public interface ICityService {
	City findOne(Long id) throws CityNotFoundException;
	List<City> findByName(String name) throws CityNotFoundException;;
	List<City> findByStateName(String stateName) throws CityNotFoundException;
	List<City> findAll();
	City create(City client);
	City update(Long id, City client) throws CityNotFoundException;
	void delete(Long id);

}
