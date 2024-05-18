package com.example.tinycalculator.Domain;

import android.util.Pair;

import com.example.tinycalculator.Enums.SquareEnum;

public class Factory extends Square{
    public Factory(Pair<Integer, Integer> position){
        super(position, SquareEnum.Factory);
    }
}
