package com.example.tinycalculator.Domain.RedBuildings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
import com.example.tinycalculator.Domain.PurpleBuildings.BarettCastle;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.GreenEnum;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.RedEnum;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Enums.YellowEnum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class GranaryTest {
    Board boardOneGranaryAllSurrounding;
    Board boardOneGranaryNoSurrounding;
    Board boardTwoGranariesWithOverlap;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Granary;
        OrangeEnum orangeEnum = OrangeEnum.Chapel;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringOneGranaryAllSurrounding =
                "Monument, Cottage, Cottage, Empty," +
                "Cottage, Farm, Cottage, Empty," +
                "Cottage, Cottage, Cottage, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneGranaryAllSurrounding = new Board(stringOneGranaryAllSurrounding,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneGranaryNoSurrounding =
                "Empty, Empty, Empty, Monument," +
                "Empty, Farm, Empty, Cottage," +
                "Empty, Empty, Empty, Cottage," +
                "Cottage, Cottage, Cottage, Cottage";
        boardOneGranaryNoSurrounding = new Board(stringOneGranaryNoSurrounding,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoGranariesWithOverlap =
                "Monument, Cottage, Cottage, Cottage," +
                "Cottage, Farm, Cottage, Empty," +
                "Cottage, Cottage, Cottage, Cottage," +
                "Empty, Empty, Cottage, Farm";
        boardTwoGranariesWithOverlap = new Board(stringTwoGranariesWithOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Granary_HasCorrectSquareType(){
        Granary granary = new Granary(Pair.create(1,2));
        assertEquals(SquareEnum.RedBuilding, granary.squareType);
    }

    @Test
    public void Granary_HasCorrectPosition(){
        Granary granary = new Granary(Pair.create(1,2));
        assertEquals(Pair.create(1,2), granary.position);
    }

    @Test
    public void Granary_HasCorrectOrangeEnum(){
        Granary granary = new Granary(Pair.create(3,3));
        assertEquals(RedEnum.Granary, granary.redBuildingType);
    }

    @Test
    public void feedCottages_OneGranaryAllSurrounding(){
        Granary granary = new Granary(Pair.create(0,0));
        granary.feedCottages(boardOneGranaryAllSurrounding);
        BarettCastle barettCastle = (BarettCastle) boardOneGranaryAllSurrounding.getSquares()[0][0];
        List<Cottage> cottagesFed = boardOneGranaryAllSurrounding.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertTrue(barettCastle.isFed);
        assertEquals(7, cottagesFed.size());
    }

    @Test
    public void feedCottages_OneGranaryNoSurrounding(){
        Granary granary = new Granary(Pair.create(0,0));
        granary.feedCottages(boardOneGranaryNoSurrounding);
        BarettCastle barettCastle = (BarettCastle) boardOneGranaryNoSurrounding.getSquares()[0][3];
        List<Cottage> cottagesFed = boardOneGranaryNoSurrounding.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertFalse(barettCastle.isFed);
        assertEquals(0, cottagesFed.size());
    }

    @Test
    public void feedCottages_TwoGranaryWithOverlap(){
        Granary granary = new Granary(Pair.create(0,0));
        granary.feedCottages(boardTwoGranariesWithOverlap);
        BarettCastle barettCastle = (BarettCastle) boardTwoGranariesWithOverlap.getSquares()[0][0];
        List<Cottage> cottagesFed = boardTwoGranariesWithOverlap.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertTrue(barettCastle.isFed);
        assertEquals(9, cottagesFed.size());
    }
}
