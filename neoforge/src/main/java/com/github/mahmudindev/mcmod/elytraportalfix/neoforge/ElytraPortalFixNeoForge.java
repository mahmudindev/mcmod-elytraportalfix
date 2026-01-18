package com.github.mahmudindev.mcmod.elytraportalfix.neoforge;

import com.github.mahmudindev.mcmod.elytraportalfix.ElytraPortalFix;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ElytraPortalFix.MOD_ID)
public final class ElytraPortalFixNeoForge {
    public static IEventBus EVENT_BUS;

    public ElytraPortalFixNeoForge(IEventBus eventBus) {
        EVENT_BUS = eventBus;

        // Run our common setup.
        ElytraPortalFix.init();
    }
}
