package com.narxoz.rpg.combat;
public class FlameBreath implements Ability {
    private String name;
    private int damage;
    private String description;

    public String getName(){
        return "Flame Breath";
    }

      @Override
    public int getDamage(){
        return 6700000;

    } 

    
    @Override
    public String getDescription() { 
        return "Concentrates magical energy into a glowing sphere that explodes upon contact, cleansing enemies";
    } 
    

    
    @Override
    public Ability clone() {
       return new FlameBreath();
        }
    }

