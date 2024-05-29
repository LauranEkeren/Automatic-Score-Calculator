package com.example.tinycalculator.Domain.YellowBuildings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Enums.YellowEnum;

import org.junit.Test;

public class YellowBuildingsFactoryTest {
    @Test
    public void createYellowBuilding_ShouldCreateBakery(){
        YellowBuilding bakery = YellowBuildingsFactory.createYellowBuilding(Pair.create(1,1), YellowEnum.Bakery);
        assertEquals(Pair.create(1,1), bakery.position);
        assertThat(bakery, instanceOf(Bakery.class));
    }

    @Test
    public void createYellowBuilding_ShouldCreateMarket(){
        YellowBuilding market = YellowBuildingsFactory.createYellowBuilding(Pair.create(1,1), YellowEnum.Market);
        assertEquals(Pair.create(1,1), market.position);
        assertThat(market, instanceOf(Market.class));
    }

    @Test
    public void createYellowBuilding_ShouldCreateTailor(){
        YellowBuilding tailor = YellowBuildingsFactory.createYellowBuilding(Pair.create(1,1), YellowEnum.Tailor);
        assertEquals(Pair.create(1,1), tailor.position);
        assertThat(tailor, instanceOf(Tailor.class));
    }

    @Test
    public void createYellowBuilding_ShouldCreateTheater(){
        YellowBuilding theater = YellowBuildingsFactory.createYellowBuilding(Pair.create(1,1), YellowEnum.Theater);
        assertEquals(Pair.create(1,1), theater.position);
        assertThat(theater, instanceOf(Theater.class));
    }
}
