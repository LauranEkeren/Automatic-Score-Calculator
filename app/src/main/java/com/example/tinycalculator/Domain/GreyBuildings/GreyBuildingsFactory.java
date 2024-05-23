package com.example.tinycalculator.Domain.GreyBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Enums.GreyEnum;

public class GreyBuildingsFactory {
    static public GreyBuilding createGreyBuilding(Pair<Integer, Integer> position, GreyEnum greyEnum){
        GreyBuilding greyBuilding;
        switch (greyEnum){
            case Shed:
                greyBuilding = new Shed(position);
                break;
            case Well:
                greyBuilding = new Well(position);
                break;
            case Fountain:
                greyBuilding = new Fountain(position);
                break;
            case Millstone:
                greyBuilding = new Millstone(position);
                break;
            default:
                greyBuilding = new Well(position);
        }
        return greyBuilding;
    }
}
