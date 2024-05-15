package com.example.tinycalculator.data

import com.example.tinycalculator.Domain.Board

data class ScoreUiState(
    val rawScoreString: String = "",
    val board: Board? = null,
    val scoreChapels: Int = 0,
    val scoreCottages: Int = 0,
    val penaltyEmptySquare: Int = 0,
    val scoreTaverns: Int = 0,
    val scoreTheaters: Int = 0,
    val scoreWells: Int = 0,
    val totalScore: Int = 0
)