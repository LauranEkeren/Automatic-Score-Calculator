package com.example.tinycalculator.Domain.RedBuildings;

import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
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
import java.util.stream.Collectors;

public class OrchardTest {
    Board boardOneOrchardCottagesInRowAndColumn;
    Board boardOneOrchardCottagesNotInRowAndColumn;
    Board boardTwoOrchardsOverlap;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Orchard;
        OrangeEnum orangeEnum = OrangeEnum.Chapel;
        YellowEnum yellowEnum = YellowEnum.Bakery;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringOneOrchardCottagesInRowAndColumn =
                "Empty, Cottage, Empty, Empty," +
                "Cottage, Farm, Cottage, Cottage," +
                "Empty, Cottage, Empty, Empty," +
                "Empty, Cottage, Empty, Empty";
        boardOneOrchardCottagesInRowAndColumn = new Board(stringOneOrchardCottagesInRowAndColumn,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringOneOrchardCottagesNotInRowAndColumn =
                "Cottage, Empty, Cottage, Cottage," +
                "Empty, Farm, Empty, Empty," +
                "Cottage, Empty, Cottage, Cottage," +
                "Cottage, Empty, Cottage, Cottage";
        boardOneOrchardCottagesNotInRowAndColumn = new Board(stringOneOrchardCottagesNotInRowAndColumn,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringTwoOrchardsOverlap =
                "Farm, Cottage, Cottage, Cottage," +
                "Cottage, Farm, Cottage, Cottage," +
                "Cottage, Cottage, Empty, Empty," +
                "Cottage, Cottage, Empty, Empty";
        boardTwoOrchardsOverlap = new Board(stringTwoOrchardsOverlap,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Orchard_HasCorrectSquareType(){
        Orchard orchard = new Orchard(Pair.create(1,2));
        assertEquals(SquareEnum.RedBuilding, orchard.squareType);
    }

    @Test
    public void Orchard_HasCorrectPosition(){
        Orchard orchard = new Orchard(Pair.create(1,2));
        assertEquals(Pair.create(1,2), orchard.position);
    }

    @Test
    public void Orchard_HasCorrectOrangeEnum(){
        Orchard orchard = new Orchard(Pair.create(3,3));
        assertEquals(RedEnum.Orchard, orchard.redBuildingType);
    }

    @Test
    public void feedCottages_OneOrchardCottagesInRowAndColumn(){
        Orchard orchard = new Orchard(Pair.create(0,0));
        orchard.feedCottages(boardOneOrchardCottagesInRowAndColumn);
        List<Cottage> fedCottages = boardOneOrchardCottagesInRowAndColumn.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertEquals(6, fedCottages.size());
    }

    @Test
    public void feedCottages_OneOrchardCottagesNotInRowAndColumn(){
        Orchard orchard = new Orchard(Pair.create(0,0));
        orchard.feedCottages(boardOneOrchardCottagesNotInRowAndColumn);
        List<Cottage> fedCottages = boardOneOrchardCottagesNotInRowAndColumn.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertEquals(0, fedCottages.size());
    }

    @Test
    public void feedCottages_TwoOrchardsOverlap(){
        Orchard orchard = new Orchard(Pair.create(0,0));
        orchard.feedCottages(boardTwoOrchardsOverlap);
        List<Cottage> fedCottages = boardTwoOrchardsOverlap.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(co -> co.isFed)
                .collect(Collectors.toList());
        assertEquals(10, fedCottages.size());
    }


}
