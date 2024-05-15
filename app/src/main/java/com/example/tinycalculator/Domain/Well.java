package com.example.tinycalculator.Domain;

import android.util.Log;
import android.util.Pair;

import com.example.tinycalculator.Domain.Enums.SquareEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Well extends Square {
    public Well(Pair<Integer, Integer> position){
        super(position, SquareEnum.Well);
    }

    public int getScore(Board board){
        List<Square> adjacentSquares = getAdjacentSquares(board);
        return (int) adjacentSquares.stream().filter(Cottage.class::isInstance).count();
    }

    public static int getScoreWells(Board board) {
        int score = 0;
        List<Square> squareList = board.getSquaresAsList();
        List<Well> wells = squareList.stream()
                .filter(Well.class::isInstance)
                .map(Well.class::cast)
                .collect(Collectors.toList());

        for (Well well : wells) {
            score += well.getScore(board);
        }
        return score;
    }
}
