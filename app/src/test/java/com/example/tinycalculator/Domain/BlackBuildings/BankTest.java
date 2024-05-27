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
public class BankTest {
    @Mock
    Board mockBoardNoBanks;
    @Mock
    Board mockBoardOneBank;
    @Mock
    Board mockBoardThreeBanks;
    @Mock
    Board mockBoardSevenBanks;

    @Before
    public void initMocks(){
        List<Square> squaresEmpty = new ArrayList<>();
        addBank(squaresEmpty, 0);
        when(mockBoardNoBanks.getSquaresAsList()).thenReturn(squaresEmpty);

        List<Square> squaresOneBank = new ArrayList<>();
        addBank(squaresOneBank, 1);
        when(mockBoardOneBank.getSquaresAsList()).thenReturn(squaresOneBank);

        List<Square> squaresThreeBank = new ArrayList<>();
        addBank(squaresThreeBank, 3);
        when(mockBoardThreeBanks.getSquaresAsList()).thenReturn(squaresThreeBank);

        List<Square> squaresSevenBank = new ArrayList<>();
        addBank(squaresSevenBank, 7);
        when(mockBoardSevenBanks.getSquaresAsList()).thenReturn(squaresSevenBank);
    }

    public void addBank(List<Square> squareList, int amount){
        for (int i = 0; i < 16; i++){
            if (i < amount){
                squareList.add(new Bank(Pair.create(0, 0)));
            } else {
                squareList.add(new EmptySquare(Pair.create(0, 0)));
            }
        }
    }

    @Test
    public void Bank_HasCorrectSquareType(){
        Bank bank = new Bank(Pair.create(0, 0));
        assertEquals(SquareEnum.BlackBuilding, bank.squareType);
    }

    @Test
    public void Bank_HasCorrectPosition(){
        Bank bank = new Bank(Pair.create(2, 2));
        assertEquals( Pair.create(2, 2), bank.position);
    }

    @Test
    public void Bank_HasCorrectBlackEnum(){
        Bank bank = new Bank(Pair.create(0, 0));
        assertEquals(BlackEnum.Bank, bank.blackBuildingType);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithZeroBuildings(){
        Bank bank = new Bank(Pair.create(0, 0));
        int score = bank.getScore(mockBoardNoBanks);
        assertEquals(0, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithOneBuilding(){
        Bank bank = new Bank(Pair.create(0, 0));
        int score = bank.getScore(mockBoardOneBank);
        assertEquals(4, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithThreeBuildings(){
        Bank bank = new Bank(Pair.create(0,0));
        int score = bank.getScore(mockBoardThreeBanks);
        assertEquals(12, score);
    }

    @Test
    public void getScore_ReturnsCorrectScoreWithSevenBuildings(){
        Bank bank = new Bank(Pair.create(0,0));
        int score = bank.getScore(mockBoardSevenBanks);
        assertEquals( 28, score);
    }
}
