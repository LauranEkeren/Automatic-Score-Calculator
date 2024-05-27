package com.example.tinycalculator.Domain.GreyBuildings;

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

public class FountainTest {
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

        String stringOneBuilding =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneBuilding = new Board(stringOneBuilding,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoBuildingsNoOverlap =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Empty, Empty," +
                "Empty, Empty, Well, Empty," +
                "Empty, Empty, Empty, Empty";
        boardTwoBuildingsNoOverlap = new Board(stringTwoBuildingsNoOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoBuildingsTwoOverlap =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Well, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardTwoBuildingsTwoOverlap = new Board(stringTwoBuildingsTwoOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringFourBuildingsNoOverlap =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Empty, Empty," +
                "Well, Empty, Well, Empty," +
                "Empty, Well, Empty, Empty";
        boardFourBuildingsNoOverlap = new Board(stringFourBuildingsNoOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringFiveBuildingsThreeOverlap =
                "Well, Well, Empty, Empty," +
                "Empty, Well, Empty, Empty," +
                "Empty, Empty, Well, Empty," +
                "Empty, Empty, Empty, Well";
        boardFiveBuildingsThreeOverlap = new Board(stringFiveBuildingsThreeOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Fountain_HasCorrectSquareType(){
        Fountain fountain = new Fountain(Pair.create(1,2));
        assertEquals(SquareEnum.GreyBuilding, fountain.squareType);
    }

    @Test
    public void Fountain_HasCorrectPosition(){
        Fountain fountain = new Fountain(Pair.create(1,2));
        assertEquals(Pair.create(1,2), fountain.position);
    }

    @Test
    public void Fountain_HasCorrectGreyEnum(){
        Fountain fountain = new Fountain(Pair.create(3,3));
        assertEquals(GreyEnum.Fountain, fountain.greyBuildingType);
    }

    @Test
    public void getScoreFountain_noAdjacent(){
        Fountain fountain = (Fountain) boardOneBuilding.getSquares()[1][1];
        int score = fountain.getScoreFountain(boardOneBuilding);
        assertEquals(0, score);
    }

    @Test
    public void getScoreFountain_oneAdjacent(){
        Fountain fountain = (Fountain) boardTwoBuildingsTwoOverlap.getSquares()[1][1];
        int score = fountain.getScoreFountain(boardTwoBuildingsTwoOverlap);
        assertEquals(2, score);
    }

    @Test
    public void getScoreFountain_twoAdjacent(){
        Fountain fountain = (Fountain) boardFiveBuildingsThreeOverlap.getSquares()[0][1];
        int score = fountain.getScoreFountain(boardFiveBuildingsThreeOverlap);
        assertEquals(2, score);
    }

    @Test
    public void getScore_noBuildings(){
        Fountain fountain = new Fountain(Pair.create(0,0));
        int score = fountain.getScore(boardNoBuildings);
        assertEquals(0, score);
    }

    @Test
    public void getScore_OneBuilding(){
        Fountain fountain = new Fountain(Pair.create(0,0));
        int score = fountain.getScore(boardOneBuilding);
        assertEquals(0, score);
    }

    @Test
    public void getScore_TwoBuildingsNoOverlap(){
        Fountain fountain = new Fountain(Pair.create(0,0));
        int score = fountain.getScore(boardTwoBuildingsNoOverlap);
        assertEquals(0, score);
    }

    @Test
    public void getScore_TwoBuildingsTwoOverlap(){
        Fountain fountain = new Fountain(Pair.create(0,0));
        int score = fountain.getScore(boardTwoBuildingsTwoOverlap);
        assertEquals(4, score);
    }

    @Test
    public void getScore_FourBuildingsNoOverlap(){
        Fountain fountain = new Fountain(Pair.create(0,0));
        int score = fountain.getScore(boardFourBuildingsNoOverlap);
        assertEquals(0, score);
    }

    @Test
    public void getScore_FiveBuildingsThreeOverlap(){
        Fountain fountain = new Fountain(Pair.create(0,0));
        int score = fountain.getScore(boardFiveBuildingsThreeOverlap);
        assertEquals(6, score);
    }

}
