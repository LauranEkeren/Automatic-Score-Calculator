package com.example.tinycalculator.Domain.PurpleBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class GroveUniversity extends PurpleBuilding{
    public GroveUniversity(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.GroveUniversity);
    }

    @Override
    public int getScore(Board board) {
        return 3;
    }
}
