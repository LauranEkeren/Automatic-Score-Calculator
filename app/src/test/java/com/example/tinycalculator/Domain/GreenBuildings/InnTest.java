package com.example.tinycalculator.Domain.GreenBuildings;

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

import java.util.HashMap;


public class InnTest {
    Board boardNoBuildings;
    Board boardOneBuilding;
    Board boardTwoBuildingsNoOverlap;
    Board boardTwoBuildingsTwoOverlap;
    Board boardFourBuildingsNoOverlap;
    Board boardFiveBuildingsThreeOverlap;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.NoPurpleBuilding;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Abbey;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Well;
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

        String stringOneBuilding =
                "Empty, Empty, Empty, Empty," +
                "Empty, Tavern, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneBuilding = new Board(stringOneBuilding,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoBuildingsNoOverlap =
                "Empty, Empty, Empty, Empty," +
                "Empty, Tavern, Empty, Empty," +
                "Empty, Empty, Tavern, Empty," +
                "Empty, Empty, Empty, Empty";
        boardTwoBuildingsNoOverlap = new Board(stringTwoBuildingsNoOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoBuildingsTwoOverlap =
                "Empty, Empty, Empty, Empty," +
                "Empty, Tavern, Tavern, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardTwoBuildingsTwoOverlap = new Board(stringTwoBuildingsTwoOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringFourBuildingsNoOverlap =
                "Tavern, Empty, Empty, Empty," +
                "Empty, Tavern, Empty, Empty," +
                "Empty, Empty, Tavern, Empty," +
                "Empty, Empty, Empty, Tavern";
        boardFourBuildingsNoOverlap = new Board(stringFourBuildingsNoOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringFiveBuildingsThreeOverlap =
                "Tavern, Tavern, Empty, Empty," +
                "Empty, Tavern, Empty, Empty," +
                "Empty, Empty, Tavern, Empty," +
                "Empty, Empty, Empty, Tavern";
        boardFiveBuildingsThreeOverlap = new Board(stringFiveBuildingsThreeOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }
    @Test
    public void Inn_HasCorrectSquareType(){
        Inn inn = new Inn(Pair.create(2,2));
        assertEquals(SquareEnum.GreenBuilding, inn.squareType);
    }

    @Test
    public void Inn_HasCorrectPosition(){
        Inn inn = new Inn(Pair.create(0,3));
        assertEquals(Pair.create(0,3), inn.position);
    }

    @Test
    public void Inn_HasCorrectGreenEnum(){
        Inn inn = new Inn(Pair.create(1,1));
        assertEquals(GreenEnum.Inn, inn.greenBuildingType);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithNoBuildings(){
        Inn inn = new Inn(Pair.create(1,1));
        int score = inn.getScore(boardNoBuildings);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithOneBuilding(){
        Inn inn = new Inn(Pair.create(2,2));
        int score = inn.getScore(boardOneBuilding);
        assertEquals(3, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithTwoBuildingsNoOverlap(){
        Inn inn = new Inn(Pair.create(2,2));
        int score = inn.getScore(boardTwoBuildingsNoOverlap);
        assertEquals(6, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithTwoBuildingsTwoOverlap(){
        Inn inn = new Inn(Pair.create(1,3));
        int score = inn.getScore(boardTwoBuildingsTwoOverlap);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithFourBuildingsNoOverlap(){
        Inn inn = new Inn(Pair.create(1,1));
        int score = inn.getScore(boardFourBuildingsNoOverlap);
        assertEquals(12, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithFiveBuildingsThreeOverlap(){
        Inn inn = new Inn(Pair.create(2,1));
        int score = inn.getScore(boardFiveBuildingsThreeOverlap);
        assertEquals(6, score);
    }



}
