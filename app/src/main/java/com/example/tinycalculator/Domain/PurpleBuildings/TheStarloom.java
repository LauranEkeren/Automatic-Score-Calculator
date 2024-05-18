package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class TheStarloom extends PurpleBuilding{
    public TheStarloom(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.TheStarloom);
    }

    @Override
    public int getScore(Board board) {
        return -999;
    }
}
