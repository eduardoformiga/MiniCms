package br.com.eduardoformiga.minicms.repository;

import br.com.eduardoformiga.minicms.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findOneByNameContainingIgnoreCase(String name);
}
