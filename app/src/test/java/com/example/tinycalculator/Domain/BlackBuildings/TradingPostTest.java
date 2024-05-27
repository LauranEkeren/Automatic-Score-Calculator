package com.example.tinycalculator.Domain.BlackBuildings;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.EmptySquare;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TradingPostTest {
    @Mock
    Board mockBoardNoTradingPosts;
    @Mock
    Board mockBoardOneTradingPost;
    @Mock
    Board mockBoardThreeTradingPosts;
    @Mock
    Board mockBoardSevenTradingPosts;

    @Before
    public void initMocks(){
        List<Square> squaresEmpty = new ArrayList<>();
        addTradingPost(squaresEmpty, 0);
        when(mockBoardNoTradingPosts.getSquaresAsList()).thenReturn(squaresEmpty);

        List<Square> squaresOneTradingPost = new ArrayList<>();
        addTradingPost(squaresOneTradingPost, 1);
        when(mockBoardOneTradingPost.getSquaresAsList()).thenReturn(squaresOneTradingPost);

        List<Square> squaresThreeTradingPost = new ArrayList<>();
        addTradingPost(squaresThreeTradingPost, 3);
        when(mockBoardThreeTradingPosts.getSquaresAsList()).thenReturn(squaresThreeTradingPost);

        List<Square> squaresSevenTradingPost = new ArrayList<>();
        addTradingPost(squaresSevenTradingPost, 7);
        when(mockBoardSevenTradingPosts.getSquaresAsList()).thenReturn(squaresSevenTradingPost);
    }

    public void addTradingPost(List<Square> squareList, int amount){
        for (int i = 0; i < 16; i++){
            if (i < amount){
                squareList.add(new TradingPost(Pair.create(0, 0)));
            } else {
                squareList.add(new EmptySquare(Pair.create(0, 0)));

            }
        }
    }
    
    @Test
    public void TradingPost_HasCorrectSquareType(){
        TradingPost tradingPost = new TradingPost(Pair.create(2, 1));
        assertEquals(SquareEnum.BlackBuilding, tradingPost.squareType);
    }
    
    @Test
    public void TradingPost_HasCorrectPosition(){
        TradingPost tradingPost = new TradingPost(Pair.create(2, 3));
        assertEquals(Pair.create(2,3), tradingPost.position);
    }
    
    @Test
    public void TradingPost_HasCorrectBlackEnum(){
        TradingPost tradingPost = new TradingPost(Pair.create(0, 0));
        assertEquals(BlackEnum.TradingPost, tradingPost.blackBuildingType);
    }
    
    @Test
    public void getScore_ReturnsCorrectScoreWithZeroBuildings(){
        TradingPost tradingPost = new TradingPost(Pair.create(0,0));
        int score = tradingPost.getScore(mockBoardNoTradingPosts);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithOneBuilding(){
        TradingPost tradingPost = new TradingPost(Pair.create(0, 0));
        int score = tradingPost.getScore(mockBoardOneTradingPost);
        assertEquals(1, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithThreeBuildings(){
        TradingPost tradingPost = new TradingPost(Pair.create(0, 0));
        int score = tradingPost.getScore(mockBoardThreeTradingPosts);
        assertEquals( 3, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSevenBuildings(){
        TradingPost tradingPost = new TradingPost(Pair.create(0, 0));
        int score = tradingPost.getScore(mockBoardSevenTradingPosts);
        assertEquals( 7, score);
    }
}
