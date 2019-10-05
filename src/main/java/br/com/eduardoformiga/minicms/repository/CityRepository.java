package br.com.eduardoformiga.minicms.repository;

import br.com.eduardoformiga.minicms.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findOneByNameContainingIgnoreCase(String name);
    List<City> findByStateNameIgnoreCase(String stateName);
}
