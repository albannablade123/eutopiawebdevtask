package eutopiagreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eutopiagreen.model.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
