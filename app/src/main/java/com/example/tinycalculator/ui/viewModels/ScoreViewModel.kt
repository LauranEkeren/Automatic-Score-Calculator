package com.example.tinycalculator.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.tinycalculator.Domain.Board
import com.example.tinycalculator.Enums.PurpleEnum
import com.example.tinycalculator.data.ScoreUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ScoreViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ScoreUiState())
    val uiState: StateFlow<ScoreUiState> = _uiState.asStateFlow()

    fun jsonStringReceived(rawStringBoard: String){
        _uiState.update {currentState ->
            currentState.copy(rawScoreString = rawStringBoard)
        }
    }

    fun monumentCardSelected(monumentNameSelected: String){
        var isMonumentInGame = false;
        if (monumentNameSelected != PurpleEnum.NoPurpleBuilding.name){
            isMonumentInGame = true
        }
        Log.d("Info", _uiState.value.rawScoreString)
        _uiState.update {currentState ->
            currentState.copy(
                monumentName = monumentNameSelected,
                monumentInGame = isMonumentInGame
            )
        }
        Log.d("Info", _uiState.value.rawScoreString)

    }

    fun calculateScore(){
        val cards = HashMap<String, String>()
        cards["Monument"] = _uiState.value.monumentName
        Log.d("Domain", cards["Monument"].toString())
        val rawStringBoard = _uiState.value.rawScoreString
        val board = Board(rawStringBoard, cards)
        val points = board.calculateScore()
        _uiState.update {
            ScoreUiState(
                rawScoreString = rawStringBoard,
                board = board,
                monumentInGame = points.containsKey("Monument"),
                scoreChapels = points["Chapel"] ?: 0,
                scoreCottages = points["Cottage"] ?: 0,
                penaltyEmptySquare =  points["EmptyPenalty"] ?: 0,
                scoreTaverns = points["Tavern"] ?: 0,
                scoreTheaters = points["Theater"] ?: 0,
                scoreWells = points["Well"] ?: 0,
                scoreMonument = points["Monument"] ?: 0,
                totalScore = points["TotalScore"] ?:0
            )
        }
    }

}