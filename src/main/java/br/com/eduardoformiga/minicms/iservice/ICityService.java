package br.com.eduardoformiga.minicms.iservice;

import br.com.eduardoformiga.minicms.model.City;

import java.util.List;


public interface ICityService {
	City findOne(Long id);
	City findOneByName(String name);
	List<City> findAll();
	City create(City client);
	City update(Long id, City client);
	void delete(Long id);

}
