package com.example.tinycalculator.Domain;

import android.util.Pair;

import com.example.tinycalculator.Domain.Enums.SquareEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cottage extends Square {
    boolean isFed = false;
    public Cottage(Pair<Integer, Integer> position){
        super(position, SquareEnum.Cottage);
    }

    public static int getScoreCottages(Board board){
        int amountCottagesFed = getAmountFedCottages(board);
        return 3 * amountCottagesFed;
    }
    public static List<Cottage> getCottages(Board board){
        return board.getSquaresAsList().stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .collect(Collectors.toList());
    }

    public static int getAmountFedCottages(Board board){
        List<Cottage> cottageList = getCottages(board);
        return (int) cottageList.stream()
                .filter(co -> co.isFed)
                .count();
    }
}
