package com.example.tinycalculator.Domain.YellowBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Enums.YellowEnum;

import java.util.List;

public class Tailor extends YellowBuilding{
    public Tailor(Pair<Integer, Integer> position) {
        super(position, YellowEnum.Tailor);
    }

    @Override
    public int getScore(Board board) {
        int numberTailorsInCenter = (int) board.getCenterSquares().stream().
                filter(sq -> sq.squareType == SquareEnum.YellowBuilding)
                .count();

        int numberTailors = (int) board.getSquaresAsList().stream().
                filter(sq -> sq.squareType == SquareEnum.YellowBuilding)
                .count();

        return numberTailors * (1 + numberTailorsInCenter);
    }
}
