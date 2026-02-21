package com.narxoz.rpg.factory;

import com.narxoz.rpg.behavior.BehaviorTypes;
import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.combat.fireTheme.FireShield;
import com.narxoz.rpg.combat.fireTheme.FlameBreath;
import com.narxoz.rpg.combat.fireTheme.MeteorStorm;
import com.narxoz.rpg.loot.*;
import java.util.ArrayList;
import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new FlameBreath("Dragon's Fury"));
        abilities.add(new FireShield("Crimson Aegis"));
        abilities.add(new MeteorStorm("Sunstrike Cascade"));
        return abilities;
    }

    @Override
    public LootTable createLootTable() {
        return new FireLootTable();
    }

    @Override
   public BehaviorTypes createAIBehavior() {
    return BehaviorTypes.AGGRESSIVE;
}
}
