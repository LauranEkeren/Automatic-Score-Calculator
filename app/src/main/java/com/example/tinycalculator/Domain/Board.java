package com.example.tinycalculator.Domain;

import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Board {
    //TODO: make properties private?
    //TODO: Make lists for the buildings?
    private final Square[][] squares = new Square[4][4];
    private final List<Square> squareList;

    public Board(String stringFromApi){
        String[] stringObjects = getStringArrayFromJsonString(stringFromApi);
        placeBuildingsInGridFromArray(stringObjects);
        squareList = returnSquaresAsList();
    }

    public Square[][] getSquares() {
        return squares;
    }
    public List<Square> getSquaresAsList(){return squareList;}

    public HashMap<String, Integer> calculateScore(){
        Log.d("Info", "From Board.java: calculateScore line 30");
        Log.d("Domain", squaresToString());
        HashMap<String, Integer> points = new HashMap<>();
        int totalScore = 0;

        Farm.feedCottages(this);
        points.put("Chapel", Chapel.getScoreChapels(this));
        points.put("Cottage", Cottage.getScoreCottages(this));
        points.put("EmptyPenalty", EmptySquare.getPenaltyEmptySquares(this));
        points.put("Tavern", Tavern.getScoreTaverns(this));
        points.put("Theater", Theater.getScoreTheaters(this));
        points.put("Well", Well.getScoreWells(this));

        for (int i : points.values()){
            totalScore += i;
        }
        points.put("TotalScore", totalScore);
        return points;
    }

    public String squaresToString(){
        StringBuilder stringBuilder = new StringBuilder("Objects:\n");
        for (int y = 0; y < 4; y++){
            for (int x = 0; x < 4; x++){
                stringBuilder.append(squares[y][x].squareType);
                stringBuilder.append(" ,");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    private String[] getStringArrayFromJsonString(String jsonString){
        //TODO: Proper json conversion
        jsonString = jsonString.replace("[", "");
        jsonString = jsonString.replace("]", "");
        jsonString = jsonString.replace(" ", "");
        jsonString = jsonString.replace("\"", "");

        return jsonString.split(",");
    }

    private void placeBuildingsInGridFromArray(String[] stringObjects){
        int total = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++){
                Pair<Integer, Integer> position = Pair.create(y, x);
                switch (stringObjects[total]){
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
                        squares[y][x] = new Theater(position);
                        break;
                    case "Well":
                        squares[y][x] = new Well(position);
                        break;
                    default:
                        squares[y][x] = new EmptySquare(position);
                }
                total++;
            }
        }
    }

    private List<Square> returnSquaresAsList(){
        List<Square> squareList = new ArrayList<>();
        for (Square[] squareArray: this.getSquares()) {
            squareList.addAll(Arrays.asList(squareArray));
        }
        return squareList;
    }
}
