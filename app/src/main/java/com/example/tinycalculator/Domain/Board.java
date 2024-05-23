package com.example.tinycalculator.Domain;

import android.util.Log;
import android.util.Pair;

import com.example.tinycalculator.Domain.BlackBuildings.BlackBuilding;
import com.example.tinycalculator.Domain.BlackBuildings.BlackBuildingsFactory;
import com.example.tinycalculator.Domain.GreenBuildings.GreenBuilding;
import com.example.tinycalculator.Domain.GreenBuildings.GreenBuildingsFactory;
import com.example.tinycalculator.Domain.GreyBuildings.GreyBuilding;
import com.example.tinycalculator.Domain.GreyBuildings.GreyBuildingsFactory;
import com.example.tinycalculator.Domain.OrangeBuildings.OrangeBuilding;
import com.example.tinycalculator.Domain.OrangeBuildings.OrangeBuildingsFactory;
import com.example.tinycalculator.Domain.RedBuildings.RedBuilding;
import com.example.tinycalculator.Domain.RedBuildings.RedBuildingsFactory;
import com.example.tinycalculator.Domain.YellowBuildings.YellowBuilding;
import com.example.tinycalculator.Domain.YellowBuildings.YellowBuildingsFactory;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.GreenEnum;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.RedEnum;
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
    GreenEnum greenBuildingCard;
    RedEnum redBuildingCard;
    public PurpleEnum monumentCard;
    YellowEnum yellowBuildingCard;
    GreyEnum greyBuildingCard;
    BlackEnum blackBuildingCard;
    public OrangeEnum orangeBuildingCard;
    public final int warehouseNumber;
    public final int amountFeastHallNeighbour;
    public final int amountStarloom;
    public final int amountTree;
    private final Square[][] squares = new Square[4][4];
    private final List<Square> squareList;

    public Board(String stringFromApi, HashMap<String, String> cards, int warehouseNumber, int amountFeastHallNeighbour, int amountStarloom, int amountTree) {
        monumentCard = PurpleEnum.valueOf(cards.get("Monument"));
        redBuildingCard = RedEnum.valueOf(cards.get("RedBuilding"));
        orangeBuildingCard = OrangeEnum.valueOf(cards.get("OrangeBuilding"));
        yellowBuildingCard = YellowEnum.valueOf(cards.get("YellowBuilding"));
        greyBuildingCard = GreyEnum.valueOf(cards.get("GreyBuilding"));
        greenBuildingCard = GreenEnum.valueOf(cards.get("GreenBuilding"));
        blackBuildingCard = BlackEnum.valueOf(cards.get("BlackBuilding"));
        this.warehouseNumber = warehouseNumber;
        this.amountFeastHallNeighbour = amountFeastHallNeighbour;
        this.amountStarloom = amountStarloom;
        this.amountTree = amountTree;
        String[] stringObjects = getStringArrayFromJsonString(stringFromApi);
        placeBuildingsInGridFromArray(stringObjects);
        squareList = returnSquaresAsList();
        Log.d("Domain", cards.toString());
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

        RedBuilding redBuilding = RedBuildingsFactory.createRedBuilding(Pair.create(0, 0), redBuildingCard);
        redBuilding.feedCottages(this);

        OrangeBuilding orangeBuilding = OrangeBuildingsFactory.createOrangeBuilding(Pair.create(0, 0), orangeBuildingCard);
        points.put("Chapel", orangeBuilding.getScore(this));

        points.put("Cottage", Cottage.getScoreCottages(this));
        points.put("EmptyPenalty", EmptySquare.getPenaltyEmptySquares(this));

        GreenBuilding greenBuilding = GreenBuildingsFactory.createGreenBuilding(Pair.create(0, 0), greenBuildingCard);
        points.put("Tavern", greenBuilding.getScore(this));

        YellowBuilding yellowBuilding = YellowBuildingsFactory.createYellowBuilding(Pair.create(0, 0), yellowBuildingCard);
        points.put("Theater", yellowBuilding.getScore(this));

        GreyBuilding greyBuilding = GreyBuildingsFactory.createGreyBuilding(Pair.create(0, 0), greyBuildingCard);
        points.put("Well", greyBuilding.getScore(this));

        BlackBuilding blackBuilding = BlackBuildingsFactory.createBlackBuilding(Pair.create(0, 0), blackBuildingCard);
        points.put("Factory", blackBuilding.getScore(this));

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

    public List<Square> getCornerSquares(){
        List<Square> cornerSquares = new ArrayList<>();
        cornerSquares.add(squares[0][0]);
        cornerSquares.add(squares[3][3]);
        cornerSquares.add(squares[0][3]);
        cornerSquares.add(squares[3][0]);
        return cornerSquares;
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
                        squares[y][x] = OrangeBuildingsFactory.createOrangeBuilding(position, orangeBuildingCard);
                        break;
                    case "Cottage":
                        Cottage cottage = new Cottage(position);
                        squares[y][x] = cottage;
                        break;
                    case "Factory":
                        squares[y][x] = BlackBuildingsFactory.createBlackBuilding(position, blackBuildingCard);
                        break;
                    case "Farm":
                        squares[y][x] = RedBuildingsFactory.createRedBuilding(position, redBuildingCard);
                        break;
                    case "Tavern":
                        squares[y][x] = GreenBuildingsFactory.createGreenBuilding(position, greenBuildingCard);
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
