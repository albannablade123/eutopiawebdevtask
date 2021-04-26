package eutopiagreen;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import eutopiagreen.model.Location;
import eutopiagreen.model.Sector;
import eutopiagreen.model.Startup;
import eutopiagreen.repository.LocationRepository;
import eutopiagreen.repository.SectorRepository;
import eutopiagreen.service.StartupServiceImpl;

@Controller
public class ApplicationController {
	@Autowired
	private LocationRepository fetchLocation;
	
	@Autowired
	private SectorRepository fetchSector;
	
	@Autowired
	private StartupServiceImpl startupService;
	
	@Autowired
	private APIController apiController;

	/**
	TO BE COMPLETED:
		Map this method to the path "/"
	*/
	@RequestMapping("/")
	public String index(Model model) {
	/**
	 * 
	TO BE COMPLETED:
		Here the candidate will need to extract from the DB all the necessary filters, which will be displayed on the home page
		- Add to "model" an attribute called "locations", a JSON with all the countries in the DB (see Location.java)
		- Add to "model" an attribute called "sectors", a JSON with all the sectors in the DB (see Sector.java)
	*/
		//Retrieve All Location as a List
		List<Location> listOfLocations = fetchLocation.findAll();
		
		//Retrieve All Sectors as a List
		List<Sector> listOfSectors = fetchSector.findAll();
		
		//Insert Both Sectors and Locations to list
		model.addAttribute("sectors",listOfSectors);
		model.addAttribute("locations",listOfLocations);	
		
		System.out.println("Model Location added succesfully");
		
		return "index";
	}


	/**
	TO BE COMPLETED:
		Map this method to the path "/{id}", where "id" corresponds to the startup id
	*/
	@RequestMapping("/{id}")
	public String detail(Model model, /**TO BE COMPLETED: map url param "id" to the following long variable */@PathVariable Long id) {
	/**
	TO BE COMPLETED:
		Here the candidate will need to extract from the DB all the details about a single startup, which will be displayed on the detail page
		- Add to "model" an attribute called "startup", with the Startup.java object corresponding to "id"
		- Add to "model" an attribute called "startupJSON", a JSON with the details above already in JSON format
	*/	
		
		//Add to model attribute startup
		try {
			if(id != null) {
				Optional<Startup> startup = startupService.findById(id);
				model.addAttribute("startup",startup);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Adding model to an attribute in JSON format, using API Controller class
		ResponseEntity<Startup> startupJson = apiController.getStartup(id);
		model.addAttribute("startupJson", startupJson);
		
		System.out.println("Model By ID added succesfully");
		
		return "detail";
	}
}

