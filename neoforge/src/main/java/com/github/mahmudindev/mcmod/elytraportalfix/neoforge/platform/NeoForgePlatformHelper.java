package com.github.mahmudindev.mcmod.elytraportalfix.neoforge.platform;

import com.github.mahmudindev.mcmod.elytraportalfix.neoforge.ElytraPortalFixNeoForge;
import com.github.mahmudindev.mcmod.elytraportalfix.platform.services.IPlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoForgePlatformHelper implements IPlatformHelper {
    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public <T, V extends T> Supplier<V> registerRegistryEntry(
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
