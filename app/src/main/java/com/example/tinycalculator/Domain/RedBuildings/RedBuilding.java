package com.example.tinycalculator.Domain.RedBuildings;

import android.util.Log;
import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
import com.example.tinycalculator.Domain.PurpleBuildings.BarettCastle;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.RedEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import java.util.List;
import java.util.stream.Collectors;

public abstract class RedBuilding extends Square {
    RedEnum redBuildingType;
    public RedBuilding(Pair<Integer, Integer> position, RedEnum redBuildingType) {
        super(position, SquareEnum.RedBuilding);
        this.redBuildingType = redBuildingType;
    }

    public static void feedSquares(Board board, List<Square> squaresToFeed){
        List<Cottage> cottages = squaresToFeed.stream()
                .distinct()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .collect(Collectors.toList());

        for (Cottage cottage: cottages) {
            cottage.isFed = true;
        }

        if (board.monumentCard == PurpleEnum.BarettCastle){
            BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(board);
            if (barettCastle != null){
                boolean barettCastleInSurroundingSquares = squaresToFeed.stream().anyMatch(BarettCastle.class::isInstance);
                if (barettCastleInSurroundingSquares){
                    barettCastle.isFed = true;
                }
            }
        }
    }

    public abstract void feedCottages(Board board);
}
