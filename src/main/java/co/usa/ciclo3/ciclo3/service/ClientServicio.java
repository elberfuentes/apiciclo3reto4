package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;

@Service
public class ClientServicio {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();        
    }

    public Optional<Client>getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        //Verificar si el id es nulo
        if (client.getIdClient()==null) {
            return clientRepository.save(client);            
        }else{ //Veridico si existe el id o no en la base de datos
            Optional<Client> consulta=clientRepository.getClient(client.getIdClient());
            if (consulta.isEmpty()) {
                return clientRepository.save(client);
                
            } else {
                return client;                
            }
        }

    }

    public Client update(Client client) {
		if(client.getIdClient()!=null) {
			Optional<Client> consulta=clientRepository.getClient(client.getIdClient());
			if(!consulta.isEmpty()) {
				if(client.getName()!=null) {
					consulta.get().setName(client.getName());
				}
				if(client.getAge()!=null) {
					consulta.get().setAge(client.getAge());
				}
				if(client.getPassword()!=null) {
					consulta.get().setPassword(client.getPassword());
				}
				if(client.getEmail()!=null) {
					consulta.get().setEmail(client.getEmail());
				}
				clientRepository.save(consulta.get());
				return consulta.get();
			}else {
				return client;
			}
		}else {
			return client;
		}
	}
	
	public boolean deleteClient(int clientId) {
		Boolean consulta = getClient(clientId).map(client->{
			clientRepository.delete(client);
			return true;
		}).orElse(false);
		return consulta;
	}
    
}
