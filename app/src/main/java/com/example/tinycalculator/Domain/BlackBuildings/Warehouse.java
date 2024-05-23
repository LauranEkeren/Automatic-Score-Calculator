package com.example.tinycalculator.Domain.BlackBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.BlackEnum;

public class Warehouse extends BlackBuilding{
    public Warehouse(Pair<Integer, Integer> position) {
        super(position, BlackEnum.Warehouse);
    }

    @Override
    public int getScore(Board board) {
        return -board.warehouseNumber;
    }
}
