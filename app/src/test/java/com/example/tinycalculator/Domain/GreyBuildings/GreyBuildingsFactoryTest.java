package com.example.tinycalculator.Domain.GreyBuildings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Enums.GreyEnum;

import org.junit.Test;

public class GreyBuildingsFactoryTest {

    @Test
    public void createGreyBuilding_ShouldCreateShed(){
        GreyBuilding shed = GreyBuildingsFactory.createGreyBuilding(Pair.create(1,1), GreyEnum.Shed);
        assertEquals(Pair.create(1,1), shed.position);
        assertThat(shed, instanceOf(Shed.class));
    }

    @Test
    public void createGreyBuilding_ShouldCreateWell(){
        GreyBuilding well = GreyBuildingsFactory.createGreyBuilding(Pair.create(1,1), GreyEnum.Well);
        assertEquals(Pair.create(1,1), well.position);
        assertThat(well, instanceOf(Well.class));
    }

    @Test
    public void createGreyBuilding_ShouldCreateFountain(){
        GreyBuilding fountain = GreyBuildingsFactory.createGreyBuilding(Pair.create(1,1), GreyEnum.Fountain);
        assertEquals(Pair.create(1,1), fountain.position);
        assertThat(fountain, instanceOf(Fountain.class));
    }

    @Test
    public void createGreyBuilding_ShouldCreateMillstone(){
        GreyBuilding millstone = GreyBuildingsFactory.createGreyBuilding(Pair.create(1,1), GreyEnum.Millstone);
        assertEquals(Pair.create(1,1), millstone.position);
        assertThat(millstone, instanceOf(Millstone.class));
    }
}
