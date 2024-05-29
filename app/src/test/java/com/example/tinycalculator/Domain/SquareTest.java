package com.example.tinycalculator.Domain;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.GreenEnum;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.RedEnum;
import com.example.tinycalculator.Enums.YellowEnum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class SquareTest {
    Board boardSquares;
    @Before
    public void createBoards() {
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Temple;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;


        String stringSquares =
                "Cottage, Factory, Farm, Chapel," +
                "Tavern, Theater, Well, Empty," +
                "Well, Theater, Tavern, Chapel," +
                "Farm, Factory, Cottage, Monument";
        boardSquares = new Board(stringSquares,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void getRowSquares_ShouldReturnCorrectRowSquares(){
        Square square = boardSquares.getSquares()[0][0];
        List<Square> squareList = square.getRowSquares(boardSquares);
        assertEquals(4, squareList.size());
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][1]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][2]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][3]));
    }

    @Test
    public void getColumnSquares_ShouldReturnCorrectSquares(){
        Square square = boardSquares.getSquares()[0][0];
        List<Square> squareList = square.getColumnSquares(boardSquares);
        assertEquals(4, squareList.size());
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[1][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[2][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[3][0]));
    }

    @Test
    public void getRowAndColumnSquares_ShouldReturnCorrectSquares(){
        Square square = boardSquares.getSquares()[0][0];
        List<Square> squareList = square.getRowAndColumnSquares(boardSquares);
        assertEquals(7, squareList.size());
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[1][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[2][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[3][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][1]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][2]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][3]));
    }

    @Test
    public void getSurroundingSquares_ShouldReturnCorrectSquares(){
        Square square = boardSquares.getSquares()[1][1];
        List<Square> squareList = square.getSurroundingSquares(boardSquares);
        assertEquals(8, squareList.size());
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[1][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[2][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][1]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][2]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[1][2]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[2][1]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[2][2]));
    }

    @Test
    public void getAdjacentSquares_ShouldReturnCorrectSquares(){
        Square square = boardSquares.getSquares()[1][1];
        List<Square> squareList = square.getAdjacentSquares(boardSquares);
        assertEquals(4, squareList.size());
        assertThat(squareList, hasItem(boardSquares.getSquares()[1][0]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[0][1]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[1][2]));
        assertThat(squareList, hasItem(boardSquares.getSquares()[2][1]));
    }
}
