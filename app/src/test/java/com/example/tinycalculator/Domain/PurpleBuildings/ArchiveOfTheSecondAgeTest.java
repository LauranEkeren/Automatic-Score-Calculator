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
public class ArchiveOfTheSecondAgeTest {

    @Mock
    Board mockBoardOnlyMonument;
    @Mock
    Board mockBoardTavernCottage;
    @Mock
    Board mockBoardTavernTwiceCottageTwice;
    @Mock
    Board mockBoardOffAllBuildingsOne;

    @Before
    public void initMocks(){
        List<Square> onlyMonument = new ArrayList<>();
        onlyMonument.add(new ArchiveOfTheSecondAge(Pair.create(0,0)));
        addEmpty(onlyMonument);
        when(mockBoardOnlyMonument.getSquaresAsList()).thenReturn(onlyMonument);

        List<Square> tavernCottage = new ArrayList<>();
        tavernCottage.add(new ArchiveOfTheSecondAge(Pair.create(0,0)));
        tavernCottage.add(new Tavern(Pair.create(0,0)));
        tavernCottage.add(new Cottage(Pair.create(0,0)));
        addEmpty(tavernCottage);
        when(mockBoardTavernCottage.getSquaresAsList()).thenReturn(tavernCottage);

        List<Square> tavernTwiceCottageTwice = new ArrayList<>();
        tavernTwiceCottageTwice.add(new ArchiveOfTheSecondAge(Pair.create(0,0)));
        tavernTwiceCottageTwice.add(new Tavern(Pair.create(0,0)));
        tavernTwiceCottageTwice.add(new Cottage(Pair.create(0,0)));
        tavernTwiceCottageTwice.add(new Tavern(Pair.create(0,0)));
        tavernTwiceCottageTwice.add(new Cottage(Pair.create(0,0)));
        addEmpty(tavernTwiceCottageTwice);
        when(mockBoardTavernTwiceCottageTwice.getSquaresAsList()).thenReturn(tavernTwiceCottageTwice);

        List<Square> offAllBuildingsOne = new ArrayList<>();
        offAllBuildingsOne.add(new ArchiveOfTheSecondAge(Pair.create(0,0)));
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
    public void ArchiveOfTheSecondAge_HasCorrectSquareType(){
        ArchiveOfTheSecondAge archiveOfTheSecondAge = new ArchiveOfTheSecondAge(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, archiveOfTheSecondAge.squareType);
    }

    @Test
    public void ArchiveOfTheSecondAge_HasCorrectPosition(){
        ArchiveOfTheSecondAge archiveOfTheSecondAge = new ArchiveOfTheSecondAge(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), archiveOfTheSecondAge.position);
    }

    @Test
    public void ArchiveOfTheSecondAge_HasCorrectPurpleEnum(){
        ArchiveOfTheSecondAge archiveOfTheSecondAge = new ArchiveOfTheSecondAge(Pair.create(0, 0));
        assertEquals(PurpleEnum.ArchiveOfTheSecondAge, archiveOfTheSecondAge.purpleBuildingType);
    }

    @Test
    public void getScore_OnlyMonument(){
        ArchiveOfTheSecondAge archiveOfTheSecondAge = new ArchiveOfTheSecondAge(Pair.create(0,0));
        int score = archiveOfTheSecondAge.getScore(mockBoardOnlyMonument);
        assertEquals(0, score);
    }

    @Test
    public void getScore_tavernCottage(){
        ArchiveOfTheSecondAge archiveOfTheSecondAge = new ArchiveOfTheSecondAge(Pair.create(0,0));
        int score = archiveOfTheSecondAge.getScore(mockBoardTavernCottage);
        assertEquals(2, score);
    }

    @Test
    public void getScore_TavernCottageTwice(){
        ArchiveOfTheSecondAge archiveOfTheSecondAge = new ArchiveOfTheSecondAge(Pair.create(0,0));
        int score = archiveOfTheSecondAge.getScore(mockBoardTavernTwiceCottageTwice);
        assertEquals(2, score);
    }

    @Test
    public void getScore_OffAllBuildingsOne(){
        ArchiveOfTheSecondAge archiveOfTheSecondAge = new ArchiveOfTheSecondAge(Pair.create(0,0));
        int score = archiveOfTheSecondAge.getScore(mockBoardOffAllBuildingsOne);
        assertEquals(7, score);
    }


}
