package co.usa.ciclo3.ciclo3.repository.crud;

import org.springframework.data.repository.CrudRepository;

import co.usa.ciclo3.ciclo3.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}
