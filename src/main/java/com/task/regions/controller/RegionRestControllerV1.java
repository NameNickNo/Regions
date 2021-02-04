package com.task.regions.controller;

import com.task.regions.dao.RegionDao;
import com.task.regions.entity.Region;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/regions")
public class RegionRestControllerV1 {

    private final RegionDao regionDao;

    public RegionRestControllerV1(@Qualifier("regionDaoImpl") RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @GetMapping
    public ResponseEntity<List<Region>> getAll() {

        List<Region> regions = regionDao.getAllRegions();
        if (regions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getById(@PathVariable("id") Long regionId) {
        if (regionId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Region region = regionDao.getRegionById(regionId);
        if (region == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(region, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Region> createRegion(@RequestBody @Valid Region region) {

        if (region == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        regionDao.createRegion(region);
        return new ResponseEntity<>(region, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Region> updateRegion(@RequestBody @Valid Region region) {

        if (region == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        regionDao.updateRegion(region);
        return new ResponseEntity<>(region, HttpStatus.OK);
    }
}
