package com.example.tinycalculator.ui.viewModels

import com.example.tinycalculator.Enums.BlackEnum
import com.example.tinycalculator.Enums.GreenEnum
import com.example.tinycalculator.Enums.GreyEnum
import com.example.tinycalculator.Enums.OrangeEnum
import com.example.tinycalculator.Enums.PurpleEnum
import com.example.tinycalculator.Enums.RedEnum
import com.example.tinycalculator.Enums.YellowEnum
import com.example.tinycalculator.data.ScoreUiState
import com.example.tinycalculator.ui.viewModels.ScoreViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ScoreViewModelTest {
    private val viewModel = ScoreViewModel()

    @Test
    fun scoreViewModel_JsonStringReceived_UpdateRawScoreString(){
        val jsonString = "test jsonString"

        viewModel.jsonStringReceived(jsonString)
        val currentScoreUiState: ScoreUiState = viewModel.uiState.value
        assertEquals(jsonString, currentScoreUiState.rawScoreString)
    }

    @Test
    fun scoreViewModel_RedBuildingCardSelected_UpdateRedBuildingName(){
        val redBuildingName = RedEnum.Farm.name
        viewModel.redBuildingCardSelected(redBuildingName)
        val currentScoreUiState = viewModel.uiState.value
        assertEquals(RedEnum.Farm.name, currentScoreUiState.redBuildingName)
    }

    @Test
    fun scoreViewModel_OrangeBuildingCardSelected_UpdateOrangeBuildingName(){
        val orangeBuildingName = OrangeEnum.Cloister.name
        viewModel.orangeBuildingCardSelected(orangeBuildingName)
        val currentScoreUiState = viewModel.uiState.value
        assertEquals(OrangeEnum.Cloister.name, currentScoreUiState.orangeBuildingName)
    }

    @Test
    fun scoreViewModel_GreenBuildingCardSelected_UpdateGreenBuildingName(){
        val greenBuildingName = GreenEnum.Inn.name
        viewModel.greenBuildingCardSelected(greenBuildingName)
        val currentScoreUiState = viewModel.uiState.value
        assertEquals(GreenEnum.Inn.name, currentScoreUiState.greenBuildingName)
    }

    @Test
    fun scoreViewModel_YellowBuildingCardSelected_UpdateYellowBuildingName(){
        val yellowBuildingName = YellowEnum.Bakery.name
        viewModel.yellowBuildingCardSelected(yellowBuildingName)
        val currentScoreUiState = viewModel.uiState.value
        assertEquals(YellowEnum.Bakery.name, currentScoreUiState.yellowBuildingName)
    }

    @Test
    fun scoreViewModel_blackBuildingCardSelected_UpdateBlackBuilding(){
        val blackBuildingName = BlackEnum.Factory.name
        viewModel.blackBuildingCardSelected(blackBuildingName)
        val currentScoreUiState = viewModel.uiState.value
        assertEquals(BlackEnum.Factory.name, currentScoreUiState.blackBuildingName)
    }

    @Test
    fun scoreViewModel_MonumentCardSelected_UpdatePurpleBuilding(){
        val purpleBuildingName = PurpleEnum.TheStarloom.name
        viewModel.monumentCardSelected(purpleBuildingName)
        val currentScoreUiState = viewModel.uiState.value
        assertEquals(PurpleEnum.TheStarloom.name, currentScoreUiState.monumentName)
        assertTrue(currentScoreUiState.monumentInGame)
    }

    @Test
    fun scoreViewModel_MonumentCardSelected_UpdatePurpleBuildingWithFalse(){
        val purpleBuildingName = PurpleEnum.NoPurpleBuilding.name
        viewModel.monumentCardSelected(purpleBuildingName)
        val currentScoreUiState = viewModel.uiState.value
        assertEquals(PurpleEnum.NoPurpleBuilding.name, currentScoreUiState.monumentName)
        assertFalse(currentScoreUiState.monumentInGame)
    }

    @Test
    fun scoreViewModel_AmountOnWareHouseIncreased_MustIncreaseWithOneAndNotGoOver48(){
        var expectedScore = 0
        var currentScoreUiState = viewModel.uiState.value
        assertEquals(0, currentScoreUiState.amountOnWarehouse)
        repeat(48){
            expectedScore += 1
            viewModel.amountOnWareHouseIncreased()
            currentScoreUiState = viewModel.uiState.value
            assertEquals(expectedScore, currentScoreUiState.amountOnWarehouse)
        }
        viewModel.amountOnWareHouseIncreased()
        currentScoreUiState = viewModel.uiState.value
        assertEquals(48, currentScoreUiState.amountOnWarehouse)
    }

    @Test
    fun scoreViewModel_AmountOnWareHouseDecreased_MustDecreaseWithOneAndNotGoBelow0(){
        repeat(48){
            viewModel.amountOnWareHouseIncreased()
        }
        var currentScoreUiState = viewModel.uiState.value
        assertEquals(48, currentScoreUiState.amountOnWarehouse)
        var expectedScore = 48
        repeat(48){
            expectedScore -= 1
            viewModel.amountOnWareHouseDecreased()
            currentScoreUiState = viewModel.uiState.value
            assertEquals(expectedScore, currentScoreUiState.amountOnWarehouse)
        }
        viewModel.amountOnWareHouseDecreased()
        currentScoreUiState = viewModel.uiState.value
        assertEquals(0, currentScoreUiState.amountOnWarehouse)
    }

    @Test
    fun scoreViewModel_AmountOnNeighboursBoardIncreased_MustNotIncreaseAbove16(){
        var expectedScore = 0
        var currentScoreUiState = viewModel.uiState.value
        assertEquals(0, currentScoreUiState.amountFeastHallOnNeighboursBoard)
        repeat(16){
            expectedScore += 1
            viewModel.amountOnNeighboursBoardIncreased()
            currentScoreUiState = viewModel.uiState.value
            assertEquals(expectedScore, currentScoreUiState.amountFeastHallOnNeighboursBoard)
        }
        viewModel.amountOnNeighboursBoardIncreased()
        currentScoreUiState = viewModel.uiState.value
        assertEquals(16, currentScoreUiState.amountFeastHallOnNeighboursBoard)
    }

    @Test
    fun scoreViewModel_AmountOnNeighboursBoardDecreased_MustDecreaseWithOneAndNotGoBelow0(){
        repeat(16){
            viewModel.amountOnNeighboursBoardIncreased()
        }
        var currentScoreUiState = viewModel.uiState.value
        assertEquals(16, currentScoreUiState.amountFeastHallOnNeighboursBoard)
        var expectedScore = 16
        repeat(16){
            expectedScore -= 1
            viewModel.amountOnNeighboursBoardDecreased()
            currentScoreUiState = viewModel.uiState.value
            assertEquals(expectedScore, currentScoreUiState.amountFeastHallOnNeighboursBoard)
        }
        viewModel.amountOnNeighboursBoardDecreased()
        currentScoreUiState = viewModel.uiState.value
        assertEquals(0, currentScoreUiState.amountFeastHallOnNeighboursBoard)
    }

    @Test
    fun scoreViewModel_AmountStarloomIncreased_MustNotIncreaseAbove6(){
        var expectedScore = 1
        var currentScoreUiState = viewModel.uiState.value
        assertEquals(expectedScore, currentScoreUiState.amountStarloom)
        repeat(5){
            expectedScore += 1
            viewModel.amountStarloomIncreased()
            currentScoreUiState = viewModel.uiState.value
            assertEquals(expectedScore, currentScoreUiState.amountStarloom)
        }
        viewModel.amountStarloomIncreased()
        currentScoreUiState = viewModel.uiState.value
        assertEquals(6, currentScoreUiState.amountStarloom)
    }

    @Test
    fun scoreViewModel_AmountStarloomDecreased_MustDecreaseWithOneAndNotGoBelow0(){
        repeat(5){
            viewModel.amountStarloomIncreased()
        }
        var currentScoreUiState = viewModel.uiState.value
        var expectedScore = 6
        assertEquals(expectedScore, currentScoreUiState.amountStarloom)
        repeat(5){
            expectedScore -= 1
            viewModel.amountStarloomDecreased()
            currentScoreUiState = viewModel.uiState.value
            assertEquals(expectedScore, currentScoreUiState.amountStarloom)
        }
        viewModel.amountStarloomDecreased()
        currentScoreUiState = viewModel.uiState.value
        assertEquals(1, currentScoreUiState.amountStarloom)
    }

    @Test
    fun scoreViewModel_AmountTreeIncreased_MustNotIncreaseAbove16(){
        var expectedScore = 1
        var currentScoreUiState = viewModel.uiState.value
        assertEquals(expectedScore, currentScoreUiState.amountTree)
        repeat(15){
            expectedScore += 1
            viewModel.amountTreeIncreased()
            currentScoreUiState = viewModel.uiState.value
            assertEquals(expectedScore, currentScoreUiState.amountTree)
        }
        viewModel.amountTreeIncreased()
        currentScoreUiState = viewModel.uiState.value
        assertEquals(16, currentScoreUiState.amountTree)
    }

    @Test
    fun scoreViewModel_AmountTreeDecreased_MustDecreaseWithOneAndNotGoBelow0(){
        repeat(15){
            viewModel.amountTreeIncreased()
        }
        var currentScoreUiState = viewModel.uiState.value
        var expectedScore = 16
        assertEquals(expectedScore, currentScoreUiState.amountTree)
        repeat(15){
            expectedScore -= 1
            viewModel.amountTreeDecreased()
            currentScoreUiState = viewModel.uiState.value
            assertEquals(expectedScore, currentScoreUiState.amountTree)
        }
        viewModel.amountTreeDecreased()
        currentScoreUiState = viewModel.uiState.value
        assertEquals(1, currentScoreUiState.amountTree)
    }

    @Test
    fun scoreViewModel_calculateScore_ShouldReturnCorrectScoreWithNoMonument(){
        viewModel.monumentCardSelected(PurpleEnum.NoPurpleBuilding.name)
        viewModel.redBuildingCardSelected(RedEnum.Farm.name)
        viewModel.orangeBuildingCardSelected(OrangeEnum.Chapel.name)
        viewModel.yellowBuildingCardSelected(YellowEnum.Theater.name)
        viewModel.greyBuildingCardSelected(GreyEnum.Well.name)
        viewModel.greenBuildingCardSelected(GreenEnum.Tavern.name)
        viewModel.blackBuildingCardSelected(BlackEnum.Factory.name)

        val jsonString =
                "Cottage, Well, Cottage, Factory," +
                "Well, Cottage, Empty, Empty," +
                "Theater, Farm, Tavern, Tavern," +
                "Chapel, Cottage, Well, Factory"
        viewModel.jsonStringReceived(jsonString)

        viewModel.calculateScore()
        val currentScoreUiState = viewModel.uiState.value
        assertEquals(jsonString, currentScoreUiState.rawScoreString)
        assertFalse(currentScoreUiState.monumentInGame)
        assertEquals(4, currentScoreUiState.scoreChapels)
        assertEquals(12, currentScoreUiState.scoreCottages)
        assertEquals(-2, currentScoreUiState.penaltyEmptySquare)
        assertEquals(5, currentScoreUiState.scoreTaverns)
        assertEquals(5, currentScoreUiState.scoreTheaters)
        assertEquals(6, currentScoreUiState.scoreWells)
        assertEquals(0, currentScoreUiState.scoreFactories)
        assertEquals(0, currentScoreUiState.scoreMonument)
        assertEquals(30, currentScoreUiState.totalScore)
    }

    @Test
    fun scoreViewModel_calculateScore_ShouldReturnCorrectScoreWithMonument(){
        viewModel.monumentCardSelected(PurpleEnum.CathedralOfCaterina.name)
        viewModel.redBuildingCardSelected(RedEnum.Greenhouse.name)
        viewModel.orangeBuildingCardSelected(OrangeEnum.Abbey.name)
        viewModel.yellowBuildingCardSelected(YellowEnum.Market.name)
        viewModel.greyBuildingCardSelected(GreyEnum.Well.name)
        viewModel.greenBuildingCardSelected(GreenEnum.Almshouse.name)
        viewModel.blackBuildingCardSelected(BlackEnum.Bank.name)

        val jsonString =
            "Farm, Monument, Empty, Theater," +
            "Cottage, Cottage, Well, Theater," +
            "Cottage, Well, Theater, Theater," +
            "Chapel, Empty, Factory, Tavern"
        viewModel.jsonStringReceived(jsonString)

        viewModel.calculateScore()
        val currentScoreUiState = viewModel.uiState.value
        assertEquals(jsonString, currentScoreUiState.rawScoreString)
        assertTrue(currentScoreUiState.monumentInGame)
        assertEquals(3, currentScoreUiState.scoreChapels)
        assertEquals(9, currentScoreUiState.scoreCottages)
        assertEquals(0, currentScoreUiState.penaltyEmptySquare)
        assertEquals(-1, currentScoreUiState.scoreTaverns)
        assertEquals(11, currentScoreUiState.scoreTheaters)
        assertEquals(3, currentScoreUiState.scoreWells)
        assertEquals(4, currentScoreUiState.scoreFactories)
        assertEquals(2, currentScoreUiState.scoreMonument)
        assertEquals(31, currentScoreUiState.totalScore)
    }

}