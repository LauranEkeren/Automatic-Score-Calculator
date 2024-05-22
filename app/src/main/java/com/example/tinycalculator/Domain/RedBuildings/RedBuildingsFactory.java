package com.example.tinycalculator.Domain.RedBuildings;

import android.util.Pair;

import com.example.tinycalculator.Enums.RedEnum;

public class RedBuildingsFactory {
    static public RedBuilding createRedBuilding(Pair<Integer, Integer> position, RedEnum redEnum){
        RedBuilding redBuilding;
        switch (redEnum){
            case Farm:
                redBuilding = new Farm(position);
                break;
            case Granary:
                redBuilding = new Granary(position);
                break;
            case Orchard:
                redBuilding = new Orchard(position);
                break;
            case Greenhouse:
                redBuilding = new Greenhouse(position);
                break;
            default:
                redBuilding = new Farm(position);
        }
        return redBuilding;
    }
}
