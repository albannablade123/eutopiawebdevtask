package eutopiagreen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eutopiagreen.model.Location;

@Service

public interface LocationService {
	
	List<Location> findAll();
	
	Optional<Location> findById(Long id);

}