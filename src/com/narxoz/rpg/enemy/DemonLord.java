package com.narxoz.rpg.enemy;

import java.util.ArrayList;
import java.util.HashMap;

import com.narxoz.rpg.behavior.BehaviorTypes;
import com.narxoz.rpg.combat.Ability;

public class DemonLord extends Enemy {

    public DemonLord() {}

    public DemonLord(String name) {
        this.name = name;
        this.health = 1000;
        this.damage = 40;
        this.defense = 400;
        this.speed = 140;

        this.aiBehavior = BehaviorTypes.TACTICAL;

        this.canFly = false;
        this.hasBreathAttack = false;
        this.wingspan = 0;

        this.abilities = new ArrayList<>();
        this.phases = new HashMap<>();
    }

    @Override
    public Enemy clone() {

        DemonLord copy = new DemonLord(this.name);

        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;

        copy.phases = new HashMap<>(this.phases);

        copy.aiBehavior = this.aiBehavior;

        copy.canFly = this.canFly;
        copy.hasBreathAttack = this.hasBreathAttack;

        copy.abilities = new ArrayList<>();

        copy.element = this.element;
        copy.wingspan = this.wingspan;

        for (Ability ability : this.abilities) {
            copy.abilities.add(ability.clone());
        }

        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }

        return copy;
    }
}