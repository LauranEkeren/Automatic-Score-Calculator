package com.example.tinycalculator.Domain;

import android.util.Log;
import android.util.Pair;

import com.example.tinycalculator.Domain.Enums.SquareEnum;

public class Chapel extends Square {

    public Chapel(Pair<Integer, Integer> position)
    {
        super(position, SquareEnum.Chapel);
    }

    public static int getScoreChapels(Board board){
        int amountCottagesFed = Cottage.getAmountFedCottages(board);
        return (int) (amountCottagesFed * board.getSquaresAsList().stream().filter(sq -> sq.squareType == SquareEnum.Chapel).count());
    }
}
