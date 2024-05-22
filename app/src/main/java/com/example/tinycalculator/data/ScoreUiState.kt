package com.example.tinycalculator.data

import com.example.tinycalculator.Domain.Board
import com.example.tinycalculator.Domain.OrangeBuildings.OrangeBuilding
import com.example.tinycalculator.Enums.GreyEnum
import com.example.tinycalculator.Enums.OrangeEnum
import com.example.tinycalculator.Enums.RedEnum
import com.example.tinycalculator.Enums.YellowEnum

data class ScoreUiState(
    val rawScoreString: String = "",
    val board: Board? = null,
    val monumentInGame: Boolean = false,

    val monumentName: String = "",
    val redBuildingName: String = RedEnum.Greenhouse.name,
    val orangeBuildingName: String = OrangeEnum.Chapel.name,
    val yellowBuildingName: String = YellowEnum.Theater.name,
    val greyBuildingName: String = GreyEnum.Millstone.name,

    val scoreChapels: Int = 0,
    val scoreCottages: Int = 0,
    val penaltyEmptySquare: Int = 0,
    val scoreTaverns: Int = 0,
    val scoreTheaters: Int = 0,
    val scoreWells: Int = 0,
    val scoreMonument: Int = 0,
    val totalScore: Int = 0,
)