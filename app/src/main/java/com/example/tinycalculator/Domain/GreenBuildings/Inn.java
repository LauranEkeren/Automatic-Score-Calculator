package com.example.tinycalculator.Domain.GreenBuildings;

import android.util.Log;
import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.GreenEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import java.io.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Inn extends GreenBuilding{
    public Inn(Pair<Integer, Integer> position) {
        super(position, GreenEnum.Inn);
    }

    @Override
    public int getScore(Board board) {
        int score = 0;
        List<Square> inns = board.getSquaresAsList().stream()
                .filter(sq -> sq.squareType == SquareEnum.GreenBuilding)
                .collect(Collectors.toList());
        Log.d("Domain", "Amount Inns: " + inns.size());
        for (Square square : inns) {
            int amountInnsInRowAndColumn =
                    (int) square.getRowAndColumnSquares(board).stream().
                    filter(sq -> sq.squareType == SquareEnum.GreenBuilding)
                    .count();
            Log.d("Domain", "Amount Inns in R+C: " + amountInnsInRowAndColumn);
            if (amountInnsInRowAndColumn == 1
            ){
                score = score + 3;
            }
        }
        return score;
    }
}
