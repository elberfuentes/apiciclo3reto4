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
    
    public Audience update(Audience audience) {
		if(audience.getId()!=null) {
			Optional<Audience> consulta=audienceRepository.getAudience(audience.getId());
			if(!consulta.isEmpty()) {
				if(audience.getOwner()!=null) {
					consulta.get().setOwner(audience.getOwner());
				}
				if(audience.getCapacity()!=null) {
					consulta.get().setCapacity(audience.getCapacity());
				}
				if(audience.getName()!=null){
					consulta.get().setName(audience.getName());
				}
				if(audience.getDescription()!=null) {
					consulta.get().setDescription(audience.getDescription());
				}
				if(audience.getCategory()!=null) {
					consulta.get().setCategory(audience.getCategory());
				}
				audienceRepository.save(consulta.get());
				return consulta.get();
			}else {
				return audience;
			}
		}else {
			return audience;
		}
	}
	
	
	public boolean deleteAudience(int audienceId) {
		Optional<Audience> consulta=audienceRepository.getAudience(audienceId);
        if (!consulta.isEmpty()) {
            audienceRepository.delete(consulta.get());
            return true;
            
        }
        return false;
    }
	
}
