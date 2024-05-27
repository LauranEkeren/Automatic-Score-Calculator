package com.example.tinycalculator.Domain.GreenBuildings;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.EmptySquare;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.GreenEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FeastHallTest {
    @Mock
    Board mockBoardNoFeastHallsLessThanNeighbour;
    @Mock
    Board mockBoardNoFeastHallsEqualWithNeighbour;

    @Mock
    Board mockBoardOneFeastHallLessThanNeighbour;
    @Mock
    Board mockBoardOneFeastHallMoreThanNeighbour;

    @Mock
    Board mockBoardThreeFeastHallsLessThanNeighbour;
    @Mock
    Board mockBoardThreeFeastHallsMoreThanNeighbour;
    @Mock
    Board mockBoardThreeFeastHallsEqualWithNeighbour;

    @Mock
    Board mockBoardSevenFeastHallsLessThanNeighbour;
    @Mock
    Board mockBoardSevenFeastHallsMoreThanNeighbour;


    @Before
    public void initMocks(){
        List<Square> squaresEmpty = new ArrayList<>();
        addFeastHall(squaresEmpty, 0);
        when(mockBoardNoFeastHallsLessThanNeighbour.getSquaresAsList()).thenReturn(squaresEmpty);
        when(mockBoardNoFeastHallsLessThanNeighbour.getAmountFeastHallNeighbour()).thenReturn(5);
        when(mockBoardNoFeastHallsEqualWithNeighbour.getSquaresAsList()).thenReturn(squaresEmpty);
        when(mockBoardNoFeastHallsEqualWithNeighbour.getAmountFeastHallNeighbour()).thenReturn(0);

        List<Square> squaresOneFeastHall = new ArrayList<>();
        addFeastHall(squaresOneFeastHall, 1);
        when(mockBoardOneFeastHallMoreThanNeighbour.getSquaresAsList()).thenReturn(squaresOneFeastHall);
        when(mockBoardOneFeastHallMoreThanNeighbour.getAmountFeastHallNeighbour()).thenReturn(0);
        when(mockBoardOneFeastHallLessThanNeighbour.getSquaresAsList()).thenReturn(squaresOneFeastHall);
        when(mockBoardOneFeastHallLessThanNeighbour.getAmountFeastHallNeighbour()).thenReturn(9);
        
        List<Square> squaresThreeFeastHall = new ArrayList<>();
        addFeastHall(squaresThreeFeastHall, 3);
        when(mockBoardThreeFeastHallsMoreThanNeighbour.getSquaresAsList()).thenReturn(squaresThreeFeastHall);
        when(mockBoardThreeFeastHallsMoreThanNeighbour.getAmountFeastHallNeighbour()).thenReturn(0);
        when(mockBoardThreeFeastHallsLessThanNeighbour.getSquaresAsList()).thenReturn(squaresThreeFeastHall);
        when(mockBoardThreeFeastHallsLessThanNeighbour.getAmountFeastHallNeighbour()).thenReturn(9);

        when(mockBoardThreeFeastHallsEqualWithNeighbour.getSquaresAsList()).thenReturn(squaresThreeFeastHall);
        when(mockBoardThreeFeastHallsEqualWithNeighbour.getAmountFeastHallNeighbour()).thenReturn(3);
        
        List<Square> squaresSevenFeastHall = new ArrayList<>();
        addFeastHall(squaresSevenFeastHall, 7);
        when(mockBoardSevenFeastHallsMoreThanNeighbour.getSquaresAsList()).thenReturn(squaresSevenFeastHall);
        when(mockBoardSevenFeastHallsMoreThanNeighbour.getAmountFeastHallNeighbour()).thenReturn(0);
        when(mockBoardSevenFeastHallsLessThanNeighbour.getSquaresAsList()).thenReturn(squaresSevenFeastHall);
        when(mockBoardSevenFeastHallsLessThanNeighbour.getAmountFeastHallNeighbour()).thenReturn(9);
    }

    public void addFeastHall(List<Square> squareList, int amount){
        for (int i = 0; i < 16; i++){
            if (i < amount){
                squareList.add(new FeastHall(Pair.create(0, 0)));
            } else {
                squareList.add(new EmptySquare(Pair.create(0, 0)));

            }
        }
    }

    @Test
    public void FeastHall_HasCorrectSquareType(){
        FeastHall feastHall = new FeastHall(Pair.create(0, 0));
        assertEquals(SquareEnum.GreenBuilding, feastHall.squareType);
    }

    @Test
    public void FeastHall_HasCorrectPosition(){
        FeastHall feastHall = new FeastHall(Pair.create(1,1));
        assertEquals(Pair.create(1,1), feastHall.position);
    }

    @Test
    public void FeastHall_HasCorrectGreenEnum(){
        FeastHall feastHall = new FeastHall(Pair.create(2,2));
        assertEquals(GreenEnum.FeastHall, feastHall.greenBuildingType);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithZeroBuildingsAndLessThanNeighbour(){
        FeastHall feastHall = new FeastHall(Pair.create(1,1));
        int score = feastHall.getScore(mockBoardNoFeastHallsLessThanNeighbour);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithZeroBuildingsAndEqualWithNeighbour(){
        FeastHall feastHall = new FeastHall(Pair.create(1,1));
        int score = feastHall.getScore(mockBoardNoFeastHallsEqualWithNeighbour);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithOneBuildingAndLessThanNeighbour(){
        FeastHall feastHall = new FeastHall(Pair.create(1,1));
        int score = feastHall.getScore(mockBoardOneFeastHallLessThanNeighbour);
        assertEquals(2, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithOneBuildingAndMoreThanNeighbour(){
        FeastHall feastHall = new FeastHall(Pair.create(1,1));
        int score = feastHall.getScore(mockBoardOneFeastHallMoreThanNeighbour);
        assertEquals(3, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithThreeBuildingsAndLessThanNeighbour(){
        FeastHall feastHall = new FeastHall(Pair.create(1,1));
        int score = feastHall.getScore(mockBoardThreeFeastHallsLessThanNeighbour);
        assertEquals(6, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithThreeBuildingsAndEqualWithNeighbour(){
        FeastHall feastHall = new FeastHall(Pair.create(1,1));
        int score = feastHall.getScore(mockBoardThreeFeastHallsEqualWithNeighbour);
        assertEquals(6, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithThreeBuildingsAndMoreThanNeighbour(){
        FeastHall feastHall = new FeastHall(Pair.create(1,1));
        int score = feastHall.getScore(mockBoardThreeFeastHallsMoreThanNeighbour);
        assertEquals(9, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSevenBuildingsAndLessThanNeighbour(){
        FeastHall feastHall = new FeastHall(Pair.create(0,0));
        int score = feastHall.getScore(mockBoardSevenFeastHallsLessThanNeighbour);
        assertEquals(14, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSevenBuildingsAndMoreThanNeighbour(){
        FeastHall feastHall = new FeastHall(Pair.create(3,2));
        int score = feastHall.getScore(mockBoardSevenFeastHallsMoreThanNeighbour);
        assertEquals(21, score);
    }
}
