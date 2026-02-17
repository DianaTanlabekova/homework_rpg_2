package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class FireLootTable implements LootTable {
    private List<String> items;
    private int gold;
    private int exp;

    
    public FireLootTable() {
        this.items = new ArrayList<>(List.of("Magma Core", "Phoenix Feather", "Volcanic Ash"));
        this.gold = 4550;
        this.exp = 780;
    }

    @Override public List<String> getItems() {
         return items;
         }
    @Override public int getGoldDrop() {
         return gold;
         }
    @Override public int getExperienceDrop() {
         return exp; 
        }

    @Override
    public String getLootInfo() {
        return "Fire Loot: " + items + " | Gold: " + gold + " | XP: " + exp;
    }

    @Override
    public LootTable clone() {
        return new FireLootTable();
    }
}