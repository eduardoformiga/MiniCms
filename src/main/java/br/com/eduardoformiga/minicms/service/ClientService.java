package br.com.eduardoformiga.minicms.service;

import br.com.eduardoformiga.minicms.exceptionHandler.ClientNotFoundException;
import br.com.eduardoformiga.minicms.iservice.IClientService;
import br.com.eduardoformiga.minicms.model.Client;
import br.com.eduardoformiga.minicms.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService implements IClientService {
	private ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client findOne(Long id) throws ClientNotFoundException {
		Client savedClient = clientRepository.findOne(id);

		if (savedClient == null) {
            throw new ClientNotFoundException("Client not found");
		}

		return savedClient;
	}

	@Override
	public List<Client> findByName(String name) throws ClientNotFoundException {
		List<Client> clients = clientRepository.findByNameContainingIgnoreCase(name);

		if (clients.isEmpty()) {
			throw new ClientNotFoundException("Client not found");
		}

		return clients;
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	@Transactional
	public Client create(Client client) {
		return clientRepository.save(client);
	}

	@Override
	@Transactional
	public Client update(Long id, Client client) throws ClientNotFoundException {
		Client savedClient = findOne(id);
		BeanUtils.copyProperties(client, savedClient, "id");

		return clientRepository.save(savedClient);
	}

	@Override
	public void delete(Long id) {
        clientRepository.delete(id);
	}

}
