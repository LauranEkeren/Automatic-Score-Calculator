package com.example.tinycalculator.Domain;

import android.util.Pair;

import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Domain.PurpleBuildings.BarettCastle;
import com.example.tinycalculator.Enums.PurpleEnum;

public class Chapel extends Square {

    public Chapel(Pair<Integer, Integer> position)
    {
        super(position, SquareEnum.OrangeBuilding);
    }

    public static int getScoreChapels(Board board){
        int points = 0;
        int amountChapels = (int) board.getSquaresAsList().stream()
                .filter(sq -> sq.squareType == SquareEnum.OrangeBuilding)
                .count();
        if (board.monumentCard == PurpleEnum.BarettCastle){
            BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(board);
            if (barettCastle != null && barettCastle.isFed){
                points = 2 * amountChapels;
            }
        }
        int amountCottagesFed = Cottage.getAmountFedCottages(board);
        points = points + (amountChapels * amountCottagesFed);
        return points;
    }
}
