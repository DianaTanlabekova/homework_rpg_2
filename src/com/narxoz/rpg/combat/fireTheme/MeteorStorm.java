package com.narxoz.rpg.combat.fireTheme;

import com.narxoz.rpg.combat.Ability;

public class MeteorStorm implements Ability {
    private String name;
    private int damage;
    private String description;

    public MeteorStorm(String name) {
        this.name = name;
        this.damage = 8600; 
        this.description = "Tears a hole in the sky to unleash a cataclysmic rain of molten rock, turning the battlefield into a living hell";
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
    @Override public Ability clone() {
         return new MeteorStorm(this.name); 
        }
}