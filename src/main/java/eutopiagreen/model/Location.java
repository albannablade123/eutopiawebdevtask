package eutopiagreen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("id")
    @Column(name = "id")
    private Long ID;
    @JsonProperty("label")
    private String name;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

