package com.narxoz.rpg.combat.fireTheme;

import com.narxoz.rpg.combat.Ability;

public class FlameBreath implements Ability {
    private String name;
    private int damage;
    private String description;

    
    public FlameBreath(String name) {
        this.name = name;
        this.damage = 3000;
        this.description = "Concentrates magical energy into a glowing sphere that explodes upon contact, cleansing enemies";
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
        return new FlameBreath(this.name);
    }
}

