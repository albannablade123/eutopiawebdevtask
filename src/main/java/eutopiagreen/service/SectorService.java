package eutopiagreen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eutopiagreen.model.Sector;

@Service

public interface SectorService {
	List<Sector> findAll();
	
	Optional<Sector> findById(Long id);

}
