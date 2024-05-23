package com.example.tinycalculator.Domain.GreenBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.GreenEnum;

public class Almshouse extends GreenBuilding{
    public Almshouse(Pair<Integer, Integer> position) {
        super(position, GreenEnum.Almshouse);
    }

    @Override
    public int getScore(Board board) {
        switch (getAmountTaverns(board)){
            case 0: return 0;
            case 1: return -1;
            case 2: return 5;
            case 3: return -3;
            case 4: return 15;
            case 5: return -5;
            default: return 26;
        }
    }
}
