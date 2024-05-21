package com.example.tinycalculator.Domain.OrangeBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Enums.YellowEnum;

public abstract class OrangeBuilding extends Square {
    OrangeEnum orangeBuildingType;

    public OrangeBuilding(Pair<Integer, Integer> position, OrangeEnum orangeBuildingType) {
        super(position, SquareEnum.OrangeBuilding);
        this.orangeBuildingType = orangeBuildingType;
    }

    public abstract int getScore(Board board);
}
