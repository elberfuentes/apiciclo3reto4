package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Elber Fernando Fuentes Moreno
 * @version 1.1
 */
@Entity
@Table(name = "audience")
public class Audience implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
	 * Se crea tabla con sus campos
	 * Se asigna atributo Id de la tabla
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Atributo name de la Audience
     */
    private String name;
    /**
     * Atributo owner de la Audience
     */
    private String owner;
    /**
     * Atributo capacity de la Audience
     */
    private Integer capacity;
    /**
     * Atributo description de la Audience
     */
    private String description;

    /**
	 * Relacion muchos a uno con category
	 * Una category tiene varias Audiences y una Audience pertenece a una category
	 */
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("audiences")
    private Category category;

    /**
	 * Relacion uno a muchos con la tabla message
	 * Una Audience tiene varios message y un message se crea a una Audience
	 */

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Message> messages;

    /**
	 * Relacion uno a muchos con la tabla reservations
	 * Una Audience tiene varias reservations pero una reservarion le pertenece a una Audience
	 */

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Reservation> reservations;

    /**
	 * Getters and Setters de los campos de Audience, y de la relaciones OneToMany y ManyToOne
	 * @return
	 */
 
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
}
