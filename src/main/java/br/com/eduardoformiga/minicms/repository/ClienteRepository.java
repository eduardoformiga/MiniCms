package br.com.eduardoformiga.minicms.repository;

import br.com.eduardoformiga.minicms.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findOneByNomeContainingIgnoreCase(String name);
}
