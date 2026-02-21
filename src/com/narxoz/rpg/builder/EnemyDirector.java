package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.EnemyType;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    public Enemy createMinion(EnemyComponentFactory componentFactory) {
        return new BasicBuilder()
                .setName("Shadow Scout")
                .setHealth(120)
                .setDamage(15)
                .setDefense(5)
                .setSpeed(45)
                .setElement(EnemyType.SHADOW)
                .setAI(componentFactory.createAIBehavior()) 
                .setAbilities(componentFactory.createAbilities())
                .setLootTable(componentFactory.createLootTable())
                .build();
    }

    public Enemy createElite(EnemyComponentFactory componentFactory) {
        return new BasicBuilder()
                .setName("Abyssal Knight")
                .setHealth(450)
                .setDamage(65)
                .setDefense(25)
                .setSpeed(35)
                .setElement(EnemyType.SHADOW)
                .setAI(componentFactory.createAIBehavior())
                .setAbilities(componentFactory.createAbilities())
                .setLootTable(componentFactory.createLootTable())
                .build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory componentFactory) {
        return new BossEnemyBuilder() 
                .setName("Inferno Warden")
                .setHealth(2500)
                .setDamage(120)
                .setDefense(45)
                .setSpeed(55)
                .setElement(EnemyType.FIRE)
                .setAI(componentFactory.createAIBehavior())
                .addPhase(1, 2500)
                .addPhase(2, 1200)
                .setAbilities(componentFactory.createAbilities())
                .setLootTable(componentFactory.createLootTable())
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory componentFactory) {
        return new BossEnemyBuilder()
                .setName("Aethelgard the Eternal")
                .setHealth(85000)
                .setDamage(750)
                .setDefense(400)
                .setSpeed(65)
                .setElement(EnemyType.FIRE)
                .setAI(componentFactory.createAIBehavior())
                .addPhase(1, 85000)
                .addPhase(2, 45000)
                .addPhase(3, 15000)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(150)
                .setAbilities(componentFactory.createAbilities())
                .setLootTable(componentFactory.createLootTable())
                .build();
    }
}