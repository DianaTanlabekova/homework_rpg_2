package com.narxoz.rpg.builder;

import com.narxoz.rpg.behavior.BehaviorTypes;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Dragon;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.EnemyType;
import com.narxoz.rpg.loot.LootTable;
import java.util.*;

public class BossEnemyBuilder extends BasicBuilder {

    
    protected Map<Integer, Integer> phases = new HashMap<>();
    protected boolean canFly;
    protected boolean hasBreathAttack;
    protected int wingspan;

    public BossEnemyBuilder() {
       
        this.enemy = new Dragon();
    }

    
    @Override
    public BossEnemyBuilder setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public BossEnemyBuilder setHealth(int health) {
        super.setHealth(health);
        return this;
    }

    @Override
    public BossEnemyBuilder setDamage(int damage) {
        super.setDamage(damage);
        return this;
    }

    @Override
    public BossEnemyBuilder setDefense(int defense) {
        super.setDefense(defense);
        return this;
    }

    @Override
    public BossEnemyBuilder setSpeed(int speed) {
        super.setSpeed(speed);
        return this;
    }

    @Override
    public BossEnemyBuilder setElement(EnemyType element) {
        super.setElement(element);
        return this;
    }

    @Override
    public BossEnemyBuilder setLootTable(LootTable lootTable) {
        super.setLootTable(lootTable);
        return this;
    }

    @Override
    public BossEnemyBuilder setAI(BehaviorTypes aiBehavior) {
        super.setAI(aiBehavior);
        return this;
    }

    @Override
    public BossEnemyBuilder setAbilities(List<Ability> abilities) {
        super.setAbilities(abilities);
        return this;
    }

    
    public BossEnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }

    public BossEnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
        return this;
    }

    public BossEnemyBuilder setWingspan(int wingspan) {
        this.wingspan = wingspan;
        return this;
    }

    @Override
    public Enemy build() {
        
        super.build();

        
        enemy.setCanFly(this.canFly);
        enemy.setHasBreathAttack(this.hasBreathAttack);
        enemy.setWingspan(this.wingspan);
        
       
        enemy.addPhase(new HashMap<>(this.phases));

        return enemy;
    }
}