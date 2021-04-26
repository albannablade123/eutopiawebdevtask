package eutopiagreen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eutopiagreen.model.Sector;
import eutopiagreen.repository.SectorRepository;
@Service

public class SectorServiceImpl implements SectorService {
	@Autowired
    private SectorRepository sectorRepository;

	@Override
	public List<Sector> findAll() {
		return sectorRepository.findAll();
	}

	@Override
	public Optional<Sector> findById(Long id) {
		return sectorRepository.findById(id);
	}
}
