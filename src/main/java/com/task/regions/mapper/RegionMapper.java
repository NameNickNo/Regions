package com.task.regions.mapper;

import com.task.regions.entity.Region;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RegionMapper {

    @Results(id = "regionResultMap", value = {
            @Result(property = "shortName", column = "short_name")
    })
    @Select("SELECT id, name, short_name FROM regions")
    List<Region> getAll();


    @ResultMap("regionResultMap")
    @Select("SELECT id, name, short_name FROM regions WHERE id = #{id}")
    Region findById(@Param("id") long id);


    @Insert("INSERT INTO regions (id, name, short_name) VALUES (#{id}, #{name}, #{shortName})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void createRegion(Region region);

    @Delete("DELETE FROM regions WHERE id = #{id}")
    void deleteRegion(@Param("id") long id);

    @Update("Update regions SET name = #{name}, short_name = #{shortName} WHERE id = ${id}")
    void updateRegion(@Param("name") String name, @Param("shortName") String shortName, @Param("id") long id);
}
