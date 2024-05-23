package com.example.tinycalculator.Domain.PurpleBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class TheStarloom extends PurpleBuilding{
    public TheStarloom(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.TheStarloom);
    }

    @Override
    public int getScore(Board board) {
        switch (board.amountStarloom){
            case 1: return 6;
            case 2: return 3;
            case 3: return 2;
            default: return 0;
        }
    }
}
