package com.example.tinycalculator.Domain.BlackBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.BlackEnum;

public class TradingPost extends BlackBuilding{
    public TradingPost(Pair<Integer, Integer> position) {
        super(position, BlackEnum.TradingPost);
    }

    @Override
    public int getScore(Board board) {
        return this.getAmountBlackBuildings(board);
    }
}
