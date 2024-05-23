package com.example.tinycalculator.Domain.BlackBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.BlackEnum;

public class Bank extends BlackBuilding{
    public Bank(Pair<Integer, Integer> position) {
        super(position, BlackEnum.Bank);
    }

    @Override
    public int getScore(Board board) {
        return this.getAmountBlackBuildings(board) * 4;
    }
}
