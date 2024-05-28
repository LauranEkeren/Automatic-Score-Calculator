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

public class GreenhouseTest {
    Board boardOneGreenhouseFiveAndThreeCottages;
    Board boardTwoGreenhouseFiveAndThreeCottages;
    Board boardTwoGreenhouseFiveAndOneCottagesAndBarettCastle;
    Board boardOneGreenhouseWithTemples;
    Board boardTwoGreenhouseAndBarettCastleWithTemples;

    @Before
    public void createBoards() {
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Greenhouse;
        OrangeEnum orangeEnum = OrangeEnum.Chapel;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringOneGreenhouseFiveAndThreeCottages =
                "Cottage, Empty, Cottage, Cottage," +
                "Cottage, Farm, Cottage, Empty," +
                "Cottage, Empty, Cottage, Cottage," +
                "Empty, Empty, Empty, Empty";
        boardOneGreenhouseFiveAndThreeCottages = new Board(stringOneGreenhouseFiveAndThreeCottages,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoGreenhouseFiveAndThreeCottages =
                "Cottage, Empty, Cottage, Cottage," +
                "Cottage, Farm, Cottage, Empty," +
                "Cottage, Farm, Cottage, Cottage," +
                "Empty, Empty, Empty, Empty";
        boardTwoGreenhouseFiveAndThreeCottages = new Board(stringTwoGreenhouseFiveAndThreeCottages,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoGreenhouseFiveAndOneCottagesAndBarettCastle =
                "Monument, Empty, Cottage, Cottage," +
                "Empty, Farm, Cottage, Empty," +
                "Empty, Farm, Cottage, Cottage," +
                "Empty, Empty, Empty, Empty";
        boardTwoGreenhouseFiveAndOneCottagesAndBarettCastle = new Board(stringTwoGreenhouseFiveAndOneCottagesAndBarettCastle,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneGreenhouseWithTemples =
                "Farm, Empty, Empty, Cottage," +
                "Empty, Empty, Empty, Cottage," +
                "Cottage, Cottage, Empty, Cottage," +
                "Chapel, Cottage, Empty, Cottage";
        boardOneGreenhouseWithTemples = new Board(stringOneGreenhouseWithTemples,
                purpleEnum, redEnum, OrangeEnum.Temple, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoGreenhouseAndBarettCastleWithTemples =
                "Monument, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Cottage, Cottage, Farm, Cottage," +
                "Chapel, Cottage, Farm, Cottage";
        boardTwoGreenhouseAndBarettCastleWithTemples = new Board(stringTwoGreenhouseAndBarettCastleWithTemples,
                purpleEnum, redEnum, OrangeEnum.Temple, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Greenhouse_HasCorrectSquareType(){
        Greenhouse greenhouse = new Greenhouse(Pair.create(1,2));
        assertEquals(SquareEnum.RedBuilding, greenhouse.squareType);
    }

    @Test
    public void Greenhouse_HasCorrectPosition(){
        Greenhouse greenhouse = new Greenhouse(Pair.create(1,2));
        assertEquals(Pair.create(1,2), greenhouse.position);
    }

    @Test
    public void Greenhouse_HasCorrectOrangeEnum(){
        Greenhouse greenhouse = new Greenhouse(Pair.create(3,3));
        assertEquals(RedEnum.Greenhouse, greenhouse.redBuildingType);
    }
    
    @Test
    public void feedCottages_boardOneGreenhouseFiveAndThreeCottages(){
        Greenhouse greenhouse = new Greenhouse(Pair.create(0,0));
        greenhouse.feedCottages(boardOneGreenhouseFiveAndThreeCottages);
        List<Cottage> fedCottages = boardOneGreenhouseFiveAndThreeCottages.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertEquals(5, fedCottages.size());
    }

    @Test
    public void feedCottages_boardTwoGreenhouseFiveAndThreeCottages(){
        Greenhouse greenhouse = new Greenhouse(Pair.create(0,0));
        greenhouse.feedCottages(boardTwoGreenhouseFiveAndThreeCottages);
        List<Cottage> fedCottages = boardTwoGreenhouseFiveAndThreeCottages.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertEquals(8, fedCottages.size());
    }

    @Test
    public void feedCottages_boardTwoGreenhouseFiveAndOneCottagesAndBarettCastle(){
        Greenhouse greenhouse = new Greenhouse(Pair.create(0,0));
        greenhouse.feedCottages(boardTwoGreenhouseFiveAndOneCottagesAndBarettCastle);
        List<Cottage> fedCottages = boardTwoGreenhouseFiveAndOneCottagesAndBarettCastle.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        BarettCastle barettCastle = (BarettCastle) boardTwoGreenhouseFiveAndOneCottagesAndBarettCastle.getSquares()[0][0];
        assertTrue(barettCastle.isFed);
        assertEquals(5, fedCottages.size());
    }

    @Test
    public void feedCottages_boardOneGreenhouseWithTemples(){
        Greenhouse greenhouse = new Greenhouse(Pair.create(0,0));
        greenhouse.feedCottages(boardOneGreenhouseWithTemples);
        Cottage cottage03 = (Cottage) boardOneGreenhouseWithTemples.getSquares()[0][3];
        Cottage cottage13 = (Cottage) boardOneGreenhouseWithTemples.getSquares()[1][3];
        Cottage cottage20 = (Cottage) boardOneGreenhouseWithTemples.getSquares()[2][0];
        Cottage cottage21 = (Cottage) boardOneGreenhouseWithTemples.getSquares()[2][1];
        Cottage cottage23 = (Cottage) boardOneGreenhouseWithTemples.getSquares()[2][3];
        Cottage cottage31 = (Cottage) boardOneGreenhouseWithTemples.getSquares()[3][1];
        Cottage cottage33 = (Cottage) boardOneGreenhouseWithTemples.getSquares()[3][3];
        assertTrue(cottage20.isFed);
        assertTrue(cottage21.isFed);
        assertTrue(cottage31.isFed);
        assertFalse(cottage03.isFed);
        assertFalse(cottage13.isFed);
        assertFalse(cottage23.isFed);
        assertFalse(cottage33.isFed);
    }

    @Test
    public void feedCottages_boardTwoGreenhouseAndBarettCastleWithTemples(){
        Greenhouse greenhouse = new Greenhouse(Pair.create(0,0));
        greenhouse.feedCottages(boardTwoGreenhouseAndBarettCastleWithTemples);
        BarettCastle barettCastle = (BarettCastle) boardTwoGreenhouseAndBarettCastleWithTemples.getSquares()[0][0];
        Cottage cottage20 = (Cottage) boardTwoGreenhouseAndBarettCastleWithTemples.getSquares()[2][0];
        Cottage cottage21 = (Cottage) boardTwoGreenhouseAndBarettCastleWithTemples.getSquares()[2][1];
        Cottage cottage23 = (Cottage) boardTwoGreenhouseAndBarettCastleWithTemples.getSquares()[2][3];
        Cottage cottage31 = (Cottage) boardTwoGreenhouseAndBarettCastleWithTemples.getSquares()[3][1];
        Cottage cottage33 = (Cottage) boardTwoGreenhouseAndBarettCastleWithTemples.getSquares()[3][3];
        assertTrue(barettCastle.isFed);
        assertTrue(cottage20.isFed);
        assertTrue(cottage21.isFed);
        assertTrue(cottage31.isFed);
        assertFalse(cottage23.isFed);
        assertFalse(cottage33.isFed);
    }
}
