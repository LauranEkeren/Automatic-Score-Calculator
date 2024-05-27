package com.example.tinycalculator.Domain.PurpleBuildings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.EmptySquare;
import com.example.tinycalculator.Domain.Square;
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
public class CathedralOfCaterinaTest {

    @Mock
    Board mockBoardCathedralOfCatherinaOnBoard;
    @Mock
    Board mockBoardCathedralOfCatherinaNotOnBoard;

    @Before
    public void initMocks(){
        List<Square> monument = new ArrayList<>();
        monument.add(new CathedralOfCaterina(Pair.create(0,0)));
        addEmpty(monument);
        when(mockBoardCathedralOfCatherinaOnBoard.getSquaresAsList()).thenReturn(monument);

        List<Square> noMonument = new ArrayList<>();
        addEmpty(noMonument);
        when(mockBoardCathedralOfCatherinaNotOnBoard.getSquaresAsList()).thenReturn(noMonument);
    }

    public void addEmpty(List<Square> squareList){
        int amount = 16 - squareList.size();
        for (int i = 0; i < amount; i++){
            squareList.add(new EmptySquare(Pair.create(0, 0)));
        }
    }

    @Test
    public void CathedralOfCaterina_HasCorrectSquareType(){
        CathedralOfCaterina cathedralOfCaterina = new CathedralOfCaterina(Pair.create(0, 0));
        assertEquals(SquareEnum.PurpleBuilding, cathedralOfCaterina.squareType);
    }

    @Test
    public void CathedralOfCaterina_HasCorrectPosition(){
        CathedralOfCaterina cathedralOfCaterina = new CathedralOfCaterina(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), cathedralOfCaterina.position);
    }

    @Test
    public void CathedralOfCaterina_HasCorrectPurpleEnum(){
        CathedralOfCaterina cathedralOfCaterina = new CathedralOfCaterina(Pair.create(0, 0));
        assertEquals(PurpleEnum.CathedralOfCaterina, cathedralOfCaterina.purpleBuildingType);
    }

    @Test
    public void getCathedralOfCatherinaFromBoard_Monument(){
        CathedralOfCaterina cathedralOfCaterina = CathedralOfCaterina.getCathedralOfCatherinaFromBoard(mockBoardCathedralOfCatherinaOnBoard);
        assertNotNull(cathedralOfCaterina);
    }

    @Test
    public void getCathedralOfCatherinaFromBoard_NoMonument(){
        CathedralOfCaterina cathedralOfCaterina = CathedralOfCaterina.getCathedralOfCatherinaFromBoard(mockBoardCathedralOfCatherinaNotOnBoard);
        assertNull(cathedralOfCaterina);
    }

    @Test
    public void getScore_ShouldReturnTwo(){
        CathedralOfCaterina cathedralOfCaterina = new CathedralOfCaterina(Pair.create(0,0));
        int score = cathedralOfCaterina.getScore(mockBoardCathedralOfCatherinaOnBoard);
        assertEquals(2, score);
    }

}
