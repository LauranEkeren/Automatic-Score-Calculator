package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

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
}
