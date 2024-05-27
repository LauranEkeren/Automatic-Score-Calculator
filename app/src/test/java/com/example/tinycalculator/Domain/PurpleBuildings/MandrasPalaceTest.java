package com.example.tinycalculator.Domain.PurpleBuildings;

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

public class MandrasPalaceTest {

    Board boardOnlyMonument;
    Board boardMonumentAndCottage;
    Board boardMonumentAndTwoCottage;
    Board boardMonumentCottageTavern;
    Board boardMonumentCottageTavernChapel;
    Board boardMonumentCottageTavernChapelWell;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.MandrasPalace;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Temple;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringOnlyMonument =
                "Empty, Empty, Empty, Empty," +
                "Empty, Monument, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOnlyMonument = new Board(stringOnlyMonument,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringMonumentAndCottage =
                "Empty, Empty, Empty, Empty," +
                "Empty, Monument, Cottage, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardMonumentAndCottage = new Board(stringMonumentAndCottage,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringMonumentAndTwoCottage =
                "Empty, Empty, Empty, Empty," +
                "Cottage, Monument, Cottage, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardMonumentAndTwoCottage = new Board(stringMonumentAndTwoCottage,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringMonumentAndCottageTavern =
                "Empty, Empty, Empty, Empty," +
                "Tavern, Monument, Cottage, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardMonumentCottageTavern = new Board(stringMonumentAndCottageTavern,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringMonumentAndCottageTavernChapel =
                "Empty, Empty, Empty, Empty," +
                "Tavern, Monument, Cottage, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardMonumentCottageTavernChapel = new Board(stringMonumentAndCottageTavernChapel,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringMonumentAndCottageTavernChapelWell =
                "Empty, Well, Empty, Empty," +
                "Tavern, Monument, Cottage, Empty," +
                "Empty, Chapel, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardMonumentCottageTavernChapelWell = new Board(stringMonumentAndCottageTavernChapelWell,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

    }

    @Test
    public void MandrasPalace_HasCorrectSquareType(){
        MandrasPalace mandrasPalace = new MandrasPalace(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, mandrasPalace.squareType);
    }

    @Test
    public void MandrasPalace_HasCorrectPosition(){
        MandrasPalace mandrasPalace = new MandrasPalace(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), mandrasPalace.position);
    }

    @Test
    public void MandrasPalace_HasCorrectPurpleEnum(){
        MandrasPalace mandrasPalace = new MandrasPalace(Pair.create(0, 0));
        assertEquals(PurpleEnum.MandrasPalace, mandrasPalace.purpleBuildingType);
    }

    @Test
    public void getScore_OnlyMonument(){
        MandrasPalace mandrasPalace = new MandrasPalace(Pair.create(1,1));
        int score = mandrasPalace.getScore(boardOnlyMonument);
        assertEquals(0, score);
    }

    @Test
    public void getScore_MonumentCottage(){
        MandrasPalace mandrasPalace = new MandrasPalace(Pair.create(1,1));
        int score = mandrasPalace.getScore(boardMonumentAndCottage);
        assertEquals(2, score);
    }

    @Test
    public void getScore_MonumentTwoCottages(){
        MandrasPalace mandrasPalace = new MandrasPalace(Pair.create(1,1));
        int score = mandrasPalace.getScore(boardMonumentAndTwoCottage);
        assertEquals(2, score);
    }

    @Test
    public void getScore_MonumentCottageTavern(){
        MandrasPalace mandrasPalace = new MandrasPalace(Pair.create(1,1));
        int score = mandrasPalace.getScore(boardMonumentCottageTavern);
        assertEquals(4, score);
    }

    @Test
    public void getScore_MonumentCottageTavernChapel(){
        MandrasPalace mandrasPalace = new MandrasPalace(Pair.create(1,1));
        int score = mandrasPalace.getScore(boardMonumentCottageTavernChapel);
        assertEquals(6, score);
    }

    @Test
    public void getScore_MonumentCottageTavernChapelWell(){
        MandrasPalace mandrasPalace = new MandrasPalace(Pair.create(1,1));
        int score = mandrasPalace.getScore(boardMonumentCottageTavernChapelWell);
        assertEquals(8, score);
    }
}
