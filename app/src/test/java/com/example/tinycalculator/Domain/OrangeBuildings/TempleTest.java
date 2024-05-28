package com.example.tinycalculator.Domain.OrangeBuildings;

import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.RedBuildings.Farm;
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

public class TempleTest {
    
    Board boardNoBuildings;
    Board boardOneTemple;
    Board boardOneTempleNextToTwoUnfedCottages;
    Board boardOneTempleNextToOneFedCottage;
    Board boardOneTempleNextToTwoFedCottages;
    Board boardOneTempleNextToUnfedCastleBarrett;
    Board boardOneTempleNextToFedCastleBarrett;
    Board boardFourTemplesThreeScoring;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Temple;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        Farm farm = new Farm(Pair.create(0,0));

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

        String stringOneTemple =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneTemple = new Board(stringOneTemple,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneTempleNextToTwoUnfedCottages =
                "Empty, Empty, Empty, Empty," +
                "Cottage, Chapel, Cottage, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneTempleNextToTwoUnfedCottages = new Board(stringOneTempleNextToTwoUnfedCottages,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneTempleNextToOneFedCottage =
                "Empty, Empty, Empty, Empty," +
                "Cottage, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Farm, Empty, Empty, Empty";
        boardOneTempleNextToOneFedCottage = new Board(stringOneTempleNextToOneFedCottage,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardOneTempleNextToOneFedCottage);

        String stringOneTempleNextToTwoFedCottages =
                "Empty, Empty, Empty, Empty," +
                "Cottage, Chapel, Cottage, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Farm, Empty, Empty, Empty";
        boardOneTempleNextToTwoFedCottages = new Board(stringOneTempleNextToTwoFedCottages,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardOneTempleNextToTwoFedCottages);

        String stringOneTempleNextToUnfedCastleBarrett =
                "Empty, Empty, Empty, Empty," +
                "Monument, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneTempleNextToUnfedCastleBarrett = new Board(stringOneTempleNextToUnfedCastleBarrett,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneTempleNextToFedCastleBarrett =
                "Empty, Empty, Empty, Empty," +
                "Monument, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Farm, Empty, Empty, Empty";
        boardOneTempleNextToFedCastleBarrett = new Board(stringOneTempleNextToFedCastleBarrett,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardOneTempleNextToFedCastleBarrett);

        String stringFourTemplesThreeScoring =
                "Empty, Empty, Empty, Chapel," +
                "Monument, Chapel, Empty, Empty," +
                "Empty, Empty, Chapel, Cottage," +
                "Farm, Cottage, Cottage, Chapel";
        boardFourTemplesThreeScoring = new Board(stringFourTemplesThreeScoring,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardFourTemplesThreeScoring);

    }
    
    @Test
    public void Temple_HasCorrectSquareType(){
        Temple temple = new Temple(Pair.create(1,2));
        assertEquals(SquareEnum.OrangeBuilding, temple.squareType);
    }

    @Test
    public void Temple_HasCorrectPosition(){
        Temple temple = new Temple(Pair.create(1,2));
        assertEquals(Pair.create(1,2), temple.position);
    }

    @Test
    public void Temple_HasCorrectOrangeEnum(){
        Temple temple = new Temple(Pair.create(3,3));
        assertEquals(OrangeEnum.Temple, temple.orangeBuildingType);
    }

    @Test
    public void getScoreTemple_NoBuildings(){
        Temple temple = new Temple(Pair.create(0,0));
        int score = temple.getScore(boardNoBuildings);
        assertEquals(0, score);
    }

    @Test
    public void getScoreTemple_OneTemple(){
        Temple temple = new Temple(Pair.create(0,0));
        int score = temple.getScore(boardOneTemple);
        assertEquals(0, score);
    }

    @Test
    public void getScoreTemple_OneTempleNextToTwoUnfedCottages(){
        Temple temple = new Temple(Pair.create(0,0));
        int score = temple.getScore(boardOneTempleNextToTwoUnfedCottages);
        assertEquals(0, score);
    }

    @Test
    public void getScoreTemple_OneTempleNextToOneFedCottage(){
        Temple temple = new Temple(Pair.create(0,0));
        int score = temple.getScore(boardOneTempleNextToOneFedCottage);
        assertEquals(0, score);
    }

    @Test
    public void getScoreTemple_OneTempleNextToTwoFedCottages(){
        Temple temple = new Temple(Pair.create(0,0));
        int score = temple.getScore(boardOneTempleNextToTwoFedCottages);
        assertEquals(4, score);
    }

    @Test
    public void getScoreTemple_OneTempleNextToUnfedCastleBarrett(){
        Temple temple = new Temple(Pair.create(0,0));
        int score = temple.getScore(boardOneTempleNextToUnfedCastleBarrett);
        assertEquals(0, score);
    }

    @Test
    public void getScoreTemple_OneTempleNextToFedCastleBarrett(){
        Temple temple = new Temple(Pair.create(0,0));
        int score = temple.getScore(boardOneTempleNextToFedCastleBarrett);
        assertEquals(4, score);
    }

    @Test
    public void getScoreTemple_FourTemplesThreeScoring(){
        Temple temple = new Temple(Pair.create(0,0));
        int score = temple.getScore(boardFourTemplesThreeScoring);
        assertEquals(12, score);
    }
    
}
