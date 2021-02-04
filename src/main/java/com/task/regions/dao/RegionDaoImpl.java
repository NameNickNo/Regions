package com.task.regions.dao;

import com.task.regions.entity.Region;
import com.task.regions.mapper.RegionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class RegionDaoImpl implements RegionDao {
    private final RegionMapper regionMapper;

    public RegionDaoImpl(RegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    @Cacheable("regions")
    public List<Region> getAllRegions() {
        log.info("RegionDao method getAllRegions() {}", regionMapper.getAll().toString());
        return regionMapper.getAll();
    }

    @Cacheable("region")
    public Region getRegionById(long id) {
        log.info("RegionDao method getRegionById() {}",regionMapper.findById(id).toString());
        return regionMapper.findById(id);
    }

    public void createRegion(Region region) {
        log.info("RegionDao method createRegion() {}", region.toString());
        regionMapper.createRegion(region);
    }

    public void updateRegion(Region region) {
        log.info("RegionDaoImpl method updateRegion() {}", region.toString());
        regionMapper.updateRegion(region.getName(), region.getShortName(), region.getId());
    }

    public void deleteRegion(Region region) {
        log.info("RegionDao method deleteRegion() {}", region.toString() );
        regionMapper.deleteRegion(region.getId());
    }
}
