package com.github.mahmudindev.mcmod.elytraportalfix.platform;

import com.github.mahmudindev.mcmod.elytraportalfix.ElytraPortalFix;
import com.github.mahmudindev.mcmod.elytraportalfix.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(
                clazz,
                Services.class.getClassLoader()
        ).findFirst().orElseThrow(() -> {
            return new NullPointerException("Failed to load service for " + clazz.getName());
        });
        ElytraPortalFix.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
