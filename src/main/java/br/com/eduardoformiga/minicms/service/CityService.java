package br.com.eduardoformiga.minicms.service;

import br.com.eduardoformiga.minicms.iservice.ICityService;
import br.com.eduardoformiga.minicms.model.City;
import br.com.eduardoformiga.minicms.repository.CityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	public City findOne(Long id) {
		City savedCity = cityRepository.findOne(id);

		if (savedCity == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return savedCity;
	}

	@Override
	public City findOneByName(String name) {
		City savedCity = cityRepository.findOneByNameContainingIgnoreCase(name);

		if (savedCity == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return savedCity;
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
	public City update(Long id, City city) {
		City savedCity = findOne(id);
		BeanUtils.copyProperties(city, savedCity, "id");

		return cityRepository.save(savedCity);
	}

	@Override
	public void delete(Long id) {
		cityRepository.delete(id);
	}

}
