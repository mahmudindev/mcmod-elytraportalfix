package com.github.mahmudindev.mcmod.elytraportalfix.core;

import net.minecraft.world.level.GameRules;

public class CustomGameRules {
    public static final GameRules.Key<GameRules.IntegerValue> ELYTRA_FLY_PORTAL_WAIT_TICK = register(
            "elytraFlyPortalWaitTick",
            GameRules.Category.MISC,
            GameRules.IntegerValue.create(0)
    );

    private static <T extends GameRules.Value<T>> GameRules.Key<T> register(
            String name,
            GameRules.Category category,
            GameRules.Type<T> type
    ) {
        return GameRules.register(name, category, type);
    }

    public static void bootstrap() {}
}
