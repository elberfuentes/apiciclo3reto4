package co.usa.ciclo3.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repository.crud.AdminCrudRepository;

@Repository
public class AdminRepository {

    @Autowired
    AdminCrudRepository adminCrudRepository;

    public List<Admin>getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin>getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    
    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }
}
