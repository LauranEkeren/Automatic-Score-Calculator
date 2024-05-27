package com.example.tinycalculator.Domain.GreyBuildings;

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

public class WellTest {
    Board boardNoBuildings;
    Board boardOneWellNoAdjacent;
    Board boardOneWellOneAdjacent;
    Board boardOneWellTwoAdjacent;
    Board boardOneWellThreeAdjacent;
    Board boardOneWellFourAdjacent;
    Board boardOneWellOneMonument;
    Board boardOneWellOneMonumentOneCottage;
    Board boardOneWellOneMonumentNotBarettCastle;
    Board boardThreeWells;
    Board boardSevenWells;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Abbey;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Well;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringNoBuildings =
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardNoBuildings = new Board(stringNoBuildings,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneWellNoAdjacent =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneWellNoAdjacent = new Board(stringOneWellNoAdjacent,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneWellOneAdjacent =
                "Empty, Cottage, Empty, Empty," +
                "Empty, Well, Empty, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneWellOneAdjacent = new Board(stringOneWellOneAdjacent,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneWellTwoAdjacent =
                "Empty, Cottage, Empty, Empty," +
                "Empty, Well, Cottage, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneWellTwoAdjacent = new Board(stringOneWellTwoAdjacent,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneWellThreeAdjacent =
                "Empty, Cottage, Empty, Empty," +
                "Cottage, Well, Cottage, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneWellThreeAdjacent = new Board(stringOneWellThreeAdjacent,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneWellFourAdjacent =
                "Empty, Cottage, Empty, Empty," +
                "Cottage, Well, Cottage, Empty," +
                "Empty, Cottage, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneWellFourAdjacent = new Board(stringOneWellFourAdjacent,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneWellOneMonument =
                "Empty, Empty, Empty, Empty," +
                "Empty, Well, Monument, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneWellOneMonument = new Board(stringOneWellOneMonument,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneWellOneMonumentOneCottage =
                "Empty, Cottage, Empty, Empty," +
                "Empty, Well, Monument, Empty," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneWellOneMonumentOneCottage = new Board(stringOneWellOneMonumentOneCottage,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        boardOneWellOneMonumentNotBarettCastle = new Board(stringOneWellOneMonument,
                PurpleEnum.ArchitectGuild, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringThreeWells =
                "Well, Cottage, Empty, Empty," +
                "Cottage, Well, Cottage, Empty," +
                "Empty, Cottage, Empty, Empty," +
                "Empty, Empty, Empty, Well";
        boardThreeWells = new Board(stringThreeWells,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringSevenWells =
                "Well, Cottage, Empty, Empty," +
                "Cottage, Well, Cottage, Well," +
                "Well, Cottage, Well, Empty," +
                "Empty, Empty, Well, Well";
        boardSevenWells = new Board(stringSevenWells,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Well_HasCorrectSquareType(){
        Well well = new Well(Pair.create(1,2));
        assertEquals(SquareEnum.GreyBuilding, well.squareType);
    }

    @Test
    public void Well_HasCorrectPosition(){
        Well well = new Well(Pair.create(1,2));
        assertEquals(Pair.create(1,2), well.position);
    }

    @Test
    public void Well_HasCorrectGreyEnum(){
        Well well = new Well(Pair.create(3,3));
        assertEquals(GreyEnum.Well, well.greyBuildingType);
    }

    @Test
    public void getScoreWell_NoAdjacent(){
        Well well = (Well) boardOneWellNoAdjacent.getSquares()[1][1];
        int score = well.getScoreWell(boardOneWellNoAdjacent);
        assertEquals(0, score);
    }

    @Test
    public void getScoreWell_OneAdjacent(){
        Well well = (Well) boardOneWellOneAdjacent.getSquares()[1][1];
        int score = well.getScoreWell(boardOneWellOneAdjacent);
        assertEquals(1, score);
    }

    @Test
    public void getScoreWell_TwoAdjacent(){
        Well well = (Well) boardOneWellTwoAdjacent.getSquares()[1][1];
        int score = well.getScoreWell(boardOneWellTwoAdjacent);
        assertEquals(2, score);
    }

    @Test
    public void getScoreWell_ThreeAdjacent(){
        Well well = (Well) boardOneWellThreeAdjacent.getSquares()[1][1];
        int score = well.getScoreWell(boardOneWellThreeAdjacent);
        assertEquals(3, score);
    }

    @Test
    public void getScoreWell_FourAdjacent(){
        Well well = (Well) boardOneWellFourAdjacent.getSquares()[1][1];
        int score = well.getScoreWell(boardOneWellFourAdjacent);
        assertEquals(4, score);
    }

    @Test
    public void getScoreWell_BarettCastleAdjacent(){
        Well well = (Well) boardOneWellOneMonument.getSquares()[1][1];
        int score = well.getScoreWell(boardOneWellOneMonument);
        assertEquals(2, score);
    }

    @Test
    public void getScoreWell_BarettCastleAndCottageAdjacent(){
        Well well = (Well) boardOneWellOneMonumentOneCottage.getSquares()[1][1];
        int score = well.getScoreWell(boardOneWellOneMonumentOneCottage);
        assertEquals(3, score);
    }
    @Test
    public void getScoreWell_MonumentAdjacentThatIsNotBarettCastle(){
        Well well = (Well) boardOneWellOneMonumentOneCottage.getSquares()[1][1];
        int score = well.getScoreWell(boardOneWellOneMonumentNotBarettCastle);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ThreeWells(){
        Well well = new Well(Pair.create(0,0));
        int score = well.getScore(boardThreeWells);
        assertEquals(6, score);
    }

    @Test
    public void getScore_SevenWells(){
        Well well = new Well(Pair.create(0,0));
        int score = well.getScore(boardSevenWells);
        assertEquals(11, score);
    }


}
