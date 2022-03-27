package com.facisa.arqi.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	public Optional<Client> findById(int id) {
		return clientRepository.findById(id);
	}
	
	public void deleteClient(int id) {
		clientRepository.deleteById(id);
	}
	
	public Client updateClient(int id, Client client) {
		Client p = clientRepository.getById(id);
		p.setName(client.getName());
		return clientRepository.save(p);
	}
}
