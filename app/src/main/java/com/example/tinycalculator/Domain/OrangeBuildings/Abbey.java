package com.example.tinycalculator.Domain.OrangeBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import java.util.List;
import java.util.stream.Collectors;

public class Abbey extends OrangeBuilding{
    public Abbey(Pair<Integer, Integer> position) {
        super(position, OrangeEnum.Abbey);
    }

    public int getScoreAbbey(Board board){
        boolean isBlackGreenOrYellowBuildingAdjacent = this.getAdjacentSquares(board).stream()
                .anyMatch(
                        sq -> sq.squareType == SquareEnum.Factory
                                || sq.squareType == SquareEnum.Tavern
                                || sq.squareType == SquareEnum.YellowBuilding);
        if (isBlackGreenOrYellowBuildingAdjacent){
            return 0;
        } else {
            return 3;
        }
    }
    @Override
    public int getScore(Board board) {
        int score = 0;
        List<Abbey> abbeys = board.getSquaresAsList().stream()
                .filter(Abbey.class::isInstance)
                .map(Abbey.class::cast)
                .collect(Collectors.toList());

        for (Abbey abbey : abbeys) {
            score += abbey.getScoreAbbey(board);
        }

        return score;
    }
}
