package com.example.tinycalculator.Domain.PurpleBuildings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GrandMausoleumOfTheRodinaTest {
    @Mock
    Board mockBoard;
    Board boardNoGrandMausoleumOfTheRodinaCard;
    Board boardNoGrandMausoleumOfTheRodina;
    Board boardGrandMausoleumOfTheRodina;

    @Before
    public void createBoards() {
        PurpleEnum purpleEnum = PurpleEnum.GrandMausoleumOfTheRodina;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Temple;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringOnlyMonumentBuilding =
                "Empty, Empty, Empty, Empty," +
                "Empty, Monument, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardNoGrandMausoleumOfTheRodinaCard = new Board(stringOnlyMonumentBuilding,
                PurpleEnum.ArchitectGuild, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringNoBuildings =
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardNoGrandMausoleumOfTheRodina = new Board(stringNoBuildings,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        boardGrandMausoleumOfTheRodina = new Board(stringOnlyMonumentBuilding,
                PurpleEnum.GrandMausoleumOfTheRodina, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void GrandMausoleumOfTheRodina_HasCorrectSquareType(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = new GrandMausoleumOfTheRodina(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, grandMausoleumOfTheRodina.squareType);
    }

    @Test
    public void GrandMausoleumOfTheRodina_HasCorrectPosition(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = new GrandMausoleumOfTheRodina(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), grandMausoleumOfTheRodina.position);
    }

    @Test
    public void GrandMausoleumOfTheRodina_HasCorrectPurpleEnum(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = new GrandMausoleumOfTheRodina(Pair.create(0, 0));
        assertEquals(PurpleEnum.GrandMausoleumOfTheRodina, grandMausoleumOfTheRodina.purpleBuildingType);
    }

    @Test
    public void getScore_ShouldReturnZero(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = new GrandMausoleumOfTheRodina(Pair.create(0,0));
        int score = grandMausoleumOfTheRodina.getScore(mockBoard);
        assertEquals(0, score);
    }

    @Test
    public void getGrandMausoleumOfTheRodinaFromBoard_NoGrandMausoleumOfTheRodinaCard(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = GrandMausoleumOfTheRodina.getGrandMausoleumOfTheRodinaFromBoard(boardNoGrandMausoleumOfTheRodinaCard);
        assertNull(grandMausoleumOfTheRodina);
    }

    @Test
    public void getGrandMausoleumOfTheRodinaFromBoard_NoGrandMausoleumOfTheRodina(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = GrandMausoleumOfTheRodina.getGrandMausoleumOfTheRodinaFromBoard(boardNoGrandMausoleumOfTheRodina);
        assertNull(grandMausoleumOfTheRodina);
    }

    @Test
    public void getGrandMausoleumOfTheRodinaFromBoard_GrandMausoleumOfTheRodina(){
        GrandMausoleumOfTheRodina grandMausoleumOfTheRodina = GrandMausoleumOfTheRodina.getGrandMausoleumOfTheRodinaFromBoard(boardGrandMausoleumOfTheRodina);
        assertNotNull(grandMausoleumOfTheRodina);
    }
}
