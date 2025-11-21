package com.github.mahmudindev.mcmod.elytraportalfix;

import com.github.mahmudindev.mcmod.elytraportalfix.core.CustomGameRules;

public final class ElytraPortalFix {
    public static final String MOD_ID = "elytraportalfix";

    public static void init() {
        CustomGameRules.bootstrap();
    }
}
