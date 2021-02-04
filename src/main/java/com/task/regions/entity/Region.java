package com.task.regions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    private Long id;

    @NotEmpty(message = "Name must not be empty!")
    @Min(value = 2,message = "Min size is 2!")
    private String name;

    @NotEmpty(message = "ShortName must not be empty!")
    @Max(value = 15, message = "Max size is 15!")
    private String shortName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(id, region.id) &&
                Objects.equals(name, region.name) &&
                Objects.equals(shortName, region.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName);
    }
}
