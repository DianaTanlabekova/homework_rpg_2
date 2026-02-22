package com.narxoz.rpg.builder;

import com.narxoz.rpg.behavior.BehaviorTypes;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.EnemyType;
import com.narxoz.rpg.enemy.Goblin; 
import com.narxoz.rpg.loot.LootTable;
import java.util.*;

public class BasicBuilder implements EnemyBuilder {
    
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected EnemyType element;
    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;
    protected BehaviorTypes aiBehavior;

    
    public BasicBuilder() {
    }

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(EnemyType element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        if (ability != null) {
            this.abilities.add(ability);
        }
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        if (abilities != null) {
           
            this.abilities = new ArrayList<>(abilities);
        }
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    @Override
    public EnemyBuilder setAI(BehaviorTypes aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public Enemy build() {
       
        Enemy newEnemy = new Goblin(); 
        
        
        newEnemy.setName(this.name);
        newEnemy.setHealth(this.health);
        newEnemy.setDamage(this.damage);
        newEnemy.setDefense(this.defense);
        newEnemy.setSpeed(this.speed);
        newEnemy.setElement(this.element);
        
       
        newEnemy.setAbilities(new ArrayList<>(this.abilities));
        
        newEnemy.setLootTable(this.lootTable);
        newEnemy.setAiBehavior(this.aiBehavior);
        
        
        return newEnemy;
    }
}
