package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import java.util.ArrayList;


public class Orc extends Enemy {
    public Orc() {}

    public Orc(String name) {
        this.name = name;
        this.health = 55;
        this.damage = 6;
        this.defense = 2;
        this.speed = 4;
        this.abilities = new ArrayList<>();
    }

    @Override
    public Enemy clone() {
        Orc copy = new Orc(this.name);
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