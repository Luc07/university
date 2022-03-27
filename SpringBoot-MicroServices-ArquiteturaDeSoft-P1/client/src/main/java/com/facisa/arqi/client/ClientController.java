package com.facisa.arqi.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/client")
	public ResponseEntity<List<Client>> getClients() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.getClients());
	}
	
	@PostMapping("/client")
	public ResponseEntity<Client> createclient(@RequestBody Client client){
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(client));
	}
	
	@DeleteMapping("/client/{id}")
	public ResponseEntity<Object> deleteclient(@PathVariable int id) {
		clientService.deleteClient(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Client Deleted!");
	}
	
	@PutMapping("/client/{id}")
	public ResponseEntity<Client> updateclient(@PathVariable int id, @RequestBody Client client){
		return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(id, client));
	}
}
