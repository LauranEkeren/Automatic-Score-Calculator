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
public class AlmshouseTest {
    @Mock
    Board mockBoardNoAlmshouses;
    @Mock
    Board mockBoardOneAlmshouse;
    @Mock
    Board mockBoardTwoAlmshouses;
    @Mock
    Board mockBoardThreeAlmshouses;
    @Mock
    Board mockBoardFourAlmshouses;
    @Mock
    Board mockBoardFiveAlmshouses;
    @Mock
    Board mockBoardSixAlmshouses;
    @Mock
    Board mockBoardSevenAlmshouses;

    @Before
    public void initMocks(){
        List<Square> squaresEmpty = new ArrayList<>();
        addAlmshouse(squaresEmpty, 0);
        when(mockBoardNoAlmshouses.getSquaresAsList()).thenReturn(squaresEmpty);

        List<Square> squaresOneAlmshouse = new ArrayList<>();
        addAlmshouse(squaresOneAlmshouse, 1);
        when(mockBoardOneAlmshouse.getSquaresAsList()).thenReturn(squaresOneAlmshouse);

        List<Square> squaresTwoAlmshouse = new ArrayList<>();
        addAlmshouse(squaresTwoAlmshouse, 2);
        when(mockBoardTwoAlmshouses.getSquaresAsList()).thenReturn(squaresTwoAlmshouse);

        List<Square> squaresThreeAlmshouse = new ArrayList<>();
        addAlmshouse(squaresThreeAlmshouse, 3);
        when(mockBoardThreeAlmshouses.getSquaresAsList()).thenReturn(squaresThreeAlmshouse);

        List<Square> squaresFourAlmshouse = new ArrayList<>();
        addAlmshouse(squaresFourAlmshouse, 4);
        when(mockBoardFourAlmshouses.getSquaresAsList()).thenReturn(squaresFourAlmshouse);

        List<Square> squaresFiveAlmshouse = new ArrayList<>();
        addAlmshouse(squaresFiveAlmshouse, 5);
        when(mockBoardFiveAlmshouses.getSquaresAsList()).thenReturn(squaresFiveAlmshouse);

        List<Square> squaresSixAlmshouse = new ArrayList<>();
        addAlmshouse(squaresSixAlmshouse, 6);
        when(mockBoardSixAlmshouses.getSquaresAsList()).thenReturn(squaresSixAlmshouse);

        List<Square> squaresSevenAlmshouse = new ArrayList<>();
        addAlmshouse(squaresSevenAlmshouse, 7);
        when(mockBoardSevenAlmshouses.getSquaresAsList()).thenReturn(squaresSevenAlmshouse);
    }

    public void addAlmshouse(List<Square> squareList, int amount){
        for (int i = 0; i < 16; i++){
            if (i < amount){
                squareList.add(new Almshouse(Pair.create(0, 0)));
            } else {
                squareList.add(new EmptySquare(Pair.create(0, 0)));

            }
        }
    }

    @Test
    public void Almshouse_HasCorrectSquareType(){
        Almshouse almshouse = new Almshouse(Pair.create(1, 1));
        assertEquals(SquareEnum.GreenBuilding, almshouse.squareType);
    }

    @Test
    public void Almshouse_HasCorrectPosition(){
        Almshouse almshouse = new Almshouse(Pair.create(3,3));
        assertEquals(Pair.create(3,3), almshouse.position);
    }

    @Test
    public void Almshouse_HasCorrectGreenEnum(){
        Almshouse almshouse = new Almshouse(Pair.create(2,3));
        assertEquals(GreenEnum.Almshouse, almshouse.greenBuildingType);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithZeroBuildings(){
        Almshouse almshouse = new Almshouse(Pair.create(2,3));
        int score = almshouse.getScore(mockBoardNoAlmshouses);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithOneBuilding(){
        Almshouse almshouse = new Almshouse(Pair.create(2,3));
        int score = almshouse.getScore(mockBoardOneAlmshouse);
        assertEquals(-1, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithTwoBuildings(){
        Almshouse almshouse = new Almshouse(Pair.create(2,3));
        int score = almshouse.getScore(mockBoardTwoAlmshouses);
        assertEquals(5, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithThreeBuildings(){
        Almshouse almshouse = new Almshouse(Pair.create(1,1));
        int score = almshouse.getScore(mockBoardThreeAlmshouses);
        assertEquals(-3, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithFourBuildings(){
        Almshouse almshouse = new Almshouse(Pair.create(1,1));
        int score = almshouse.getScore(mockBoardFourAlmshouses);
        assertEquals(15, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithFiveBuildings(){
        Almshouse almshouse = new Almshouse(Pair.create(1,1));
        int score = almshouse.getScore(mockBoardFiveAlmshouses);
        assertEquals(-5, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSixBuildings(){
        Almshouse almshouse = new Almshouse(Pair.create(0,0));
        int score = almshouse.getScore(mockBoardSixAlmshouses);
        assertEquals(26, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSevenBuildings(){
        Almshouse almshouse = new Almshouse(Pair.create(1,1));
        int score = almshouse.getScore(mockBoardSevenAlmshouses);
        assertEquals(26, score);
    }
}
