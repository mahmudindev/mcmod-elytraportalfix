package com.github.mahmudindev.mcmod.elytraportalfix.neoforge;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ElytraPortalFixExpectPlatformImpl {
    public static <T, V extends T> Supplier<V> registerRegistryEntry(
            ResourceKey<? extends Registry<T>> resourceKey,
            Identifier identifier,
            Supplier<? extends V> supplier
    ) {
        DeferredRegister<T> deferredRegister = DeferredRegister.create(
                resourceKey,
                identifier.getNamespace()
        );

        deferredRegister.register(ElytraPortalFixNeoForge.EVENT_BUS);

        return deferredRegister.register(identifier.getPath(), supplier);
    }
}
