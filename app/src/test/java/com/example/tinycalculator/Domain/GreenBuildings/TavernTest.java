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
public class TavernTest {
    @Mock
    Board mockBoardNoTaverns;
    @Mock
    Board mockBoardOneTavern;
    @Mock
    Board mockBoardTwoTaverns;
    @Mock
    Board mockBoardThreeTaverns;
    @Mock
    Board mockBoardFourTaverns;
    @Mock
    Board mockBoardFiveTaverns;
    @Mock
    Board mockBoardSixTaverns;
    @Mock
    Board mockBoardSevenTaverns;

    @Before
    public void initMocks(){
        List<Square> squaresEmpty = new ArrayList<>();
        addTavern(squaresEmpty, 0);
        when(mockBoardNoTaverns.getSquaresAsList()).thenReturn(squaresEmpty);

        List<Square> squaresOneTavern = new ArrayList<>();
        addTavern(squaresOneTavern, 1);
        when(mockBoardOneTavern.getSquaresAsList()).thenReturn(squaresOneTavern);

        List<Square> squaresTwoTavern = new ArrayList<>();
        addTavern(squaresTwoTavern, 2);
        when(mockBoardTwoTaverns.getSquaresAsList()).thenReturn(squaresTwoTavern);

        List<Square> squaresThreeTavern = new ArrayList<>();
        addTavern(squaresThreeTavern, 3);
        when(mockBoardThreeTaverns.getSquaresAsList()).thenReturn(squaresThreeTavern);

        List<Square> squaresFourTavern = new ArrayList<>();
        addTavern(squaresFourTavern, 4);
        when(mockBoardFourTaverns.getSquaresAsList()).thenReturn(squaresFourTavern);

        List<Square> squaresFiveTavern = new ArrayList<>();
        addTavern(squaresFiveTavern, 5);
        when(mockBoardFiveTaverns.getSquaresAsList()).thenReturn(squaresFiveTavern);

        List<Square> squaresSixTavern = new ArrayList<>();
        addTavern(squaresSixTavern, 6);
        when(mockBoardSixTaverns.getSquaresAsList()).thenReturn(squaresSixTavern);

        List<Square> squaresSevenTavern = new ArrayList<>();
        addTavern(squaresSevenTavern, 7);
        when(mockBoardSevenTaverns.getSquaresAsList()).thenReturn(squaresSevenTavern);
    }

    public void addTavern(List<Square> squareList, int amount){
        for (int i = 0; i < 16; i++){
            if (i < amount){
                squareList.add(new Tavern(Pair.create(0, 0)));
            } else {
                squareList.add(new EmptySquare(Pair.create(0, 0)));

            }
        }
    }

    @Test
    public void Tavern_HasCorrectSquareType(){
        Tavern tavern = new Tavern(Pair.create(1, 1));
        assertEquals(SquareEnum.GreenBuilding, tavern.squareType);
    }

    @Test
    public void Tavern_HasCorrectPosition(){
        Tavern tavern = new Tavern(Pair.create(3,3));
        assertEquals(Pair.create(3,3), tavern.position);
    }

    @Test
    public void Tavern_HasCorrectGreenEnum(){
        Tavern tavern = new Tavern(Pair.create(2,3));
        assertEquals(GreenEnum.Tavern, tavern.greenBuildingType);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithZeroBuildings(){
        Tavern tavern = new Tavern(Pair.create(2,3));
        int score = tavern.getScore(mockBoardNoTaverns);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithOneBuilding(){
        Tavern tavern = new Tavern(Pair.create(2,3));
        int score = tavern.getScore(mockBoardOneTavern);
        assertEquals(2, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithTwoBuildings(){
        Tavern tavern = new Tavern(Pair.create(2,3));
        int score = tavern.getScore(mockBoardTwoTaverns);
        assertEquals(5, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithThreeBuildings(){
        Tavern tavern = new Tavern(Pair.create(1,1));
        int score = tavern.getScore(mockBoardThreeTaverns);
        assertEquals(9, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithFourBuildings(){
        Tavern tavern = new Tavern(Pair.create(1,1));
        int score = tavern.getScore(mockBoardFourTaverns);
        assertEquals(14, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithFiveBuildings(){
        Tavern tavern = new Tavern(Pair.create(1,1));
        int score = tavern.getScore(mockBoardFiveTaverns);
        assertEquals(20, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSixBuildings(){
        Tavern tavern = new Tavern(Pair.create(0,0));
        int score = tavern.getScore(mockBoardSixTaverns);
        assertEquals(20, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSevenBuildings(){
        Tavern tavern = new Tavern(Pair.create(1,1));
        int score = tavern.getScore(mockBoardSevenTaverns);
        assertEquals(20, score);
    }
}
