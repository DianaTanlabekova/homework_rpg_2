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
        super(); 
    }

    @Override
    public BossEnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BossEnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public BossEnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public BossEnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public BossEnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public BossEnemyBuilder setElement(EnemyType element) {
        this.element = element;
        return this;
    }

    @Override
    public BossEnemyBuilder addAbility(Ability ability) {
        if (ability != null) {
            this.abilities.add(ability);
        }
        return this;
    }

    @Override
    public BossEnemyBuilder setAbilities(List<Ability> abilities) {
        if (abilities != null) {
            this.abilities = new ArrayList<>(abilities);
        }
        return this;
    }

    @Override
    public BossEnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    @Override
    public BossEnemyBuilder setAI(BehaviorTypes aiBehavior) {
        this.aiBehavior = aiBehavior;
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
       
        Dragon boss = new Dragon();
        
        boss.setName(this.name);
        boss.setHealth(this.health);
        boss.setDamage(this.damage);
        boss.setDefense(this.defense);
        boss.setSpeed(this.speed);
        boss.setElement(this.element);
        boss.setAiBehavior(this.aiBehavior);
        boss.setLootTable(this.lootTable);
        
        boss.setAbilities(new ArrayList<>(this.abilities));
        
        boss.setCanFly(this.canFly);
        boss.setHasBreathAttack(this.hasBreathAttack);
        boss.setWingspan(this.wingspan);
        
        
        boss.addPhase(new HashMap<>(this.phases));
        
        return boss;
    }
}