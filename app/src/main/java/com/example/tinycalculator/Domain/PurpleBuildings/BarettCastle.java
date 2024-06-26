package com.example.tinycalculator.Domain.PurpleBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class BarettCastle extends PurpleBuilding{
    public boolean isFed = false;
    public BarettCastle(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.BarettCastle);
    }

    @Override
    public int getScore(Board board) {
        if (isFed){
            return 5;
        } else {
            return 0;
        }
    }

    public static BarettCastle getBarettCastleFromBoard(Board board){
        if (board.monumentCard != PurpleEnum.BarettCastle){
            return null;
        }
        return  board.getSquaresAsList().stream()
                .filter(PurpleBuilding.class::isInstance)
                .findAny().map(BarettCastle.class::cast)
                .orElse(null);
    }
}
