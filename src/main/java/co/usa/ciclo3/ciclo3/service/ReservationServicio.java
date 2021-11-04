package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;

/**
 * 
 * @author Elber Fernando Fuentes Moreno
 * @version 1.1
 *
 */

@Service
public class ReservationServicio {

    /**
     * @return
     */

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();        
    }

    /**
     * 
     * @param id
     * @return
     */

    public Optional<Reservation>getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    /**
     * 
     * @param reservation
     * @return
     */

    public Reservation save(Reservation reservation){
        
        if (reservation.getIdReservation()==null) {
            return reservationRepository.save(reservation);            
        }else{ 
            Optional<Reservation> consulta=reservationRepository.getReservation(reservation.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepository.save(reservation);
                
            } else {
                return reservation;                
            }
        }

    }

    /**
     * se genera update
     * @param reservation
     * @return
     */

    public Reservation update(Reservation reservation) {
		/**
		 * Muestra un elemento de reservation y se realiza el update
		 */
		if(reservation.getIdReservation()!=null) {
			Optional<Reservation> consulta= reservationRepository.getReservation(reservation.getIdReservation());
			if(!consulta.isEmpty()) {
				if(reservation.getStartDate()!=null) {
					consulta.get().setStartDate(reservation.getStartDate());
				}
				if(reservation.getDevolutionDate()!=null) {
					consulta.get().setDevolutionDate(reservation.getDevolutionDate());
				}
				if(reservation.getStatus()!=null) {
					consulta.get().setStatus(reservation.getStatus());
				}
				reservationRepository.save(consulta.get());
				return consulta.get();
			}else {
				return reservation;
			}
		}else {
			return reservation;
		}
	}
    /**
     * se genera delete
     * @param reservationId
     * @return
     */
	public boolean deleteReservation(int reservationId) {
		/**
		 * Metodo delete reservation
		 */
		Boolean consulta = getReservation(reservationId).map(reservation ->{
			reservationRepository.delete(reservation);
			return true;
		}).orElse(false);
		return consulta;
	}
    
}
