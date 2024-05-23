package com.example.tinycalculator.Domain.RedBuildings;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.RedEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orchard extends RedBuilding{
    public Orchard(Pair<Integer, Integer> position) {
        super(position, RedEnum.Orchard);
    }

    @Override
    public void feedCottages(Board board) {
        List<Orchard> orchards = board.getSquaresAsList().stream()
                .filter(Orchard.class::isInstance)
                .map(Orchard.class::cast)
                .collect(Collectors.toList());
        List<Square> allSquaresToFeed = new ArrayList<>();
        for (Orchard orchard : orchards){
            allSquaresToFeed.addAll(orchard.getRowAndColumnSquares(board));
        }
        RedBuilding.feedSquares(board, allSquaresToFeed);
    }
}
