package com.github.mahmudindev.mcmod.elytraportalfix.mixin;

import com.github.mahmudindev.mcmod.elytraportalfix.core.CustomGameRules;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = Player.class, priority = 1500)
public abstract class PlayerHMixin extends LivingEntity {
    @Shadow public abstract ItemStack getItemBySlot(EquipmentSlot equipmentSlot);

    protected PlayerHMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @WrapMethod(method = "getPortalWaitTime")
    private int getPortalWaitTimeElytra(Operation<Integer> original) {
        if (this.isFallFlying()) {
            ItemStack itemStack = this.getItemBySlot(EquipmentSlot.CHEST);

            if (itemStack.getItem() == Items.ELYTRA && ElytraItem.isFlyEnabled(itemStack)) {
                Level level = this.level();
                GameRules gameRules = level.getGameRules();

                return  gameRules.getInt(CustomGameRules.ELYTRA_FLY_PORTAL_WAIT_TICK);
            }
        }

        return original.call();
    }
}
