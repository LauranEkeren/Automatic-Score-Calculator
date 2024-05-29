package com.example.tinycalculator.Domain;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.BlackBuildings.Factory;
import com.example.tinycalculator.Domain.GreenBuildings.Tavern;
import com.example.tinycalculator.Domain.GreyBuildings.Well;
import com.example.tinycalculator.Domain.OrangeBuildings.Chapel;
import com.example.tinycalculator.Domain.PurpleBuildings.PurpleBuilding;
import com.example.tinycalculator.Domain.RedBuildings.Farm;
import com.example.tinycalculator.Domain.YellowBuildings.Theater;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.GreenEnum;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.RedEnum;
import com.example.tinycalculator.Enums.YellowEnum;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class BoardTest {
    String boardOneString =
            "Cottage, Factory, Farm, Chapel," +
            "Tavern, Theater, Well, Empty," +
            "Well, Theater, Tavern, Chapel," +
            "Farm, Factory, Cottage, Empty";

    String boardTwoString =
            "Cottage, Cottage, Cottage, Chapel," +
            "Cottage, Cottage, Empty, Chapel," +
            "Cottage, Empty, Empty, Chapel," +
            "Cottage, Cottage, Cottage, Empty";

    @Test
    public void Board_ShouldHaveCorrectCards(){
        Board board = new Board(boardOneString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 0, 0,
                0, 0);
        assertEquals(GreenEnum.Tavern, board.greenBuildingCard);
        assertEquals(RedEnum.Farm, board.redBuildingCard);
        assertEquals(PurpleEnum.NoPurpleBuilding, board.monumentCard);
        assertEquals(YellowEnum.Theater, board.yellowBuildingCard);
        assertEquals(GreyEnum.Well, board.greyBuildingCard);
        assertEquals(BlackEnum.Factory, board.blackBuildingCard);
        assertEquals(OrangeEnum.Chapel, board.orangeBuildingCard);
    }

    @Test
    public void Board_ShouldHaveCorrectAmounts(){
        Board board = new Board(boardOneString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 1, 2,
                3, 4);
        assertEquals(1, board.getWarehouseNumber());
        assertEquals(2, board.getAmountFeastHallNeighbour());
        assertEquals(3, board.getAmountStarloom());
        assertEquals(4, board.getAmountTree());
    }

    @Test
    public void Board_ShouldHaveCorrectSquares(){
        Board board = new Board(boardOneString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 1, 2,
                3, 4);
        Square square = board.getSquares()[0][0];
        assertThat(square, instanceOf(Cottage.class));
        assertEquals(Pair.create(0,0), square.position);

        square = board.getSquares()[0][1];
        assertThat(square, instanceOf(Factory.class));
        assertEquals(Pair.create(0,1), square.position);

        square = board.getSquares()[0][2];
        assertThat(square, instanceOf(Farm.class));
        assertEquals(Pair.create(0,2), square.position);

        square = board.getSquares()[0][3];
        assertThat(square, instanceOf(Chapel.class));
        assertEquals(Pair.create(0,3), square.position);

        square = board.getSquares()[1][0];
        assertThat(square, instanceOf(Tavern.class));
        assertEquals(Pair.create(1,0), square.position);

        square = board.getSquares()[1][1];
        assertThat(square, instanceOf(Theater.class));
        assertEquals(Pair.create(1,1), square.position);

        square = board.getSquares()[1][2];
        assertThat(square, instanceOf(Well.class));
        assertEquals(Pair.create(1,2), square.position);

        square = board.getSquares()[1][3];
        assertThat(square, instanceOf(EmptySquare.class));
        assertEquals(Pair.create(1,3), square.position);

        square = board.getSquares()[2][0];
        assertThat(square, instanceOf(Well.class));
        assertEquals(Pair.create(2,0), square.position);

        square = board.getSquares()[2][1];
        assertThat(square, instanceOf(Theater.class));
        assertEquals(Pair.create(2,1), square.position);

        square = board.getSquares()[2][2];
        assertThat(square, instanceOf(Tavern.class));
        assertEquals(Pair.create(2,2), square.position);

        square = board.getSquares()[2][3];
        assertThat(square, instanceOf(Chapel.class));
        assertEquals(Pair.create(2,3), square.position);

        square = board.getSquares()[3][0];
        assertThat(square, instanceOf(Farm.class));
        assertEquals(Pair.create(3,0), square.position);

        square = board.getSquares()[3][1];
        assertThat(square, instanceOf(Factory.class));
        assertEquals(Pair.create(3,1), square.position);

        square = board.getSquares()[3][2];
        assertThat(square, instanceOf(Cottage.class));
        assertEquals(Pair.create(3,2), square.position);

        square = board.getSquares()[3][3];
        assertThat(square, instanceOf(EmptySquare.class));
        assertEquals(Pair.create(3,3), square.position);
    }

    @Test
    public void Board_ShouldHaveCorrectSquareList(){
        Board board = new Board(boardOneString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 1, 2,
                3, 4);

        List<Square> squareList = board.getSquaresAsList();
        assertThat(squareList, hasItem(board.getSquares()[0][0]));
        assertThat(squareList, hasItem(board.getSquares()[0][1]));
        assertThat(squareList, hasItem(board.getSquares()[0][2]));
        assertThat(squareList, hasItem(board.getSquares()[0][3]));

        assertThat(squareList, hasItem(board.getSquares()[1][0]));
        assertThat(squareList, hasItem(board.getSquares()[1][1]));
        assertThat(squareList, hasItem(board.getSquares()[1][2]));
        assertThat(squareList, hasItem(board.getSquares()[1][3]));

        assertThat(squareList, hasItem(board.getSquares()[2][0]));
        assertThat(squareList, hasItem(board.getSquares()[2][1]));
        assertThat(squareList, hasItem(board.getSquares()[2][2]));
        assertThat(squareList, hasItem(board.getSquares()[2][3]));

        assertThat(squareList, hasItem(board.getSquares()[3][0]));
        assertThat(squareList, hasItem(board.getSquares()[3][1]));
        assertThat(squareList, hasItem(board.getSquares()[3][2]));
        assertThat(squareList, hasItem(board.getSquares()[3][3]));
    }

    @Test
    public void getSizeOfLargesContiguousGroupOfSameBuildingType_ShouldReturnCorrectSize(){
        Board board = new Board(boardTwoString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 1, 2,
                3, 4);
        int size = board.getSizeOfLargesContiguousGroupOfSameBuildingType();
        assertEquals(9, size);
    }

    @Test
    public void getListOfContiguousGroupOfSameBuildingTypeFromSquare_ShouldReturnCorrectList(){
        Board board = new Board(boardTwoString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 1, 2,
                3, 4);
        Set<Square> squareSet = board.getListOfContiguousGroupOfSameBuildingTypeFromSquare(board.getSquares()[0][0]);
        assertEquals(9, squareSet.size());

        assertThat(squareSet, hasItem(board.getSquares()[0][1]));
        assertThat(squareSet, hasItem(board.getSquares()[0][2]));
        assertThat(squareSet, hasItem(board.getSquares()[1][0]));
        assertThat(squareSet, hasItem(board.getSquares()[1][1]));
        assertThat(squareSet, hasItem(board.getSquares()[2][0]));
        assertThat(squareSet, hasItem(board.getSquares()[3][0]));
        assertThat(squareSet, hasItem(board.getSquares()[3][1]));
        assertThat(squareSet, hasItem(board.getSquares()[3][2]));
    }

    @Test
    public void getCenterSquares_ShouldReturnCenterSquares(){
        Board board = new Board(boardOneString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 1, 2,
                3, 4);

        List<Square> centerSquares = board.getCenterSquares();
        assertEquals(4, centerSquares.size());
        assertThat(centerSquares, hasItem(board.getSquares()[1][1]));
        assertThat(centerSquares, hasItem(board.getSquares()[1][2]));
        assertThat(centerSquares, hasItem(board.getSquares()[2][1]));
        assertThat(centerSquares, hasItem(board.getSquares()[2][2]));
    }

    @Test
    public void getCornerSquares_ShouldReturnCornerSquares(){
        Board board = new Board(boardOneString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 1, 2,
                3, 4);

        List<Square> cornerSquares = board.getCornerSquares();
        assertEquals(4, cornerSquares.size());
        assertThat(cornerSquares, hasItem(board.getSquares()[0][0]));
        assertThat(cornerSquares, hasItem(board.getSquares()[0][3]));
        assertThat(cornerSquares, hasItem(board.getSquares()[3][0]));
        assertThat(cornerSquares, hasItem(board.getSquares()[3][3]));
    }

    @Test
    public void calculateScore_ShouldReturnCorrectScoreForScene1(){
        String boardString =
                "Cottage, Well, Cottage, Factory," +
                "Well, Cottage, Empty, Empty," +
                "Theater, Farm, Tavern, Tavern," +
                "Chapel, Cottage, Well, Factory";
        Board board = new Board(boardString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 0, 0,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(12, (int) score.get("Cottage"));
        assertEquals(4, (int) score.get("Chapel"));
        assertEquals(5, (int) score.get("Tavern"));
        assertEquals(5, (int) score.get("Theater"));
        assertEquals(6, (int) score.get("Well"));
        assertEquals(0, (int) score.get("Factory"));
        assertFalse(score.containsKey("Monument"));
        assertEquals(-2, (int) score.get("EmptyPenalty"));
        assertEquals(30, ((int) score.get("TotalScore")));
    }

    @Test
    public void calculateScore_ShouldReturnCorrectScoreForScene1364(){
        String boardString =
                "Cottage, Well, Cottage, Factory," +
                        "Well, Cottage, Empty, Empty," +
                        "Theater, Farm, Tavern, Tavern," +
                        "Chapel, Cottage, Well, Factory";
        Board board = new Board(boardString,
                PurpleEnum.NoPurpleBuilding, RedEnum.Farm, OrangeEnum.Chapel,
                YellowEnum.Theater, GreyEnum.Well, GreenEnum.Tavern,
                BlackEnum.Factory, 0, 0,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(12, (int) score.get("Cottage"));
        assertEquals(4, (int) score.get("Chapel"));
        assertEquals(5, (int) score.get("Tavern"));
        assertEquals(5, (int) score.get("Theater"));
        assertEquals(6, (int) score.get("Well"));
        assertEquals(0, (int) score.get("Factory"));
        assertFalse(score.containsKey("Monument"));
        assertEquals(-2, (int) score.get("EmptyPenalty"));
        assertEquals(30, ((int) score.get("TotalScore")));
    }


}
