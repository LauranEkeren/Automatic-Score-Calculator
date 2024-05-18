package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.PurpleEnum;

public class CathedralOfCaterina extends PurpleBuilding{
    public CathedralOfCaterina(Pair<Integer, Integer> position) {
        super(position, PurpleEnum.CathedralOfCaterina);
    }

    public static CathedralOfCaterina getCathedralOfCatherinaFromBoard(Board board){
        return board.getSquaresAsList().stream()
                .filter(PurpleBuilding.class::isInstance)
                .findAny().map(CathedralOfCaterina.class::cast)
                .orElse(null);
    }

    @Override
    public int getScore(Board board) {
        return 2;
    }
}
