package eutopiagreen.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "startups")
public class Startup {
	/**TO BE COMPLETED:
	Create an entity to map the table "startups", with the following columns:
		- id 		INTEGER PRIMARY KEY
		- visibile 	BIT
		- name 		VARCHAR(255)
		- logo		VARCHAR(255)
		- country_id 	INTEGER
		- sector_id	INTEGER
	*/
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	@JsonProperty("id")
	private Long ID;
	@JsonProperty("id")
    
	
	private Boolean visibile;
	
	private String name;
	
	private String logo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Location location;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sector_id")
	private Sector sector;
	
	
	
	public Long getID() {
		return ID;
	}
	
	public void setID() {
		this.ID = ID;
	}
	
	public String getName() {
        return name;
    }
	
	public Startup(){}

    public Startup(Long iD, Boolean visibile, String name, String logo, Location country, Sector sector) {
		super();
		ID = iD;
		this.visibile = visibile;
		this.name = name;
		this.logo = logo;
		this.location = country;
		this.sector = sector;
	}

	public void setName(String name) {
        this.name = name;
    }
    
    public void setLogo() {
    	this.logo = logo;
    }
    
    public String getLogo() {
    	return logo;
    }

	protected Location getLocation() {
		return location;
	}

	protected void setLocation(Location location) {
		this.location = location;
	}

	protected Sector getSector() {
		return sector;
	}

	protected void setSector(Sector sector) {
		this.sector = sector;
	}
    
  
	
}

