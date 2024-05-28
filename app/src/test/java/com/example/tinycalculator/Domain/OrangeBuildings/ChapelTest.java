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

public class ChapelTest {
    Board boardNoBuildings;
    Board boardOneChapel;
    Board boardOneChapelOneUnfedCottage;
    Board boardOneChapelOneFedCottage;
    Board boardOneChapelTwoFedCottages;
    Board boardOneChapelOneUnfedCastleBarret;
    Board boardOneChapelOneFedCastleBarret;
    Board boardTwoChapelOneFedCastleBarretThreeFedCottages;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Chapel;
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

        String stringOneChapel =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneChapel = new Board(stringOneChapel,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneChapelOneUnfedCottage =
                "Cottage, Empty, Empty, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneChapelOneUnfedCottage = new Board(stringOneChapelOneUnfedCottage,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneChapelOneFedCottage =
                "Cottage, Empty, Empty, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Farm, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneChapelOneFedCottage = new Board(stringOneChapelOneFedCottage,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardOneChapelOneFedCottage);


                String stringOneChapelTwoFedCottages =
                "Cottage, Cottage, Empty, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Farm, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneChapelTwoFedCottages = new Board(stringOneChapelTwoFedCottages,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardOneChapelTwoFedCottages);

        String stringOneChapelOneUnfedCastleBarett =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Monument, Empty, Empty, Empty";
        boardOneChapelOneUnfedCastleBarret = new Board(stringOneChapelOneUnfedCastleBarett,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneChapelOneFedCastleBarett =
                "Empty, Empty, Empty, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Farm, Empty," +
                "Monument, Empty, Empty, Empty";
        boardOneChapelOneFedCastleBarret = new Board(stringOneChapelOneFedCastleBarett,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardOneChapelOneFedCastleBarret);

        String stringTwoChapelOneFedCastleBarettThreeFedCottages =
                "Cottage, Cottage, Cottage, Cottage," +
                "Empty, Chapel, Chapel, Empty," +
                "Empty, Empty, Farm, Empty," +
                "Monument, Empty, Empty, Empty";
        boardTwoChapelOneFedCastleBarretThreeFedCottages = new Board(stringTwoChapelOneFedCastleBarettThreeFedCottages,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardTwoChapelOneFedCastleBarretThreeFedCottages);
    }


    @Test
    public void Chapel_HasCorrectSquareType(){
        Chapel chapel = new Chapel(Pair.create(1,2));
        assertEquals(SquareEnum.OrangeBuilding, chapel.squareType);
    }

    @Test
    public void Chapel_HasCorrectPosition(){
        Chapel chapel = new Chapel(Pair.create(1,2));
        assertEquals(Pair.create(1,2), chapel.position);
    }

    @Test
    public void Chapel_HasCorrectOrangeEnum(){
        Chapel chapel = new Chapel(Pair.create(3,3));
        assertEquals(OrangeEnum.Chapel, chapel.orangeBuildingType);
    }

    @Test
    public void getScore_boardNoBuildings(){
        Chapel chapel = new Chapel(Pair.create(0,0));
        int score = chapel.getScore(boardNoBuildings);
        assertEquals(0, score);
    }

    @Test
    public void getScore_boardOneChapel(){
        Chapel chapel = new Chapel(Pair.create(0,0));
        int score = chapel.getScore(boardOneChapel);
        assertEquals(0, score);
    }

    @Test
    public void getScore_boardOneChapelOneUnfedCottage(){
        Chapel chapel = new Chapel(Pair.create(0,0));
        int score = chapel.getScore(boardOneChapelOneUnfedCottage);
        assertEquals(0, score);
    }

    @Test
    public void getScore_boardOneChapelOneFedCottage(){
        Chapel chapel = new Chapel(Pair.create(0,0));
        int score = chapel.getScore(boardOneChapelOneFedCottage);
        assertEquals(1, score);
    }

    @Test
    public void getScore_boardOneChapelTwoFedCottage(){
        Chapel chapel = new Chapel(Pair.create(0,0));
        int score = chapel.getScore(boardOneChapelTwoFedCottages);
        assertEquals(2, score);
    }

    @Test
    public void getScore_boardOneChapelOneUnfedCastleBarret(){
        Chapel chapel = new Chapel(Pair.create(0,0));
        int score = chapel.getScore(boardOneChapelOneUnfedCastleBarret);
        assertEquals(0, score);
    }

    @Test
    public void getScore_boardOneChapelOneFedCastleBarret(){
        Chapel chapel = new Chapel(Pair.create(0,0));
        int score = chapel.getScore(boardOneChapelOneFedCastleBarret);
        assertEquals(2, score);
    }

    @Test
    public void getScore_boardTwoChapelOneFedCastleBarretThreeFedCottages(){
        Chapel chapel = new Chapel(Pair.create(0,0));
        int score = chapel.getScore(boardTwoChapelOneFedCastleBarretThreeFedCottages);
        assertEquals(10, score);
    }

}
