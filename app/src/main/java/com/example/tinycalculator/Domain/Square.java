package com.example.tinycalculator.Domain;

import android.util.Pair;

import com.example.tinycalculator.Domain.Enums.SquareEnum;

import java.util.ArrayList;

public abstract class Square {
    //TODO Make properties private
    SquareEnum squareType;
    //First is y: Row, second is x: Column
    Pair<Integer, Integer> position;


    public Square(Pair<Integer, Integer> position, SquareEnum squareType){
        this.position = position;
        this.squareType = squareType;
    }

    public ArrayList<Square> getAdjacentSquares(Board board){
        ArrayList<Square> adjacentSquares = new ArrayList<>();
        switch (this.position.first){
            case 0:
                adjacentSquares.add(board.getSquares()[this.position.first + 1][this.position.second]);
                break;
            case 3:
                adjacentSquares.add(board.getSquares()[this.position.first -1][this.position.second]);
                break;
            default:
                adjacentSquares.add(board.getSquares()[this.position.first +1][this.position.second]);
                adjacentSquares.add(board.getSquares()[this.position.first -1][this.position.second]);
        }

        switch (this.position.second){
            case 0:
                adjacentSquares.add(board.getSquares()[this.position.first][this.position.second + 1]);
                break;
            case 3:
                adjacentSquares.add(board.getSquares()[this.position.first][this.position.second - 1]);
                break;
            default:
                adjacentSquares.add(board.getSquares()[this.position.first][this.position.second + 1]);
                adjacentSquares.add(board.getSquares()[this.position.first][this.position.second - 1]);
        }

        return adjacentSquares;
    }
}
