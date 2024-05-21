package com.example.tinycalculator.Domain;

import android.util.Log;
import android.util.Pair;

import com.example.tinycalculator.Domain.GreyBuildings.GreyBuilding;
import com.example.tinycalculator.Domain.GreyBuildings.GreyBuildingsFactory;
import com.example.tinycalculator.Domain.GreyBuildings.Well;
import com.example.tinycalculator.Domain.YellowBuildings.YellowBuilding;
import com.example.tinycalculator.Domain.YellowBuildings.YellowBuildingsFactory;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Domain.PurpleBuildings.NoScoringPurpleBuilding;
import com.example.tinycalculator.Domain.PurpleBuildings.PurpleBuilding;
import com.example.tinycalculator.Domain.PurpleBuildings.PurpleBuildingFactory;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.YellowEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Board {
    public PurpleEnum monumentCard;
    YellowEnum yellowBuildingCard;
    GreyEnum greyBuildingCard;
    private final Square[][] squares = new Square[4][4];
    private final List<Square> squareList;

    public Board(String stringFromApi, HashMap<String, String> cards) {
        monumentCard = PurpleEnum.valueOf(cards.get("Monument"));
        yellowBuildingCard = YellowEnum.valueOf(cards.get("YellowBuilding"));
        greyBuildingCard = GreyEnum.valueOf(cards.get("GreyBuilding"));
        String[] stringObjects = getStringArrayFromJsonString(stringFromApi);
        placeBuildingsInGridFromArray(stringObjects);
        squareList = returnSquaresAsList();
    }

    public Square[][] getSquares() {
        return squares;
    }

    public List<Square> getSquaresAsList() {
        return squareList;
    }

    public HashMap<String, Integer> calculateScore() {
        Log.d("Log", "From Board.java: calculateScore line 30");
        Log.d("Log", squaresToString());
        HashMap<String, Integer> points = new HashMap<>();
        int totalScore = 0;

        Farm.feedCottages(this);
        points.put("Chapel", Chapel.getScoreChapels(this));
        points.put("Cottage", Cottage.getScoreCottages(this));
        points.put("EmptyPenalty", EmptySquare.getPenaltyEmptySquares(this));
        points.put("Tavern", Tavern.getScoreTaverns(this));

        YellowBuilding yellowBuilding = YellowBuildingsFactory.createYellowBuilding(Pair.create(0, 0), yellowBuildingCard);
        points.put("Theater", yellowBuilding.getScore(this));

        GreyBuilding greyBuilding = GreyBuildingsFactory.createGreyBuilding(Pair.create(0, 0), greyBuildingCard);
        points.put("Well", greyBuilding.getScore(this));

        PurpleBuilding purpleBuilding;
        if (monumentCard != PurpleEnum.NoPurpleBuilding) {
            purpleBuilding = squareList.stream()
                    .filter(PurpleBuilding.class::isInstance)
                    .findAny().map(PurpleBuilding.class::cast)
                    .orElse(new NoScoringPurpleBuilding(Pair.create(0, 0)));
            points.put("Monument", purpleBuilding.getScore(this));
        }


        for (int i : points.values()) {
            totalScore += i;
        }
        points.put("TotalScore", totalScore);
        return points;
    }

    public int getSizeOfLargesContiguousGroupOfSameBuildingType() {
        int largestSet = 0;
        Set<Square> squaresDone = new HashSet<>();
        for (Square square : this.squareList) {
            if (!(squaresDone.contains(square) || square.squareType == SquareEnum.Empty)) {
                Set<Square> currentSet = getListOfContiguousGroupOfSameBuildingTypeFromSquare(square);
                if (currentSet.size() > largestSet) {
                    largestSet = currentSet.size();
                }
                squaresDone.addAll(currentSet);
            }
        }
        return largestSet;
    }

    public Set<Square> getListOfContiguousGroupOfSameBuildingTypeFromSquare(Square square) {
        Log.d("Domain", square.position.toString());
        SquareEnum squareTypeToLookFor = square.squareType;
        Set<Square> contiguousGroup = new HashSet<>();
        List<Square> squaresToGetAdjacentFrom = new ArrayList<>();
        squaresToGetAdjacentFrom.add(square);

        while (!squaresToGetAdjacentFrom.isEmpty()) {
            Square currentSquare = squaresToGetAdjacentFrom.get(0);

            contiguousGroup.add(currentSquare);
            List<Square> squaresToAdd = currentSquare.getAdjacentSquares(this).stream()
                    .filter(sq -> sq.squareType == squareTypeToLookFor && !contiguousGroup.contains(sq))
                    .collect(Collectors.toList());
            squaresToGetAdjacentFrom.addAll(squaresToAdd);
            squaresToGetAdjacentFrom.remove(currentSquare);

        }
        Log.d("Domain", String.valueOf(contiguousGroup.size()));
        return contiguousGroup;
    }

    public List<Square> getCenterSquares() {
        List<Square> centerSquares = new ArrayList<>();
        centerSquares.add(squares[1][1]);
        centerSquares.add(squares[1][2]);
        centerSquares.add(squares[2][1]);
        centerSquares.add(squares[2][2]);
        return centerSquares;
    }

    public String squaresToString() {
        StringBuilder stringBuilder = new StringBuilder("Objects:\n");
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                stringBuilder.append(squares[y][x].squareType);
                stringBuilder.append(" ,");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private String[] getStringArrayFromJsonString(String jsonString) {
        //TODO: Proper json conversion
        jsonString = jsonString.replace("[", "");
        jsonString = jsonString.replace("]", "");
        jsonString = jsonString.replace(" ", "");
        jsonString = jsonString.replace("\"", "");

        return jsonString.split(",");
    }

    private void placeBuildingsInGridFromArray(String[] stringObjects) {
        int total = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                Pair<Integer, Integer> position = Pair.create(y, x);
                switch (stringObjects[total]) {
                    case "Chapel":
                        squares[y][x] = new Chapel(position);
                        break;
                    case "Cottage":
                        Cottage cottage = new Cottage(position);
                        squares[y][x] = cottage;
                        break;
                    case "Factory":
                        squares[y][x] = new Factory(position);
                        break;
                    case "Farm":
                        squares[y][x] = new Farm(position);
                        break;
                    case "Tavern":
                        squares[y][x] = new Tavern(position);
                        break;
                    case "Theater":
                        squares[y][x] = YellowBuildingsFactory.createYellowBuilding(position, yellowBuildingCard);
                        break;
                    case "Well":
                        squares[y][x] = GreyBuildingsFactory.createGreyBuilding(position, greyBuildingCard);
                        break;
                    case "Monument":
                        squares[y][x] = PurpleBuildingFactory.createSquare(position, monumentCard);
                        break;
                    default:
                        squares[y][x] = new EmptySquare(position);
                }
                total++;
            }
        }
    }

    private List<Square> returnSquaresAsList() {
        List<Square> squareList = new ArrayList<>();
        for (Square[] squareArray : this.getSquares()) {
            squareList.addAll(Arrays.asList(squareArray));
        }
        return squareList;
    }
}
