package com.example.tinycalculator.Domain;

import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

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

import java.util.List;

public class EmptySquareTest {

    Board boardAllEmptySquares;
    Board boardCardCathedralOfCaterinaNoMonument;
    Board boardHasCathedralOfCaterina;
    @Before
    public void createBoards() {
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Temple;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;


        String stringAllEmptySquares =
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardAllEmptySquares = new Board(stringAllEmptySquares,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringCardCathedralOfCaterinaNoMonument =
                "Cottage, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardCardCathedralOfCaterinaNoMonument = new Board(stringCardCathedralOfCaterinaNoMonument,
                PurpleEnum.CathedralOfCaterina, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringHasCathedralOfCaterina =
                "Cottage, Monument, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardHasCathedralOfCaterina = new Board(stringHasCathedralOfCaterina,
                PurpleEnum.CathedralOfCaterina, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void EmptySquare_HasCorrectSquareType(){
        EmptySquare emptySquare = new EmptySquare(Pair.create(0, 0));
        assertEquals(SquareEnum.Empty, emptySquare.squareType);
    }

    @Test
    public void EmptySquare_HasCorrectPosition(){
        EmptySquare emptySquare = new EmptySquare(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), emptySquare.position);
    }

    @Test
    public void getEmptySquares_AllEmptySquares(){
        List<EmptySquare> emptySquares = EmptySquare.getEmptySquares(boardAllEmptySquares);
        assertEquals(16, emptySquares.size());
    }

    @Test
    public void getEmptySquares_CardCathedralOfCaterinaNoMonument(){
        List<EmptySquare> emptySquares = EmptySquare.getEmptySquares(boardCardCathedralOfCaterinaNoMonument);
        assertEquals(15, emptySquares.size());
    }

    @Test
    public void getEmptySquares_HasCathedralOfCaterina(){
        List<EmptySquare> emptySquares = EmptySquare.getEmptySquares(boardHasCathedralOfCaterina);
        assertEquals(14, emptySquares.size());
    }

    @Test
    public void getPenaltyEmptySquares_AllEmptySquares(){
        int score = EmptySquare.getPenaltyEmptySquares(boardAllEmptySquares);
        assertEquals(-16, score);
    }

    @Test
    public void getPenaltyEmptySquares_CardCathedralOfCaterinaNoMonument(){
        int score = EmptySquare.getPenaltyEmptySquares(boardCardCathedralOfCaterinaNoMonument);
        assertEquals(-15, score);
    }

    @Test
    public void getPenaltyEmptySquares_CardCathedralOfCaterinaNoMonumentHasCathedralOfCaterina(){
        int score = EmptySquare.getPenaltyEmptySquares(boardHasCathedralOfCaterina);
        assertEquals(0, score);
    }



}
