package com.example.tinycalculator.Domain;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
                "Cottage, Factory, Factory, Tavern," +
                "Cottage, Farm, Empty, Tavern," +
                "Chapel, Theater, Well, Well," +
                "Chapel, Empty, Tavern, Tavern";
        Board board = new Board(boardString,
                PurpleEnum.NoPurpleBuilding,
                RedEnum.Farm,
                OrangeEnum.Abbey,
                YellowEnum.Bakery,
                GreyEnum.Fountain,
                GreenEnum.Almshouse,
                BlackEnum.Bank, 0, 0,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(6, (int) score.get("Cottage"));
        assertEquals(3, (int) score.get("Chapel"));
        assertEquals(15, (int) score.get("Tavern"));
        assertEquals(3, (int) score.get("Theater"));
        assertEquals(4, (int) score.get("Well"));
        assertEquals(8, (int) score.get("Factory"));
        assertFalse(score.containsKey("Monument"));
        assertEquals(-2, (int) score.get("EmptyPenalty"));
        assertEquals(37, ((int) score.get("TotalScore")));
    }

    @Test
    public void calculateScore_ShouldReturnCorrectScoreForScene6064(){
        String boardString =
                "Chapel, Factory, Theater, Tavern," +
                "Tavern, Monument, Empty, Well," +
                "Theater, Theater, Well, Farm," +
                "Well, Tavern, Cottage, Cottage";
        Board board = new Board(boardString,
                PurpleEnum.ArchitectGuild,
                RedEnum.Farm,
                OrangeEnum.Chapel,
                YellowEnum.Tailor,
                GreyEnum.Millstone,
                GreenEnum.FeastHall,
                BlackEnum.Warehouse,
                3, 0,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(6, (int) score.get("Cottage"));
        assertEquals(2, (int) score.get("Chapel"));
        assertEquals(9, (int) score.get("Tavern"));
        assertEquals(6, (int) score.get("Theater"));
        assertEquals(6, (int) score.get("Well"));
        assertEquals(-3, (int) score.get("Factory"));
        assertTrue(score.containsKey("Monument"));
        assertEquals(1, (int) score.get("Monument"));
        assertEquals(-1, (int) score.get("EmptyPenalty"));

        assertEquals(26, ((int) score.get("TotalScore")));
    }

    @Test
    public void calculateScore_ShouldReturnCorrectScoreForScene7608(){
        String boardString =
                "Chapel, Empty, Well, Factory," +
                "Farm, Theater, Theater, Theater," +
                "Cottage, Empty, Empty, Chapel," +
                "Chapel, Tavern, Tavern, Monument";
        Board board = new Board(boardString,
                PurpleEnum.ArchitectGuild,
                RedEnum.Farm,
                OrangeEnum.Cloister,
                YellowEnum.Tailor,
                GreyEnum.Shed,
                GreenEnum.FeastHall,
                BlackEnum.Bank,
                0, 5,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(3, (int) score.get("Cottage"));
        assertEquals(6, (int) score.get("Chapel"));
        assertEquals(4, (int) score.get("Tavern"));
        assertEquals(9, (int) score.get("Theater"));
        assertEquals(1, (int) score.get("Well"));
        assertEquals(4, (int) score.get("Factory"));
        assertTrue(score.containsKey("Monument"));
        assertEquals(1, (int) score.get("Monument"));
        assertEquals(-3, (int) score.get("EmptyPenalty"));

        assertEquals(25, ((int) score.get("TotalScore")));
    }

    @Test
    public void calculateScore_ShouldReturnCorrectScoreForScene9209(){
        String boardString =
                "Chapel, Well, Cottage, Chapel," +
                "Well, Farm, Tavern, Factory," +
                "Cottage, Theater, Empty, Tavern," +
                "Chapel, Monument, Empty, Chapel";
        Board board = new Board(boardString,
                PurpleEnum.ArchiveOfTheSecondAge,
                RedEnum.Granary,
                OrangeEnum.Cloister,
                YellowEnum.Tailor,
                GreyEnum.Well,
                GreenEnum.Inn,
                BlackEnum.Warehouse,
                2, 0,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(6, (int) score.get("Cottage"));
        assertEquals(16, (int) score.get("Chapel"));
        assertEquals(6, (int) score.get("Tavern"));
        assertEquals(2, (int) score.get("Theater"));
        assertEquals(2, (int) score.get("Well"));
        assertEquals(-2, (int) score.get("Factory"));
        assertTrue(score.containsKey("Monument"));
        assertEquals(7, (int) score.get("Monument"));
        assertEquals(-2, (int) score.get("EmptyPenalty"));

        assertEquals(35, ((int) score.get("TotalScore")));
    }

    @Test
    public void calculateScore_ShouldReturnCorrectScoreForScene10349(){
        String boardString =
                "Cottage, Factory, Empty, Monument," +
                "Chapel, Farm, Empty, Empty," +
                "Cottage, Cottage, Empty, Tavern," +
                "Theater, Theater, Theater, Well";
        Board board = new Board(boardString,
                PurpleEnum.ArchiveOfTheSecondAge,
                RedEnum.Granary,
                OrangeEnum.Temple,
                YellowEnum.Market,
                GreyEnum.Millstone,
                GreenEnum.Almshouse,
                BlackEnum.Factory,
                0, 0,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(9, (int) score.get("Cottage"));
        assertEquals(4, (int) score.get("Chapel"));
        assertEquals(-1, (int) score.get("Tavern"));
        assertEquals(9, (int) score.get("Theater"));
        assertEquals(2, (int) score.get("Well"));
        assertEquals(0, (int) score.get("Factory"));
        assertTrue(score.containsKey("Monument"));
        assertEquals(7, (int) score.get("Monument"));
        assertEquals(-4, (int) score.get("EmptyPenalty"));

        assertEquals(26, ((int) score.get("TotalScore")));
    }

    @Test
    public void calculateScore_ShouldReturnCorrectScoreForScene14733(){
        String boardString =
                "Tavern, Tavern, Theater, Chapel," +
                "Factory, Empty, Cottage, Monument," +
                "Factory, Empty, Chapel, Farm," +
                "Tavern, Well, Cottage, Well";
        Board board = new Board(boardString,
                PurpleEnum.BarettCastle,
                RedEnum.Granary,
                OrangeEnum.Temple,
                YellowEnum.Theater,
                GreyEnum.Millstone,
                GreenEnum.Almshouse,
                BlackEnum.Bank,
                0, 0,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(6, (int) score.get("Cottage"));
        assertEquals(8, (int) score.get("Chapel"));
        assertEquals(-3, (int) score.get("Tavern"));
        assertEquals(3, (int) score.get("Theater"));
        assertEquals(2, (int) score.get("Well"));
        assertEquals(8, (int) score.get("Factory"));
        assertTrue(score.containsKey("Monument"));
        assertEquals(5, (int) score.get("Monument"));
        assertEquals(-2, (int) score.get("EmptyPenalty"));

        assertEquals(27, ((int) score.get("TotalScore")));
    }

    @Test
    public void calculateScore_ShouldReturnCorrectScoreForScene16369(){
        String boardString =
                "Chapel, Empty, Chapel, Well," +
                "Tavern, Theater, Theater, Well," +
                "Cottage, Cottage, Tavern, Factory," +
                "Farm, Monument, Empty, Empty";
        Board board = new Board(boardString,
                PurpleEnum.BarettCastle,
                RedEnum.Granary,
                OrangeEnum.Chapel,
                YellowEnum.Tailor,
                GreyEnum.Shed,
                GreenEnum.Inn,
                BlackEnum.Warehouse,
                1, 0,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(6, (int) score.get("Cottage"));
        assertEquals(8, (int) score.get("Chapel"));
        assertEquals(6, (int) score.get("Tavern"));
        assertEquals(6, (int) score.get("Theater"));
        assertEquals(2, (int) score.get("Well"));
        assertEquals(-1, (int) score.get("Factory"));
        assertTrue(score.containsKey("Monument"));
        assertEquals(5, (int) score.get("Monument"));
        assertEquals(-3, (int) score.get("EmptyPenalty"));

        assertEquals(29, ((int) score.get("TotalScore")));
    }

    @Test
    public void calculateScore_ShouldReturnCorrectScoreForScene16806(){
        String boardString =
                "Farm, Monument, Empty, Theater," +
                "Cottage, Cottage, Well, Theater," +
                "Cottage, Well, Theater, Theater," +
                "Chapel, Empty, Factory, Tavern";
        Board board = new Board(boardString,
                PurpleEnum.CathedralOfCaterina,
                RedEnum.Greenhouse,
                OrangeEnum.Abbey,
                YellowEnum.Market,
                GreyEnum.Well,
                GreenEnum.Almshouse,
                BlackEnum.Bank,
                0, 0,
                0, 0);

        HashMap<String, Integer> score = board.calculateScore();
        assertEquals(9, (int) score.get("Cottage"));
        assertEquals(3, (int) score.get("Chapel"));
        assertEquals(-1, (int) score.get("Tavern"));
        assertEquals(11, (int) score.get("Theater"));
        assertEquals(3, (int) score.get("Well"));
        assertEquals(4, (int) score.get("Factory"));
        assertTrue(score.containsKey("Monument"));
        assertEquals(2, (int) score.get("Monument"));
        assertEquals(0, (int) score.get("EmptyPenalty"));

        assertEquals(31, ((int) score.get("TotalScore")));
    }

    

}
