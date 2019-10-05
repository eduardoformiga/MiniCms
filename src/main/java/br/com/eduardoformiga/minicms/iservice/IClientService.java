package br.com.eduardoformiga.minicms.iservice;

import br.com.eduardoformiga.minicms.exceptionHandler.ClientNotFoundException;
import br.com.eduardoformiga.minicms.model.Client;

import java.util.List;


public interface IClientService {
	Client findOne(Long  id) throws ClientNotFoundException;
	List<Client> findByName(String name) throws ClientNotFoundException;
	List<Client> findAll();
	Client create(Client client);
	Client update(Long id, Client client) throws ClientNotFoundException;
	void delete(Long id);

}
