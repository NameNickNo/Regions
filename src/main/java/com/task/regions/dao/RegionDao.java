package com.task.regions.dao;

import com.task.regions.entity.Region;

import java.util.List;

public interface RegionDao {
    List<Region> getAllRegions();

    Region getRegionById(long id);

    void createRegion(Region region);

    void updateRegion(Region region);

    void deleteRegion(Region region);
}
