package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class ShrineOfTheElderTree extends PurpleBuilding{
    public ShrineOfTheElderTree(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.ShrineOfTheElderTree);
    }

    @Override
    public int getScore(Board board) {
        switch (board.amountTree){
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            case 4: return 4;
            case 5: return 5;
            default: return 8;
        }
    }
}
