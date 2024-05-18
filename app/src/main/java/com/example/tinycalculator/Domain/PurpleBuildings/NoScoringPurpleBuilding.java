package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class NoScoringPurpleBuilding extends PurpleBuilding{
    public NoScoringPurpleBuilding(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.NoScoringPurpleBuilding);
    }

    @Override
    public int getScore(Board board) {
        return 0;
    }
}
