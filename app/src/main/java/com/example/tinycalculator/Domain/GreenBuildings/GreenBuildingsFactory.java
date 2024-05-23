package com.example.tinycalculator.Domain.GreenBuildings;

import android.util.Pair;

import com.example.tinycalculator.Enums.GreenEnum;

public class GreenBuildingsFactory {
    static public GreenBuilding createGreenBuilding(Pair<Integer, Integer> position, GreenEnum greenEnum){
        GreenBuilding greenBuilding;
        switch (greenEnum){
            case Inn:
                greenBuilding = new Inn(position);
                break;
            case Tavern:
                greenBuilding = new Tavern(position);
                break;
            case Almshouse:
                greenBuilding = new Almshouse(position);
                break;
            case FeastHall:
                greenBuilding = new FeastHall(position);
                break;
            default:
                greenBuilding = new Tavern(position);
        }
        return greenBuilding;
    }
}
