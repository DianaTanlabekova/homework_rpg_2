package com.narxoz.rpg.combat.iceTheme;

import com.narxoz.rpg.combat.Ability;

public class Blizzard implements Ability {
    private String name;
    private int damage;
    private String description;

    public Blizzard(String name) {
        this.name = name;
        this.damage = 6000;
        this.description = "Commands a localized ice age, trapping enemies in a howling vortex of jagged frost and bone-chilling winds";
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
         return new Blizzard(this.name);
         }
}