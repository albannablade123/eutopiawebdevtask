package eutopiagreen;

import eutopiagreen.model.Startup;
import eutopiagreen.model.StartupFilter;
import eutopiagreen.service.StartupServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(value = "eutopiagreen.controller")
public class MainController {
	@Autowired
	private StartupServiceImpl startupService;

	public List<Startup> getStartupListCore(StartupFilter filter) {
	/**
	TO BE COMPLETED:
		Retrieve from the DB a list of Startups, applying any filter in "filter"
	*/
		//Initialize the list of startup using services
		List<Startup> startupCore = startupService.findAll();
		
	//Apply filters
		startupCore = filter.setStartups(startupCore).sectorFilter().withLimit().withOffset().getStartups();
		
		return startupCore;
		
	}
}

