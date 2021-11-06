package co.usa.ciclo3.ciclo3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.Reportes.ReportsClient;
import co.usa.ciclo3.ciclo3.model.Reportes.ReportsStatus;
import co.usa.ciclo3.ciclo3.service.ReservationServicio;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ReservationControlador {

    @Autowired
    private ReservationServicio reservationServicio;

    @GetMapping("/all")
    public List<Reservation>getReservations(){
        return reservationServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation>getReservation(@PathVariable("id") int id){
        return reservationServicio.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationServicio.save(reservation);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationServicio.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservationServicio.deleteReservation(reservationId);
    }
    
    /**
     * Reports 
     * @return
     */
    
    @GetMapping("/report-status")
    public ReportsStatus getReservas(){
        return reservationServicio.reporteStatusServicio();
    }
    /**
     * 
     * @param dateOne
     * @param dateTwo
     * @return
     */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
     public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
         return reservationServicio.reporteTiempoServicio(dateOne, dateTwo);
     }
     /**
      * 
      * @return
      */
     @GetMapping("/report-clients")
     public List<ReportsClient> getClientes(){
         return reservationServicio.reporteClientesServicio();
     }
    
}
