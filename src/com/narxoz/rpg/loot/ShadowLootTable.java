package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {
    private List<String> items;
    private int gold;
    private int exp;

    public ShadowLootTable() {
        this.items = new ArrayList<>(List.of("Void Essence", "Shadow Fragment", "Cursed Coin"));
        this.gold = 15500;
        this.exp = 7700;
    }

    @Override 
    public List<String> getItems() {
         return items;
    }

    @Override 
    public int getGoldDrop() {
         return gold;
    }

    @Override 
    public int getExperienceDrop() {
         return exp;
    }
    
    @Override 
    public String getLootInfo() {
        return "Shadow Loot: " + items + " | Gold: " + gold + " | XP: " + exp;
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable();
    }
}
