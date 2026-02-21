package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import java.util.ArrayList;

public class Dragon extends Enemy {

    public Dragon() {}

    public Dragon(String name) {
        this.name = name;
        this.health = 900;
        this.defense = 100;
        this.damage = 225;
        this.speed = 230;

        this.canFly = true;
        this.hasBreathAttack = true;
        this.wingspan = 20;

        this.abilities = new ArrayList<>();
    }

    @Override
    public Enemy clone() {
        Dragon copy = new Dragon(this.name);

        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;

        copy.canFly = this.canFly;
        copy.hasBreathAttack = this.hasBreathAttack;
        copy.wingspan = this.wingspan;

        copy.abilities = new ArrayList<>();
        for (Ability ability : this.abilities) {
            copy.abilities.add(ability.clone());
        }

        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }

        return copy;
    }
}
/**
 * Example complex boss enemy — THE REASON BUILDER PATTERN EXISTS.
 *
 * ============================================================
 * READ THIS CAREFULLY — THIS IS THE CORE LEARNING MOMENT!
 * ============================================================
 *
 * Look at this constructor. REALLY look at it.
 * Count the parameters. Imagine using it in Main.java.
 * Imagine a teammate trying to understand what each parameter means.
 *
 * This is called the "Telescoping Constructor" anti-pattern.
 * It's the #1 problem that the Builder pattern solves.
 *
 * YOUR MISSION:
 * After studying this horror, you will create an EnemyBuilder
 * that constructs DragonBoss (and other complex enemies)
 * step-by-step, with clear and readable code.
 *
 * Compare:
 *
 *   BEFORE (Telescoping Constructor — current code):
 *   new DragonBoss("Fire Dragon", 50000, 500, 200, 50, "FIRE",
 *       abilities, 30000, 15000, 5000, loot, "AGGRESSIVE",
 *       true, true, 20);
 *   // What does 'true, true, 20' mean? Nobody knows!
 *
 *   AFTER (Builder Pattern — your implementation):
 *   new BossEnemyBuilder()
 *       .setName("Fire Dragon")
 *       .setHealth(50000)
 *       .setDamage(500)
 *       .setDefense(200)
 *       .setSpeed(50)
 *       .setElement("FIRE")
 *       .addAbility(new FlameBreath())
 *       .addAbility(new WingBuffet())
 *       .addPhase(1, 50000)
 *       .addPhase(2, 30000)
 *       .addPhase(3, 15000)
 *       .setLootTable(fireLoot)
 *       .setAI("AGGRESSIVE")
 *       .build();
 *   // Every parameter is labeled! Readable! Maintainable!
 *
 * ============================================================
 * TODO: After implementing your Builder, REFACTOR this class!
 * ============================================================
 * - Remove (or simplify) the telescoping constructor
 * - Make DragonBoss constructable ONLY through a Builder
 * - Make the built DragonBoss IMMUTABLE (no setters!)
 * - The Builder handles all the complexity
 */

    /**
     * THE TELESCOPING CONSTRUCTOR FROM HELL.
     *
     * Count the parameters: FIFTEEN (15).
     * Can you tell which parameter is which when calling this?
     * Can you remember the order?
     * What if you want to add a 16th parameter later?
     *
     * THIS is why the Builder pattern exists.
     *
     * After you implement your Builder, this constructor should be
     * either simplified (package-private, called only by Builder)
     * or replaced entirely.
     */

    // TODO: Implement clone() for Prototype pattern
    // DragonBoss has MANY fields that need deep copying:
    //   - abilities (List<Ability>) → deep copy each ability
    //   - phases (Map<Integer, Integer>) → copy the map
    //   - lootTable → deep copy
    //   - primitive fields → direct copy
    //
    // This is more complex than Goblin.clone()!
    // That's the challenge of Prototype with complex objects.

    // TODO: Add helper methods for variant creation
    // - void setElement(String element) — for elemental variants
    // - void multiplyStats(double multiplier) — for difficulty tiers


