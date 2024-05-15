package com.example.tinycalculator.Domain;

import android.util.Pair;

import com.example.tinycalculator.Domain.Enums.SquareEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmptySquare extends Square {
    public EmptySquare(Pair<Integer, Integer> position){
        super(position, SquareEnum.Empty);
    }

    public static List<EmptySquare> getEmptySquares(Board board){
        return board.getSquaresAsList().stream()
                .filter(EmptySquare.class::isInstance)
                .map(EmptySquare.class::cast)
                .collect(Collectors.toList());
    }

    public static int getPenaltyEmptySquares(Board board){
        return -getEmptySquares(board).size();
    }
}
