package com.example.tinycalculator.Domain.YellowBuildings;

import android.util.Pair;

import com.example.tinycalculator.Enums.YellowEnum;

public class YellowBuildingsFactory {
    static public YellowBuilding createYellowBuilding(Pair<Integer, Integer> position, YellowEnum yellowEnum){
        YellowBuilding yellowBuilding;
        switch (yellowEnum){
            case Bakery:
                yellowBuilding = new Bakery(position);
                break;
            case Market:
                yellowBuilding = new Market(position);
                break;
            case Tailor:
                yellowBuilding = new Tailor(position);
                break;
            case Theater:
                yellowBuilding = new Theater(position);
                break;
            default:
                yellowBuilding = new Theater(position);
        }
        return yellowBuilding;
    }
}
