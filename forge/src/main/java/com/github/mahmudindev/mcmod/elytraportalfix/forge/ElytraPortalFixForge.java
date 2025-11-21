package com.github.mahmudindev.mcmod.elytraportalfix.forge;

import com.github.mahmudindev.mcmod.elytraportalfix.ElytraPortalFix;
import net.minecraftforge.fml.common.Mod;

@Mod(ElytraPortalFix.MOD_ID)
public final class ElytraPortalFixForge {
    public ElytraPortalFixForge() {
        // Run our common setup.
        ElytraPortalFix.init();
    }
}
