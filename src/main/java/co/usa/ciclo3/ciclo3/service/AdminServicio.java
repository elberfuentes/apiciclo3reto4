package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repository.AdminRepository;

@Service
public class AdminServicio {

    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();        
    }

    public Optional<Admin>getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin){
        //Verificar si el id es nulo
        if (admin.getIdAdmin()==null) {
            return adminRepository.save(admin);            
        }else{ //Veridico si existe el id o no en la base de datos
            Optional<Admin> consulta=adminRepository.getAdmin(admin.getIdAdmin());
            if (consulta.isEmpty()) {
                return adminRepository.save(admin);
                
            } else {
                return admin;                
            }
        }

    }
    
}
