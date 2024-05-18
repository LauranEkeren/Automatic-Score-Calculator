package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class ArchitectsGuild extends PurpleBuilding{
    public ArchitectsGuild(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.ArchitectGuild);
    }

    @Override
    public int getScore(Board board) {
        return 1;
    }
}
