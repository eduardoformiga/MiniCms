package br.com.eduardoformiga.minicms.service;

import br.com.eduardoformiga.minicms.iservice.IClienteService;
import br.com.eduardoformiga.minicms.model.Cliente;
import br.com.eduardoformiga.minicms.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService implements IClienteService {
	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Cliente findOne(Long id) {
		Cliente savedCliente = clienteRepository.findOne(id);

		if (savedCliente == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return savedCliente;
	}

	@Override
	public Cliente findOneByNome(String name) {
		Cliente savedCliente = clienteRepository.findOneByNomeContainingIgnoreCase(name);

		if (savedCliente == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return savedCliente;
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Cliente create(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public Cliente update(Long id, Cliente cliente) {
		Cliente clienteSalvo = findOne(id);
		BeanUtils.copyProperties(cliente, clienteSalvo, "id");

		return clienteRepository.save(clienteSalvo);
	}

	@Override
	public void delete(Long id) {
		clienteRepository.delete(id);
	}

}
