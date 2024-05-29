package com.example.tinycalculator.Domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

public class CottageTest {

    Board boardFiveCottagesFourFed;
    Board boardSixCottagesFourFedWithGrandMausoleum;
    Board boardSixCottagesFourFedWithGrandMausoleumCardButNotBuilding;
    @Before
    public void createBoards() {
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Temple;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        Farm farm = new Farm(Pair.create(0, 0));

        String stringFiveCottagesFourFed =
                "Farm, Empty, Empty, Empty," +
                "Cottage, Cottage, Cottage, Cottage," +
                "Cottage, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardFiveCottagesFourFed = new Board(stringFiveCottagesFourFed,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardFiveCottagesFourFed);

        String stringSixCottagesFourFedWithGrandMausoleum =
                "Farm, Empty, Monument, Empty," +
                "Cottage, Cottage, Cottage, Cottage," +
                "Cottage, Cottage, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardSixCottagesFourFedWithGrandMausoleum = new Board(stringSixCottagesFourFedWithGrandMausoleum,
                PurpleEnum.GrandMausoleumOfTheRodina, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardSixCottagesFourFedWithGrandMausoleum);

        String stringSixCottagesFourFedWithGrandMausoleumCardButNotBuilding =
                "Farm, Empty, Empty, Empty," +
                "Cottage, Cottage, Cottage, Cottage," +
                "Cottage, Cottage, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardSixCottagesFourFedWithGrandMausoleumCardButNotBuilding = new Board(stringSixCottagesFourFedWithGrandMausoleumCardButNotBuilding,
                PurpleEnum.GrandMausoleumOfTheRodina, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardSixCottagesFourFedWithGrandMausoleumCardButNotBuilding);
    }
    @Test
    public void Cottage_HasCorrectSquareType(){
        Cottage cottage = new Cottage(Pair.create(0, 0));
        assertEquals(SquareEnum.Cottage, cottage.squareType);
    }

    @Test
    public void Cottage_HasCorrectPosition(){
        Cottage cottage = new Cottage(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), cottage.position);
    }

    @Test
    public void Cottage_IsNotFedOnCreation(){
        Cottage cottage = new Cottage(Pair.create(0, 0));
        assertFalse(cottage.isFed);
    }

    @Test
    public void getScoreCottages_FiveCottagesFourFed(){
        int score = Cottage.getScoreCottages(boardFiveCottagesFourFed);
        assertEquals(12, score);
    }

    @Test
    public void getScoreCottages_SixCottagesFourFedWithGrandMausoleum(){
        int score = Cottage.getScoreCottages(boardSixCottagesFourFedWithGrandMausoleum);
        assertEquals(18, score);
    }

    @Test
    public void getScoreCottages_SixCottagesFourFedWithGrandMausoleumCardButNotBuilding(){
        int score = Cottage.getScoreCottages(boardSixCottagesFourFedWithGrandMausoleumCardButNotBuilding);
        assertEquals(12, score);
    }

    @Test
    public void getCottages_FiveCottagesFourFed(){
        List<Cottage> cottages = Cottage.getCottages(boardFiveCottagesFourFed);
        assertEquals(5, cottages.size());
    }

    @Test
    public void getCottages_SixCottagesFourFedWithGrandMausoleum(){
        List<Cottage> cottages = Cottage.getCottages(boardSixCottagesFourFedWithGrandMausoleum);
        assertEquals(6, cottages.size());
    }

    @Test
    public void getCottages_SixCottagesFourFedWithGrandMausoleumButNotBuilding(){
        List<Cottage> cottages = Cottage.getCottages(boardSixCottagesFourFedWithGrandMausoleumCardButNotBuilding);
        assertEquals(6, cottages.size());
    }

    @Test
    public void getAmountFedCottages_FiveCottagesFourFed(){
        int amount = Cottage.getAmountFedCottages(boardFiveCottagesFourFed);
        assertEquals(4, amount);
    }

    @Test
    public void getAmountFedCottages_SixCottagesFourFedWithGrandMausoleum(){
        int amount = Cottage.getAmountFedCottages(boardSixCottagesFourFedWithGrandMausoleum);
        assertEquals(4, amount);
    }

    @Test
    public void getAmountFedCottages_SixCottagesFourFedWithGrandMausoleumCardButNotBuilding(){
        int amount = Cottage.getAmountFedCottages(boardSixCottagesFourFedWithGrandMausoleumCardButNotBuilding);
        assertEquals(4, amount);
    }
}
