package com.example.tinycalculator.Domain.YellowBuildings;

import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
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

public class BakeryTests {

    Board boardBakeryNextToNothing;
    Board boardBakeryNextToCottage;
    Board boardBakeryNextToFarm;
    Board boardBakeryNextToFactory;
    Board boardFourBakeriesTwoScoring;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Chapel;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringBakeryNextToNothing =
                "Empty, Empty, Farm, Empty," +
                "Empty, Theater, Empty, Farm," +
                "Factory, Empty, Empty, Empty," +
                "Empty, Factory, Empty, Empty";
        boardBakeryNextToNothing = new Board(stringBakeryNextToNothing,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringBakeryNextToCottage =
                "Empty, Empty, Empty, Empty," +
                "Cottage, Theater, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardBakeryNextToCottage = new Board(stringBakeryNextToCottage,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringBakeryNextToFarm =
                "Empty, Empty, Empty, Empty," +
                "Farm, Theater, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardBakeryNextToFarm = new Board(stringBakeryNextToFarm,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringBakeryNextToFactory =
                "Empty, Empty, Empty, Empty," +
                "Factory, Theater, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardBakeryNextToFactory = new Board(stringBakeryNextToFactory,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringFourBakeriesTwoScoring =
                "Empty, Farm, Empty, Empty," +
                "Factory, Theater, Empty, Theater," +
                "Factory, Empty, Empty, Empty," +
                "Theater, Empty, Theater, Empty";
        boardFourBakeriesTwoScoring = new Board(stringFourBakeriesTwoScoring,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Bakery_HasCorrectSquareType(){
        Bakery bakery = new Bakery(Pair.create(1,2));
        assertEquals(SquareEnum.YellowBuilding, bakery.squareType);
    }

    @Test
    public void Bakery_HasCorrectPosition(){
        Bakery bakery = new Bakery(Pair.create(1,2));
        assertEquals(Pair.create(1,2), bakery.position);
    }

    @Test
    public void Bakery_HasCorrectYellowEnum(){
        Bakery bakery = new Bakery(Pair.create(3,3));
        assertEquals(YellowEnum.Bakery, bakery.yellowBuildingType);
    }

    @Test
    public void getScore_BakeryNextToNothing(){
        Bakery bakery = new Bakery(Pair.create(1,1));
        int score = bakery.getScoreBakery(boardBakeryNextToNothing);
        assertEquals(0, score);
    }

    @Test
    public void getScore_BakeryNextToCottage(){
        Bakery bakery = new Bakery(Pair.create(1,1));
        int score = bakery.getScoreBakery(boardBakeryNextToCottage);
        assertEquals(0, score);
    }

    @Test
    public void getScore_BakeryNextToFarm(){
        Bakery bakery = new Bakery(Pair.create(1,1));
        int score = bakery.getScoreBakery(boardBakeryNextToFarm);
        assertEquals(3, score);
    }

    @Test
    public void getScore_BakeryNextToFactory(){
        Bakery bakery = new Bakery(Pair.create(1,1));
        int score = bakery.getScoreBakery(boardBakeryNextToFactory);
        assertEquals(3, score);
    }

    @Test
    public void getScore_FourBakeriesTwoScoring(){
        Bakery bakery = new Bakery(Pair.create(0,0));
        int score = bakery.getScore(boardFourBakeriesTwoScoring);
        assertEquals(6, score);
    }

}
