package co.usa.ciclo3.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {

 @Autowired
 CategoryCrudRepository categoryCrudRepository;

 public List<Category>getAll(){
    return (List<Category>)categoryCrudRepository.findAll();
}

public Optional<Category>getCategory(int id){
    return categoryCrudRepository.findById(id);
}

public Category save(Category category){
    return categoryCrudRepository.save(category);
}
 
}
