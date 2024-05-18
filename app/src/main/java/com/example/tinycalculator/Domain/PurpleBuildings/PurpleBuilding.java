package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Domain.Square;

public abstract class PurpleBuilding extends Square {
    PurpleEnum purpleBuildingType;
    public PurpleBuilding(Pair<Integer, Integer> position, PurpleEnum purpleBuildingType) {
        super(position, SquareEnum.Monument);
        this.purpleBuildingType = purpleBuildingType;
    }
    public abstract int getScore(Board board);
}
