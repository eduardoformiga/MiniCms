package br.com.eduardoformiga.minicms.service;

import br.com.eduardoformiga.minicms.exceptionHandler.CityNotFoundException;
import br.com.eduardoformiga.minicms.iservice.ICityService;
import br.com.eduardoformiga.minicms.model.City;
import br.com.eduardoformiga.minicms.repository.CityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService implements ICityService {
	private CityRepository cityRepository;

	@Autowired
	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public City findOne(Long id) throws CityNotFoundException {
		City savedCity = cityRepository.findOne(id);

		if (savedCity == null) {
            throw new CityNotFoundException("City not found");
		}

		return savedCity;
	}

	@Override
	public List<City> findByName(String name) throws CityNotFoundException {
        List<City> cities = cityRepository.findOneByNameContainingIgnoreCase(name);

		if (cities.isEmpty()) {
            throw new CityNotFoundException("City not found");
		}

		return cities;
	}

	@Override
	public List<City> findByStateName(String stateName) throws CityNotFoundException {
        List<City> cities = cityRepository.findByStateNameIgnoreCase(stateName);

		if (cities.isEmpty()) {
			throw new CityNotFoundException("City not found");
		}

		return cities;
	}

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	@Transactional
	public City create(City city) {
	    return cityRepository.save(city);
	}

	@Override
	@Transactional
	public City update(Long id, City city) throws CityNotFoundException {
		City savedCity = findOne(id);
		BeanUtils.copyProperties(city, savedCity, "id");

		return cityRepository.save(savedCity);
	}

	@Override
	public void delete(Long id) {
		cityRepository.delete(id);
	}

}
