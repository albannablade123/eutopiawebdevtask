package eutopiagreen.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eutopiagreen.model.Startup;
import eutopiagreen.repository.StartupRepository;

@Service

public class StartupServiceImpl implements StartupService {
	@Autowired
    private StartupRepository startupRepository;
	
	Logger logger = LoggerFactory.getLogger(StartupServiceImpl.class);
	
	@Override
	public List<Startup> findAll() {
		return startupRepository.findAll();
	}

	@Override
	public Optional<Startup> findById(Long id) {
		return startupRepository.findById(id);
	}
	
	

}
