package co.usa.ciclo3.ciclo3.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.Reportes.ReportsClient;
import co.usa.ciclo3.ciclo3.model.Reportes.ReportsStatus;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;


@Service
public class ReservationServicio {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();        
    }

    public Optional<Reservation>getReservation(int id){
        return reservationRepository.getReservation(id);
    }

   

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

   

    public Reservation update(Reservation reservation) {
		
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
   
	public boolean deleteReservation(int reservationId) {
	
		Boolean consulta = getReservation(reservationId).map(reservation ->{
			reservationRepository.delete(reservation);
			return true;
		}).orElse(false);
		return consulta;
	}

    
	public ReportsStatus reporteStatusServicio (){
        List<Reservation>completed= reservationRepository.ReservacionStatusRepositorio("completed");
        List<Reservation>cancelled= reservationRepository.ReservacionStatusRepositorio("cancelled");
      
        return new ReportsStatus(completed.size(), cancelled.size() );
    }
   
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }
    
     public List<ReportsClient> reporteClientesServicio(){
            return reservationRepository.getClientesRepositorio();
        }
    
}
