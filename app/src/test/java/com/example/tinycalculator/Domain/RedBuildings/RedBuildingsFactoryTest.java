package com.example.tinycalculator.Domain.RedBuildings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Enums.RedEnum;

import org.junit.Test;

public class RedBuildingsFactoryTest {
    @Test
    public void createRedBuilding_ShouldCreateFarm(){
        RedBuilding farm = RedBuildingsFactory.createRedBuilding(Pair.create(0,0), RedEnum.Farm);
        assertEquals(Pair.create(0,0), farm.position);
        assertThat(farm, instanceOf(Farm.class));
    }

    @Test
    public void createRedBuilding_ShouldCreateGranary(){
        RedBuilding granary = RedBuildingsFactory.createRedBuilding(Pair.create(0,0), RedEnum.Granary);
        assertEquals(Pair.create(0,0), granary.position);
        assertThat(granary, instanceOf(Granary.class));
    }

    @Test
    public void createRedBuilding_ShouldCreateOrchard(){
        RedBuilding orchard = RedBuildingsFactory.createRedBuilding(Pair.create(0,0), RedEnum.Orchard);
        assertEquals(Pair.create(0,0), orchard.position);
        assertThat(orchard, instanceOf(Orchard.class));
    }

    @Test
    public void createRedBuilding_ShouldCreateGreenhouse(){
        RedBuilding greenhouse = RedBuildingsFactory.createRedBuilding(Pair.create(0,0), RedEnum.Greenhouse);
        assertEquals(Pair.create(0,0), greenhouse.position);
        assertThat(greenhouse, instanceOf(Greenhouse.class));
    }
}
