package net.jimit.JimitsEndMod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class EnderiteStaff extends Item {
    private static final int MAX_DISTANCE = 32;

    public EnderiteStaff(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide) {
            HitResult hit = player.pick(MAX_DISTANCE, 0.0F, false);

            if(hit.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockhit = (BlockHitResult) hit;
                BlockPos targetPos = blockhit.getBlockPos().above();
                boolean spaceAbove = level.getBlockState(targetPos).isAir() && level.getBlockState(targetPos.above()).isAir();

                if(spaceAbove) {
                    player.teleportTo(targetPos.getX(), targetPos.getY(), targetPos.getZ());
                    player.getItemInHand(hand).hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                    level.playSound(null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
                }
                player.getCooldowns().addCooldown(this, 40);
                return InteractionResultHolder.success(player.getItemInHand(hand));
            }
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
