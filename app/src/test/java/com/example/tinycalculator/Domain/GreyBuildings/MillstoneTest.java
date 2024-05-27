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

public class MillstoneTest {
    Board boardNoBuildings;
    Board boardOneMillstoneNoOthers;
    Board boardOneMillstoneOneAdjacentTheater;
    Board boardOneMillstoneOneAdjacentFarm;
    Board boardOneMillstoneOneAdjacentTheaterAndFarm;
    Board boardThreeMillstonesAllScoring;
    Board boardSevenMillstonesFourScoring;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.NoPurpleBuilding;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Abbey;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Millstone;
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

        String stringOneMillstoneNoOthers =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneMillstoneNoOthers = new Board(stringOneMillstoneNoOthers,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneMillstoneOneAdjacentTheater =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Theater, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneMillstoneOneAdjacentTheater = new Board(stringOneMillstoneOneAdjacentTheater,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneMillstoneOneAdjacentFarm =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Farm, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneMillstoneOneAdjacentFarm = new Board(stringOneMillstoneOneAdjacentFarm,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneMillstoneOneAdjacentTheaterAndFarm =
                "Empty, Empty, Empty, Empty," +
                "Theater, Well, Farm, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneMillstoneOneAdjacentTheaterAndFarm = new Board(stringOneMillstoneOneAdjacentTheaterAndFarm,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringThreeMillstonesAllScoring =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Farm, Empty," +
                "Empty, Empty, Well, Empty," +
                "Well, Theater, Empty, Empty";
        boardThreeMillstonesAllScoring = new Board(stringThreeMillstonesAllScoring,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringSevenMillstonesFourScoring =
                "Well, Empty, Empty, Well," +
                "Well, Well, Farm, Empty," +
                "Farm, Farm, Well, Empty," +
                "Well, Theater, Empty, Well";
        boardSevenMillstonesFourScoring = new Board(stringSevenMillstonesFourScoring,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Millstone_HasCorrectSquareType(){
        Millstone millstone = new Millstone(Pair.create(1,2));
        assertEquals(SquareEnum.GreyBuilding, millstone.squareType);
    }

    @Test
    public void Millstone_HasCorrectPosition(){
        Millstone millstone = new Millstone(Pair.create(1,2));
        assertEquals(Pair.create(1,2), millstone.position);
    }

    @Test
    public void Millstone_HasCorrectGreyEnum(){
        Millstone millstone = new Millstone(Pair.create(3,3));
        assertEquals(GreyEnum.Millstone, millstone.greyBuildingType);
    }

    @Test
    public void getScoreMillstone_noAdjacent(){
        Millstone millstone = (Millstone) boardOneMillstoneNoOthers.getSquares()[1][1];
        int score = millstone.getScoreMillstone(boardOneMillstoneNoOthers);
        assertEquals(0, score);
    }

    @Test
    public void getScoreMillstone_oneAdjacentTheater(){
        Millstone millstone = (Millstone) boardOneMillstoneOneAdjacentTheater.getSquares()[1][1];
        int score = millstone.getScoreMillstone(boardOneMillstoneOneAdjacentTheater);
        assertEquals(2, score);
    }

    @Test
    public void getScoreMillstone_oneAdjacentFarm(){
        Millstone millstone = (Millstone) boardOneMillstoneOneAdjacentFarm.getSquares()[1][1];
        int score = millstone.getScoreMillstone(boardOneMillstoneOneAdjacentFarm);
        assertEquals(2, score);
    }

    @Test
    public void getScoreMillstone_oneAdjacentFarmAndTheater(){
        Millstone millstone = (Millstone) boardOneMillstoneOneAdjacentTheaterAndFarm.getSquares()[1][1];
        int score = millstone.getScoreMillstone(boardOneMillstoneOneAdjacentTheaterAndFarm);
        assertEquals(2, score);
    }

    @Test
    public void getScore_noBuildings(){
        Millstone millstone = new Millstone(Pair.create(0,0));
        int score = millstone.getScore(boardNoBuildings);
        assertEquals(0, score);
    }

    @Test
    public void getScore_OneMillstoneNotScoring(){
        Millstone millstone = new Millstone(Pair.create(0,0));
        int score = millstone.getScore(boardOneMillstoneNoOthers);
        assertEquals(0, score);
    }

    @Test
    public void getScore_OneMillstoneScoring(){
        Millstone millstone = new Millstone(Pair.create(0,0));
        int score = millstone.getScore(boardOneMillstoneOneAdjacentFarm);
        assertEquals(2, score);
    }

    @Test
    public void getScore_ThreeMillstonesAllScoring(){
        Millstone millstone = new Millstone(Pair.create(0,0));
        int score = millstone.getScore(boardThreeMillstonesAllScoring);
        assertEquals(6, score);
    }

    @Test
    public void getScore_SevenMillstonesFourScoring(){
        Millstone millstone = new Millstone(Pair.create(0,0));
        int score = millstone.getScore(boardSevenMillstonesFourScoring);
        assertEquals(8, score);
    }

}
