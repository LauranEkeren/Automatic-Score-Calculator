package com.example.tinycalculator.Domain.PurpleBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.SquareEnum;

import java.util.List;

public class MandrasPalace extends PurpleBuilding{
    public MandrasPalace(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.MandrasPalace);
    }

    @Override
    public int getScore(Board board) {
        List<Square> adjacentSquares = this.getAdjacentSquares(board);
        return (int) (2 * adjacentSquares.stream()
                .filter(sq -> sq.squareType != SquareEnum.Empty)
                .map(sq -> sq.squareType)
                .distinct() .count());
    }
}
