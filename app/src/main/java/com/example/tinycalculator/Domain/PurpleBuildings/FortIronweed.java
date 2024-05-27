package com.example.tinycalculator.Domain.PurpleBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class FortIronweed extends PurpleBuilding{
    public FortIronweed(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.FortIronweed);
    }

    @Override
    public int getScore(Board board) {
        return 7;
    }
}
