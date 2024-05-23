package com.example.tinycalculator.Domain.RedBuildings;

import android.util.Log;
import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Domain.Cottage;
import com.example.tinycalculator.Domain.OrangeBuildings.Temple;
import com.example.tinycalculator.Domain.PurpleBuildings.BarettCastle;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Domain.Utils.BinaryCounter;
import com.example.tinycalculator.Domain.Utils.SizeComparator;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.RedEnum;
import com.example.tinycalculator.Enums.SquareEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Greenhouse extends RedBuilding {
    public Greenhouse(Pair<Integer, Integer> position) {
        super(position, RedEnum.Greenhouse);
    }

    @Override
    public void feedCottages(Board board) {
        BarettCastle barettCastle = BarettCastle.getBarettCastleFromBoard(board);
        List<Square> squareList = board.getSquaresAsList();
        int amountGreenhouses = (int) squareList.stream()
                .filter(sq -> sq.squareType == SquareEnum.RedBuilding)
                .count();
        List<Cottage> cottages = squareList.stream()
                .filter(Cottage.class::isInstance)
                .map(Cottage.class::cast)
                .collect(Collectors.toList());

        List<Set<Cottage>> contiguousGroups = new ArrayList<>();
        Set<Cottage> squaresDone = new HashSet<>();

        for (Cottage cottage : cottages) {
            if (!squaresDone.contains(cottage) && cottage.squareType == SquareEnum.Cottage) {
                Set<Cottage> currentSet = board.getListOfContiguousGroupOfSameBuildingTypeFromSquare(cottage).stream()
                        .map(Cottage.class::cast)
                        .collect(Collectors.toSet());
                contiguousGroups.add(currentSet);
                squaresDone.addAll(currentSet);
            }
        }
        //We have gotten all that we need
        int amountToFeed = contiguousGroups.size();
        if (barettCastle != null) {
            amountToFeed += 1;
        }
        if (amountToFeed <= amountGreenhouses) {
            for (Set<Cottage> group : contiguousGroups) {
                group.forEach(c -> c.isFed = true);
            }
            if (barettCastle != null) {
                barettCastle.isFed = true;
            }
            return;
        }

        //IF TEMPLE IS IN GAME
        if (board.orangeBuildingCard == OrangeEnum.Temple && squareList.stream().anyMatch(sq -> sq.squareType == SquareEnum.OrangeBuilding)) {
            feedCottagesWithTempleInGame(amountGreenhouses, board, barettCastle, contiguousGroups);
            return;
        }

        contiguousGroups.sort(new SizeComparator().reversed());
        for (int i = 0; i < amountGreenhouses; i++) {
            if (barettCastle != null && !barettCastle.isFed && contiguousGroups.get(i).size() < 2) {
                barettCastle.isFed = true;
                i--;
                amountGreenhouses--;
            } else {
                for (Cottage cottage : contiguousGroups.get(i)) {
                    cottage.isFed = true;
                }
            }
        }
    }

    private void feedCottagesWithTempleInGame(int amountFood, Board board, BarettCastle barettCastle, List<Set<Cottage>> contiguousGroups) {
        int amountToFeed = contiguousGroups.size();
        if (barettCastle != null) {
            amountToFeed++;
        }
        Log.d("Domain", "Amount to feed: " + amountToFeed);
        Log.d("Domain", "Groups size: " + contiguousGroups.size());

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
                        int currentI = i;
                        contiguousGroups.get(i).forEach(c -> c.isFed = binaryCounter.countArray[currentI] == 1);
                    }
                }
                int scoreLoop = temple.getScore(board);
                scoreLoop = scoreLoop + Cottage.getScoreCottages(board);
                Log.d("TempleFarm", "Scoreloop: " + scoreLoop);
                Log.d("TempleFarm", "Highest Score: " + highestScore);
                if (barettCastle != null) {
                    scoreLoop = scoreLoop + barettCastle.getScore(board);
                }
                if (highestScore < scoreLoop) {
                    highestScore = scoreLoop;
                    rightArray = Arrays.copyOf(binaryCounter.countArray, binaryCounter.countArray.length);
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
                    int currentI = i;
                    int[] finalRightArray = rightArray;
                    contiguousGroups.get(i).forEach(c -> c.isFed = finalRightArray[currentI] == 1);
                }
            }
        }
    }
}
