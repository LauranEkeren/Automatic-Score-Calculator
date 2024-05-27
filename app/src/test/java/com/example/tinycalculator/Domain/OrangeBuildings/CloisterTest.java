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

public class CloisterTest {

    Board boardNoBuildings;
    Board boardOneCloisterCorner;
    Board boardOneCloisterMiddle;
    Board boardTwoCloistersCorner;
    Board boardTwoCloistersCornerThreeMiddle;
    Board boardFourCloistersCorner;
    Board boardFourCloistersCornerFiveMiddle;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.NoPurpleBuilding;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Cloister;
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

        String stringOneCloisterCorner =
                "Chapel, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneCloisterCorner = new Board(stringOneCloisterCorner,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneCloisterMiddle =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneCloisterMiddle = new Board(stringOneCloisterMiddle,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoCloistersCorner =
                "Empty, Empty, Empty, Chapel," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Chapel";
        boardTwoCloistersCorner = new Board(stringTwoCloistersCorner,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoCloistersCornerThreeMiddle =
                "Empty, Empty, Empty, Chapel," +
                "Empty, Chapel, Empty, Chapel," +
                "Empty, Empty, Empty, Chapel," +
                "Empty, Empty, Empty, Chapel";
        boardTwoCloistersCornerThreeMiddle = new Board(stringTwoCloistersCornerThreeMiddle,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringFourCloistersCorner =
                "Chapel, Empty, Empty, Chapel," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Chapel, Empty, Empty, Chapel";
        boardFourCloistersCorner = new Board(stringFourCloistersCorner,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringFourCloistersCornerFivMiddle =
                "Chapel, Empty, Empty, Chapel," +
                "Empty, Chapel, Empty, Chapel," +
                "Empty, Chapel, Empty, Chapel," +
                "Chapel, Chapel, Empty, Chapel";
        boardFourCloistersCornerFiveMiddle = new Board(stringFourCloistersCornerFivMiddle,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }
    
    @Test
    public void Cloister_HasCorrectSquareType(){
        Cloister cloister = new Cloister(Pair.create(1,2));
        assertEquals(SquareEnum.OrangeBuilding, cloister.squareType);
    }

    @Test
    public void Cloister_HasCorrectPosition(){
        Cloister cloister = new Cloister(Pair.create(1,2));
        assertEquals(Pair.create(1,2), cloister.position);
    }

    @Test
    public void Cloister_HasCorrectOrangeEnum(){
        Cloister cloister = new Cloister(Pair.create(3,3));
        assertEquals(OrangeEnum.Cloister, cloister.orangeBuildingType);
    }

    @Test
    public void getScore_NoBuildings(){
        Cloister cloister = new Cloister(Pair.create(0,0));
        int score = cloister.getScore(boardNoBuildings);
        assertEquals(0, score);
    }

    @Test
    public void getScore_OneCloisterCorner(){
        Cloister cloister = new Cloister(Pair.create(0,0));
        int score = cloister.getScore(boardOneCloisterCorner);
        assertEquals(1, score);
    }

    @Test
    public void getScore_OneCloisterCornerMiddle(){
        Cloister cloister = new Cloister(Pair.create(0,0));
        int score = cloister.getScore(boardOneCloisterMiddle);
        assertEquals(0, score);
    }

    @Test
    public void getScore_TwoCloistersCorner(){
        Cloister cloister = new Cloister(Pair.create(0,0));
        int score = cloister.getScore(boardTwoCloistersCorner);
        assertEquals(4, score);
    }

    @Test
    public void getScore_TwoCloistersCornerThreeMiddle(){
        Cloister cloister = new Cloister(Pair.create(0,0));
        int score = cloister.getScore(boardTwoCloistersCornerThreeMiddle);
        assertEquals(10, score);
    }

    @Test
    public void getScore_FourCloistersCorner(){
        Cloister cloister = new Cloister(Pair.create(0,0));
        int score = cloister.getScore(boardFourCloistersCorner);
        assertEquals(16, score);
    }

    @Test
    public void getScore_FourCloistersCornerFiveMiddle(){
        Cloister cloister = new Cloister(Pair.create(0,0));
        int score = cloister.getScore(boardFourCloistersCornerFiveMiddle);
        assertEquals(36, score);
    }

}
