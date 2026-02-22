package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import java.util.ArrayList;

public class Goblin extends Enemy {

    public Goblin() {
       
        this.name = "Goblin Scout";
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 40;
        this.abilities = new ArrayList<>();
    }

    public Goblin(String name) {
        this();
        this.name = name;
    }

    @Override
    public Enemy clone() {
       
        Goblin copy = new Goblin(this.name);
        
        
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
        for (Ability ability : this.abilities) {
            copy.abilities.add(ability.clone());
        }

       
        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }

        return copy;
    }
}
    // TODO: Implement clone() for Prototype pattern
    // This is CRITICAL! You must deep copy:
    //   - The abilities list (create new list, clone each ability)
    //   - The loot table (clone it)
    //   - Primitive fields can be copied directly
    //
    // Example skeleton:
    // public Enemy clone() {
    //     Goblin copy = new Goblin(this.name);
    //     copy.health = this.health;
    //     copy.damage = this.damage;
    //     copy.defense = this.defense;
    //     copy.speed = this.speed;
    //     copy.abilities = ???  // DEEP COPY! Not just = this.abilities!
    //     copy.lootTable = ???  // DEEP COPY!
    //     return copy;
    // }

    // TODO: Add helper methods for Prototype variant creation
    // Consider methods like:
    // - void multiplyStats(double multiplier) — for Elite/Champion variants
    // - void addAbility(Ability ability) — for enhanced variants
    // - void setElement(String element) — for elemental variants


