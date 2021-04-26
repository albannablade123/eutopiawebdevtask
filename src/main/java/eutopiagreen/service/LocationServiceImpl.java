package eutopiagreen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eutopiagreen.model.Location;
import eutopiagreen.repository.LocationRepository;

@Service

public class LocationServiceImpl implements LocationService{
	@Autowired
    private LocationRepository locationRepository;

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public Optional<Location> findById(Long id) {
		return locationRepository.findById(id);
	}


}
