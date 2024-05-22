package com.example.tinycalculator.Domain;

import android.util.Pair;

import com.example.tinycalculator.Enums.SquareEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Square {
    public SquareEnum squareType;
    //First is y: Row, second is x: Column
    //Top left = (0,0) and bottom right = (3, 3)
    public Pair<Integer, Integer> position;


    public Square(Pair<Integer, Integer> position, SquareEnum squareType){
        this.position = position;
        this.squareType = squareType;
    }

    public List<Square> getRowSquares(Board board){
        return Arrays.stream(board.getSquares()[this.position.first])
                .collect(Collectors.toList());
    }

    public List<Square> getColumnSquares(Board board){
        List<Square> columnSquares = new ArrayList<>();
        for (int y = 0; y < 4; y++){
            Square currentSquare = board.getSquares()[y][this.position.second];
            columnSquares.add(currentSquare);
        }
        return columnSquares;
    }

    public List<Square> getRowAndColumnSquares(Board board){
        List<Square> columnSquares = this.getColumnSquares(board);
        List<Square> rowSquares = this.getRowSquares(board);
        columnSquares.addAll(rowSquares);
        return columnSquares;
    }

    public ArrayList<Square> getSurroundingSquares(Board board){
        ArrayList<Square> surroundingSquares = new ArrayList<>(getAdjacentSquares(board));

        if (this.position.first != 0){
            //Upper Left
            if (this.position.second != 0){
                surroundingSquares.add(board.getSquares()[this.position.first - 1][this.position.second - 1]);
            }
            //Upper right
            if (this.position.second != 3){
                surroundingSquares.add(board.getSquares()[this.position.first - 1][this.position.second + 1]);
            }
        }
        if (this.position.first != 3) {
            //Lower Left
            if (this.position.second != 0) {
                surroundingSquares.add(board.getSquares()[this.position.first + 1][this.position.second - 1]);
            }
            //Lower right
            if (this.position.second != 3) {
                surroundingSquares.add(board.getSquares()[this.position.first + 1][this.position.second + 1]);
            }
        }
        return surroundingSquares;
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
