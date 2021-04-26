package eutopiagreen.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component

public class StartupFilter{
	
	private List<Startup> startups;
	public String location;
	public String sector;
    public int limit = 1;
    public int offset = 0;

	/**
	TO BE COMPLETED:
		Create a filter class, used by other methods, to filter by location and/or sector, with a "limit" property (limiting the results found) and an "offset" property (to paginate the results)
	 * @return 
	*/
	public List<Startup> getStartups() {
		return this.startups;
	}
	
	
	/**
	 * Constructor for StartupFilter
	 * @param startups
	 */
	public StartupFilter setStartups(List<Startup> startups) {
		this.startups = startups;
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public StartupFilter locationFilter() {
        this.startups = this.startups.stream().filter(startup -> startup.getLocation().getName().equals(this.location)).collect(Collectors.toList());
        return this;
    }
	
	/**
	 * 
	 * @param location
	 * @return
	 */
	public StartupFilter locationFilter(String location) {
        this.location = location;
        return this.locationFilter();
    }
	
	/**
	 * 
	 * @return
	 */
	public StartupFilter sectorFilter() {
        this.startups = this.startups.stream().filter(startup -> startup.getSector().getName().equals(this.sector)).collect(Collectors.toList());
        return this;
    }

    /**
     * apply the sector filter
     * @param sector input filter
     * @return StartupFilter
     */
    public StartupFilter sectorFilter(String sector) {
        this.sector = sector;
        return this.sectorFilter();
    }
    
    /**
     * 
     * @return StartupFilter
     */
    public StartupFilter withOffset() {
        this.startups = this.startups.subList(this.offset, this.startups.size());
        return this;
    }

    /**
     * 
     * @param offset
     * @return StartupFilter
     */
    public StartupFilter withOffset(int offset) {
        if (offset >= this.startups.size())
            this.offset = --offset;
        else
            this.offset = offset;
        
        return this.withOffset();
    }
    
    /**
     * 
     * @return StartupFilter
     */
    public StartupFilter withLimit() {
        this.startups = this.startups.subList(0, this.limit);
        return this;
    }
    
   
    /**
     * 
     * @param limit
     * @return StartupFilter
     */
    public StartupFilter withLimit(int limit) {
        this.limit = Math.min(limit, this.startups.size());
        return this.withLimit();
    }

    
	public String getLocation() {
		return location;
	}


	protected void setLocation(String location) {
		this.location = location;
	}


	public String getSector() {
		return sector;
	}


	protected void setSector(String sector) {
		this.sector = sector;
	}
    
}