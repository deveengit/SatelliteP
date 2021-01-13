package com.Constellation.satellite.service;

import java.util.Optional;

import com.Constellation.satellite.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Constellation.satellite.model.SatelliteModel;


@Service
public class SatelliteService {

    @Autowired
    SatelliteRepository SatelliteRepository;

    public void saveSatellite(SatelliteModel SatelliteModel) {
        SatelliteRepository.save(SatelliteModel);
    }

    public Iterable<SatelliteModel> getSatelliteHistory() {
        return SatelliteRepository.findAll();
    }

    public Optional<SatelliteModel> getSatellite(Long id) {
        return SatelliteRepository.findById(id);
    }

    public String deleteSatellite(Long id) {
        SatelliteRepository.deleteById(id);
        return "Satellite removed !! " + id;
    }

    public SatelliteModel updateSatellite(SatelliteModel SatelliteModel) {
        SatelliteModel existingSatellite = SatelliteRepository.findById(SatelliteModel.getSatelliteId()).orElse(null);
        existingSatellite.setSatelliteName(SatelliteModel.getSatelliteName());
        existingSatellite.setCountry(SatelliteModel.getCountry());
        existingSatellite.setStatus(SatelliteModel.getStatus());
        return SatelliteRepository.save(existingSatellite);

    }
}