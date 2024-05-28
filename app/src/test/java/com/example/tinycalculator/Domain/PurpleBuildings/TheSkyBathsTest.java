package com.example.tinycalculator.Domain.PurpleBuildings;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.BlackBuildings.Factory;
import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
import com.example.tinycalculator.Domain.EmptySquare;
import com.example.tinycalculator.Domain.GreenBuildings.Tavern;
import com.example.tinycalculator.Domain.GreyBuildings.Well;
import com.example.tinycalculator.Domain.OrangeBuildings.Chapel;
import com.example.tinycalculator.Domain.RedBuildings.Farm;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Domain.YellowBuildings.Theater;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TheSkyBathsTest {

    @Mock
    Board mockBoardOnlyMonument;
    @Mock
    Board mockBoardCottage;
    @Mock
    Board mockBoardTavernCottage;
    @Mock
    Board mockBoardTavernTwiceCottageTwice;
    @Mock
    Board mockBoardOffAllBuildingsOne;
    @Test
    public void TheSkyBaths_HasCorrectSquareType(){
        TheSkyBaths theSkyBaths = new TheSkyBaths(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, theSkyBaths.squareType);
    }

    @Before
    public void initMocks(){
        List<Square> onlyMonument = new ArrayList<>();
        onlyMonument.add(new TheSkyBaths(Pair.create(0,0)));
        addEmpty(onlyMonument);
        when(mockBoardOnlyMonument.getSquaresAsList()).thenReturn(onlyMonument);
        
        List<Square> cottage = new ArrayList<>();
        cottage.add(new TheSkyBaths(Pair.create(0,0)));
        cottage.add(new Cottage(Pair.create(0,0)));
        when(mockBoardCottage.getSquaresAsList()).thenReturn(cottage);

        List<Square> tavernCottage = new ArrayList<>();
        tavernCottage.add(new TheSkyBaths(Pair.create(0,0)));
        tavernCottage.add(new Tavern(Pair.create(0,0)));
        tavernCottage.add(new Cottage(Pair.create(0,0)));
        addEmpty(tavernCottage);
        when(mockBoardTavernCottage.getSquaresAsList()).thenReturn(tavernCottage);

        List<Square> tavernTwiceCottageTwice = new ArrayList<>();
        tavernTwiceCottageTwice.add(new TheSkyBaths(Pair.create(0,0)));
        tavernTwiceCottageTwice.add(new Tavern(Pair.create(0,0)));
        tavernTwiceCottageTwice.add(new Cottage(Pair.create(0,0)));
        tavernTwiceCottageTwice.add(new Tavern(Pair.create(0,0)));
        tavernTwiceCottageTwice.add(new Cottage(Pair.create(0,0)));
        addEmpty(tavernTwiceCottageTwice);
        when(mockBoardTavernTwiceCottageTwice.getSquaresAsList()).thenReturn(tavernTwiceCottageTwice);

        List<Square> offAllBuildingsOne = new ArrayList<>();
        offAllBuildingsOne.add(new TheSkyBaths(Pair.create(0,0)));
        offAllBuildingsOne.add(new Tavern(Pair.create(0,0)));
        offAllBuildingsOne.add(new Cottage(Pair.create(0,0)));
        offAllBuildingsOne.add(new Factory(Pair.create(0,0)));
        offAllBuildingsOne.add(new Farm(Pair.create(0,0)));
        offAllBuildingsOne.add(new Theater(Pair.create(0,0)));
        offAllBuildingsOne.add(new Well(Pair.create(0,0)));
        offAllBuildingsOne.add(new Chapel(Pair.create(0,0)));
        addEmpty(offAllBuildingsOne);
        when(mockBoardOffAllBuildingsOne.getSquaresAsList()).thenReturn(offAllBuildingsOne);
    }

    public void addEmpty(List<Square> squareList){
        int amount = 16 - squareList.size();
        for (int i = 0; i < amount; i++){
            squareList.add(new EmptySquare(Pair.create(0, 0)));
        }
    }
    
    @Test
    public void TheSkyBaths_HasCorrectPosition(){
        TheSkyBaths theSkyBaths = new TheSkyBaths(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), theSkyBaths.position);
    }

    @Test
    public void TheSkyBaths_HasCorrectPurpleEnum(){
        TheSkyBaths theSkyBaths = new TheSkyBaths(Pair.create(0, 0));
        assertEquals(PurpleEnum.TheSkyBaths, theSkyBaths.purpleBuildingType);
    }
    
    @Test
    public void getScore_BoardOnlyMonument(){
        TheSkyBaths theSkyBaths = new TheSkyBaths(Pair.create(0,0));
        int score = theSkyBaths.getScore(mockBoardOnlyMonument);
        assertEquals(14, score);
    }

    @Test
    public void getScore_BoardMonumentCottage(){
        TheSkyBaths theSkyBaths = new TheSkyBaths(Pair.create(0,0));
        int score = theSkyBaths.getScore(mockBoardCottage);
        assertEquals(12, score);
    }

    @Test
    public void getScore_BoardMonumentTavernCottage(){
        TheSkyBaths theSkyBaths = new TheSkyBaths(Pair.create(0,0));
        int score = theSkyBaths.getScore(mockBoardTavernCottage);
        assertEquals(10, score);
    }

    @Test
    public void getScore_BoardMonumentTwiceTavernCottage(){
        TheSkyBaths theSkyBaths = new TheSkyBaths(Pair.create(0,0));
        int score = theSkyBaths.getScore(mockBoardTavernTwiceCottageTwice);
        assertEquals(10, score);
    }

    @Test
    public void getScore_BoardOffAllBuildingsOne(){
        TheSkyBaths theSkyBaths = new TheSkyBaths(Pair.create(0,0));
        int score = theSkyBaths.getScore(mockBoardOffAllBuildingsOne);
        assertEquals(0, score);
    }

}
