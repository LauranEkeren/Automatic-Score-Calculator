package com.example.tinycalculator.Domain.OrangeBuildings;


import android.util.Pair;

import com.example.tinycalculator.Enums.OrangeEnum;

public class OrangeBuildingsFactory {
    static public OrangeBuilding createOrangeBuilding(Pair<Integer, Integer> position, OrangeEnum orangeEnum){
        OrangeBuilding orangeBuilding;
        switch (orangeEnum){
            case Abbey:
                orangeBuilding = new Abbey(position);
                break;
            case Chapel:
                orangeBuilding = new Chapel(position);
                break;
            case Temple:
                orangeBuilding = new Temple(position);
                break;
            case Cloister:
                orangeBuilding = new Cloister(position);
                break;
            default:
                orangeBuilding = new Chapel(position);
        }
        return orangeBuilding;
    }
}
