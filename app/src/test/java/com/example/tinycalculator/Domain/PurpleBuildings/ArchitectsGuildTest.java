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
public class ArchitectsGuildTest {
    @Mock
    Board board;

    @Test
    public void ArchitectsGuild_HasCorrectSquareType(){
        ArchitectsGuild architectsGuild = new ArchitectsGuild(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, architectsGuild.squareType);
    }

    @Test
    public void ArchitectsGuild_HasCorrectPosition(){
        ArchitectsGuild architectsGuild = new ArchitectsGuild(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), architectsGuild.position);
    }

    @Test
    public void ArchitectsGuild_HasCorrectPurpleEnum(){
        ArchitectsGuild architectsGuild = new ArchitectsGuild(Pair.create(0, 0));
        assertEquals(PurpleEnum.ArchitectGuild, architectsGuild.purpleBuildingType);
    }
    
    @Test
    public void getScore_ShouldReturnOne(){
        ArchitectsGuild architectsGuild = new ArchitectsGuild(Pair.create(0,0));
        int score = architectsGuild.getScore(board);
        assertEquals(1, score);
    }
}
