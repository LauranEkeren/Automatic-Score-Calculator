package com.example.tinycalculator.Domain.OrangeBuildings;

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

public class AbbeyTest {

    Board boardNoBuildings;
    Board boardOneAbbey;
    Board boardOneAbbeyAdjacentToFactory;
    Board boardOneAbbeyAdjacentToTavern;
    Board boardOneAbbeyAdjacentToTheater;
    Board boardOneAbbeyAdjacentToFarm;
    Board boardThreeAbbeysTwoScoring;
    Board boardSevenAbbeysFourScoring;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.NoPurpleBuilding;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Abbey;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringNoBuildings =
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardNoBuildings = new Board(stringNoBuildings,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneAbbey =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneAbbey = new Board(stringOneAbbey,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneAbbeyAdjacentToFactory =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Factory, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneAbbeyAdjacentToFactory = new Board(stringOneAbbeyAdjacentToFactory,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneAbbeyAdjacentToTavern =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Tavern, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneAbbeyAdjacentToTavern = new Board(stringOneAbbeyAdjacentToTavern,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneAbbeyAdjacentToTheater =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Theater, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneAbbeyAdjacentToTheater = new Board(stringOneAbbeyAdjacentToTheater,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneAbbeyAdjacentToFarm =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Farm, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneAbbeyAdjacentToFarm = new Board(stringOneAbbeyAdjacentToFarm,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringThreeAbbeysTwoScoring =
                "Chapel, Farm, Empty, Empty," +
                "Cottage, Chapel, Theater, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Well, Chapel, Empty, Empty";
        boardThreeAbbeysTwoScoring = new Board(stringThreeAbbeysTwoScoring,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringSevenAbbeysFourScoring =
                "Chapel, Farm, Chapel, Factory," +
                "Cottage, Chapel, Theater, Tavern," +
                "Chapel, Empty, Empty, Chapel," +
                "Well, Chapel, Chapel, Empty";
        boardSevenAbbeysFourScoring = new Board(stringSevenAbbeysFourScoring,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Abbey_HasCorrectSquareType(){
        Abbey abbey = new Abbey(Pair.create(1,2));
        assertEquals(SquareEnum.OrangeBuilding, abbey.squareType);
    }

    @Test
    public void Abbey_HasCorrectPosition(){
        Abbey abbey = new Abbey(Pair.create(1,2));
        assertEquals(Pair.create(1,2), abbey.position);
    }

    @Test
    public void Abbey_HasCorrectOrangeEnum(){
        Abbey abbey = new Abbey(Pair.create(3,3));
        assertEquals(OrangeEnum.Abbey, abbey.orangeBuildingType);
    }

    @Test
    public void getScoreAbbey_AbbeyAdjacentToNone(){
        Abbey abbey = (Abbey) boardOneAbbey.getSquares()[1][1];
        int score = abbey.getScoreAbbey(boardOneAbbey);
        assertEquals(3, score);
    }

    @Test
    public void getScoreAbbey_AbbeyAdjacentToFactory(){
        Abbey abbey = (Abbey) boardOneAbbeyAdjacentToFactory.getSquares()[1][1];
        int score = abbey.getScoreAbbey(boardOneAbbeyAdjacentToFactory);
        assertEquals(0, score);
    }

    @Test
    public void getScoreAbbey_AbbeyAdjacentToTavern(){
        Abbey abbey = (Abbey) boardOneAbbeyAdjacentToTavern.getSquares()[1][1];
        int score = abbey.getScoreAbbey(boardOneAbbeyAdjacentToTavern);
        assertEquals(0, score);
    }

    @Test
    public void getScoreAbbey_AbbeyAdjacentToTheater(){
        Abbey abbey = (Abbey) boardOneAbbeyAdjacentToTheater.getSquares()[1][1];
        int score = abbey.getScoreAbbey(boardOneAbbeyAdjacentToTheater);
        assertEquals(0, score);
    }

    @Test
    public void getScoreAbbey_AbbeyAdjacentToFarm(){
        Abbey abbey = (Abbey) boardOneAbbeyAdjacentToFarm.getSquares()[1][1];
        int score = abbey.getScoreAbbey(boardOneAbbeyAdjacentToFarm);
        assertEquals(3, score);
    }

    @Test
    public void getScore_BoardThreeAbbeysTwoScoring(){
        Abbey abbey = new Abbey(Pair.create(0,0));
        int score = abbey.getScore(boardThreeAbbeysTwoScoring);
        assertEquals(6, score);
    }

    @Test
    public void getScore_BoardSevenAbbeysFourScoring(){
        Abbey abbey = new Abbey(Pair.create(0,0));
        int score = abbey.getScore(boardSevenAbbeysFourScoring);
        assertEquals(12, score);
    }

}
