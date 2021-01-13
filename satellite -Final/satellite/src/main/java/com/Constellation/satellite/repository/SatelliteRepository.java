package com.Constellation.satellite.repository;

import com.Constellation.satellite.model.SatelliteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SatelliteRepository extends CrudRepository<SatelliteModel, Long>{

}