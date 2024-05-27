package com.example.tinycalculator.Domain.BlackBuildings;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WarehouseTest {

    @Mock
    Board mockBoardWarehouseNumberZero;
    @Mock
    Board mockBoardWarehouseNumberOne;
    @Mock
    Board mockBoardWarehouseNumberThree;
    @Mock
    Board mockBoardWarehouseNumberSeven;

    @Before
    public void initMocks(){
        when(mockBoardWarehouseNumberZero.getWarehouseNumber()).thenReturn(0);
        when(mockBoardWarehouseNumberOne.getWarehouseNumber()).thenReturn(1);
        when(mockBoardWarehouseNumberThree.getWarehouseNumber()).thenReturn(3);
        when(mockBoardWarehouseNumberSeven.getWarehouseNumber()).thenReturn(7);
    }

    @Test
    public void Warehouse_HasCorrectSquareType(){
        Warehouse warehouse = new Warehouse(Pair.create(0, 0));
        assertEquals(SquareEnum.BlackBuilding, warehouse.squareType);
    }

    @Test
    public void Warehouse_HasCorrectPosition(){
        Warehouse warehouse = new Warehouse(Pair.create(1,3));
        assertEquals(Pair.create(1,3), warehouse.position);
    }

    @Test
    public void Warehouse_HasCorrectBlackEnum(){
        Warehouse warehouse = new Warehouse(Pair.create(0, 0));
        assertEquals(BlackEnum.Warehouse, warehouse.blackBuildingType);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithZeroWarehouseNumber(){
        Warehouse warehouse = new Warehouse(Pair.create(0, 0));
        int score = warehouse.getScore(mockBoardWarehouseNumberZero);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithOneWarehouseNumber(){
        Warehouse warehouse = new Warehouse(Pair.create(0, 0));
        int score = warehouse.getScore(mockBoardWarehouseNumberOne);
        assertEquals(-1, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithThreeWarehouseNumber(){
        Warehouse warehouse = new Warehouse(Pair.create(1, 3));
        int score = warehouse.getScore(mockBoardWarehouseNumberThree);
        assertEquals(-3, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSevenWarehouseNumber(){
        Warehouse warehouse = new Warehouse(Pair.create(0, 0));
        int score = warehouse.getScore(mockBoardWarehouseNumberSeven);
        assertEquals(-7, score);
    }
}
