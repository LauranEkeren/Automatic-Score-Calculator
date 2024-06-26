package com.example.tinycalculator.Domain.GreyBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Domain.PurpleBuildings.BarettCastle;
import com.example.tinycalculator.Enums.PurpleEnum;

import java.util.List;
import java.util.stream.Collectors;

public class Well extends GreyBuilding {
    public Well(Pair<Integer, Integer> position){
        super(position, GreyEnum.Well);
    }

    public int getScoreWell(Board board){
        int totalPoints = 0;
        List<Square> adjacentSquares = getAdjacentSquares(board);
        if (board.monumentCard == PurpleEnum.BarettCastle){
            BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(board);
            if (barettCastle != null){
                boolean isMonumentOnAdjacentSquare = adjacentSquares.stream()
                        .anyMatch(sq -> sq.squareType == SquareEnum.PurpleBuilding);
                if (isMonumentOnAdjacentSquare){
                    totalPoints = 2;
                }
            }
        }
        totalPoints = totalPoints + (int) adjacentSquares.stream().
                filter(Cottage.class::isInstance).count();

        return totalPoints;
    }

    public int getScore(Board board) {
        int score = 0;
        List<Square> squareList = board.getSquaresAsList();
        List<Well> wells = squareList.stream()
                .filter(Well.class::isInstance)
                .map(Well.class::cast)
                .collect(Collectors.toList());

        for (Well well : wells) {
            score += well.getScoreWell(board);
        }
        return score;
    }
}
