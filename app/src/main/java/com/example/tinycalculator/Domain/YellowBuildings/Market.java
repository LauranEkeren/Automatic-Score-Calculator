package com.example.tinycalculator.Domain.YellowBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Enums.YellowEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Market extends YellowBuilding{
    public Market(Pair<Integer, Integer> position) {
        super(position, YellowEnum.Market);
    }

    public int getScoreMarket(Board board){
        //Get all theaters in same row
        int marketsRow = (int) Arrays.stream(board.getSquares()[this.position.first])
                .filter(sq -> sq.squareType == SquareEnum.YellowBuilding)
                .count();

        //Get all markets in same column
        int marketsColumn = 0;
        for (int y = 0; y < 4; y++){
            SquareEnum currentSquareEnum = board.getSquares()[y][this.position.second].squareType;
            if(currentSquareEnum == SquareEnum.YellowBuilding){
                marketsColumn++;
            }
        }
        return Math.max(marketsRow, marketsColumn);
    }

    @Override
    public int getScore(Board board) {
        int score = 0;
        List<Square> squareList = board.getSquaresAsList();
        List<Market> markets = squareList.stream()
                .filter(Market.class::isInstance)
                .map(Market.class::cast)
                .collect(Collectors.toList());

        for (Market market : markets){
            score += market.getScoreMarket(board);
        }
        return score;
    }
}
