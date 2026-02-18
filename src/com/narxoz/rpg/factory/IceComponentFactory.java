package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.combat.iceTheme.Blizzard;
import com.narxoz.rpg.combat.iceTheme.FrostBreath;
import com.narxoz.rpg.combat.iceTheme.IceShield;
import com.narxoz.rpg.loot.*;
import java.util.ArrayList;
import java.util.List;

public class IceComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new FrostBreath("Eternal Zero"));
        abilities.add(new IceShield("Glacial Shell"));
        abilities.add(new Blizzard("Winter's Wrath"));
        return abilities;
    }

    @Override
    public LootTable createLootTable() {
        return new IceLootTable();
    }

    @Override
    public String createAIBehavior() {
        return "DEFENSIVE";
   }
}