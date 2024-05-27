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
public class SilvaForumTest {
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
            when(mockBoardAmountOne.getSizeOfLargesContiguousGroupOfSameBuildingType()).thenReturn(1);
            when(mockBoardAmountTwo.getSizeOfLargesContiguousGroupOfSameBuildingType()).thenReturn(2);
            when(mockBoardAmountThree.getSizeOfLargesContiguousGroupOfSameBuildingType()).thenReturn(3);
            when(mockBoardAmountFour.getSizeOfLargesContiguousGroupOfSameBuildingType()).thenReturn(4);
            when(mockBoardAmountFive.getSizeOfLargesContiguousGroupOfSameBuildingType()).thenReturn(5);
            when(mockBoardAmountSix.getSizeOfLargesContiguousGroupOfSameBuildingType()).thenReturn(6);
            when(mockBoardAmountSeven.getSizeOfLargesContiguousGroupOfSameBuildingType()).thenReturn(7);
        }

        @Test
        public void SilvaForum_HasCorrectSquareType(){
            SilvaForum silvaForum = new SilvaForum(Pair.create(0, 0));
            assertEquals(SquareEnum.PurpleBuilding, silvaForum.squareType);
        }

        @Test
        public void SilvaForum_HasCorrectPosition(){
            SilvaForum silvaForum = new SilvaForum(Pair.create(2, 2));
            assertEquals( Pair.create(2, 2), silvaForum.position);
        }

        @Test
        public void SilvaForum_HasCorrectPurpleEnum(){
            SilvaForum silvaForum = new SilvaForum(Pair.create(0, 0));
            assertEquals(PurpleEnum.SilvaForum, silvaForum.purpleBuildingType);
        }

    @Test
    public void getScore_AmountOne(){
        SilvaForum silvaForum = new SilvaForum(Pair.create(0,0));
        int score = silvaForum.getScore(mockBoardAmountOne);
        assertEquals(2, score);
    }

    @Test
    public void getScore_AmountTwo(){
        SilvaForum silvaForum = new SilvaForum(Pair.create(0,0));
        int score = silvaForum.getScore(mockBoardAmountTwo);
        assertEquals(3, score);
    }

    @Test
    public void getScore_AmountThree(){
        SilvaForum silvaForum = new SilvaForum(Pair.create(0,0));
        int score = silvaForum.getScore(mockBoardAmountThree);
        assertEquals(4, score);
    }

    @Test
    public void getScore_AmountFour(){
        SilvaForum silvaForum = new SilvaForum(Pair.create(0,0));
        int score = silvaForum.getScore(mockBoardAmountFour);
        assertEquals(5, score);
    }

    @Test
    public void getScore_AmountFive(){
        SilvaForum silvaForum = new SilvaForum(Pair.create(0,0));
        int score = silvaForum.getScore(mockBoardAmountFive);
        assertEquals(6, score);
    }

    @Test
    public void getScore_AmountSix(){
        SilvaForum silvaForum = new SilvaForum(Pair.create(0,0));
        int score = silvaForum.getScore(mockBoardAmountSix);
        assertEquals(7, score);
    }

    @Test
    public void getScore_AmountSeven(){
        SilvaForum silvaForum = new SilvaForum(Pair.create(0,0));
        int score = silvaForum.getScore(mockBoardAmountSeven);
        assertEquals(8, score);
    }
}
