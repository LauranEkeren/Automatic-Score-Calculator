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

public class FarmTest {
    Board boardOneFarmOneCottage;
    Board boardOneFarmFourCottages;
    Board boardOneFarmFiveCottages;
    Board boardTwoFarmsEightCottages;
    Board boardOneFarmOneBarettCastle;
    Board boardOneFarmFourCottagesOneBarretCastle;
    Board boardOneFarmSixCottagesWithTemples ;
    Board boardOneFarmSixCottagesOneBarettCastleWithTemples;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Chapel;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringOneFarmOneCottage =
                "Empty, Empty, Empty, Empty," +
                "Empty, Farm, Cottage, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneFarmOneCottage = new Board(stringOneFarmOneCottage,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneFarmFourCottages =
                "Empty, Empty, Empty, Empty," +
                "Empty, Farm, Empty, Empty," +
                "Cottage, Cottage, Cottage, Cottage," +
                "Empty, Empty, Empty, Empty";
        boardOneFarmFourCottages = new Board(stringOneFarmFourCottages,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneFarmFiveCottages =
                "Empty, Empty, Empty, Empty," +
                "Empty, Farm, Empty, Empty," +
                "Cottage, Cottage, Cottage, Cottage," +
                "Cottage, Empty, Empty, Empty";
        boardOneFarmFiveCottages = new Board(stringOneFarmFiveCottages,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoFarmEightCottages =
                "Empty, Empty, Empty, Empty," +
                "Farm, Farm, Empty, Empty," +
                "Cottage, Cottage, Cottage, Cottage," +
                "Cottage, Cottage, Cottage, Cottage";
        boardTwoFarmsEightCottages = new Board(stringTwoFarmEightCottages,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneFarmOneBarettCastle =
                "Monument, Empty, Empty, Empty," +
                "Empty, Farm, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneFarmOneBarettCastle = new Board(stringOneFarmOneBarettCastle,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneFarmFourCottagesOneBarettCastle =
                "Monument, Empty, Empty, Empty," +
                "Empty, Farm, Empty, Empty," +
                "Cottage, Cottage, Cottage, Cottage," +
                "Empty, Empty, Empty, Empty";
        boardOneFarmFourCottagesOneBarretCastle = new Board(stringOneFarmFourCottagesOneBarettCastle,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneFarmSixCottagesWithChapels =
                "Cottage, Empty, Empty, Cottage," +
                "Chapel, Farm, Empty, Chapel," +
                "Cottage, Empty, Chapel, Cottage," +
                "Cottage, Chapel, Cottage, Chapel";
        boardOneFarmSixCottagesWithTemples = new Board(stringOneFarmSixCottagesWithChapels,
                purpleEnum, redEnum, OrangeEnum.Temple, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneFarmSixCottagesOneBarettCastleWithChapels =
                "Cottage, Cottage, Chapel, Monument," +
                 "Chapel, Farm, Empty, Empty," +
                 "Cottage, Empty, Chapel, Cottage," +
                 "Cottage, Chapel, Cottage, Chapel";
        boardOneFarmSixCottagesOneBarettCastleWithTemples = new Board(stringOneFarmSixCottagesOneBarettCastleWithChapels,
                purpleEnum, redEnum, OrangeEnum.Temple, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Farm_HasCorrectSquareType(){
        Farm farm = new Farm(Pair.create(1,2));
        assertEquals(SquareEnum.RedBuilding, farm.squareType);
    }

    @Test
    public void Farm_HasCorrectPosition(){
        Farm farm = new Farm(Pair.create(1,2));
        assertEquals(Pair.create(1,2), farm.position);
    }

    @Test
    public void Farm_HasCorrectOrangeEnum(){
        Farm farm = new Farm(Pair.create(3,3));
        assertEquals(RedEnum.Farm, farm.redBuildingType);
    }

    @Test
    public void feedCottages_OneFarmOneCottage(){
        Farm farm = new Farm(Pair.create(0,0));
        farm.feedCottages(boardOneFarmOneCottage);
        Cottage cottage = (Cottage) boardOneFarmOneCottage.getSquares()[1][2];
        assertTrue(cottage.isFed);
    }

    @Test
    public void feedCottages_OneFarmFourCottages(){
        Farm farm = new Farm(Pair.create(0,0));
        farm.feedCottages(boardOneFarmFourCottages);
        List<Cottage> fedCottages = boardOneFarmFourCottages.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertEquals(4, fedCottages.size());
    }

    @Test
    public void feedCottages_OneFarmFiveCottages(){
        Farm farm = new Farm(Pair.create(0,0));
        farm.feedCottages(boardOneFarmFiveCottages);
        List<Cottage> fedCottages = boardOneFarmFiveCottages.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertEquals(4, fedCottages.size());
    }

    @Test
    public void feedCottages_TwoFarmsEightCottages(){
        Farm farm = new Farm(Pair.create(0,0));
        farm.feedCottages(boardTwoFarmsEightCottages);
        List<Cottage> fedCottages = boardTwoFarmsEightCottages.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertEquals(8, fedCottages.size());
    }

    @Test
    public void feedCottages_OneFarmOneBarettCastle(){
        Farm farm = new Farm(Pair.create(0,0));
        farm.feedCottages(boardOneFarmOneBarettCastle);
        BarettCastle barettCastle = (BarettCastle) boardOneFarmOneBarettCastle.getSquares()[0][0];
        assertTrue(barettCastle.isFed);
    }

    @Test
    public void feedCottages_OneFarmFourCottagesOneBarretCastle(){
        Farm farm = new Farm(Pair.create(0,0));
        farm.feedCottages(boardOneFarmFourCottagesOneBarretCastle);
        BarettCastle barettCastle = (BarettCastle) boardOneFarmFourCottagesOneBarretCastle.getSquares()[0][0];
        List<Cottage> fedCottages = boardOneFarmFourCottagesOneBarretCastle.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertTrue(barettCastle.isFed);
        assertEquals(3, fedCottages.size());
    }

    @Test
    public void feedCottages_OneFarmSixCottagesWithTemples(){
        Farm farm = new Farm(Pair.create(0,0));
        farm.feedCottages(boardOneFarmSixCottagesWithTemples);
        Cottage cottage00 = (Cottage) boardOneFarmSixCottagesWithTemples.getSquares()[0][0];
        Cottage cottage03 = (Cottage) boardOneFarmSixCottagesWithTemples.getSquares()[0][3];
        Cottage cottage20 = (Cottage) boardOneFarmSixCottagesWithTemples.getSquares()[2][0];
        Cottage cottage23 = (Cottage) boardOneFarmSixCottagesWithTemples.getSquares()[2][3];
        Cottage cottage30 = (Cottage) boardOneFarmSixCottagesWithTemples.getSquares()[3][0];
        Cottage cottage32 = (Cottage) boardOneFarmSixCottagesWithTemples.getSquares()[3][2];
        assertTrue(cottage03.isFed);
        assertTrue(cottage30.isFed);
        assertTrue(cottage23.isFed);
        assertTrue(cottage32.isFed);
        assertFalse(cottage00.isFed);
        assertFalse(cottage20.isFed);
    }

    @Test
    public void feedCottages_OneFarmSixCottagesOneBarettCastleWithTemples(){
        Farm farm = new Farm(Pair.create(0,0));
        farm.feedCottages(boardOneFarmSixCottagesOneBarettCastleWithTemples);
        Cottage cottage00 = (Cottage) boardOneFarmSixCottagesOneBarettCastleWithTemples.getSquares()[0][0];
        Cottage cottage01 = (Cottage) boardOneFarmSixCottagesOneBarettCastleWithTemples.getSquares()[0][1];
        Cottage cottage20 = (Cottage) boardOneFarmSixCottagesOneBarettCastleWithTemples.getSquares()[2][0];
        Cottage cottage23 = (Cottage) boardOneFarmSixCottagesOneBarettCastleWithTemples.getSquares()[2][3];
        Cottage cottage30 = (Cottage) boardOneFarmSixCottagesOneBarettCastleWithTemples.getSquares()[3][0];
        Cottage cottage32 = (Cottage) boardOneFarmSixCottagesOneBarettCastleWithTemples.getSquares()[3][2];
        BarettCastle barettCastle = (BarettCastle) boardOneFarmSixCottagesOneBarettCastleWithTemples.getSquares()[0][3];
        assertTrue(cottage23.isFed);
        assertTrue(cottage30.isFed);
        assertTrue(cottage32.isFed);
        assertTrue(barettCastle.isFed);
        assertFalse(cottage00.isFed);
        assertFalse(cottage01.isFed);
        assertFalse(cottage20.isFed);

    }
}
