package com.example.tinycalculator.Domain.RedBuildings;

import static org.junit.Assert.assertTrue;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
import com.example.tinycalculator.Domain.PurpleBuildings.BarettCastle;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.GreenEnum;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.RedEnum;
import com.example.tinycalculator.Enums.YellowEnum;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class RedBuildingTest {
    String empty =
            "Monument, Empty, Empty, Empty," +
            "Empty, Empty, Empty, Empty," +
            "Empty, Empty, Empty, Empty," +
            "Empty, Empty, Empty, Empty";
    Board board = new Board(empty,
            PurpleEnum.BarettCastle, RedEnum.Orchard, OrangeEnum.Temple, YellowEnum.Bakery, GreyEnum.Fountain,
            GreenEnum.FeastHall, BlackEnum.TradingPost, 0, 0,
            0, 0);


    @Test
    public void feedSquares_ShouldFeedGivenSquares(){
        List<Square> squares = new ArrayList<>();
        Cottage cottageOne = new Cottage(Pair.create(0,0));
        Cottage cottageTwo = new Cottage(Pair.create(0,0));
        BarettCastle barettCastle = (BarettCastle) board.getSquares()[0][0];

        squares.add(cottageOne);
        squares.add(cottageTwo);
        squares.add(barettCastle);

        RedBuilding.feedSquares(board, squares);

        assertTrue(cottageOne.isFed);
        assertTrue(cottageTwo.isFed);
        assertTrue(barettCastle.isFed);
    }
}
