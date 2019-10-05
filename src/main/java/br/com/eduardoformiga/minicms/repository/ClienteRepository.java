package br.com.eduardoformiga.minicms.repository;

import br.com.eduardoformiga.minicms.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long> {
    Client findOneByNameContainingIgnoreCase(String name);
}
