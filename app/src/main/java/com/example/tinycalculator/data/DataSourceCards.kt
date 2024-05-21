package com.example.tinycalculator.data

import com.example.tinycalculator.Enums.PurpleEnum
import com.example.tinycalculator.Enums.YellowEnum
import com.example.tinycalculator.R
import com.example.tinycalculator.model.BuildingCard

object DataSourceCards {
    val monumentCards = listOf(
        BuildingCard(PurpleEnum.NoPurpleBuilding.name, R.drawable.placeholder),
        BuildingCard(PurpleEnum.ArchitectGuild.name, R.drawable.monument_architect_guild),
        BuildingCard(PurpleEnum.ArchiveOfTheSecondAge.name, R.drawable.monument_archive_of_the_second_age),
        BuildingCard(PurpleEnum.BarettCastle.name, R.drawable.monument_barett_castle),
        BuildingCard(PurpleEnum.CathedralOfCaterina.name, R.drawable.monument_cathedral_of_caterina),
        BuildingCard(PurpleEnum.FortIronweed.name, R.drawable.monument_fort_ironweed),
        BuildingCard(PurpleEnum.GrandMausoleumOfTheRodina.name, R.drawable.monument_grand_mausoleum_of_the_rodina),
        BuildingCard(PurpleEnum.GroveUniversity.name, R.drawable.monument_grove_university),
        BuildingCard(PurpleEnum.MandrasPalace.name, R.drawable.monument_mandras_palace),
        BuildingCard(PurpleEnum.ObeliskOfTheCrescent.name, R.drawable.monument_obelisk_of_the_crescent),
        BuildingCard(PurpleEnum.OpaleyesWatch.name, R.drawable.monument_opal_eyes_watch),
        BuildingCard(PurpleEnum.ShrineOfTheElderTree.name, R.drawable.monument_shrine_of_the_elder_tree),
        BuildingCard(PurpleEnum.SilvaForum.name, R.drawable.monument_silva_forum),
        BuildingCard(PurpleEnum.TheSkyBaths.name, R.drawable.monument_the_sky_baths),
        BuildingCard(PurpleEnum.TheStarloom.name, R.drawable.monument_the_starloom),
        BuildingCard(PurpleEnum.StatueOfTheBondmaker.name, R.drawable.monument_statue_of_the_bondmaker),
    )

    val yellowBuildingCards = listOf(
        BuildingCard(YellowEnum.Theater.name, R.drawable.placeholder),
        BuildingCard(YellowEnum.Bakery.name, R.drawable.placeholder),
        BuildingCard(YellowEnum.Market.name, R.drawable.placeholder),
        BuildingCard(YellowEnum.Tailor.name, R.drawable.placeholder),
        )
}