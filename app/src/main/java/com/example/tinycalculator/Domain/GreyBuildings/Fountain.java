package com.example.tinycalculator.Domain.GreyBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import java.util.List;
import java.util.stream.Collectors;

public class Fountain extends GreyBuilding{
    public Fountain(Pair<Integer, Integer> position) {
        super(position, GreyEnum.Fountain);
    }

    public int getScoreFountain(Board board){
        boolean adjacentToGreyBuilding = this.getAdjacentSquares(board).stream()
                .anyMatch(sq -> sq.squareType == SquareEnum.GreyBuilding);
        if (adjacentToGreyBuilding){
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public int getScore(Board board) {
        int score = 0;
        List<Fountain> fountains = board.getSquaresAsList().stream()
                .filter(Fountain.class::isInstance)
                .map(Fountain.class::cast)
                .collect(Collectors.toList());

        for (Fountain fountain : fountains){
            score += fountain.getScoreFountain(board);
        }
        return score;
    }
}
