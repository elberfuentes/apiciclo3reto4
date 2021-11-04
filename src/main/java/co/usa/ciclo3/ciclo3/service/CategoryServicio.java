package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;

@Service
public class CategoryServicio {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();        
    }

    public Optional<Category>getCategory(int CategoryId){
        return categoryRepository.getCategory(CategoryId);
    }

    public Category save(Category category){
        //Verificar si el id es nulo
        if (category.getId()==null) {
            return categoryRepository.save(category);            
        }else{ //Veridico si existe el id o no en la base de datos
            Optional<Category> consulta=categoryRepository.getCategory(category.getId());
            if (consulta.isEmpty()) {
                return categoryRepository.save(category);
                
            } else {
                return category;                
            }
        }

    }
    
}
