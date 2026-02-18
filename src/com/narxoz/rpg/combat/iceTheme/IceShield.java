package com.narxoz.rpg.combat.iceTheme;

import com.narxoz.rpg.combat.Ability;

public class IceShield implements Ability {
    private String name;
    private int damage;
    private String description;

    
    public IceShield(String name) {
        this.name = name;
        this.damage = 0; 
        this.description = "Creates a solid barrier of permafrost that mitigates incoming physical strikes and chills attackers";
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
        return new IceShield(this.name);
    }
}