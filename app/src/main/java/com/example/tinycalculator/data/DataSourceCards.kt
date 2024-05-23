package com.example.tinycalculator.data

import com.example.tinycalculator.Enums.BlackEnum
import com.example.tinycalculator.Enums.GreenEnum
import com.example.tinycalculator.Enums.GreyEnum
import com.example.tinycalculator.Enums.OrangeEnum
import com.example.tinycalculator.Enums.PurpleEnum
import com.example.tinycalculator.Enums.RedEnum
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

    val greyBuildingCards = listOf(
        BuildingCard(GreyEnum.Well.name, R.drawable.placeholder),
        BuildingCard(GreyEnum.Fountain.name, R.drawable.placeholder),
        BuildingCard(GreyEnum.Millstone.name, R.drawable.placeholder),
        BuildingCard(GreyEnum.Shed.name, R.drawable.placeholder),
        )

    val orangeBuildingCards = listOf(
        BuildingCard(OrangeEnum.Chapel.name, R.drawable.placeholder),
        BuildingCard(OrangeEnum.Abbey.name, R.drawable.placeholder),
        BuildingCard(OrangeEnum.Cloister.name, R.drawable.placeholder),
        BuildingCard(OrangeEnum.Temple.name, R.drawable.placeholder),
        )

    val redBuildingCards = listOf(
        BuildingCard(RedEnum.Farm.name, R.drawable.placeholder),
        BuildingCard(RedEnum.Granary.name, R.drawable.placeholder),
        BuildingCard(RedEnum.Greenhouse.name, R.drawable.placeholder),
        BuildingCard(RedEnum.Orchard.name, R.drawable.placeholder),
        )

    val greenBuildingCards = listOf(
        BuildingCard(GreenEnum.Tavern.name, R.drawable.placeholder),
        BuildingCard(GreenEnum.Almshouse.name, R.drawable.placeholder),
        BuildingCard(GreenEnum.FeastHall.name, R.drawable.placeholder),
        BuildingCard(GreenEnum.Inn.name, R.drawable.placeholder),
        )

    val blackBuildingCards = listOf(
        BuildingCard(BlackEnum.Factory.name, R.drawable.placeholder),
        BuildingCard(BlackEnum.Bank.name, R.drawable.placeholder),
        BuildingCard(BlackEnum.TradingPost.name, R.drawable.placeholder),
        BuildingCard(BlackEnum.Warehouse.name, R.drawable.placeholder),
        )
}