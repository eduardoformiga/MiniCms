package br.com.eduardoformiga.minicms.controller;

import br.com.eduardoformiga.minicms.iservice.ICityService;
import br.com.eduardoformiga.minicms.model.City;
import br.com.eduardoformiga.minicms.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = Constants.URL_PREFIX + "/cities")
public class CityController {

	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping
	public List<City> findAll() {
		return cityService.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		City city = cityService.findOne(id);

		return city != null ? ResponseEntity.ok().body(city) : ResponseEntity.notFound().build();
	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> findOneByName(@PathVariable String name) {
		City city = cityService.findOneByName(name);

		return city != null ? ResponseEntity.ok().body(city) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody City city, HttpServletResponse response) {
		City savedCity = cityService.create(city);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCity);
	}

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody City city, HttpServletResponse response) {
        City savedCity = cityService.update(id, city);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCity);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        cityService.delete(id);
    }

}
