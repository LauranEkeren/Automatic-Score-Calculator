package com.example.tinycalculator.Domain;

import android.util.Log;
import android.util.Pair;

import com.example.tinycalculator.Domain.Enums.SquareEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Farm extends Square{
    public Farm(Pair<Integer, Integer> position){
        super(position, SquareEnum.Farm);
    }

    public static List<Farm> getFarms(Board board){
        return board.getSquaresAsList().stream()
                .filter(Farm.class::isInstance)
                .map(Farm.class::cast)
                .collect(Collectors.toList());
    }

    public static void feedCottages(Board board){
        int amountFarms = (int) board.getSquaresAsList().stream().filter(sq -> sq.squareType == SquareEnum.Farm).count();
        int amountFood = amountFarms * 4;
        List<Cottage> cottages = Cottage.getCottages(board);
        if (cottages.size() > amountFood){
            for (int i = 0; i < amountFood; i++){
                cottages.get(i).isFed = true;
            }
        } else {
            cottages.forEach(x -> x.isFed = true);
        }
    }
}
