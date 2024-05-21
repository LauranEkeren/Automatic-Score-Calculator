package com.example.tinycalculator.Domain.GreyBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import java.util.List;

public class Shed extends GreyBuilding{
    public Shed(Pair<Integer, Integer> position) {
        super(position, GreyEnum.Shed);
    }

    @Override
    public int getScore(Board board) {
        return (int) board.getSquaresAsList().stream()
                .filter(sq -> sq.squareType == SquareEnum.GreyBuilding)
                .count();
    }
}
