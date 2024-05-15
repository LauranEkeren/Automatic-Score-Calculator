package com.example.tinycalculator.ui.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.tinycalculator.Domain.Board
import com.example.tinycalculator.data.ScoreUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ScoreViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ScoreUiState())
    val uiState: StateFlow<ScoreUiState> = _uiState.asStateFlow()

    fun setScore(rawStringBoard: String){
        val board = Board(rawStringBoard)
        val points = board.calculateScore()
        _uiState.update {
            ScoreUiState(
                rawScoreString = rawStringBoard,
                board = board,
                scoreChapels = points["Chapel"] ?: 0,
                scoreCottages = points["Cottage"] ?: 0,
                penaltyEmptySquare =  points["EmptyPenalty"] ?: 0,
                scoreTaverns = points["Tavern"] ?: 0,
                scoreTheaters = points["Theater"] ?: 0,
                scoreWells = points["Well"] ?: 0,
                totalScore = points["TotalScore"] ?:0
            )
        }
    }

}