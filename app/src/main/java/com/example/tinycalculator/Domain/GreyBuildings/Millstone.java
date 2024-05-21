package com.example.tinycalculator.Domain.GreyBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import java.util.List;
import java.util.stream.Collectors;

public class Millstone extends GreyBuilding{
    public Millstone(Pair<Integer, Integer> position) {
        super(position, GreyEnum.Millstone);
    }

    public int getScoreMillstone(Board board){
        boolean adjacentToRedOrYellowBuilding = this.getAdjacentSquares(board).stream()
                .anyMatch(sq -> sq.squareType == SquareEnum.Farm || sq.squareType == SquareEnum.YellowBuilding);
        if (adjacentToRedOrYellowBuilding){
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public int getScore(Board board) {
        int score = 0;
        List<Millstone> millstones = board.getSquaresAsList().stream().
                filter(Millstone.class::isInstance)
                .map(Millstone.class::cast)
                .collect(Collectors.toList());

        for (Millstone millstone : millstones) {
            score += millstone.getScoreMillstone(board);
        }
        return score;
    }
}
