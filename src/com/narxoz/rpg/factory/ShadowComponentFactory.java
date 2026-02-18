package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.combat.shadowTheme.DarkNova;
import com.narxoz.rpg.combat.shadowTheme.ShadowStrike;
import com.narxoz.rpg.combat.shadowTheme.Vanish;
import com.narxoz.rpg.loot.*;
import java.util.ArrayList;
import java.util.List;


public class ShadowComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new ShadowStrike("Nightfall Blade"));
        abilities.add(new Vanish("Ghost Step"));
        abilities.add(new DarkNova("Eclipse Burst"));
        return abilities;
    }


    @Override
    public LootTable createLootTable() {
        return new ShadowLootTable();
    }

    @Override
    public String createAIBehavior() {
        return "TACTICAL"; 
    }
}


