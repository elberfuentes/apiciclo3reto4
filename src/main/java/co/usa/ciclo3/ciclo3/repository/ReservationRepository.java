package co.usa.ciclo3.ciclo3.repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.Reportes.ReportsClient;
import co.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;

public class ReservationRepository {

    @Autowired
    ReservationCrudRepository reservationCrudRepository;

    public List<Reservation>getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
    }

    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete(Reservation reservation) {
		reservationCrudRepository.delete(reservation);
	}

    /**
	 * Reto 5
	 */
	public List<Reservation> ReservacionStatusRepositorio (String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    
    public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    /**
     * Create JSON
     * @return
     */
    public List<ReportsClient> getClientesRepositorio(){
        List<ReportsClient> res= new ArrayList<>();

        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ReportsClient((Long)report.get(i)[1], (Client)report.get(i)[1]));
        }
        return res;
    }
    
}
