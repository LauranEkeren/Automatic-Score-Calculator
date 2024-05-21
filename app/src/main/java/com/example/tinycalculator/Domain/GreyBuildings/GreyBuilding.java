package com.example.tinycalculator.Domain.GreyBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.SquareEnum;

public abstract class GreyBuilding extends Square {
    GreyEnum greyBuildingType;

    public GreyBuilding(Pair<Integer, Integer> position, GreyEnum greyBuildingType) {
        super(position, SquareEnum.GreyBuilding);
        this.greyBuildingType = greyBuildingType;
    }

    public abstract int getScore(Board board);
}
