package com.example.tinycalculator.Domain.BlackBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.SquareEnum;

public class Factory extends BlackBuilding {
    public Factory(Pair<Integer, Integer> position){
        super(position, BlackEnum.Factory);
    }

    @Override
    public int getScore(Board board) {
        return 0;
    }
}
