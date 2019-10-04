package br.com.eduardoformiga.minicms.controller;

import br.com.eduardoformiga.minicms.iservice.IClienteService;
import br.com.eduardoformiga.minicms.model.Cliente;
import br.com.eduardoformiga.minicms.util.Constantes;
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
@RequestMapping(value = Constantes.URL_PREFIX + "/clientes")
public class ClienteController {

	private IClienteService clienteService;

	@Autowired
	public ClienteController(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		Cliente cliente = clienteService.findOne(id);

		return cliente != null ? ResponseEntity.ok().body(cliente) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clientSalvo = clienteService.create(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clientSalvo);
	}

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cliente cliente, HttpServletResponse response) {
        Cliente savedCliente = clienteService.update(id, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        clienteService.delete(id);
    }


}
