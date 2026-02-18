package com.narxoz.rpg.combat.iceTheme;

import com.narxoz.rpg.combat.Ability;

public class FrostBreath implements Ability {
    private String name;
    private int damage;
    private String description;


   
    public FrostBreath(String name) {
        this.name = name;
        this.damage = 2100;
        this.description = "A gust of polar wind that encases the enemy's limbs in frost, making every action sluggish and heavy";
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
        return new FrostBreath(this.name);
    }
}
