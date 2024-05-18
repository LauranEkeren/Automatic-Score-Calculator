package com.example.tinycalculator.Domain;

import android.util.Pair;

import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Domain.PurpleBuildings.BarettCastle;
import com.example.tinycalculator.Enums.PurpleEnum;

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

        if (board.monumentCard == PurpleEnum.BarettCastle){
            if (amountFood != 0){
                BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(board);
                if (barettCastle != null){
                    barettCastle.isFed = true;
                    amountFood = amountFood - 1;
                }
            }
        }

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
