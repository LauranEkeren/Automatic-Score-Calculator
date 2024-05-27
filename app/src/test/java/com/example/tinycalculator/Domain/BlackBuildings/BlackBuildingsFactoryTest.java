package com.example.tinycalculator.Domain.BlackBuildings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Enums.BlackEnum;

import org.junit.Test;

public class BlackBuildingsFactoryTest {

    @Test
    public void createBlackBuilding_ShouldCreateFactory(){
        BlackBuilding factory = BlackBuildingsFactory.createBlackBuilding(Pair.create(0,0), BlackEnum.Factory);
        assertEquals(Pair.create(0,0), factory.position);
        assertThat(factory, instanceOf(Factory.class));
    }

    @Test
    public void createBlackBuilding_ShouldCreateBank(){
        BlackBuilding bank = BlackBuildingsFactory.createBlackBuilding(Pair.create(1,3), BlackEnum.Bank);
        assertEquals(Pair.create(1,3), bank.position);
        assertThat(bank, instanceOf(Bank.class));
    }

    @Test
    public void createBlackBuilding_ShouldCreateWarehouse(){
        BlackBuilding warehouse = BlackBuildingsFactory.createBlackBuilding(Pair.create(2,2), BlackEnum.Warehouse);
        assertEquals(Pair.create(2, 2), warehouse.position);
        assertThat(warehouse, instanceOf(Warehouse.class));
    }

    @Test
    public void createBlackBuilding_ShouldCreateTradingPost(){
        BlackBuilding tradingPost = BlackBuildingsFactory.createBlackBuilding(Pair.create(3, 3), BlackEnum.TradingPost);
        assertEquals(Pair.create(3,3), tradingPost.position);
        assertThat(tradingPost, instanceOf(TradingPost.class));
    }
}
