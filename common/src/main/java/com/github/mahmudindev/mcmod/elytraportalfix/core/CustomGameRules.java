package com.github.mahmudindev.mcmod.elytraportalfix.core;

import com.github.mahmudindev.mcmod.elytraportalfix.ElytraPortalFix;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.gamerules.*;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class CustomGameRules {
    public static final Supplier<GameRule<Integer>> ELYTRA_FLYING_PORTAL_DELAY = register(
            "elytra_flying_portal_delay",
            GameRuleCategory.MISC,
            GameRuleType.INT,
            IntegerArgumentType.integer(0, Integer.MAX_VALUE),
            Codec.intRange(0, Integer.MAX_VALUE),
            0,
            FeatureFlagSet.of(),
            GameRuleTypeVisitor::visitInteger,
            value -> value
    );

    private static <T> Supplier<GameRule<T>> register(
            String name,
            GameRuleCategory gameRuleCategory,
            GameRuleType gameRuleType,
            ArgumentType<T> argumentType,
            Codec<T> codec,
            T object,
            FeatureFlagSet featureFlagSet,
            GameRules.VisitorCaller<T> visitorCaller,
            ToIntFunction<T> toIntFunction
    ) {
        return ElytraPortalFix.PLATFORM.registerRegistryEntry(
                BuiltInRegistries.GAME_RULE.key(),
                Identifier.parse(name),
                () -> new GameRule<>(
                        gameRuleCategory,
                        gameRuleType,
                        argumentType,
                        visitorCaller,
                        codec,
                        toIntFunction,
                        object,
                        featureFlagSet
                )
        );
    }

    public static void bootstrap() {}
}
