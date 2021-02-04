package com.task.regions.controller;

import com.task.regions.AbstractTestClass;
import com.task.regions.dao.RegionDaoImpl;
import com.task.regions.entity.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RegionRestControllerV1Test extends AbstractTestClass {

    @Mock
    private RegionDaoImpl regionDao;

    @InjectMocks
    private RegionRestControllerV1 controllerV1;

    private static List<Region> regions;

    @BeforeEach
    void setUp() {
        regions = List.of(new Region(1L, "Test", "Case"));
    }

    @Test
    void methodGetAllShouldToCall_GetAllRegions() {
        when(regionDao.getAllRegions()).thenReturn(regions);
        controllerV1.getAll();
        verify(regionDao).getAllRegions();
    }

    @Test
    void methodGetByIdShouldToCall_GetRegionById() {
        Region region = regions.stream()
                .findAny().orElse(null);
        long regionId = 1L;
        when(regionDao.getRegionById(regionId)).thenReturn(region);
        controllerV1.getById(regionId);
        verify(regionDao).getRegionById(regionId);
    }

}