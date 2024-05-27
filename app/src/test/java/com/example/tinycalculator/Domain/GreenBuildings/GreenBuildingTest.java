package com.example.tinycalculator.Domain.GreenBuildings;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.EmptySquare;
import com.example.tinycalculator.Domain.Square;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GreenBuildingTest {
    @Mock
    Board mockBoardNoGreenBuildings;
    @Mock
    Board mockBoardOneGreenBuilding;
    @Mock
    Board mockBoardThreeGreenBuildings;
    @Mock
    Board mockBoardSevenGreenBuildings;

    @Before
    public void initMocks(){
        List<Square> squaresEmpty = new ArrayList<>();
        addGreenBuilding(squaresEmpty, 0);
        when(mockBoardNoGreenBuildings.getSquaresAsList()).thenReturn(squaresEmpty);

        List<Square> squaresOneGreenBuilding = new ArrayList<>();
        addGreenBuilding(squaresOneGreenBuilding, 1);
        when(mockBoardOneGreenBuilding.getSquaresAsList()).thenReturn(squaresOneGreenBuilding);

        List<Square> squaresThreeGreenBuilding = new ArrayList<>();
        addGreenBuilding(squaresThreeGreenBuilding, 3);
        when(mockBoardThreeGreenBuildings.getSquaresAsList()).thenReturn(squaresThreeGreenBuilding);

        List<Square> squaresSevenGreenBuilding = new ArrayList<>();
        addGreenBuilding(squaresSevenGreenBuilding, 7);
        when(mockBoardSevenGreenBuildings.getSquaresAsList()).thenReturn(squaresSevenGreenBuilding);
    }

    public void addGreenBuilding(List<Square> squareList, int amount){
        for (int i = 0; i < 16; i++){
            if (i < amount){
                squareList.add(new Tavern(Pair.create(0, 0)));
            } else {
                squareList.add(new EmptySquare(Pair.create(0, 0)));
            }
        }
    }

    @Test
    public void getAmountGreenBuildings_ReturnsCorrectAmountWhenNoGreenBuildings(){
        GreenBuilding GreenBuilding = new Tavern(Pair.create(0, 0));
        int amount = GreenBuilding.getAmountGreenBuildings(mockBoardNoGreenBuildings);
        assertEquals(0, amount);
    }

    @Test
    public void getAmountGreenBuildings_ReturnsCorrectAmountWhenOneGreenBuilding(){
        GreenBuilding GreenBuilding = new Tavern(Pair.create(0,0));
        int amount = GreenBuilding.getAmountGreenBuildings(mockBoardOneGreenBuilding);
        assertEquals(1, amount);
    }

    @Test
    public void getAmountGreenBuildings_ReturnsCorrectAmountWhenThreeGreenBuildings(){
        GreenBuilding GreenBuilding = new Tavern(Pair.create(0,0));
        int amount = GreenBuilding.getAmountGreenBuildings(mockBoardThreeGreenBuildings);
        assertEquals(3, amount);
    }

    @Test
    public void getAmountGreenBuildings_ReturnsCorrectAmountWhenSevenGreenBuildings(){
        GreenBuilding GreenBuilding = new Tavern(Pair.create(0,0));
        int amount = GreenBuilding.getAmountGreenBuildings(mockBoardSevenGreenBuildings);
        assertEquals(7, amount);
    }
}
