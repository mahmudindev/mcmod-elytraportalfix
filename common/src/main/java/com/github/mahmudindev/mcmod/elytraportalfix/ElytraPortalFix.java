package com.github.mahmudindev.mcmod.elytraportalfix;

import com.github.mahmudindev.mcmod.elytraportalfix.core.CustomGameRules;
import com.github.mahmudindev.mcmod.elytraportalfix.platform.Services;
import com.github.mahmudindev.mcmod.elytraportalfix.platform.services.IPlatformHelper;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public final class ElytraPortalFix {
    public static final String MOD_ID = "elytraportalfix";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final IPlatformHelper PLATFORM = Services.PLATFORM;

    public static void init() {
        CustomGameRules.bootstrap();
    }
}
