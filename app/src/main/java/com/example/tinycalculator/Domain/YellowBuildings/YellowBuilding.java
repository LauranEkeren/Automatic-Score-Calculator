package com.example.tinycalculator.Domain.YellowBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Enums.YellowEnum;

public abstract class YellowBuilding extends Square {
    YellowEnum yellowBuildingType;
    public YellowBuilding(Pair<Integer, Integer> position, YellowEnum yellowBuildingType){
        super(position, SquareEnum.YellowBuilding);
        this.yellowBuildingType = yellowBuildingType;
    }

    public abstract int getScore(Board board);
}
