package com.example.tinycalculator.Domain.PurpleBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class GrandMausoleumOfTheRodina extends PurpleBuilding{
    public GrandMausoleumOfTheRodina(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.GrandMausoleumOfTheRodina);
    }

    @Override
    public int getScore(Board board) {
        return 0;
    }

    public static GrandMausoleumOfTheRodina getGrandMausoleumOfTheRodinaFromBoard(Board board){
        if (board.monumentCard != PurpleEnum.GrandMausoleumOfTheRodina){
            return null;
        }
        return  board.getSquaresAsList().stream()
                .filter(PurpleBuilding.class::isInstance)
                .findAny().map(GrandMausoleumOfTheRodina.class::cast)
                .orElse(null);
    }
}
