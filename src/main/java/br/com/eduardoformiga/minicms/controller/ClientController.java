package br.com.eduardoformiga.minicms.controller;

import br.com.eduardoformiga.minicms.iservice.IClientService;
import br.com.eduardoformiga.minicms.model.Client;
import br.com.eduardoformiga.minicms.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = Constants.URL_PREFIX + "/clients")
public class ClientController {

	private IClientService clientService;

	@Autowired
	public ClientController(IClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping
	public List<Client> findAll() {
		return clientService.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		Client client = clientService.findOne(id);

		return client != null ? ResponseEntity.ok().body(client) : ResponseEntity.notFound().build();
	}
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> findOneByName(@PathVariable String name) {
		Client client = clientService.findOneByName(name);

		return client != null ? ResponseEntity.ok().body(client) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Client client, HttpServletResponse response) {
		Client savedClient = clientService.create(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
	}

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Client client, HttpServletResponse response) {
        Client savedClient = clientService.update(id, client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        clientService.delete(id);
    }


}
