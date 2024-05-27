package com.example.tinycalculator.Domain.BlackBuildings;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.EmptySquare;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FactoryTest {
    @Mock
    Board board;


    @Test
    public void Factory_HasCorrectSquareType(){
        Factory factory = new Factory(Pair.create(0, 0));
        assertEquals(SquareEnum.BlackBuilding, factory.squareType);
    }

    @Test
    public void Factory_HasCorrectPosition(){
        Factory factory = new Factory(Pair.create(3, 2));
        assertEquals(Pair.create(3, 2), factory.position);
    }

    @Test
    public void Factory_HasCorrectBlackEnum(){
        Factory factory = new Factory(Pair.create(0, 0));
        assertEquals(BlackEnum.Factory, factory.blackBuildingType);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithZeroBuildings(){
        Factory factory = new Factory(Pair.create(0, 0));
        int score = factory.getScore(board);
        assertEquals(0, score);
    }

}
