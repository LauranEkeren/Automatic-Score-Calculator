package com.example.tinycalculator.Domain.RedBuildings;

import android.util.Log;
import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
import com.example.tinycalculator.Domain.OrangeBuildings.Temple;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Domain.Utils.BinaryCounter;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.RedEnum;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Domain.PurpleBuildings.BarettCastle;
import com.example.tinycalculator.Enums.PurpleEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Farm extends RedBuilding {
    public Farm(Pair<Integer, Integer> position) {
        super(position, RedEnum.Farm);
    }

    public static List<Farm> getFarms(Board board) {
        return board.getSquaresAsList().stream()
                .filter(Farm.class::isInstance)
                .map(Farm.class::cast)
                .collect(Collectors.toList());
    }

    public void feedCottages(Board board) {
        int amountFarms = (int) board.getSquaresAsList().stream().filter(sq -> sq.squareType == SquareEnum.RedBuilding).count();
        int amountFood = amountFarms * 4;
        if (board.orangeBuildingCard == OrangeEnum.Temple) {
            feedCottagesWithTempleInGame(amountFood, board);
            return;
        }
        if (board.monumentCard == PurpleEnum.BarettCastle) {
            if (amountFood != 0) {
                BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(board);
                if (barettCastle != null) {
                    barettCastle.isFed = true;
                    amountFood = amountFood - 1;
                }
            }
        }
        List<Cottage> cottages = Cottage.getCottages(board);
        if (cottages.size() > amountFood) {
            for (int i = 0; i < amountFood; i++) {
                cottages.get(i).isFed = true;
            }
        } else {
            cottages.forEach(x -> x.isFed = true);
        }
    }

    private static void feedCottagesWithTempleInGame(int amountFood, Board board) {
        List<Cottage> cottages = Cottage.getCottages(board);
        int amountToFeed = cottages.size();

        BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(board);
        if (barettCastle != null) {
            amountToFeed++;
        }

        // There is more food than buildings that can be fed
        if (amountToFeed < amountFood) {
            cottages.forEach(x -> x.isFed = true);
            if (barettCastle != null) {
                barettCastle.isFed = true;
                return;
            }
        }

        BinaryCounter binaryCounter = new BinaryCounter(amountToFeed);
        int highestScore = 0;
        int[] rightArray = null;
        Temple temple = new Temple(Pair.create(0, 0));
        while (true) {
            if (binaryCounter.stopAtNextCorrectBinaryNumber(amountFood)) {
                for (int i = 0; i < binaryCounter.countArray.length; i++) {
                    if (barettCastle != null && i == binaryCounter.countArray.length - 1) {
                        barettCastle.isFed = binaryCounter.countArray[i] == 1;
                    } else {
                        cottages.get(i).isFed = binaryCounter.countArray[i] == 1;
                    }
                }
                int scoreLoop = temple.getScore(board);
                if (barettCastle != null) {
                    scoreLoop = scoreLoop + barettCastle.getScore(board);
                    scoreLoop = scoreLoop + Cottage.getScoreCottages(board);
                }
                Log.d("TempleFarm", "Scoreloop: " + scoreLoop);
                Log.d("TempleFarm", "Highest Score: " + highestScore);
                if (highestScore < scoreLoop) {
                    highestScore = scoreLoop;
                    rightArray = Arrays.copyOf(binaryCounter.countArray, binaryCounter.countArray.length);
                    Log.d("TempleFarm", "rightArray: " + Arrays.toString(rightArray));
                }
            } else {
                break;
            }
        }

        if (rightArray != null) {
            for (int i = 0; i < rightArray.length; i++) {
                if (barettCastle != null && i == rightArray.length - 1) {
                    barettCastle.isFed = rightArray[i] == 1;
                } else {
                    cottages.get(i).isFed = rightArray[i] == 1;
                }
            }
        }
    }
}
