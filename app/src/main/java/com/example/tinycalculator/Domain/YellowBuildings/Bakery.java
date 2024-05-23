package com.example.tinycalculator.Domain.YellowBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Enums.YellowEnum;

import java.util.List;
import java.util.stream.Collectors;

public class Bakery extends YellowBuilding{

    public Bakery(Pair<Integer, Integer> position) {
        super(position, YellowEnum.Bakery);
    }

    public int getScoreBakery(Board board){
        //Get all adjacent squares
        List<Square> adjacentSquares = this.getAdjacentSquares(board);
        boolean hasBlackOrRedBuilding = adjacentSquares.stream()
                .anyMatch(sq -> sq.squareType == SquareEnum.BlackBuilding || sq.squareType == SquareEnum.RedBuilding);
        if (hasBlackOrRedBuilding){
            return 3;
        } else {
            return 0;
        }
    }

    @Override
    public int getScore(Board board) {
        int score = 0;
        List<Square> squareList = board.getSquaresAsList();
        List<Bakery> bakeries = squareList.stream()
                .filter(Bakery.class::isInstance)
                .map(Bakery.class::cast)
                .collect(Collectors.toList());

        for (Bakery bakery : bakeries){
            score += bakery.getScoreBakery(board);
        }

        return score;
    }
}
