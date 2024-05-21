package com.example.tinycalculator.Domain.Utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryCounter {
    public int[] countArray;

    public BinaryCounter(int size){
        countArray = new int[size];
    }

    public void increaseArray(){
        int currentSpot = 0;
        while (currentSpot < countArray.length){
            if (countArray[currentSpot] == 0){
                countArray[currentSpot] = 1;
                break;
            } else {
                countArray[currentSpot] = 0;
            }
            currentSpot++;
        }
    }

    public boolean isAmountOnesRight(int amountOnesNeeded){
        int ones = (int) Arrays.stream(countArray)
                .filter(i -> i == 1)
                .count();
        return ones == amountOnesNeeded;
    }

    public boolean allZeroes(){
        int zeroes = (int) Arrays.stream(countArray).filter(i -> i == 0).count();
        return zeroes == countArray.length;
    }

    public boolean stopAtNextCorrectBinaryNumber(int amountOnesNeeded){
        while (true){
            this.increaseArray();
            if (this.isAmountOnesRight(amountOnesNeeded)){
                return true;
            } else if (allZeroes()){
                return false;
            }
        }
    }
}
