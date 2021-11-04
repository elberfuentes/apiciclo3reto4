package co.usa.ciclo3.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.model.Audience;
import co.usa.ciclo3.ciclo3.repository.crud.AudienceCrudRepository;

@Repository
public class AudienceRepository {

    @Autowired
    AudienceCrudRepository audienceCrudRepository;

    public List<Audience>getAll(){
        return (List<Audience>)audienceCrudRepository.findAll();
    }

    public Optional<Audience>getAudience(int id){
        return audienceCrudRepository.findById(id);
    }

    public Audience save(Audience audience){
        return audienceCrudRepository.save(audience);
    }
    
}
