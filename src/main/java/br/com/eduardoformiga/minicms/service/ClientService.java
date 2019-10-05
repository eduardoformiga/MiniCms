package br.com.eduardoformiga.minicms.service;

import br.com.eduardoformiga.minicms.iservice.IClientService;
import br.com.eduardoformiga.minicms.model.Client;
import br.com.eduardoformiga.minicms.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService implements IClientService {
	private ClienteRepository clienteRepository;

	@Autowired
	public ClientService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Client findOne(Long id) {
		Client savedClient = clienteRepository.findOne(id);

		if (savedClient == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return savedClient;
	}

	@Override
	public Client findOneByName(String name) {
		Client savedClient = clienteRepository.findOneByNameContainingIgnoreCase(name);

		if (savedClient == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return savedClient;
	}

	@Override
	public List<Client> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Client create(Client client) {
		return clienteRepository.save(client);
	}

	@Override
	@Transactional
	public Client update(Long id, Client client) {
		Client savedClient = findOne(id);
		BeanUtils.copyProperties(client, savedClient, "id");

		return clienteRepository.save(savedClient);
	}

	@Override
	public void delete(Long id) {
		clienteRepository.delete(id);
	}

}
