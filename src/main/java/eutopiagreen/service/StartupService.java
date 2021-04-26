package eutopiagreen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eutopiagreen.model.Startup;

@Service

public interface StartupService {
	
	List<Startup> findAll();
	
	Optional<Startup> findById(Long id);
	
}