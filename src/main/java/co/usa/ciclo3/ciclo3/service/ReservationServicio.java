package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;

@Service
public class ReservationServicio {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();        
    }

    public Optional<Reservation>getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        //Verificar si el id es nulo
        if (reservation.getIdReservation()==null) {
            return reservationRepository.save(reservation);            
        }else{ //Veridico si existe el id o no en la base de datos
            Optional<Reservation> consulta=reservationRepository.getReservation(reservation.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepository.save(reservation);
                
            } else {
                return reservation;                
            }
        }

    }
    
}
