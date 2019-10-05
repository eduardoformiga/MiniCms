package br.com.eduardoformiga.minicms.iservice;

import br.com.eduardoformiga.minicms.model.Client;

import java.util.List;


public interface IClientService {
	Client findOne(Long  id);
	Client findOneByName(String name);
	List<Client> findAll();
	Client create(Client client);
	Client update(Long id, Client client);
	void delete(Long id);

}
