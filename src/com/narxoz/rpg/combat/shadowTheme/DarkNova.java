package com.narxoz.rpg.combat.shadowTheme;

import com.narxoz.rpg.combat.Ability;

public class DarkNova implements Ability {
    private String name;
    private int damage;
    private String description;

    public DarkNova(String name) {
        this.name = name;
        this.damage = 7600;
        this.description = "Detonates a sphere of concentrated void energy, creating a shockwave of darkness that erases the existence of those caught in its wake";
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
         return new DarkNova(this.name);
         }
}
