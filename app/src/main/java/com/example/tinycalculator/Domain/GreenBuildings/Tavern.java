package com.example.tinycalculator.Domain.GreenBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.GreenEnum;

public class Tavern extends GreenBuilding {
    public Tavern(Pair<Integer, Integer> position){
        super(position, GreenEnum.Tavern);
    }

    @Override
    public int getScore(Board board){
        switch (getAmountGreenBuildings(board)){
            case 0: return 0;
            case 1: return 2;
            case 2: return 5;
            case 3: return 9;
            case 4: return 14;
            default: return 20;
        }
    }
}
