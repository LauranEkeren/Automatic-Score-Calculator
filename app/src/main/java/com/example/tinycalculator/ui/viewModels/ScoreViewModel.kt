package com.example.tinycalculator.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.tinycalculator.Domain.Board
import com.example.tinycalculator.Enums.BlackEnum
import com.example.tinycalculator.Enums.GreenEnum
import com.example.tinycalculator.Enums.GreyEnum
import com.example.tinycalculator.Enums.OrangeEnum
import com.example.tinycalculator.Enums.PurpleEnum
import com.example.tinycalculator.Enums.RedEnum
import com.example.tinycalculator.Enums.YellowEnum
import com.example.tinycalculator.data.ScoreUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ScoreViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ScoreUiState())
    val uiState: StateFlow<ScoreUiState> = _uiState.asStateFlow()

    fun resetScore() {
        _uiState.value = ScoreUiState()
    }

    fun jsonStringReceived(rawStringBoard: String){
        _uiState.update {currentState ->
            currentState.copy(rawScoreString = rawStringBoard)
        }
    }

    fun redBuildingCardSelected(redBuildingNameSelected: String){
        _uiState.update { currentState ->
            currentState.copy(
                redBuildingName = redBuildingNameSelected
            )
        }
    }

    fun orangeBuildingCardSelected(orangeBuildingNameSelected: String){
        _uiState.update { currentState ->
            currentState.copy(
                orangeBuildingName = orangeBuildingNameSelected
            )
        }
    }

    fun greenBuildingCardSelected(greenBuildingNameSelected: String){
        _uiState.update { currentState ->
            currentState.copy(
                greenBuildingName = greenBuildingNameSelected
            )
        }
    }

    fun yellowBuildingCardSelected(yellowBuildingNameSelected: String){
        _uiState.update {currentState ->
            currentState.copy(
                yellowBuildingName = yellowBuildingNameSelected
            )
        }
    }

    fun greyBuildingCardSelected(greyBuildingNameSelected: String){
        _uiState.update { currentState ->
            currentState.copy(
                greyBuildingName = greyBuildingNameSelected
            )
        }
    }

    fun blackBuildingCardSelected(blackBuildingNameSelected: String){
        _uiState.update { currentState ->
            currentState.copy(
                blackBuildingName = blackBuildingNameSelected
            )
        }
    }

    fun monumentCardSelected(monumentNameSelected: String){
        var isMonumentInGame = false
        if (monumentNameSelected != PurpleEnum.NoPurpleBuilding.name){
            isMonumentInGame = true
        }
        _uiState.update {currentState ->
            currentState.copy(
                monumentName = monumentNameSelected,
                monumentInGame = isMonumentInGame
            )
        }
    }

    fun amountOnWareHouseIncreased(){
        val currentAmountOnWarehouse = _uiState.value.amountOnWarehouse
        if (currentAmountOnWarehouse < 48){
            _uiState.update {currentState ->
                currentState.copy(
                    amountOnWarehouse = currentAmountOnWarehouse + 1
                )
            }
        }
    }

    fun amountOnWareHouseDecreased(){
        val currentAmountOnWarehouse = _uiState.value.amountOnWarehouse
        if (currentAmountOnWarehouse > 0){
            _uiState.update {currentState ->
                currentState.copy(
                    amountOnWarehouse = currentAmountOnWarehouse - 1
                )
            }
        }
    }

    fun amountOnNeighboursBoardIncreased(){
        val currentAmountOnNeighboursBoard = _uiState.value.amountFeastHallOnNeighboursBoard
        if (currentAmountOnNeighboursBoard < 16){
            _uiState.update {currentState ->
                currentState.copy(
                    amountFeastHallOnNeighboursBoard = currentAmountOnNeighboursBoard + 1
                )
            }
        }
    }

    fun amountOnNeighboursBoardDecreased(){
        val currentAmountOnNeighboursBoard = _uiState.value.amountFeastHallOnNeighboursBoard
        if (currentAmountOnNeighboursBoard > 0){
            _uiState.update {currentState ->
                currentState.copy(
                    amountFeastHallOnNeighboursBoard = currentAmountOnNeighboursBoard - 1
                )
            }
        }
    }

    fun amountStarloomIncreased(){
        val currentStarloom = _uiState.value.amountStarloom
        if (currentStarloom < 6){
            _uiState.update {currentState ->
                currentState.copy(
                    amountStarloom = currentStarloom + 1
                )
            }
        }
    }

    fun amountStarloomDecreased(){
        val currentStarloom = _uiState.value.amountStarloom
        if (currentStarloom > 1){
            _uiState.update {currentState ->
                currentState.copy(
                    amountStarloom = currentStarloom - 1
                )
            }
        }
    }

    fun amountTreeIncreased(){
        val currentTree = _uiState.value.amountTree
        if (currentTree < 14){
            _uiState.update {currentState ->
                currentState.copy(
                    amountTree = currentTree + 1
                )
            }
        }
    }

    fun amountTreeDecreased(){
        val currentTree = _uiState.value.amountTree
        if (currentTree > 1){
            _uiState.update {currentState ->
                currentState.copy(
                    amountTree = currentTree - 1
                )
            }
        }
    }

    fun calculateScore(){
        Log.d("Test","calculateScore")
        val monumentCard = PurpleEnum.valueOf(_uiState.value.monumentName)
        val redCard = RedEnum.valueOf(_uiState.value.redBuildingName)
        val orangeCard = OrangeEnum.valueOf(_uiState.value.orangeBuildingName)
        val yellowCard = YellowEnum.valueOf(_uiState.value.yellowBuildingName)
        val greyCard = GreyEnum.valueOf(_uiState.value.greyBuildingName)
        val greenCard = GreenEnum.valueOf(_uiState.value.greenBuildingName)
        val blackBuildingCard = BlackEnum.valueOf(_uiState.value.blackBuildingName)

        val rawStringBoard = _uiState.value.rawScoreString
        val wareHouseNumber = _uiState.value.amountOnWarehouse
        val amountFeastHallNeighbours = _uiState.value.amountFeastHallOnNeighboursBoard
        val amountStarloom = _uiState.value.amountStarloom
        val amountTree = _uiState.value.amountTree
        val board = Board(rawStringBoard, monumentCard, redCard, orangeCard,
            yellowCard, greyCard, greenCard, blackBuildingCard,
            wareHouseNumber, amountFeastHallNeighbours, amountStarloom,
            amountTree)
        val points = board.calculateScore()
        _uiState.update {currentState ->
            currentState.copy(
                rawScoreString = rawStringBoard,
                board = board,
                monumentInGame = points.containsKey("Monument"),
                scoreChapels = points["Chapel"] ?: 0,
                scoreCottages = points["Cottage"] ?: 0,
                penaltyEmptySquare =  points["EmptyPenalty"] ?: 0,
                scoreTaverns = points["Tavern"] ?: 0,
                scoreTheaters = points["Theater"] ?: 0,
                scoreWells = points["Well"] ?: 0,
                scoreFactories = points["Factory"] ?: 0,
                scoreMonument = points["Monument"] ?: 0,
                totalScore = points["TotalScore"] ?:0
            )
        }
    }

}