package eutopiagreen;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eutopiagreen.model.Startup;
import eutopiagreen.model.StartupFilter;
import eutopiagreen.service.StartupServiceImpl;

/**
TO BE COMPLETED:
	Allow REST controller
*/

@ComponentScan(value = "eutopiagreen.controller")
@RestController
public class APIController {
	
	@Autowired
	private StartupServiceImpl startupService;
	/**
	TO BE COMPLETED:
		Map this method to "/getStartupList", consuming a JSON and producing a JSON
	*/
	
	
	@PostMapping(path = "/getStartupList", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HashMap<String,Object>> getStartupList(@RequestBody StartupFilter startupFilter) {
		/**
		TO BE COMPLETED:
			Return a ResponseEntity containing a HashMap<String, Object> with two items:
				- "results", with a List<Startup> applying any filter in "startupFilter"
				- "count", with the total number of results found with the filters above, excluding offset and limit
		*/
		
		//Retrieve Startup list
		List<Startup> listOfStartup = startupService.findAll();

		//Apply Sector filter
		if (startupFilter.getSector() != null) {
			listOfStartup = startupFilter.setStartups(listOfStartup).sectorFilter(startupFilter.getSector()).getStartups();
		}
		
		//Apply Location filter
		if (startupFilter.getLocation() != null) {
			listOfStartup = startupFilter.setStartups(listOfStartup).locationFilter(startupFilter.getLocation()).getStartups();
		}
        
		//Apply pagination and l
		listOfStartup = startupFilter.withOffset(startupFilter.offset).withLimit(startupFilter.limit).getStartups();
		

//		//Initialize Hashmap
		HashMap<String,Object> startupMap = new HashMap<String, Object>();
//		//Insert Count
		startupMap.put("count",listOfStartup.size());
		//Insert results counts
		startupMap.put("results",listOfStartup);
		
		return new ResponseEntity<>(startupMap, HttpStatus.OK);

	}
	
	/**
	TO BE COMPLETED:
		Map this method to "/getStartup/{id}", producing a JSON
	*/
	@RequestMapping(value="/getStartup/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Startup> getStartup(@PathVariable Long id) {
		
//		/**
//		TO BE COMPLETED:
//			Return a ResponseEntity containing th Startup with id corresponding to "id", with the following cases:
//				- startup found
//				- startup not found
//				- "id" is null
//		*/
		//Check if Id is not null
		if(id != null) {
			Optional<Startup> result = this.startupService.findById(id);
			//With lambda function, we can check if result is found, or else it returns not found
			return result.map(startup -> new ResponseEntity(startup,HttpStatus.OK)).orElseGet(()-> new ResponseEntity("Startup not found",HttpStatus.NOT_FOUND));
		}
		//Condition if id is null
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		
	}
}

