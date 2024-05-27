package com.example.tinycalculator.Domain.PurpleBuildings;

import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NoScoringPurpleBuildingTest {
    @Mock
    Board mockBoard;

    @Test
    public void NoScoringPurpleBuilding_HasCorrectSquareType(){
        NoScoringPurpleBuilding noScoringPurpleBuilding = new NoScoringPurpleBuilding(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, noScoringPurpleBuilding.squareType);
    }

    @Test
    public void NoScoringPurpleBuilding_HasCorrectPosition(){
        NoScoringPurpleBuilding noScoringPurpleBuilding = new NoScoringPurpleBuilding(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), noScoringPurpleBuilding.position);
    }

    @Test
    public void NoScoringPurpleBuilding_HasCorrectPurpleEnum(){
        NoScoringPurpleBuilding noScoringPurpleBuilding = new NoScoringPurpleBuilding(Pair.create(0, 0));
        assertEquals(PurpleEnum.NoScoringPurpleBuilding, noScoringPurpleBuilding.purpleBuildingType);
    }

    @Test
    public void getScore_ShouldReturnZero(){
        NoScoringPurpleBuilding noScoringPurpleBuilding = new NoScoringPurpleBuilding(Pair.create(0,0));
        int score = noScoringPurpleBuilding.getScore(mockBoard);
        assertEquals(0, score);
    }

}
