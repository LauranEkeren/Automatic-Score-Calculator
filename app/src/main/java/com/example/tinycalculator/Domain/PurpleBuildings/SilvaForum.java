package com.example.tinycalculator.Domain.PurpleBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class SilvaForum extends PurpleBuilding{
    public SilvaForum(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.SilvaForum);
    }

    @Override
    public int getScore(Board board) {
        return board.getSizeOfLargesContiguousGroupOfSameBuildingType() + 1;
    }
}
