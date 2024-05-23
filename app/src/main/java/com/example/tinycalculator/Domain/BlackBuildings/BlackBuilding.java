package com.example.tinycalculator.Domain.BlackBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.SquareEnum;

public abstract class BlackBuilding extends Square {
    BlackEnum blackBuildingType;
    public BlackBuilding(Pair<Integer, Integer> position, BlackEnum blackBuildingType) {
        super(position, SquareEnum.BlackBuilding);
        this.blackBuildingType = blackBuildingType;
    }

    public int getAmountBlackBuildings(Board board){
        return (int) board.getSquaresAsList().stream()
                .filter(sq -> sq.squareType == SquareEnum.BlackBuilding)
                .count();
    }

    public abstract int getScore(Board board);
}
