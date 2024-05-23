package com.example.tinycalculator.Domain.OrangeBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.SquareEnum;

public class Cloister extends OrangeBuilding{
    public Cloister(Pair<Integer, Integer> position) {
        super(position, OrangeEnum.Cloister);
    }

    @Override
    public int getScore(Board board) {
        int amountOrangeBuildingsInCorners = (int) board.getCornerSquares().stream()
                .filter(sq -> sq.squareType == SquareEnum.OrangeBuilding)
                .count();

        int amountOrangeBuildings = (int) board.getSquaresAsList().stream()
                .filter(sq -> sq.squareType == SquareEnum.OrangeBuilding)
                .count();
        return amountOrangeBuildings * amountOrangeBuildingsInCorners;
    }
}
