package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Audience;
import co.usa.ciclo3.ciclo3.repository.AudienceRepository;

@Service
public class AudienceServicio {

    @Autowired
    AudienceRepository audienceRepository;

    public List<Audience> getAll(){
        return audienceRepository.getAll();        
    }

    public Optional<Audience>getAudience(int id){
        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience audience){
        //Verificar si el id es nulo
        if (audience.getId()==null) {
            return audienceRepository.save(audience);            
        }else{ //Veridico si existe el id o no en la base de datos
            Optional<Audience> consulta=audienceRepository.getAudience(audience.getId());
            if (consulta.isEmpty()) {
                return audienceRepository.save(audience);
                
            } else {
                return audience;                
            }
        }

    }
    
}
