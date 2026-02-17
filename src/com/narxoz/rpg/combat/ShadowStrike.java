package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {
    private String name;
    private int damage;
    private String description;

    public ShadowStrike(String name) {
        this.name = name;
        this.damage = 89000;
        this.description = "A lethal strike from the void that severs the target's sight, leaving them lost in eternal darkness";
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
        return new ShadowStrike(this.name);
    }
}