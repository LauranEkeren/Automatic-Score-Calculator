package com.example.tinycalculator.Domain.BlackBuildings;

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
public class BlackBuildingTest {
    @Mock
    Board mockBoardNoBlackBuildings;
    @Mock
    Board mockBoardOneBlackBuilding;
    @Mock
    Board mockBoardThreeBlackBuildings;
    @Mock
    Board mockBoardSevenBlackBuildings;

    @Before
    public void initMocks(){
        List<Square> squaresEmpty = new ArrayList<>();
        addBlackBuilding(squaresEmpty, 0);
        when(mockBoardNoBlackBuildings.getSquaresAsList()).thenReturn(squaresEmpty);

        List<Square> squaresOneBlackBuilding = new ArrayList<>();
        addBlackBuilding(squaresOneBlackBuilding, 1);
        when(mockBoardOneBlackBuilding.getSquaresAsList()).thenReturn(squaresOneBlackBuilding);

        List<Square> squaresThreeBlackBuilding = new ArrayList<>();
        addBlackBuilding(squaresThreeBlackBuilding, 3);
        when(mockBoardThreeBlackBuildings.getSquaresAsList()).thenReturn(squaresThreeBlackBuilding);

        List<Square> squaresSevenBlackBuilding = new ArrayList<>();
        addBlackBuilding(squaresSevenBlackBuilding, 7);
        when(mockBoardSevenBlackBuildings.getSquaresAsList()).thenReturn(squaresSevenBlackBuilding);
    }

    public void addBlackBuilding(List<Square> squareList, int amount){
        for (int i = 0; i < 16; i++){
            if (i < amount){
                squareList.add(new Bank(Pair.create(0, 0)));
            } else {
                squareList.add(new EmptySquare(Pair.create(0, 0)));
            }
        }
    }

    @Test
    public void getAmountBlackBuildings_ReturnsCorrectAmountWhenNoBlackBuildings(){
        BlackBuilding blackBuilding = new Bank(Pair.create(0, 0));
        int amount = blackBuilding.getAmountBlackBuildings(mockBoardNoBlackBuildings);
        assertEquals(0, amount);
    }

    @Test
    public void getAmountBlackBuildings_ReturnsCorrectAmountWhenOneBlackBuilding(){
        BlackBuilding blackBuilding = new Bank(Pair.create(0,0));
        int amount = blackBuilding.getAmountBlackBuildings(mockBoardOneBlackBuilding);
        assertEquals(1, amount);
    }

    @Test
    public void getAmountBlackBuildings_ReturnsCorrectAmountWhenThreeBlackBuildings(){
        BlackBuilding blackBuilding = new Bank(Pair.create(0,0));
        int amount = blackBuilding.getAmountBlackBuildings(mockBoardThreeBlackBuildings);
        assertEquals(3, amount);
    }

    @Test
    public void getAmountBlackBuildings_ReturnsCorrectAmountWhenSevenBlackBuildings(){
        BlackBuilding blackBuilding = new Bank(Pair.create(0,0));
        int amount = blackBuilding.getAmountBlackBuildings(mockBoardSevenBlackBuildings);
        assertEquals(7, amount);
    }
}
