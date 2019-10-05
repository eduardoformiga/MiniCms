package br.com.eduardoformiga.minicms.service;

import br.com.eduardoformiga.minicms.iservice.IClientService;
import br.com.eduardoformiga.minicms.model.Client;
import br.com.eduardoformiga.minicms.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	public Client findOne(Long id) {
		Client savedClient = clientRepository.findOne(id);

		if (savedClient == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return savedClient;
	}

	@Override
	public Client findOneByName(String name) {
		Client savedClient = clientRepository.findOneByNameContainingIgnoreCase(name);

		if (savedClient == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return savedClient;
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
	public Client update(Long id, Client client) {
		Client savedClient = findOne(id);
		BeanUtils.copyProperties(client, savedClient, "id");

		return clientRepository.save(savedClient);
	}

	@Override
	public void delete(Long id) {
		clientRepository.delete(id);
	}

}
