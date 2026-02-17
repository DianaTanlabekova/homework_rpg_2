package com.narxoz.rpg.combat;

public class Vanish implements Ability {
    private String name;
    private int damage;
    private String description;

    public Vanish(String name) {
        this.name = name;
        this.damage = 0; 
        this.description = "Dissolves the caster's physical form into mist, becoming an untouchable wraith that bypasses all mortal blades";
    }

    @Override 
    public String getName() { 
        return name; 
    }

    @Override 
    public int getDamage() { 
        return damage;
    }

    @Override 
    public String getDescription() {
         return description;
    }

    @Override
    public Ability clone() {
        return new Vanish(this.name);
    }
}