package com.example.tinycalculator.Domain;

import androidx.core.util.Pair;

import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Domain.PurpleBuildings.CathedralOfCaterina;
import com.example.tinycalculator.Enums.PurpleEnum;

import java.util.List;
import java.util.stream.Collectors;

public class EmptySquare extends Square {
    public EmptySquare(Pair<Integer, Integer> position){
        super(position, SquareEnum.Empty);
    }

    public static List<EmptySquare> getEmptySquares(Board board){
        return board.getSquaresAsList().stream()
                .filter(EmptySquare.class::isInstance)
                .map(EmptySquare.class::cast)
                .collect(Collectors.toList());
    }

    public static int getPenaltyEmptySquares(Board board){
        if (board.monumentCard == PurpleEnum.CathedralOfCaterina){
            CathedralOfCaterina cathedralOfCaterina = CathedralOfCaterina.getCathedralOfCatherinaFromBoard(board);
            if (cathedralOfCaterina != null){
                return 0;
            }
        }
        return -getEmptySquares(board).size();
    }
}
