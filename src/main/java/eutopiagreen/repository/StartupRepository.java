package eutopiagreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eutopiagreen.model.Startup;

public interface StartupRepository extends JpaRepository<Startup,Long>{
	
}
