package com.Constellation.satellite.control;

import java.util.Optional;

import com.Constellation.satellite.exception.InvalidSatReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Constellation.satellite.model.SatelliteModel;
import com.Constellation.satellite.service.SatelliteService;

@RestController
@RequestMapping("/satellite")
public class SatelliteControl {

    @Autowired
    SatelliteService satelliteService;

    @PostMapping("/create")
    public Long createSatellite(@RequestBody SatelliteModel satellite) {
        satelliteService.saveSatellite(satellite);
        return satellite.getSatelliteId();
    }

    @GetMapping("/viewAll")
    public Iterable<SatelliteModel> viewAllSatellites() {
        return satelliteService.getSatelliteHistory();
    }

    @GetMapping("/view/{id}")
    public SatelliteModel viewSatelliteById(@PathVariable ("id") Long id) {
        Optional<SatelliteModel> satellite = satelliteService.getSatellite(id);
        if(satellite.isPresent()) {
            return satellite.get();
        }

        throw new InvalidSatReference("Invalid Satellite reference");
    }

    @PutMapping("/update")
    public Long updateSatellite(@RequestBody SatelliteModel satellite) {
        satelliteService.updateSatellite(satellite);
        return satellite.getSatelliteId();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSatellite(@PathVariable ("id") long id) {
        Optional<SatelliteModel> satellite = satelliteService.getSatellite(id);
        if(satellite.isPresent()) {
            return satelliteService.deleteSatellite(id);
        }

        throw new InvalidSatReference("Invalid Satellite reference");
    }
}