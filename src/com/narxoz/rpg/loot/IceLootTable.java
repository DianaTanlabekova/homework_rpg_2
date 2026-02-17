package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable {
    private List<String> items;
    private int gold;
    private int exp;

    public IceLootTable() {
        this.items = new ArrayList<>(List.of("Everfrost Shard", "Yeti Fur", "Glacier Water"));
        this.gold = 940;
        this.exp = 3400;
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
        return "Ice Loot: " + items + " | Gold: " + gold + " | XP: " + exp;
    }

    @Override
    public LootTable clone() {
        return new IceLootTable();
     
    }
}