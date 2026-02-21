package com.narxoz.rpg.enemy;

import com.narxoz.rpg.behavior.BehaviorTypes;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base interface for all enemies in the RPG system.
 *
 * Every enemy — from a lowly Goblin to an Ancient Dragon — shares
 * certain characteristics: they have stats, abilities, and loot.
 * But HOW they are created varies dramatically.
 *
 * ============================================================
 * WHY THIS INTERFACE MATTERS FOR DESIGN PATTERNS:
 * ============================================================
 *
 * Builder Pattern:
 *   Complex enemies have many fields (stats, abilities, phases, loot, AI).
 *   The Builder pattern constructs enemies step-by-step instead of
 *   cramming everything into one monstrous constructor.
 *   → Think: Should Enemy be immutable once built? (Hint: YES!)
 *
 * Prototype Pattern:
 *   This interface includes a clone() method. Enemies must be CLONABLE
 *   so we can create variants efficiently:
 *     Base Goblin → Elite Goblin → Goblin Champion → Goblin King
 *   → Think: What needs DEEP copying? What can be SHALLOW copied?
 *
 * Factory Method:
 *   The Builder's build() method IS a factory method — it produces
 *   Enemy objects. Different builders produce different enemy types.
 *
 * Abstract Factory:
 *   Enemy components (abilities, loot) come from themed factories.
 *   A FireComponentFactory guarantees all components match the fire theme.
 *
 * ============================================================
 * YOUR TASKS:
 * ============================================================
 *
 * TODO: Decide — should this be an interface or abstract class?
 *   - Interface: If implementations are very different
 *   - Abstract class: If you want shared fields (name, health, etc.)
 *   Hint: An abstract class with shared stat fields might be cleaner.
 *
 * TODO: Define the core enemy contract.
 *   Every enemy should provide:
 *   - Basic stats (health, damage, defense, speed)
 *   - Abilities they can use
 *   - Loot they drop when defeated
 *   - Information display (for the demo)
 *   - Clone method (for Prototype pattern)
 *
 * TODO: Think about immutability.
 *   - Once built by the Builder, should enemy stats change?
 *   - Should clone() return a mutable or immutable copy?
 *   - How do you allow Prototype to modify cloned stats?
 */
    // TODO: Define core stat methods
    // - String getName()
    // - int getHealth()
    // - int getDamage()
    // - int getDefense()
    // - int getSpeed()

    // TODO: Define ability methods
    // - List<Ability> getAbilities()

    // TODO: Define loot methods
    // - LootTable getLootTable()

    // TODO: Define display method
    // - void displayInfo()   (shows all stats, abilities, loot)

    // TODO: Define clone method for Prototype pattern
    // - Enemy clone()
    //
    // CRITICAL: This must perform DEEP COPY!
    // If you do shallow copy, cloned enemies will share ability
    // and loot references with the original — causing bugs!
    //
    // Test your clone: modify the clone's abilities.
    // Does the original change? If yes → your copy is too shallow!


public abstract class Enemy implements Cloneable {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;


    protected EnemyType element;

    protected List<Ability> abilities = new ArrayList<>();
    protected Map<Integer, Integer> phases = new HashMap<>();

    protected LootTable lootTable;
    protected BehaviorTypes aiBehavior;

    protected boolean canFly;
    protected boolean hasBreathAttack;
    protected int wingspan;

    public Enemy() {}

    protected Enemy(Enemy other) {
        this.name = other.name;
        this.health = other.health;
        this.damage = other.damage;
        this.defense = other.defense;
        this.speed = other.speed;
        this.element = other.element;

        this.abilities = new ArrayList<>(other.abilities);
        this.phases = new HashMap<>(other.phases);

        this.lootTable = other.lootTable;
        this.aiBehavior = other.aiBehavior;

        this.canFly = other.canFly;
        this.hasBreathAttack = other.hasBreathAttack;
        this.wingspan = other.wingspan;
    }

    public String getName() {
         return name;
         }
    public int getHealth() {
         return health; 
        }
    public int getDamage() {
         return damage;
         }
    public int getDefense() {
         return defense;
         }
    public int getSpeed() {
         return speed; 
        }

    public EnemyType getElement() {
         return element;
         }
    public List<Ability> getAbilities() {
         return abilities;
         }
    public Map<Integer, Integer> getPhases() { 
        return phases;
     }

    public LootTable getLootTable() {
         return lootTable;
         }
    public BehaviorTypes getAiBehavior() {
         return aiBehavior;
         }

    public boolean getCanFly() {
         return canFly; 
        }
    public boolean getHasBreathAttack() { 
        return hasBreathAttack; 
    }
    public int getWingspan() {
         return wingspan;
         }

    public void setName(String name) {
         this.name = name; 
        }
    public void setHealth(int health) { 
        this.health = health; 
    }
    public void setDamage(int damage) { 
        this.damage = damage;
    }
    public void setDefense(int defense) { 
        this.defense = defense;
     }
    public void setSpeed(int speed) { 
        this.speed = speed;
     }

    public void setElement(EnemyType element) { 
        this.element = element;
     }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = (abilities == null) ? new ArrayList<>() : abilities;
    }

    public void setLootTable(LootTable lootTable) { 
        this.lootTable = lootTable;
     }
    public void setAiBehavior(BehaviorTypes aiBehavior) { 
        this.aiBehavior = aiBehavior;
     }

    public void setCanFly(boolean canFly) { 
        this.canFly = canFly; 
    }
    public void setHasBreathAttack(boolean hasBreathAttack) { 
        this.hasBreathAttack = hasBreathAttack;
     }
    public void setWingspan(int wingspan) {
         this.wingspan = wingspan; 
        }

    public void addAbility(Ability ability) {
        if (ability != null) abilities.add(ability);
    }

    public void addPhase(int phaseNumber, int healthThreshold) {
        phases.put(phaseNumber, healthThreshold);
    }

    public void addPhase(Map<Integer, Integer> phases) {
        if (phases == null) return;
        this.phases = new HashMap<>(phases);
    }

    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * multiplier);
    }

    public void displayInfo() {

    System.out.println("=== " + name + " ===");

    System.out.println("Health: " + health +
            " | Damage: " + damage +
            " | Defense: " + defense +
            " | Speed: " + speed);

    System.out.println("Element: " + element);

    System.out.println("AI Behavior: " + aiBehavior);

    if (!abilities.isEmpty()) {

        System.out.println("Abilities (" + abilities.size() + "):");

        for (Ability a : abilities) {

            System.out.println("  - " + a.getName() +
                    " (Damage: " + a.getDamage() + ")");
        }
    }

    if (!phases.isEmpty()) {

        System.out.println("Boss Phases: " + phases.size());

        for (Map.Entry<Integer, Integer> p : phases.entrySet()) {

            System.out.println("  Phase " + p.getKey() +
                    ": triggers at " + p.getValue() + " HP");
        }
    }

    System.out.println("Can Fly: " + canFly +
            " | Breath Attack: " + hasBreathAttack +
            " | Wingspan: " + wingspan);

    if (lootTable != null) {

        System.out.println("Loot: " +
                lootTable.getLootInfo());
    }

    System.out.println("==============================\n");
}
    @Override
    public abstract Enemy clone();
}


