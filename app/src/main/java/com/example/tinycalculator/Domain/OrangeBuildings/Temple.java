package com.example.tinycalculator.Domain.OrangeBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
import com.example.tinycalculator.Domain.PurpleBuildings.BarettCastle;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import java.util.List;
import java.util.stream.Collectors;

public class Temple extends OrangeBuilding{
    public Temple(Pair<Integer, Integer> position) {
        super(position, OrangeEnum.Temple);
    }

    private int getScoreTemple(Board board){
        List<Square> squaresAdjacent = this.getAdjacentSquares(board);
        if (board.monumentCard == PurpleEnum.BarettCastle){
            boolean isFedBarettCastleAdjacent = squaresAdjacent.stream()
                    .filter(BarettCastle.class::isInstance)
                    .map(BarettCastle.class::cast)
                    .anyMatch(c -> c.isFed);
            if (isFedBarettCastleAdjacent) {
                return 4;
            }
        }
        int amountFedCottagesAdjacent = (int) squaresAdjacent.stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .filter(c -> c.isFed)
                .count();
        if (amountFedCottagesAdjacent < 2){
            return 0;
        } else {
            return 4;
        }
    }
    @Override
    public int getScore(Board board) {
        int score = 0;
        List<Temple> temples = board.getSquaresAsList().stream()
                .filter(Temple.class::isInstance)
                .map(Temple.class::cast)
                .collect(Collectors.toList());

        for (Temple temple : temples) {
            score += temple.getScoreTemple(board);
        }
        return score;
    }
}
