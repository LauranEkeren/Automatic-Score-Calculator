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
public class FortIronweedTest {

    @Mock
    Board board;
    @Test
    public void FortIronweed_HasCorrectSquareType(){
        FortIronweed fortIronweed = new FortIronweed(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, fortIronweed.squareType);
    }

    @Test
    public void FortIronweed_HasCorrectPosition(){
        FortIronweed fortIronweed = new FortIronweed(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), fortIronweed.position);
    }

    @Test
    public void FortIronweed_HasCorrectPurpleEnum(){
        FortIronweed fortIronweed = new FortIronweed(Pair.create(0, 0));
        assertEquals(PurpleEnum.FortIronweed, fortIronweed.purpleBuildingType);
    }

    @Test
    public void getScore_ShouldReturnSeven(){
        FortIronweed fortIronweed = new FortIronweed(Pair.create(0,0));
        int score = fortIronweed.getScore(board);
        assertEquals(7, score);
    }
}
