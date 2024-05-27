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
public class GroveUniversityTest {

    @Mock
    Board mockBoard;

    @Test
    public void GroveUniversity_HasCorrectSquareType(){
        GroveUniversity groveUniversity = new GroveUniversity(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, groveUniversity.squareType);
    }

    @Test
    public void GroveUniversity_HasCorrectPosition(){
        GroveUniversity groveUniversity = new GroveUniversity(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), groveUniversity.position);
    }

    @Test
    public void GroveUniversity_HasCorrectPurpleEnum(){
        GroveUniversity groveUniversity = new GroveUniversity(Pair.create(0, 0));
        assertEquals(PurpleEnum.GroveUniversity, groveUniversity.purpleBuildingType);
    }

    @Test
    public void getScore_ShouldReturnThree(){
        GroveUniversity groveUniversity = new GroveUniversity(Pair.create(0,0));
        int score = groveUniversity.getScore(mockBoard);
        assertEquals(3, score);
    }


}
