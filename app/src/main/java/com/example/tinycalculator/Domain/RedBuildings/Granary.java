package com.example.tinycalculator.Domain.RedBuildings;

import android.util.Log;
import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.RedEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Granary extends RedBuilding{
    public Granary(Pair<Integer, Integer> position) {
        super(position, RedEnum.Granary);
    }

    @Override
    public void feedCottages(Board board) {
        List<Granary> granaries = board.getSquaresAsList().stream()
                .filter(Granary.class::isInstance)
                .map(Granary.class::cast)
                .collect(Collectors.toList());

        List<Square> surroundingSquares = new ArrayList<>();
        for (Granary granary : granaries) {
            surroundingSquares.addAll(granary.getSurroundingSquares(board));
        }
        RedBuilding.feedSquares(board, surroundingSquares);
    }
}
