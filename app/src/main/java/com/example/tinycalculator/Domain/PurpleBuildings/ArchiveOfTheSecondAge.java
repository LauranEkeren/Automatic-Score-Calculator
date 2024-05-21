package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Domain.Square;

import java.util.List;

public class ArchiveOfTheSecondAge extends PurpleBuilding{
    public ArchiveOfTheSecondAge(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.ArchiveOfTheSecondAge);
    }

    @Override
    public int getScore(Board board) {
        List<Square> squares = board.getSquaresAsList();
        return (int) squares.stream()
                .map(sq -> sq.squareType)
                .filter(sq -> sq != SquareEnum.Empty && sq != SquareEnum.PurpleBuilding)
                .distinct().count();
    }
}
