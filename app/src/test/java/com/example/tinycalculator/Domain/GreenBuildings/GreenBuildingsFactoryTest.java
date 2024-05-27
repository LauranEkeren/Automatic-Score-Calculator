package com.example.tinycalculator.Domain.GreenBuildings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Enums.GreenEnum;

import org.junit.Assert;
import org.junit.Test;

public class GreenBuildingsFactoryTest {

    @Test
    public void createGreenBuilding_ShouldCreateInn(){
        GreenBuilding inn = GreenBuildingsFactory.createGreenBuilding(Pair.create(1,1), GreenEnum.Inn);
        assertEquals(Pair.create(1,1), inn.position);
        assertThat(inn, instanceOf(Inn.class));
    }

    @Test
    public void createGreenBuilding_ShouldCreateTavern(){
        GreenBuilding tavern = GreenBuildingsFactory.createGreenBuilding(Pair.create(3,3), GreenEnum.Tavern);
        assertEquals(Pair.create(3,3), tavern.position);
        assertThat(tavern, instanceOf(Tavern.class));
    }

    @Test
    public void createGreenBuilding_ShouldCreateAlmshouse(){
        GreenBuilding almshouse = GreenBuildingsFactory.createGreenBuilding(Pair.create(0,1), GreenEnum.Almshouse);
        assertEquals(Pair.create(0,1), almshouse.position);
        assertThat(almshouse, instanceOf(Almshouse.class));
    }

    @Test
    public void createGreenBuilding_ShouldCreateFeastHall(){
        GreenBuilding feastHall = GreenBuildingsFactory.createGreenBuilding(Pair.create(3,2), GreenEnum.FeastHall);
        assertEquals(Pair.create(3,2), feastHall.position);
        assertThat(feastHall, instanceOf(FeastHall.class));
    }
}
