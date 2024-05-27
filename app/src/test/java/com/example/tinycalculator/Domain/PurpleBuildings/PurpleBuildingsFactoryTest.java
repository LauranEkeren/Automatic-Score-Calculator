package com.example.tinycalculator.Domain.PurpleBuildings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import androidx.core.util.Pair;

import com.example.tinycalculator.Domain.EmptySquare;
import com.example.tinycalculator.Domain.Square;
import com.example.tinycalculator.Enums.PurpleEnum;

import org.junit.Test;

public class PurpleBuildingsFactoryTest {
    @Test
    public void createSquare_ShouldCreateArchitectGuild(){
        Square architectGuild = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.ArchitectGuild);
        assertEquals(Pair.create(0,0), architectGuild.position);
        assertThat(architectGuild, instanceOf(ArchitectsGuild.class));
    }
    
    @Test
    public void createSquare_ShouldCreateArchiveOfTheSecondAge(){
        Square archiveOfTheSecondAge = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.ArchiveOfTheSecondAge);
        assertEquals(Pair.create(0,0), archiveOfTheSecondAge.position);
        assertThat(archiveOfTheSecondAge, instanceOf(ArchiveOfTheSecondAge.class));
    }

    @Test
    public void createSquare_ShouldCreateBarrettCastle(){
        Square barrettCastle = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.BarettCastle);
        assertEquals(Pair.create(0,0), barrettCastle.position);
        assertThat(barrettCastle, instanceOf(BarettCastle.class));
    }
    
    @Test
    public void createSquare_ShouldCreateCathedralOfCaterina(){
        Square cathedralOfCaterina = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.CathedralOfCaterina);
        assertEquals(Pair.create(0,0), cathedralOfCaterina.position);
        assertThat(cathedralOfCaterina, instanceOf(CathedralOfCaterina.class));
    }

    @Test
    public void createSquare_ShouldCreateFortIronweed(){
        Square fortIronweed = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.FortIronweed);
        assertEquals(Pair.create(0,0), fortIronweed.position);
        assertThat(fortIronweed, instanceOf(FortIronweed.class));
    }

    @Test
    public void createSquare_ShouldCreateGrandMausoleumOfTheRodina(){
        Square grandMausoleumOfTheRodina = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.GrandMausoleumOfTheRodina);
        assertEquals(Pair.create(0,0), grandMausoleumOfTheRodina.position);
        assertThat(grandMausoleumOfTheRodina, instanceOf(GrandMausoleumOfTheRodina.class));
    }

    @Test
    public void createSquare_ShouldCreateGroveUniversity(){
        Square groveUniversity = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.GroveUniversity);
        assertEquals(Pair.create(0,0), groveUniversity.position);
        assertThat(groveUniversity, instanceOf(GroveUniversity.class));
    }

    @Test
    public void createSquare_ShouldCreateMandrasPalace(){
        Square mandrasPalace = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.MandrasPalace);
        assertEquals(Pair.create(0,0), mandrasPalace.position);
        assertThat(mandrasPalace, instanceOf(MandrasPalace.class));
    }

    @Test
    public void createSquare_ShouldCreateShrineOfTheElderTree(){
        Square shrineOfTheElderTree = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.ShrineOfTheElderTree);
        assertEquals(Pair.create(0,0), shrineOfTheElderTree.position);
        assertThat(shrineOfTheElderTree, instanceOf(ShrineOfTheElderTree.class));
    }

    @Test
    public void createSquare_ShouldCreateSilvaForum(){
        Square silvaForum = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.SilvaForum);
        assertEquals(Pair.create(0,0), silvaForum.position);
        assertThat(silvaForum, instanceOf(SilvaForum.class));
    }

    @Test
    public void createSquare_ShouldCreateTheSkyBaths(){
        Square theSkyBaths = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.TheSkyBaths);
        assertEquals(Pair.create(0,0), theSkyBaths.position);
        assertThat(theSkyBaths, instanceOf(TheSkyBaths.class));
    }

    @Test
    public void createSquare_ShouldCreateTheStarloom(){
        Square theStarloom = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.TheStarloom);
        assertEquals(Pair.create(0,0), theStarloom.position);
        assertThat(theStarloom, instanceOf(TheStarloom.class));
    }

    @Test
    public void createSquare_ShouldCreateEmptySquare(){
        Square emptySquare = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.NoPurpleBuilding);
        assertEquals(Pair.create(0,0), emptySquare.position);
        assertThat(emptySquare, instanceOf(EmptySquare.class));
    }

    @Test
    public void createSquare_ShouldCreateNoScoringPurpleBuilding(){
        Square noScoringBuilding = PurpleBuildingsFactory.createSquare(Pair.create(0,0), PurpleEnum.StatueOfTheBondmaker);
        assertEquals(Pair.create(0,0), noScoringBuilding.position);
        assertThat(noScoringBuilding, instanceOf(NoScoringPurpleBuilding.class));
    }
}
