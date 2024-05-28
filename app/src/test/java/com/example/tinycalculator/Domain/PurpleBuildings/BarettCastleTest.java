package com.example.tinycalculator.Domain.PurpleBuildings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

public class BarettCastleTest {

    Board boardNoBarrettCastleCard;
    Board boardNoBarrettCastle;
    Board boardBarrettCastleUnfed;
    Board boardBarrettCastleFed;

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

        String stringOnlyMonumentBuilding =
                "Empty, Empty, Empty, Empty," +
                "Empty, Monument, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";


        boardNoBarrettCastleCard = new Board(stringOnlyMonumentBuilding,
                PurpleEnum.ArchitectGuild, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringNoBuildings =
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardNoBarrettCastle = new Board(stringNoBuildings,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        boardBarrettCastleUnfed = new Board(stringOnlyMonumentBuilding,
                PurpleEnum.BarettCastle, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringBarretCastleFed =
                "Empty, Empty, Empty, Empty," +
                "Empty, Monument, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Farm, Empty, Empty, Empty";
        boardBarrettCastleFed = new Board(stringBarretCastleFed,
                PurpleEnum.BarettCastle, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
        farm.feedCottages(boardBarrettCastleFed);

    }

    @Test
    public void BarettCastle_HasCorrectSquareType(){
        BarettCastle barettCastle = new BarettCastle(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, barettCastle.squareType);
    }

    @Test
    public void BarettCastle_HasCorrectPosition(){
        BarettCastle barettCastle = new BarettCastle(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), barettCastle.position);
    }

    @Test
    public void BarettCastle_HasCorrectPurpleEnum(){
        BarettCastle barettCastle = new BarettCastle(Pair.create(0, 0));
        assertEquals(PurpleEnum.BarettCastle, barettCastle.purpleBuildingType);
    }

    @Test
    public void getBarettCastleFromBoard_NoBarrettCastleCard(){
        BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(boardNoBarrettCastleCard);
        assertNull(barettCastle);
    }

    @Test
    public void getBarettCastleFromBoard_NoBarrettCastle(){
        BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(boardNoBarrettCastle);
        assertNull(barettCastle);
    }

    @Test
    public void getBarettCastleFromBoard_boardBarretCastleUnfed(){
        BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(boardBarrettCastleUnfed);
        assertNotNull(barettCastle);
    }

    @Test
    public void getScore_boardBarrettCastleUnfed(){
        BarettCastle barettCastle = (BarettCastle) boardBarrettCastleUnfed.getSquares()[1][1];
        int score = barettCastle.getScore(boardBarrettCastleUnfed);
        assertFalse(barettCastle.isFed);
        assertEquals(0, score);
    }

    @Test
    public void getScore_boardBarrettCastleFed(){
        BarettCastle barettCastle = (BarettCastle) boardBarrettCastleFed.getSquares()[1][1];
        int score = barettCastle.getScore(boardBarrettCastleFed);
        assertTrue(barettCastle.isFed);
        assertEquals(5, score);
    }


}
