package com.example.tinycalculator.Domain;

import android.util.Pair;

import com.example.tinycalculator.Domain.Enums.SquareEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tavern extends Square{
    public Tavern(Pair<Integer, Integer> position){
        super(position, SquareEnum.Tavern);
    }

    public static List<Tavern> getTaverns(Board board){
        return board.getSquaresAsList().stream()
                .filter(Tavern.class::isInstance)
                .map(Tavern.class::cast)
                .collect(Collectors.toList());
    }
    public static int getScoreTaverns(Board board){
        switch (getTaverns(board).size()){
            case 0: return 0;
            case 1: return 2;
            case 2: return 5;
            case 3: return 9;
            case 4: return 14;
            default: return 20;
        }
    }
}
