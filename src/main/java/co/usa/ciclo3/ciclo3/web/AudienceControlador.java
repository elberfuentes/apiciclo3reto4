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

import co.usa.ciclo3.ciclo3.model.Audience;
import co.usa.ciclo3.ciclo3.service.AudienceServicio;



@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class AudienceControlador {
    
    @Autowired
    private AudienceServicio audienceServicio;

    @GetMapping("/all")
    public List<Audience>getAudiences(){
        return audienceServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Audience>getAudience(@PathVariable("id") int id){
        return audienceServicio.getAudience(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience save(@RequestBody Audience audience){
        return audienceServicio.save(audience);

    }

    @PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Audience update(@RequestBody Audience audience) {
		return audienceServicio.update(audience); 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int audienceId) {
		return audienceServicio.deleteAudience(audienceId);
	}
}
