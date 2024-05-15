package com.example.tinycalculator.Domain;

import android.util.Log;
import android.util.Pair;

import com.example.tinycalculator.Domain.Enums.SquareEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Theater extends Square{
    public Theater(Pair<Integer, Integer> position){
        super(position, SquareEnum.Theater);
    }

    public int getScore(Board board){
        //Get all buildings in the same row.
        List<SquareEnum> rowBuildings = Arrays.stream(board.getSquares()[this.position.first]).map(sq -> sq.squareType).distinct().collect(Collectors.toList());

        //Get all buildings in the same column.
        List<SquareEnum> columnBuildings = new ArrayList<>();
        for (int y = 0; y < 4; y++){
            SquareEnum currentSquareEnum = board.getSquares()[y][this.position.second].squareType;
            if (!columnBuildings.contains(currentSquareEnum)){
                columnBuildings.add(currentSquareEnum);
            }
        }
        Set<SquareEnum> allBuildings = new LinkedHashSet<>(rowBuildings);
        allBuildings.addAll(columnBuildings);
        allBuildings.remove(SquareEnum.Theater);
        allBuildings.remove(SquareEnum.Empty);

        return allBuildings.size();
    }



    public static int getScoreTheaters(Board board){
        int score = 0;
        List<Square> squareList = board.getSquaresAsList();
        List<Theater> theaters = squareList.stream()
                .filter(Theater.class::isInstance)
                .map(Theater.class::cast)
                .collect(Collectors.toList());

        for (Theater theater : theaters) {
            score += theater.getScore(board);
        }

        return score;
    }
}
