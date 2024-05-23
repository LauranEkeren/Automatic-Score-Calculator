package com.example.tinycalculator.Domain.BlackBuildings;

import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Enums.SquareEnum;

import org.junit.Test;

public class BankTest {
    @Test
    public void BankHasCorrectSquareType(){
        Bank bank = new Bank(Pair.create(0, 0));
        assertEquals(bank.squareType, SquareEnum.BlackBuilding);
    }
}
