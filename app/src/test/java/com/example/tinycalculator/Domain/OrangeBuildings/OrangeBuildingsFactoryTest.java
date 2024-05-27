package com.example.tinycalculator.Domain.OrangeBuildings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Enums.OrangeEnum;

import org.junit.Test;

public class OrangeBuildingsFactoryTest {
    @Test
    public void createOrangeBuilding_ShouldCreateAbbey(){
        OrangeBuilding abbey = OrangeBuildingsFactory.createOrangeBuilding(Pair.create(1,1), OrangeEnum.Abbey);
        assertEquals(Pair.create(1,1), abbey.position);
        assertThat(abbey, instanceOf(Abbey.class));
    }

    @Test
    public void createOrangeBuilding_ShouldCreateChapel(){
        OrangeBuilding chapel = OrangeBuildingsFactory.createOrangeBuilding(Pair.create(1,1), OrangeEnum.Chapel);
        assertEquals(Pair.create(1,1), chapel.position);
        assertThat(chapel, instanceOf(Chapel.class));
    }

    @Test
    public void createOrangeBuilding_ShouldCreateTemple(){
        OrangeBuilding temple = OrangeBuildingsFactory.createOrangeBuilding(Pair.create(1,1), OrangeEnum.Temple);
        assertEquals(Pair.create(1,1), temple.position);
        assertThat(temple, instanceOf(Temple.class));
    }

    @Test
    public void createOrangeBuilding_ShouldCreateCloister(){
        OrangeBuilding cloister = OrangeBuildingsFactory.createOrangeBuilding(Pair.create(1,1), OrangeEnum.Cloister);
        assertEquals(Pair.create(1,1), cloister.position);
        assertThat(cloister, instanceOf(Cloister.class));
    }
}
