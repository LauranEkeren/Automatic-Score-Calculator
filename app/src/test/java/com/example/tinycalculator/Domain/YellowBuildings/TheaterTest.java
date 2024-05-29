package com.example.tinycalculator.Domain.YellowBuildings;

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

public class TheaterTest {

    Board boardOneTheater;
    Board boardOneTheaterCottageFarm;
    Board boardOneTheaterAllBuildings;
    Board boardThreeTheaters;

    @Before
    public void createBoards() {
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Chapel;
        YellowEnum yellowEnum = YellowEnum.Theater;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringOneTheater =
                "Empty, Empty, Empty, Empty," +
                "Empty, Theater, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneTheater = new Board(stringOneTheater,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneTheaterCottageFarm =
                "Empty, Empty, Empty, Empty," +
                "Cottage, Theater, Empty, Empty," +
                "Empty, Farm, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneTheaterCottageFarm = new Board(stringOneTheaterCottageFarm,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneTheaterAllBuildings =
                "Empty, Factory, Empty, Empty," +
                "Cottage, Theater, Tavern, Well," +
                "Empty, Farm, Empty, Empty," +
                "Empty, Chapel, Empty, Empty";
        boardOneTheaterAllBuildings = new Board(stringOneTheaterAllBuildings,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringThreeTheaters =
                "Empty, Factory, Empty, Theater," +
                "Cottage, Theater, Tavern, Well," +
                "Empty, Farm, Empty, Monument," +
                "Empty, Chapel, Well, Theater";
        boardThreeTheaters = new Board(stringThreeTheaters,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );


    }
    @Test
    public void Theater_HasCorrectSquareType(){
        Theater theater = new Theater(Pair.create(1,2));
        assertEquals(SquareEnum.YellowBuilding, theater.squareType);
    }

    @Test
    public void Theater_HasCorrectPosition(){
        Theater theater = new Theater(Pair.create(1,2));
        assertEquals(Pair.create(1,2), theater.position);
    }

    @Test
    public void Theater_HasCorrectYellowEnum(){
        Theater theater = new Theater(Pair.create(3,3));
        assertEquals(YellowEnum.Theater, theater.yellowBuildingType);
    }

    @Test
    public void getScoreTheater_OneTheater(){
        Theater theater = new Theater(Pair.create(1,1));
        int score = theater.getScoreTheater(boardOneTheater);
        assertEquals(0, score);
    }

    @Test
    public void getScoreTheater_OneTheaterCottageFarm(){
        Theater theater = new Theater(Pair.create(1,1));
        int score = theater.getScoreTheater(boardOneTheaterCottageFarm);
        assertEquals(2, score);
    }

    @Test
    public void getScoreTheater_OneTheaterAllBuildings(){
        Theater theater = new Theater(Pair.create(1,1));
        int score = theater.getScoreTheater(boardOneTheaterAllBuildings);
        assertEquals(6, score);
    }

    @Test
    public void getScore_OneTheater(){
        Theater theater = new Theater(Pair.create(1,1));
        int score = theater.getScore(boardOneTheater);
        assertEquals(0, score);
    }

    @Test
    public void getScore_OneTheaterCottageFarm(){
        Theater theater = new Theater(Pair.create(1,1));
        int score = theater.getScore(boardOneTheaterCottageFarm);
        assertEquals(2, score);
    }

    @Test
    public void getScore_OneTheaterAllBuildings(){
        Theater theater = new Theater(Pair.create(1,1));
        int score = theater.getScore(boardOneTheaterAllBuildings);
        assertEquals(6, score);
    }

    @Test
    public void getScore_ThreeTheaters(){
        Theater theater = new Theater(Pair.create(1,1));
        int score = theater.getScore(boardThreeTheaters);
        assertEquals(12, score);
    }

}
