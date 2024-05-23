package com.example.tinycalculator.Domain.PurpleBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.SquareEnum;

public class TheSkyBaths extends PurpleBuilding{
    public TheSkyBaths(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.TheSkyBaths);
    }

    @Override
    public int getScore(Board board) {
        int differentBuildings = (int) board.getSquaresAsList().stream()
                .map(sq -> sq.squareType)
                .filter(sq -> sq != SquareEnum.Empty)
                .distinct().count();
        int buildingsMissing = 8 - differentBuildings;
        return 2 * buildingsMissing;
    }
}
