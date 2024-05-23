package com.example.tinycalculator.Domain.GreenBuildings;

import android.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.GreenEnum;

public class FeastHall extends GreenBuilding{
    public FeastHall(Pair<Integer, Integer> position) {
        super(position, GreenEnum.FeastHall);
    }

    @Override
    public int getScore(Board board) {
        int amountFeastHallsOnOwnBoard = this.getAmountTaverns(board);
        if (amountFeastHallsOnOwnBoard <= board.amountFeastHallNeighbour){
            return 2 * amountFeastHallsOnOwnBoard;
        } else {
            return 3 * amountFeastHallsOnOwnBoard;
        }
    }
}
