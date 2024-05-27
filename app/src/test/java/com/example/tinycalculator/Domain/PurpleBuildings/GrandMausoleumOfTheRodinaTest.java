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
public class GrandMausoleumOfTheRodinaTest {
    @Mock
    Board mockBoard;

    @Test
    public void GrandMausoleumOfTheRodina_HasCorrectSquareType(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = new GrandMausoleumOfTheRodina(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, grandMausoleumOfTheRodina.squareType);
    }

    @Test
    public void GrandMausoleumOfTheRodina_HasCorrectPosition(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = new GrandMausoleumOfTheRodina(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), grandMausoleumOfTheRodina.position);
    }

    @Test
    public void GrandMausoleumOfTheRodina_HasCorrectPurpleEnum(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = new GrandMausoleumOfTheRodina(Pair.create(0, 0));
        assertEquals(PurpleEnum.GrandMausoleumOfTheRodina, grandMausoleumOfTheRodina.purpleBuildingType);
    }

    @Test
    public void getScore_ShouldReturnZero(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = new GrandMausoleumOfTheRodina(Pair.create(0,0));
        int score = grandMausoleumOfTheRodina.getScore(mockBoard);
        assertEquals(0, score);
    }
}
