package com.narxoz.rpg.combat;

public class FireShield implements Ability {
    private String name;
    private int damage;
    private String description;

    
    public FireShield(String name) {
        this.name = name;
        this.damage = 50000;
        this.description = "Surrounds the caster with a wall of fire...";
    }


    @Override public String getName() { 
        return name; 
    }
    @Override public int getDamage() { 
        return damage;
     }
    @Override public String getDescription() {
         return description;
         }

    @Override
    public Ability clone() {
        
        return new FireShield(this.name);
    }
}