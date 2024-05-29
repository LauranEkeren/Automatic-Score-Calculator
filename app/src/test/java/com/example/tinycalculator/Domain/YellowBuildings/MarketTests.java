package com.example.tinycalculator.Domain.YellowBuildings;

import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.Board;
import com.example.tinycalculator.Enums.BlackEnum;
import com.example.tinycalculator.Enums.GreenEnum;
import com.example.tinycalculator.Enums.GreyEnum;
import com.example.tinycalculator.Enums.OrangeEnum;
import com.example.tinycalculator.Enums.PurpleEnum;
import com.example.tinycalculator.Enums.RedEnum;
import com.example.tinycalculator.Enums.SquareEnum;
import com.example.tinycalculator.Enums.YellowEnum;

import org.junit.Before;
import org.junit.Test;

public class MarketTests {
    Board boardOneMarket;
    Board boardMoreMarketInRow;
    Board boardMoreMarketInColumn;
    Board boardFiveMarkets;

    @Before
    public void createBoards(){
        PurpleEnum purpleEnum = PurpleEnum.BarettCastle;
        RedEnum redEnum = RedEnum.Farm;
        OrangeEnum orangeEnum = OrangeEnum.Chapel;
        YellowEnum yellowEnum = YellowEnum.Market;
        GreyEnum greyEnum = GreyEnum.Fountain;
        GreenEnum greenEnum = GreenEnum.Inn;
        BlackEnum blackEnum = BlackEnum.TradingPost;

        String stringOneMarket =
                "Empty, Empty, Empty, Empty," +
                "Empty, Theater, Empty, Farm," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardOneMarket = new Board(stringOneMarket,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringMoreMarketInRow =
                "Empty, Theater, Empty, Empty," +
                "Theater, Theater, Empty, Farm," +
                "Empty, Theater, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardMoreMarketInRow = new Board(stringMoreMarketInRow,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringMoreMarketInColumn =
                "Empty, Theater, Empty, Empty," +
                "Theater, Theater, Theater, Theater," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Empty, Empty, Empty";
        boardMoreMarketInColumn = new Board(stringMoreMarketInColumn,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );

        String stringFiveMarkets =
                "Empty, Theater, Empty, Empty," +
                "Theater, Theater, Empty, Theater," +
                "Empty, Empty, Empty, Empty," +
                "Empty, Theater, Empty, Empty";
        boardFiveMarkets = new Board(stringFiveMarkets,
                purpleEnum, redEnum, orangeEnum, yellowEnum, greyEnum,
                greenEnum, blackEnum, 0, 0,
                0, 0
        );
    }

    @Test
    public void Market_HasCorrectSquareType(){
        Market market = new Market(Pair.create(1,2));
        assertEquals(SquareEnum.YellowBuilding, market.squareType);
    }

    @Test
    public void Market_HasCorrectPosition(){
        Market market = new Market(Pair.create(1,2));
        assertEquals(Pair.create(1,2), market.position);
    }

    @Test
    public void Market_HasCorrectYellowEnum(){
        Market market = new Market(Pair.create(3,3));
        assertEquals(YellowEnum.Market, market.yellowBuildingType);
    }

    @Test
    public void getScoreMarket_OneMarket(){
        Market market = new Market(Pair.create(1,1));
        int score = market.getScoreMarket(boardOneMarket);
        assertEquals(1, score);
    }

    @Test
    public void getScoreMarket_MoreMarketInRow(){
        Market market = new Market(Pair.create(1,1));
        int score = market.getScoreMarket(boardMoreMarketInRow);
        assertEquals(3, score);
    }

    @Test
    public void getScoreMarket_MoreMarketInColumn(){
        Market market = new Market(Pair.create(1,1));
        int score = market.getScoreMarket(boardMoreMarketInColumn);
        assertEquals(4, score);
    }

    @Test
    public void getScore_OneMarket(){
        Market market = new Market(Pair.create(1,1));
        int score = market.getScore(boardOneMarket);
        assertEquals(1, score);
    }

    @Test
    public void getScore_MoreMarketInRow(){
        Market market = new Market(Pair.create(1,1));
        int score = market.getScore(boardMoreMarketInRow);
        assertEquals(11, score);
    }

    @Test
    public void getScore_MoreMarketInColumn(){
        Market market = new Market(Pair.create(1,1));
        int score = market.getScore(boardMoreMarketInColumn);
        assertEquals(18, score);
    }

    @Test
    public void getScore_FiveMarkets(){
        Market market = new Market(Pair.create(1,1));
        int score = market.getScore(boardFiveMarkets);
        assertEquals(15, score);
    }
}
