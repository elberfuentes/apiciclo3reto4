package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;

@Service
public class MessageServicio {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();        
    }

    public Optional<Message>getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        //Verificar si el id es nulo
        if (message.getIdMessage()==null) {
            return messageRepository.save(message);            
        }else{ //Veridico si existe el id o no en la base de datos
            Optional<Message> consulta=messageRepository.getMessage(message.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepository.save(message);
                
            } else {
                return message;                
            }
        }

    }
    
}
