package com.example.tinycalculator.Domain.BlackBuildings;

import android.util.Pair;

import com.example.tinycalculator.Enums.BlackEnum;

public class BlackBuildingsFactory {
    static public BlackBuilding createBlackBuilding(Pair<Integer, Integer> position, BlackEnum blackEnum){
        BlackBuilding blackBuilding;
        switch (blackEnum){
            case Factory:
                blackBuilding = new Factory(position);
                break;
            case Bank:
                blackBuilding = new Bank(position);
                break;
            case Warehouse:
                blackBuilding = new Warehouse(position);
                break;
            case TradingPost:
                blackBuilding = new TradingPost(position);
                break;
            default:
                blackBuilding = new Factory(position);
        }
        return blackBuilding;
    }
}
