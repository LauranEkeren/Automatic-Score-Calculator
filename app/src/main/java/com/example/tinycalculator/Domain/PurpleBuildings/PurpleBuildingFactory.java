package com.example.tinycalculator.Domain.PurpleBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.EmptySquare;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Domain.Square;

public class PurpleBuildingFactory {
    static public Square createPurpleBuilding(Pair<Integer, Integer> position, PurpleEnum purpleEnum){
        Square purpleBuilding;
        switch (purpleEnum){
            case ArchitectGuild:
                purpleBuilding = new ArchitectsGuild(position);
                break;
            case ArchiveOfTheSecondAge:
                purpleBuilding = new ArchiveOfTheSecondAge(position);
                break;
            case BarettCastle:
                purpleBuilding = new BarettCastle(position);
                break;
            case CathedralOfCaterina:
                purpleBuilding = new CathedralOfCaterina(position);
                break;
            case FortIronweed:
                purpleBuilding = new ForIronweed(position);
                break;
            case GrandMausoleumOfTheRodina:
                purpleBuilding = new GrandMausoleumOfTheRodina(position);
                break;
            case GroveUniversity:
                purpleBuilding = new GroveUniversity(position);
                break;
            case MandrasPalace:
                purpleBuilding = new MandrasPalace(position);
                break;
            case ShrineOfTheElderTree:
                purpleBuilding = new ShrineOfTheElderTree(position);
                break;
            case SilvaForum:
                purpleBuilding = new SilvaForum(position);
                break;
            case TheSkyBaths:
                purpleBuilding = new TheSkyBaths(position);
                break;
            case TheStarloom:
                purpleBuilding = new TheStarloom(position);
                break;
            case NoPurpleBuilding:
                purpleBuilding = new EmptySquare(position);
                break;
            default:
                purpleBuilding = new NoScoringPurpleBuilding(position);
        }
        return purpleBuilding;
    }
}
