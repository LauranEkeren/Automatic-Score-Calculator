package com.example.tinycalculator.Domain.GreenBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.GreenEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GreenBuilding extends Square {
    GreenEnum greenBuildingType;

    public GreenBuilding(Pair<Integer, Integer> position, GreenEnum greenBuildingType) {
        super(position, SquareEnum.GreenBuilding);
        this.greenBuildingType = greenBuildingType;
    }

    public int getAmountTaverns(Board board){
        return (int) board.getSquaresAsList().stream()
                .filter(sq -> sq.squareType == SquareEnum.GreenBuilding)
                .count();
    }

    public abstract int getScore(Board board);
}
