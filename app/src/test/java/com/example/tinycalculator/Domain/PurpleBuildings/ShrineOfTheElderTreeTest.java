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
public class ShrineOfTheElderTreeTest 
{
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
    @Mock
    Board mockBoardAmountSeven;

    @Before
    public void initMocks(){
        when(mockBoardAmountOne.getAmountTree()).thenReturn(1);
        when(mockBoardAmountTwo.getAmountTree()).thenReturn(2);
        when(mockBoardAmountThree.getAmountTree()).thenReturn(3);
        when(mockBoardAmountFour.getAmountTree()).thenReturn(4);
        when(mockBoardAmountFive.getAmountTree()).thenReturn(5);
        when(mockBoardAmountSix.getAmountTree()).thenReturn(6);
        when(mockBoardAmountSeven.getAmountTree()).thenReturn(7);
    }

    @Test
    public void ShrineOfTheElderTree_HasCorrectSquareType(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, shrineOfTheElderTree.squareType);
    }

    @Test
    public void ShrineOfTheElderTree_HasCorrectPosition(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), shrineOfTheElderTree.position);
    }

    @Test
    public void ShrineOfTheElderTree_HasCorrectPurpleEnum(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(0, 0));
        assertEquals(PurpleEnum.ShrineOfTheElderTree, shrineOfTheElderTree.purpleBuildingType);
    }

    @Test
    public void getScore_AmountOne(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(0,0));
        int score = shrineOfTheElderTree.getScore(mockBoardAmountOne);
        assertEquals(1, score);
    }

    @Test
    public void getScore_AmountTwo(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(0,0));
        int score = shrineOfTheElderTree.getScore(mockBoardAmountTwo);
        assertEquals(2, score);
    }

    @Test
    public void getScore_AmountThree(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(0,0));
        int score = shrineOfTheElderTree.getScore(mockBoardAmountThree);
        assertEquals(3, score);
    }

    @Test
    public void getScore_AmountFour(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(0,0));
        int score = shrineOfTheElderTree.getScore(mockBoardAmountFour);
        assertEquals(4, score);
    }

    @Test
    public void getScore_AmountFive(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(0,0));
        int score = shrineOfTheElderTree.getScore(mockBoardAmountFive);
        assertEquals(5, score);
    }

    @Test
    public void getScore_AmountSix(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(0,0));
        int score = shrineOfTheElderTree.getScore(mockBoardAmountSix);
        assertEquals(8, score);
    }

    @Test
    public void getScore_AmountSeven(){
        ShrineOfTheElderTree shrineOfTheElderTree = new ShrineOfTheElderTree(Pair.create(0,0));
        int score = shrineOfTheElderTree.getScore(mockBoardAmountSeven);
        assertEquals(8, score);
    }
}
