package com.github.mahmudindev.mcmod.elytraportalfix.mixin;

import com.github.mahmudindev.mcmod.elytraportalfix.core.CustomGameRules;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.block.NetherPortalBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NetherPortalBlock.class)
public abstract class NetherPortalBlockHMixin {
    @WrapMethod(method = "getPortalTransitionTime")
    private int getPortalTransitionTimeElytra(
            ServerLevel serverLevel,
            Entity entity,
            Operation<Integer> original
    ) {
        if (entity instanceof Player player && player.isFallFlying()) {
            ItemStack itemStack = player.getItemBySlot(EquipmentSlot.CHEST);

            if (itemStack.getItem() == Items.ELYTRA && LivingEntity.canGlideUsing(
                    itemStack,
                    EquipmentSlot.CHEST
            )) {
                GameRules gameRules = serverLevel.getGameRules();

                return gameRules.get(CustomGameRules.ELYTRA_FLYING_PORTAL_DELAY);
            }
        }

        return original.call(serverLevel, entity);
    }
}
