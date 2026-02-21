package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import java.util.ArrayList;


public class Skeleton extends Enemy {
    public Skeleton() {}

    public Skeleton(String name) {
        this.name = name;
        this.health = 29;
        this.damage = 5;
        this.defense = 9;
        this.speed = 7;
        this.abilities = new ArrayList<>();
    }

    @Override
    public Enemy clone() {
        Skeleton copy = new Skeleton(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;

        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;
        copy.canFly = this.canFly;
        copy.hasBreathAttack = this.hasBreathAttack;
        copy.wingspan = this.wingspan;

        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            copy.abilities.add(a.clone());
        }

        copy.phases = new java.util.HashMap<>(this.phases);

        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }

        return copy;
    }
}