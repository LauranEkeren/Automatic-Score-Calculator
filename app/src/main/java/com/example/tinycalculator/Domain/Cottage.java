package com.example.tinycalculator.Domain;

import android.util.Pair;

import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Enums.PurpleEnum;

import java.util.List;
import java.util.stream.Collectors;

public class Cottage extends Square {
    public boolean isFed = false;
    public Cottage(Pair<Integer, Integer> position){
        super(position, SquareEnum.Cottage);
    }

    public static int getScoreCottages(Board board){
        if (board.monumentCard == PurpleEnum.GrandMausoleumOfTheRodina){
            return 3 * getCottages(board).size();
        }
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
