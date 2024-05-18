package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class ForIronweed extends PurpleBuilding{
    public ForIronweed(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.FortIronweed);
    }

    @Override
    public int getScore(Board board) {
        return 7;
    }
}
