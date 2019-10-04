package br.com.eduardoformiga.minicms.iservice;

import br.com.eduardoformiga.minicms.model.Cliente;

import java.util.List;


public interface IClienteService {
	Cliente findOne(Long  id);
	List<Cliente> findAll();
	Cliente create(Cliente cliente);
	Cliente update(Long id, Cliente cliente);
	void delete(Long id);

}
