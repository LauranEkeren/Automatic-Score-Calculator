package com.example.tinycalculator.Domain.PurpleBuildings;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TheStarloomTest {

    @Mock
    Board mockBoardAmountOne;
    @Mock
    Board mockBoardAmountTwo;
    @Mock
    Board mockBoardAmountThree;
    @Mock
    Board mockBoardAmountFour;
    @Mock
    Board mockBoardAmountFive;
    @Mock
    Board mockBoardAmountSix;

    @Before
    public void initMocks(){
        when(mockBoardAmountOne.getAmountStarloom()).thenReturn(1);
        when(mockBoardAmountTwo.getAmountStarloom()).thenReturn(2);
        when(mockBoardAmountThree.getAmountStarloom()).thenReturn(3);
        when(mockBoardAmountFour.getAmountStarloom()).thenReturn(4);
        when(mockBoardAmountFive.getAmountStarloom()).thenReturn(5);
        when(mockBoardAmountSix.getAmountStarloom()).thenReturn(6);
    }

    @Test
    public void TheStarloom_HasCorrectSquareType(){
        TheStarloom theStarloom = new TheStarloom(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, theStarloom.squareType);
    }

    @Test
    public void TheStarloom_HasCorrectPosition(){
        TheStarloom theStarloom = new TheStarloom(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), theStarloom.position);
    }

    @Test
    public void TheStarloom_HasCorrectPurpleEnum(){
        TheStarloom theStarloom = new TheStarloom(Pair.create(0, 0));
        assertEquals(PurpleEnum.TheStarloom, theStarloom.purpleBuildingType);
    }

    @Test
    public void getScore_AmountOne(){
        TheStarloom theStarloom = new TheStarloom(Pair.create(0,0));
        int score = theStarloom.getScore(mockBoardAmountOne);
        assertEquals(6, score);
    }

    @Test
    public void getScore_AmountTwo(){
        TheStarloom theStarloom = new TheStarloom(Pair.create(0,0));
        int score = theStarloom.getScore(mockBoardAmountTwo);
        assertEquals(3, score);
    }

    @Test
    public void getScore_AmountThree(){
        TheStarloom theStarloom = new TheStarloom(Pair.create(0,0));
        int score = theStarloom.getScore(mockBoardAmountThree);
        assertEquals(2, score);
    }

    @Test
    public void getScore_AmountFour(){
        TheStarloom theStarloom = new TheStarloom(Pair.create(0,0));
        int score = theStarloom.getScore(mockBoardAmountFour);
        assertEquals(0, score);
    }

    @Test
    public void getScore_AmountFive(){
        TheStarloom theStarloom = new TheStarloom(Pair.create(0,0));
        int score = theStarloom.getScore(mockBoardAmountFive);
        assertEquals(0, score);
    }

    @Test
    public void getScore_AmountSix(){
        TheStarloom theStarloom = new TheStarloom(Pair.create(0,0));
        int score = theStarloom.getScore(mockBoardAmountSix);
        assertEquals(0, score);
    }

}
