package com.example.tinycalculator.Domain.GreyBuildings;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.EmptySquare;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ShedTest {
    @Mock
    Board mockBoardNoSheds;
    @Mock
    Board mockBoardOneShed;
    @Mock
    Board mockBoardTwoSheds;
    @Mock
    Board mockBoardThreeSheds;
    @Mock
    Board mockBoardFourSheds;
    @Mock
    Board mockBoardFiveSheds;
    @Mock
    Board mockBoardSixSheds;
    @Mock
    Board mockBoardSevenSheds;

    @Before
    public void initMocks(){
        List<Square> squaresEmpty = new ArrayList<>();
        addShed(squaresEmpty, 0);
        when(mockBoardNoSheds.getSquaresAsList()).thenReturn(squaresEmpty);

        List<Square> squaresOneShed = new ArrayList<>();
        addShed(squaresOneShed, 1);
        when(mockBoardOneShed.getSquaresAsList()).thenReturn(squaresOneShed);

        List<Square> squaresTwoShed = new ArrayList<>();
        addShed(squaresTwoShed, 2);
        when(mockBoardTwoSheds.getSquaresAsList()).thenReturn(squaresTwoShed);

        List<Square> squaresThreeShed = new ArrayList<>();
        addShed(squaresThreeShed, 3);
        when(mockBoardThreeSheds.getSquaresAsList()).thenReturn(squaresThreeShed);

        List<Square> squaresFourShed = new ArrayList<>();
        addShed(squaresFourShed, 4);
        when(mockBoardFourSheds.getSquaresAsList()).thenReturn(squaresFourShed);

        List<Square> squaresFiveShed = new ArrayList<>();
        addShed(squaresFiveShed, 5);
        when(mockBoardFiveSheds.getSquaresAsList()).thenReturn(squaresFiveShed);

        List<Square> squaresSixShed = new ArrayList<>();
        addShed(squaresSixShed, 6);
        when(mockBoardSixSheds.getSquaresAsList()).thenReturn(squaresSixShed);

        List<Square> squaresSevenShed = new ArrayList<>();
        addShed(squaresSevenShed, 7);
        when(mockBoardSevenSheds.getSquaresAsList()).thenReturn(squaresSevenShed);
    }

    public void addShed(List<Square> squareList, int amount){
        for (int i = 0; i < 16; i++){
            if (i < amount){
                squareList.add(new Shed(Pair.create(0, 0)));
            } else {
                squareList.add(new EmptySquare(Pair.create(0, 0)));
            }
        }
    }

    @Test
    public void Shed_HasCorrectSquareType(){
        Shed shed = new Shed(Pair.create(1,2));
        assertEquals(SquareEnum.GreyBuilding, shed.squareType);
    }

    @Test
    public void Shed_HasCorrectPosition(){
        Shed shed = new Shed(Pair.create(1,2));
        assertEquals(Pair.create(1,2), shed.position);
    }

    @Test
    public void Shed_HasCorrectGreyEnum(){
        Shed shed = new Shed(Pair.create(3,3));
        assertEquals(GreyEnum.Shed, shed.greyBuildingType);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithZeroBuildings(){
        Shed shed = new Shed(Pair.create(2,3));
        int score = shed.getScore(mockBoardNoSheds);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithOneBuilding(){
        Shed shed = new Shed(Pair.create(2,3));
        int score = shed.getScore(mockBoardOneShed);
        assertEquals(1, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithTwoBuildings(){
        Shed shed = new Shed(Pair.create(2,3));
        int score = shed.getScore(mockBoardTwoSheds);
        assertEquals(2, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithThreeBuildings(){
        Shed shed = new Shed(Pair.create(1,1));
        int score = shed.getScore(mockBoardThreeSheds);
        assertEquals(3, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithFourBuildings(){
        Shed shed = new Shed(Pair.create(1,1));
        int score = shed.getScore(mockBoardFourSheds);
        assertEquals(4, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithFiveBuildings(){
        Shed shed = new Shed(Pair.create(1,1));
        int score = shed.getScore(mockBoardFiveSheds);
        assertEquals(5, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSixBuildings(){
        Shed shed = new Shed(Pair.create(0,0));
        int score = shed.getScore(mockBoardSixSheds);
        assertEquals(6, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSevenBuildings(){
        Shed shed = new Shed(Pair.create(1,1));
        int score = shed.getScore(mockBoardSevenSheds);
        assertEquals(7, score);
    }
    
    
}
