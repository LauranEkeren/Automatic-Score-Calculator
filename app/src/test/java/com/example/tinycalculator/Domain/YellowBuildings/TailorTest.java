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

public class TailorTest {

    Board boardOneTailorCenter;
    Board boardOneTailorOuter;
    Board boardFourTailorCenterFourTailorOuter;

    @Before
    public void createBoards() {
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Chapel;
        YellowEnum yellowEnum = YellowEnum.Tailor;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringOneTailorCenter =
                "Empty, Empty, Empty, Empty," +
                "Empty, Theater, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneTailorCenter = new Board(stringOneTailorCenter,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneTailorOuter =
                "Empty, Theater, Empty, Empty," +
                "Empty, Empty, Empty, Farm," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneTailorOuter = new Board(stringOneTailorOuter,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringFourTailorCenterFourTailorOuter =
                "Empty, Theater, Empty, Theater," +
                "Empty, Theater, Theater, Farm," +
                "Theater, Theater, Theater, Empty," +
                "Empty, Empty, Empty, Theater";
        boardFourTailorCenterFourTailorOuter = new Board(stringFourTailorCenterFourTailorOuter,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Tailor_HasCorrectSquareType(){
        Tailor tailor = new Tailor(Pair.create(1,2));
        assertEquals(SquareEnum.YellowBuilding, tailor.squareType);
    }

    @Test
    public void Tailor_HasCorrectPosition(){
        Tailor tailor = new Tailor(Pair.create(1,2));
        assertEquals(Pair.create(1,2), tailor.position);
    }

    @Test
    public void Tailor_HasCorrectYellowEnum(){
        Tailor tailor = new Tailor(Pair.create(3,3));
        assertEquals(YellowEnum.Tailor, tailor.yellowBuildingType);
    }

    @Test
    public void getScore_OneTailorCenter(){
        Tailor tailor = new Tailor(Pair.create(2,2));
        int score = tailor.getScore(boardOneTailorCenter);
        assertEquals(2, score);
    }

    @Test
    public void getScore_OneTailorOuter(){
        Tailor tailor = new Tailor(Pair.create(2,2));
        int score = tailor.getScore(boardOneTailorOuter);
        assertEquals(1, score);
    }

    @Test
    public void getScore_FourTailorCenterFourTailorOuter(){
        Tailor tailor = new Tailor(Pair.create(2,2));
        int score = tailor.getScore(boardFourTailorCenterFourTailorOuter);
        assertEquals(40, score);
    }

}
