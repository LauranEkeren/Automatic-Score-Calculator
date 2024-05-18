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
        return -999;
    }
}
